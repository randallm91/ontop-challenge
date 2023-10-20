package ontop.service_gateways;

import ontop.transferModels.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BalanceTransactionsApiServiceImpl implements BalanceTransactionApiService{

    @Autowired
    RestTemplate restTemplate;

    public BalanceTransactionsApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Balance getBalanceTransactionFromExternalApi(int userId) {
        String API_URL = "http://mockoon.tools.getontop.com:3000/wallets/balance?user_id=%s";
        String formatterURL = String.format(API_URL,userId);
        ResponseEntity<Balance> response = restTemplate.getForEntity(formatterURL, Balance.class);
        return response.getBody();
    }
}
