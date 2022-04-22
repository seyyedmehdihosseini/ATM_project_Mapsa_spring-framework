package atm.atm.Repository;

import atm.atm.Entity.Users;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<Users,Long> {
    Boolean existsByUsername(String username);

    Users findUsersByUsername(String username);

}
