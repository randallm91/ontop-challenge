package ontop.service;

import ontop.entity.OntopAccounts;
import ontop.repository.OntopAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class OntopAccountServiceImpl implements OntopAccountService{


    @Override
    public OntopAccounts getOntopAccounts() {
        return null;
    }
}
