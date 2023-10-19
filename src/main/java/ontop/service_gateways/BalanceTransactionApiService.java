package ontop.service_gateways;

import ontop.transferModels.Balance;

public interface BalanceTransactionApiService {

    Balance getBalanceTransactionFromExternalApi(int userId);
}
