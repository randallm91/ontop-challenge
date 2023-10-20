package ontop.controller;

import ontop.entity.WalletTransactionHistory;
import ontop.service.WalletTransactionHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class WalletTransactionHistoryController {

    @Autowired
    WalletTransactionHistoryServiceImpl walletTransactionHistoryService;

    @GetMapping("/getwallethistorybyid/{user_id}")
    public Optional<WalletTransactionHistory> getWalletTransactionHistory(@PathVariable(value = "user_id")int userId){
        return walletTransactionHistoryService.getWalletTransactionHistoryById(userId);
    }
}
