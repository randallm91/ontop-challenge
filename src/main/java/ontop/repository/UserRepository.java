package ontop.repository;

import ontop.entity.UserBankInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserBankInformation, Integer> {
}
