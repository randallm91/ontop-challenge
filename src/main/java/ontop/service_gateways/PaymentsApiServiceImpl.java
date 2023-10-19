package ontop.service_gateways;

import ontop.transferModels.TransferRequest;
import ontop.transferModels.TransferResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentsApiServiceImpl  implements PaymentsApiService{

    private final String API_URL = "http://mockoon.tools.getontop.com:3000/api/v1/payments";

    @Autowired
    RestTemplate restTemplate;

    public PaymentsApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public TransferResponse executeTransference(TransferRequest transferRequest) {
        ResponseEntity<TransferResponse> response;
        HttpEntity<TransferRequest> transferRequestHttpEntity = new HttpEntity<>(transferRequest);
        response= restTemplate.postForEntity(API_URL,transferRequestHttpEntity, TransferResponse.class);

        return response.getBody();
    }

}
