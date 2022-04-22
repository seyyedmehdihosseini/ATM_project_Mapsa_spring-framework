package atm.atm.Service;

import atm.atm.Entity.Transaction;
import atm.atm.Repository.ITransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService implements ITransactionService {
    private ITransactionRepository repository ;

    @Override
    public Transaction created(Transaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public Transaction update(Transaction transaction) {

        return null;
    }

    @Override
    public Transaction findByUnique(Long id) {
        return null;
    }

    @Override
    public void deleteByUnique(Long id) {

    }

    @Override
    public List<Transaction> findAll() {
        return null;
    }


}
