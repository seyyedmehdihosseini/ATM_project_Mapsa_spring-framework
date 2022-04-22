package atm.atm.Service;

import atm.atm.Entity.Transaction;

public interface ITransactionService extends CRUD<Transaction,Long> {

    public Transaction created(Transaction transaction);


}
