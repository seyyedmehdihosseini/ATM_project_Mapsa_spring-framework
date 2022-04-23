package atm.atm.Controller;

import atm.atm.Entity.Account;
import atm.atm.Service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountController {
    private IAccountService service;

    @PostMapping("/account/add")
    public ResponseEntity<?> addAccount(@RequestParam String username, @RequestBody Account account) {
        Account created = service.created(username, account);
        return new ResponseEntity<>(created,HttpStatus.CREATED);
    }

    @PutMapping("/account/customer/update/") // change update is layer service account
    public ResponseEntity<?> updateAccount(@RequestBody Account account) {
        Account update = service.update(account);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/account/delete")
    public ResponseEntity<?> deleteAccount(@RequestParam Long accountNumber) {
        service.deleteByUnique(accountNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/account/customer/../allAccount")
    public ResponseEntity<?> findAllAccountByUsername(@RequestParam String username) {
        List<Account> allByUsername = service.findAllByUsername(username);
        if (!allByUsername.isEmpty()) {
            return new ResponseEntity<>(allByUsername, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("There is no account with this username ", HttpStatus.NO_CONTENT);
        }
    }


    @GetMapping("/account/findAll")
    public ResponseEntity<?> findAllAccount() {
        List<Account> all = service.findAll();
        if (!all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("There is no account", HttpStatus.NO_CONTENT);
        }
    }


    @GetMapping("/account/customer/balance{id}")
    public ResponseEntity<?> getBalance(@PathVariable("id") Long accountNumber) {
        if (service.existByAccountNumbers(accountNumber)) {
            Account byUnique = service.findByUnique(accountNumber);
            return new ResponseEntity<>(byUnique.getAmount(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("account number is not found ", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/account/customer/increase")
    public ResponseEntity<?> increaseInventory(@RequestParam Long accountNumber, @RequestParam Long amount) {
        Long deposit = service.depositToAccount(accountNumber, amount);
        return new ResponseEntity<>("amount : " + deposit, HttpStatus.OK);
    }


    @PutMapping("/account/customer/fundTransfer")
    public ResponseEntity<?> fundTransfers(Long accountNumberSender, Long amount, Long AccountNumberReceiver) {
        Boolean aBoolean = service.fundTransfers(accountNumberSender, amount, AccountNumberReceiver);
        if (aBoolean) {
            return new ResponseEntity<>("Operation successfully ", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
