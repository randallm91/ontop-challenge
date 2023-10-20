package ontop.controller;

import ontop.entity.WalletTransactionHistory;
import ontop.service.WalletTransactionHistoryService;
import ontop.service.WalletTransactionHistoryServiceImpl;
import ontop.transferModels.*;
import ontop.service.TransactionsServiceImpl;
import ontop.service_gateways.BalanceTransactionsApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TransactionsController {


    @Autowired
    BalanceTransactionsApiServiceImpl balanceTransactionsApiService;
    @Autowired
    WalletTransactionHistoryService walletTransactionHistoryService;

    @Autowired
    TransactionsServiceImpl transactionsService;


    @GetMapping("/showbalance/{user_id}")
    public Balance getBalanceApi(@PathVariable(value = "user_id")final int userId) {
        return balanceTransactionsApiService.getBalanceTransactionFromExternalApi(userId);
    }

    @GetMapping("/showfee")
    public double getBalanceApi() {
        return transactionsService.getFee();
    }

    @PostMapping("/executetransaction")
    public TransactionResponse executeTransaction(@RequestBody TransactionRequest transactionRequest){
        return transactionsService.createTransaction(transactionRequest);
    }

    @GetMapping("/getwallethistorybyid/{user_id}")
    public Optional<WalletTransactionHistory>getWalletTransactionHistory(@PathVariable(value = "user_id")int userId){
        return walletTransactionHistoryService.getWalletTransactionHistoryById(userId);
    }








}
