package com.cts.userinfo.userdetails.service;

import com.cts.userinfo.userdetails.entity.UserAccountDetails;
import com.cts.userinfo.userdetails.entity.UserDetails;
import com.cts.userinfo.userdetails.exception.ResourceNotFoundException;
import com.cts.userinfo.userdetails.repository.UserAccountDetailsRepository;
import com.cts.userinfo.userdetails.repository.UserDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;


@Service
public class UserAccountDetailsServiceImpl implements UserAccountDetailsService{

    @Autowired
    private UserAccountDetailsRepository userAccountDetailsRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserAccountDetails saveUserAccountDetails(UserAccountDetails userAccountDetails){
        if(userDetailsRepository.findByUserId(userAccountDetails.getUserId()) == null) {
            throw new ResourceNotFoundException("UserAccountDetails with User Id : "+ userAccountDetails.toString());
        }
        return userAccountDetailsRepository.save(userAccountDetails);
    }

    @Override
    public List<UserAccountDetails> getUserAccountDetailsList() {
        return userAccountDetailsRepository.findAll();
    }

    @Override
    public UserAccountDetails getUserAccountDetailsById(int user_id) {
        return userAccountDetailsRepository.findById(user_id).get();
    }

    @Override
    public void deleteUserAccountDetailsById(int user_id) {
        userAccountDetailsRepository.deleteById(user_id);
    }

    @Override
    public UserAccountDetails updateUserAccountDetailsById(int user_id, UserAccountDetails userAccountDetails) {
        UserAccountDetails userAccountDetailsDB = userAccountDetailsRepository.findById(user_id).get();
        if (user_id==userAccountDetailsDB.getUserId()) {
            userAccountDetailsDB.setUserAccountType(userAccountDetails.getUserAccountType());
            userAccountDetailsDB.setOperationType(userAccountDetails.getOperationType());
            userAccountDetailsDB.setSecondOperatorName(userAccountDetails.getSecondOperatorName());
        }
        return userAccountDetailsRepository.save(userAccountDetailsDB);
    }

    @Override
    public UserAccountDetails updateUserAccountDetails(UserAccountDetails userAccountDetails) {
        return userAccountDetailsRepository.save(userAccountDetails);
    }

    @Override
    public List<UserAccountDetails> saveUserAccountDetailsList(List<UserAccountDetails> userAccountDetailsList) {

        userAccountDetailsList.forEach(userAccountDetails -> {

            log.info(" userId in forEach "+userAccountDetails.getUserId());

            if (userDetailsRepository.findById(userAccountDetails.getUserId()).isPresent()){
                userAccountDetailsRepository.save(userAccountDetails);
                log.info(" userId in  if "+userAccountDetails.getUserId());
                log.info(userAccountDetails.toString());
            }

        });


       return userAccountDetailsList;
    }

}
