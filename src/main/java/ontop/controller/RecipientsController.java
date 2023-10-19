package ontop.controller;

import ontop.entity.Recipients;
import ontop.service.RecipientsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RecipientsController {

    @Autowired
    RecipientsServiceImpl bankInformationService;

    @PostMapping(value = "/add_recipient_bank_information")
    public Recipients addRecipientBankInformation(@RequestBody Recipients information){
        return bankInformationService.addRecipientBankInformation(information);
    }

    @GetMapping("/get_all_recipients")
    public List<Recipients> getRecipientBankInformation(){
        return  bankInformationService.getRecipientsBankInformation();
    }

    @GetMapping("get_recipient_by_account_number/{accountNumber}")
    public Optional<Recipients> getRecipientBankInformationById(@PathVariable(value = "accountNumber") String accountNumber){
       return bankInformationService.getRecipientBankInformationByAccountNumber(accountNumber);
    }
}
