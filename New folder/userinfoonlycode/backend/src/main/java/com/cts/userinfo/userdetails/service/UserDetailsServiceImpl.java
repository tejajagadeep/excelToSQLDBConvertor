package com.cts.userinfo.userdetails.service;


import com.cts.userinfo.userdetails.entity.UserDetails;
import com.cts.userinfo.userdetails.repository.UserDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService{



    @Autowired
    private UserDetailsRepository userDetailsRepository;


    @Override
    public UserDetails saveUserDetails(UserDetails userDetails) {
//        List<UserDetails> userDetailsList = null;
//        log.info(String.valueOf("the size of : "+userDetailsList.size()));
        return userDetailsRepository.save(userDetails);
    }

    @Override
    public List<UserDetails> getUserDetailsList(){
        return userDetailsRepository.findAll();
    }

    @Override
    public UserDetails getUserDetailsById(int user_id) {
        return userDetailsRepository.findById(user_id).get();
    }

    @Override
    public void deleteUserDetailsById(int user_id) {
        userDetailsRepository.deleteById(user_id);
    }

    @Override
    public UserDetails updateUserDetailsById(int user_id, UserDetails userDetails) {
        UserDetails userDetailsDB = userDetailsRepository.findById(user_id).get();
        if (user_id==userDetailsDB.getUserId()) {
            userDetailsDB.setUserEmailId(userDetails.getUserEmailId());
            userDetailsDB.setUserMobileNumber(userDetails.getUserMobileNumber());
        }
        return userDetailsRepository.save(userDetailsDB);
    }

    @Override
    public UserDetails updateUserDetails(UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }

}
