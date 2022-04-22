package atm.atm.Service;

import atm.atm.Entity.Account;
import atm.atm.Entity.Transaction;
import atm.atm.Entity.Users;
import atm.atm.Exception_Handling.BusinessException;
import atm.atm.Exception_Handling.ConflictException;
import atm.atm.Exception_Handling.NotFoundException;
import atm.atm.Repository.IAccountRepository;
import atm.atm.Repository.IUserRepository;
import atm.atm.enums.TransactionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountService implements IAccountService {
    private IAccountRepository repository;
    private IUserRepository userRepository;
    private ITransactionService transactionService;

    @Override
    public Account created(String username, Account account) {
        if (userRepository.existsByUsername(username)) {
            if (!repository.existsByAccountNumber(account.getAccountNumber())) {
                Users usersByUsername = userRepository.findUsersByUsername(username);
                account.setUsers(usersByUsername);
                return repository.save(account);
            }else {
                throw new ConflictException("account number is conflict");
            }
        }
        else {
            throw new NotFoundException(" username is not found ");
        }
    }

    @Override
    public Boolean existByAccountNumbers(Long accountNumber) {
        return repository.existsByAccountNumber(accountNumber);
    }

    @Override
    public List<Account> findAllByUsername(String username) {
        if (userRepository.existsByUsername(username)){
            return repository.findAllByUsers_Username(username);
        }
        else {
            throw new NotFoundException("username is not found");
        }
    }

    @Override
    public Boolean fundTransfers(Long accountNumberSender, Long amount, Long accountNumberReceiver) {
        if (repository.existsByAccountNumber(accountNumberSender) &&
                repository.existsByAccountNumber(accountNumberReceiver)) {
            Account accountSender = repository.findAccountByAccountNumber(accountNumberSender);
            if (accountSender.getAmount() > (amount + 5000)) {
                accountSender.setAmount(accountSender.getAmount() - amount);
                Transaction transactionSender = Transaction.builder()
                        .account((List<Account>) accountSender)
                        .amount(amount)
                        .type(TransactionType.TRANSFER)
                        .date(new Date())
                        .build();
                repository.save(accountSender);
                transactionService.created(transactionSender);
                Account accountReceiver = repository.findAccountByAccountNumber(accountNumberReceiver);
                accountReceiver.setAmount(accountReceiver.getAmount() + amount);
                Transaction transactionReceiver = Transaction.builder()
                        .account((List<Account>) accountReceiver)
                        .amount(amount)
                        .type(TransactionType.DEPOSIT)
                        .date(new Date())
                        .build();
                repository.save(accountReceiver);
                return true;
            } else {
                throw new BusinessException("amount is a large and balance ");
            }

        }
        throw new NotFoundException("account numbers is not found ");
    }

    @Override
    public Long depositToAccount(Long accountNumber, Long amount) {
        if (repository.existsByAccountNumber(accountNumber)) {
            Account account = repository.findAccountByAccountNumber(accountNumber);
            account.setAmount(amount);
            Account save = repository.save(account);
            Transaction transaction = Transaction.builder()
                    .account((List<Account>) account)
                    .type(TransactionType.DEPOSIT)
                    .amount(amount)
                    .date(new Date())
                    .build();
            transactionService.created(transaction);
            return save.getAmount();
        } else {
            throw new NotFoundException("account number is not found ");
        }
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public Account findByUnique(Long accountNumber) {
        if (repository.existsByAccountNumber(accountNumber)) {
            return repository.findAccountByAccountNumber(accountNumber);
        }
        throw new NotFoundException("account number is not found ");
    }

    @Override
    public void deleteByUnique(Long accountNumber) {
        if (repository.existsByAccountNumber(accountNumber)) {
            Account accountByAccountNumber = repository.findAccountByAccountNumber(accountNumber);
            repository.deleteById(accountByAccountNumber.getId());
        } else {
            throw new NotFoundException("account number is not found");
        }
    }

    @Override
    public List<Account> findAll() {
        Iterable<Account> all = repository.findAll();
        return (List<Account>) all;
    }


}