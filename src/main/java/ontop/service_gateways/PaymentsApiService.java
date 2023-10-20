package ontop.service_gateways;

import ontop.transferModels.TransferRequest;
import ontop.transferModels.TransferResponse;

public interface PaymentsApiService {

    TransferResponse executeTransference(TransferRequest request);
}
