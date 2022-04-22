package atm.atm.Repository;

import atm.atm.Entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepository extends PagingAndSortingRepository<Account, Long> {
    Boolean existsByAccountNumber(Long accountNumber);

    Account findAccountByAccountNumber(Long accountNumber);

    List<Account> findAllByUsers_Username(String username);

}
