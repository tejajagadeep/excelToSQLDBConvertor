package com.cts.userinfo.userdetails.service;

import com.cts.userinfo.userdetails.entity.UserAccountDetails;
import com.cts.userinfo.userdetails.entity.UserDetails;

import java.util.List;

public interface UserAccountDetailsService{

    public UserAccountDetails saveUserAccountDetails(UserAccountDetails userAccountDetails);

    public List<UserAccountDetails> getUserAccountDetailsList();

    public UserAccountDetails getUserAccountDetailsById(int user_id);

    public void deleteUserAccountDetailsById(int user_id);

    public UserAccountDetails updateUserAccountDetailsById(int user_id, UserAccountDetails userAccountDetails);

    public UserAccountDetails updateUserAccountDetails(UserAccountDetails userAccountDetails);

    public List<UserAccountDetails> saveUserAccountDetailsList(List<UserAccountDetails> userAccountDetailsList);

}
