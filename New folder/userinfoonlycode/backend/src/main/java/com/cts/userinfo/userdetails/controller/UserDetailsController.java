package com.cts.userinfo.userdetails.controller;

import com.cts.userinfo.userdetails.entity.UserDetails;
import com.cts.userinfo.userdetails.model.MessageResponse;
import com.cts.userinfo.userdetails.repository.UserDetailsRepository;
import com.cts.userinfo.userdetails.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserDetailsController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @GetMapping("/helloWorld")
    public MessageResponse helloWorld(){
        return new MessageResponse("Hello World");
    }

    @PostMapping("/saveUserDetails")
    public UserDetails saveUserDetails(@RequestBody UserDetails userDetails){
        return userDetailsService.saveUserDetails(userDetails);
    }

    @GetMapping("/getUserDetails")
    public List<UserDetails> getUserDetailsList(){
//        return userDetailsRepository.findAll();
        return userDetailsService.getUserDetailsList();
    }

    @GetMapping("/getUserDetailsById/{user_id}")
    public UserDetails getUserDetailsById(@PathVariable int user_id){
        return userDetailsService.getUserDetailsById(user_id);
    }

    @DeleteMapping("/deleteUserDetailsById/{user_id}")
    public List<UserDetails> deleteUserDetailsById(@PathVariable int user_id){
        UserDetails deletedUserDetails = userDetailsRepository.getReferenceById(user_id);
        userDetailsService.deleteUserDetailsById(user_id);
//        return "deleted "+deletedUserDetails.toString();
        return userDetailsRepository.findAll();
    }

    @PutMapping("/updateUserDetailsById/{user_id}")
    public UserDetails updateUserDetailsById(@PathVariable int user_id,@RequestBody UserDetails userDetails){
        return userDetailsService.updateUserDetailsById(user_id, userDetails);
    }

    @PutMapping("/updateUserDetails")
    public UserDetails updateUserDetails(@RequestBody UserDetails userDetails){
        return userDetailsService.updateUserDetails(userDetails);
    }



}
