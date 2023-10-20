package ontop.service_gateways;

import ontop.entity.Transactions;
import ontop.transferModels.WalletRequest;
import ontop.transferModels.WalletResponse;

public interface WalletTransactionApiService {

    WalletResponse getTransactionFromExternalApi(WalletRequest walletRequest);
}
