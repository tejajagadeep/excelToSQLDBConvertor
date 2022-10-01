package com.cts.userinfo.userdetails.controller;

import com.cts.userinfo.userdetails.entity.UserDetails;
import com.cts.userinfo.userdetails.model.MessageResponse;
import com.cts.userinfo.userdetails.repository.UserDetailsRepository;
import com.cts.userinfo.userdetails.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserDetailsController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @PostMapping("/saveUserDetails")
    public ResponseEntity<UserDetails> saveUserDetails(@RequestBody UserDetails userDetails){
        return new ResponseEntity<>(userDetailsService.saveUserDetails(userDetails), HttpStatus.OK);
    }

    @GetMapping("/getUserDetails")
    public ResponseEntity<List<UserDetails>> getUserDetailsList(){
        return new ResponseEntity<>(userDetailsService.getUserDetailsList(), HttpStatus.OK);
    }

    @GetMapping("/getUserDetailsById/{user_id}")
    public ResponseEntity<UserDetails> getUserDetailsById(@PathVariable long user_id){
        return new ResponseEntity<>(userDetailsService.getUserDetailsById(user_id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUserDetailsById/{user_id}")
    public ResponseEntity<List<UserDetails>> deleteUserDetailsById(@PathVariable long user_id){
        UserDetails deletedUserDetails = userDetailsRepository.getReferenceById(user_id);
        userDetailsService.deleteUserDetailsById(user_id);
        return new ResponseEntity<>(userDetailsRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/updateUserDetailsById/{user_id}")
    public ResponseEntity<UserDetails> updateUserDetailsById(@PathVariable long user_id,@RequestBody UserDetails userDetails){
        return new ResponseEntity<>(userDetailsService.updateUserDetailsById(user_id, userDetails), HttpStatus.OK);
    }

}
