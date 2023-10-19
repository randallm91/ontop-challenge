package ontop.service_gateways;

import ontop.transferModels.WalletRequest;
import ontop.transferModels.WalletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WalletTransactionsApiServiceImpl implements WalletTransactionApiService {

    private final String API_URL = "http://mockoon.tools.getontop.com:3000/wallets/transactions";
    @Autowired
    RestTemplate restTemplate;
    public WalletTransactionsApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public WalletResponse getTransactionFromExternalApi(WalletRequest request) {
        ResponseEntity<WalletResponse> response;
            HttpEntity<WalletRequest> transactionsHttpEntity = new HttpEntity<>(request);
             response= restTemplate.postForEntity(API_URL,transactionsHttpEntity, WalletResponse.class);
        return response.getBody();
    }
}
