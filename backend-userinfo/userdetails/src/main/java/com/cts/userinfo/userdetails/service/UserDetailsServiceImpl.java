package com.cts.userinfo.userdetails.service;


import com.cts.userinfo.userdetails.entity.UserDetails;
import com.cts.userinfo.userdetails.repository.UserDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService{



    @Autowired
    UserDetailsRepository userDetailsRepository;


    @Override
    public UserDetails saveUserDetails(UserDetails userDetails) {
        Optional<UserDetails> userDetailsOptional = userDetailsRepository.findById(userDetails.getUserId());

        if (userDetailsOptional.isEmpty()) {
            return userDetailsRepository.save(userDetails);
        } else {
            throw new NoSuchElementException("Record with User Id : " + userDetails.getUserId() + "  doesn't exists!");
        }
    }

    @Override
    public List<UserDetails> getUserDetailsList(){
        return userDetailsRepository.findAll();
    }

    @Override
    public UserDetails getUserDetailsById(long user_id) {
        Optional<UserDetails> userDetailsOptional = userDetailsRepository.findById(user_id);
        if (userDetailsOptional.isPresent()){
            return userDetailsOptional.get();
        } else {
            throw new NoSuchElementException("Record with User Id : " + user_id + "  doesn't exists!");
        }

    }

    @Override
    public void deleteUserDetailsById(long user_id) {
        Optional<UserDetails> userDetailsOptional = userDetailsRepository.findById(user_id);
        if (userDetailsOptional.isPresent()){
            userDetailsRepository.deleteById(user_id);
        } else {
            throw new NoSuchElementException("Record with User Id : " + user_id + "  doesn't exists!");
        }
    }

    @Override
    public UserDetails updateUserDetailsById(long user_id, UserDetails userDetails) {

        Optional<UserDetails> userDetailsOptional = userDetailsRepository.findById(user_id);

        if (userDetailsOptional.isPresent()) {
            UserDetails userDetailsDB = userDetailsOptional.get();
                userDetailsDB.setUserEmailId(userDetails.getUserEmailId());
                userDetailsDB.setUserMobileNumber(userDetails.getUserMobileNumber());

            return userDetailsRepository.save(userDetailsDB);
        } else {
            throw new NoSuchElementException("Record with User Id : " + user_id + "  doesn't exists!");
        }
    }
}
