package ontop.repository;

import ontop.entity.OntopAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OntopAccountRepository extends JpaRepository<OntopAccounts,Integer> {

}
