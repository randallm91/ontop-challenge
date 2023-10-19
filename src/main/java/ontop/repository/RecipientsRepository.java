package ontop.repository;

import ontop.entity.Recipients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RecipientsRepository extends JpaRepository <Recipients, Integer> {

    Optional<Recipients> findRecipientByUserId(int userId);
    Optional<Recipients>findRecipientByNationalIdentificationNumber(String nationalIdentificationNumber);
    Optional<Recipients>findRecipientByAccountNumber(String accountNumber);


}
