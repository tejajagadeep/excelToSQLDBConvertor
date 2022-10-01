package com.cts.userinfo.userdetails.service;

import com.cts.userinfo.userdetails.entity.UserAccountDetails;
import com.cts.userinfo.userdetails.repository.UserAccountDetailsRepository;
import com.cts.userinfo.userdetails.repository.UserDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserAccountDetailsServiceImpl implements UserAccountDetailsService{

    @Autowired
    UserAccountDetailsRepository userAccountDetailsRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public List<UserAccountDetails> getUserAccountDetailsList() {
        return userAccountDetailsRepository.findAll();
    }

    @Override
    public UserAccountDetails getUserAccountDetailsById(long user_account_no) {
        Optional<UserAccountDetails> userAccountDetailsOptional = userAccountDetailsRepository.findById(user_account_no);

        if (userAccountDetailsOptional.isPresent()){
            return userAccountDetailsOptional.get();
        } else {
            throw new NoSuchElementException("Record with User account no : " + user_account_no + "  doesn't exists!");
        }

    }

    @Override
    public void deleteUserAccountDetailsById(long user_account_no) {
        Optional<UserAccountDetails> userAccountDetailsOptional = userAccountDetailsRepository.findById(user_account_no);

        if (userAccountDetailsOptional.isPresent()){
            userAccountDetailsRepository.deleteById(user_account_no);
        } else {
            throw new NoSuchElementException("Record with User account no : " + user_account_no + "  doesn't exists!");
        }

    }

    @Override
    public UserAccountDetails updateUserAccountDetailsById(long user_account_no, UserAccountDetails userAccountDetails) {
        Optional<UserAccountDetails> userAccountDetailsOptional = userAccountDetailsRepository.findById(user_account_no);

        if (userAccountDetailsOptional.isPresent()) {
            UserAccountDetails userAccountDetailsDB = userAccountDetailsOptional.get();
                userAccountDetailsDB.setUserAccountType(userAccountDetails.getUserAccountType());
                userAccountDetailsDB.setOperationType(userAccountDetails.getOperationType());
                userAccountDetailsDB.setSecondOperatorName(userAccountDetails.getSecondOperatorName());
            return userAccountDetailsRepository.save(userAccountDetailsDB);
        } else {
            throw new NoSuchElementException("Record with User account no : " + user_account_no + "  doesn't exists!");
        }

    }

    @Override
    public List<UserAccountDetails> saveUserAccountDetailsList(List<UserAccountDetails> userAccountDetailsList) {

        userAccountDetailsList.forEach(userAccountDetails -> {

            log.info(" userId in forEach "+userAccountDetails.getUserId());

            if (userDetailsRepository.findById(userAccountDetails.getUserId()).isPresent() && userAccountDetailsRepository.findByUserId(userAccountDetails.getUserId()).isEmpty()){
                userAccountDetailsRepository.save(userAccountDetails);
                log.info(" userId in  if "+userAccountDetails.getUserId());
                log.info(userAccountDetails.toString());
            }

        });


       return userAccountDetailsList;
    }

}
