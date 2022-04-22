package atm.atm.Repository;

import atm.atm.Entity.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransactionRepository extends PagingAndSortingRepository<Transaction,Long> {
    @Query("select t from Transaction t where t.account = ?1")
    Iterable<Transaction> findAllByAccountEquals(Long accountNumber);
}
