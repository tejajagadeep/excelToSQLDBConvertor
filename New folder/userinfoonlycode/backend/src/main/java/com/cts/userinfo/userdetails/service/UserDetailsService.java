package com.cts.userinfo.userdetails.service;

import com.cts.userinfo.userdetails.entity.UserAccountDetails;
import com.cts.userinfo.userdetails.entity.UserDetails;

import java.util.List;

public interface UserDetailsService {
    public List<UserDetails> getUserDetailsList();

    public UserDetails getUserDetailsById(int user_id);

    public UserDetails saveUserDetails(UserDetails userDetails);

    public void deleteUserDetailsById(int user_id);

    public UserDetails updateUserDetailsById(int user_id, UserDetails userDetails);

    public UserDetails updateUserDetails(UserDetails userDetails);

//
}
