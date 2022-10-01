package com.cts.userinfo.userdetails.controller;

import com.cts.userinfo.userdetails.entity.UserAccountDetails;
import com.cts.userinfo.userdetails.model.MessageResponse;
import com.cts.userinfo.userdetails.repository.UserAccountDetailsRepository;
import com.cts.userinfo.userdetails.service.UserAccountDetailsService;
import com.cts.userinfo.userdetails.service.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserAccountDetailsController {

    @Autowired
    private UserAccountDetailsService userAccountDetailsService;

    @Autowired
    private UserAccountDetailsRepository userDetailsAccountRepository;

    Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    public UserAccountDetailsController() {
    }

    @PostMapping("/saveUserAccountDetails")
    public UserAccountDetails saveUserAccountDetails(@RequestBody UserAccountDetails userAccountDetails){
        return userAccountDetailsService.saveUserAccountDetails(userAccountDetails);
    }

    @PostMapping("/saveAllUserAccountDetails")
    public List<UserAccountDetails> saveUserAccountDetailsList(@RequestBody List<UserAccountDetails> userAccountDetailsList){
        return userAccountDetailsService.saveUserAccountDetailsList(userAccountDetailsList);
    }

    @GetMapping("/returnStoredAccountCount")
    public MessageResponse returnStoredAccountCount(){
        log.info("Controller Number of Records Stored : " + userDetailsAccountRepository.count());
        return new MessageResponse(userDetailsAccountRepository.count(), userDetailsAccountRepository.count()+" Records are Successfully stored");
    }

    @GetMapping("/getUserAccountDetails")
    public List<UserAccountDetails> getUserAccountDetailsList(){
        return userAccountDetailsService.getUserAccountDetailsList();
    }

    @GetMapping("/getUserAccountDetailsById/{user_id}")
    public UserAccountDetails getUserAccountDetailsById(@PathVariable int user_id){
        return userAccountDetailsService.getUserAccountDetailsById(user_id);
    }

    @DeleteMapping("/deleteUserAccountDetailsById/{user_id}")
    public List<UserAccountDetails> deleteUserAccountDetailsById(@PathVariable int user_id){
        UserAccountDetails deletedUserAccountDetails = userDetailsAccountRepository.getReferenceById(user_id);
        userAccountDetailsService.deleteUserAccountDetailsById(user_id);
        return userDetailsAccountRepository.findAll();
    }

    @PutMapping("/updateUserAccountDetailsById/{user_id}")
    public UserAccountDetails updateUserAccountDetailsById(@PathVariable int user_id, @RequestBody UserAccountDetails userAccountDetails){
        return userAccountDetailsService.updateUserAccountDetailsById(user_id, userAccountDetails);
    }

    @PutMapping("/updateUserAccountDetails")
    public UserAccountDetails updateAccountUserDetails(@RequestBody UserAccountDetails userAccountDetails){
        return userAccountDetailsService.updateUserAccountDetails(userAccountDetails);
    }

}
