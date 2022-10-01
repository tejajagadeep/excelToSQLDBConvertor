package com.cts.userinfo.userdetails.service;

import com.cts.userinfo.userdetails.entity.UserAccountDetails;

import java.util.List;

public interface UserAccountDetailsService{

    List<UserAccountDetails> getUserAccountDetailsList();

    UserAccountDetails getUserAccountDetailsById(long user_account_no);

    void deleteUserAccountDetailsById(long user_account_no);

    UserAccountDetails updateUserAccountDetailsById(long user_account_no, UserAccountDetails userAccountDetails);

    List<UserAccountDetails> saveUserAccountDetailsList(List<UserAccountDetails> userAccountDetailsList);

}
