package ontop.controller;

import ontop.entity.UserBankInformation;
import ontop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/addbankinformation")
    @ResponseBody
    public UserBankInformation adduserbankinformation(@RequestBody UserBankInformation information){
        return userRepository.save(information);
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "display the bank information";
    }


}
