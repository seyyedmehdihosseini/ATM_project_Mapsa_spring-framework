package atm.atm.Service;

import atm.atm.Entity.Account;

import java.util.List;

public interface IAccountService extends CRUD<Account,Long>{
    public Boolean existByAccountNumbers(Long accountNumber);
    public Account created(String username , Account account);
    public List<Account> findAllByUsername(String username);

    public Boolean fundTransfers(Long accountNumberSender, Long amount, Long accountNumberReceiver);
    public Long depositToAccount(Long accountNumber , Long amount); // variz b hesab
/*
    public Boolean withdrawToAccount(Long accountNumber , Long amount);
    public Long balance(Long accountNumber);
*/

}
