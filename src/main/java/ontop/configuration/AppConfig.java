package ontop.configuration;

import ontop.business.CalculateAmounts;
import ontop.entity.OntopAccounts;
import ontop.entity.Recipients;
import ontop.transferModels.TransactionRequest;
import ontop.transferModels.TransactionResponse;
import ontop.transferModels.TransferRequest;
import ontop.transferModels.WalletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CalculateAmounts amounts(){
        return new CalculateAmounts();
    }

    @Bean
    Recipients bankInformation(){
        return new Recipients();
    }

    @Bean
    WalletResponse walletResponse(){
        return new WalletResponse();
    }
    @Bean
    TransactionRequest transactionRequest(){
       return new TransactionRequest();
    }

    @Bean
    TransactionResponse transactionResponse(){
        return new TransactionResponse();
    }

    @Bean
    OntopAccounts ontopAccounts(){
        return new OntopAccounts();
    }


}
