package atm.atm.Service;

public interface BankingOperations {
    public Boolean fundTransfers(Long accountNumberSender, Long amount, Long accountNumberReceiver);
    public Long Inventory(Long accountNumber);// mojodi
    public Boolean Withdrawals(Long accountNumber , Long amount);//bardasht
    public Boolean Increase(Long accountNumber , Long amount);// afzayesh

}
