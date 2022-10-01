package com.cts.userinfo.userdetails.controller;

import com.cts.userinfo.userdetails.entity.UserAccountDetails;
import com.cts.userinfo.userdetails.model.MessageResponse;
import com.cts.userinfo.userdetails.repository.UserAccountDetailsRepository;
import com.cts.userinfo.userdetails.service.UserAccountDetailsService;
import com.cts.userinfo.userdetails.service.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserAccountDetailsController {

    @Autowired
    UserAccountDetailsService userAccountDetailsService;

    @Autowired
    UserAccountDetailsRepository userDetailsAccountRepository;

    Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    public UserAccountDetailsController() {
    }

    @PostMapping("/saveAllUserAccountDetails")
    public ResponseEntity<List<UserAccountDetails>> saveUserAccountDetailsList(@RequestBody List<UserAccountDetails> userAccountDetailsList){
        return new ResponseEntity<>(userAccountDetailsService.saveUserAccountDetailsList(userAccountDetailsList), HttpStatus.OK);
    }

    @GetMapping("/returnStoredAccountCount")
    public ResponseEntity<MessageResponse> returnStoredAccountCount(){
        log.info("Controller Number of Records Stored : " + userDetailsAccountRepository.count());
        return new ResponseEntity<>(new MessageResponse(userDetailsAccountRepository.count(), userDetailsAccountRepository.count()+" Records are Successfully stored"), HttpStatus.OK);
    }

    @GetMapping("/getUserAccountDetails")
    public ResponseEntity<List<UserAccountDetails>> getUserAccountDetailsList(){
        return new ResponseEntity<>(userAccountDetailsService.getUserAccountDetailsList(), HttpStatus.OK);
    }

    @GetMapping("/getUserAccountDetailsById/{user_account_no}")
    public ResponseEntity<UserAccountDetails> getUserAccountDetailsById(@PathVariable long user_account_no){
        return new ResponseEntity<>(userAccountDetailsService.getUserAccountDetailsById(user_account_no), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUserAccountDetailsById/{user_account_no}")
    public ResponseEntity<List<UserAccountDetails>> deleteUserAccountDetailsById(@PathVariable long user_account_no){
        UserAccountDetails deletedUserAccountDetails = userDetailsAccountRepository.getReferenceById(user_account_no);
        userAccountDetailsService.deleteUserAccountDetailsById(user_account_no);
        return new ResponseEntity<>(userDetailsAccountRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/updateUserAccountDetailsById/{user_account_no}")
    public ResponseEntity<UserAccountDetails> updateUserAccountDetailsById(@PathVariable long user_account_no, @RequestBody UserAccountDetails userAccountDetails){
        return new ResponseEntity<>(userAccountDetailsService.updateUserAccountDetailsById(user_account_no, userAccountDetails), HttpStatus.OK);
    }

}
