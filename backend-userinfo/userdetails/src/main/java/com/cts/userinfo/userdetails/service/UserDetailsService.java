package com.cts.userinfo.userdetails.service;

import com.cts.userinfo.userdetails.entity.UserDetails;

import java.util.List;

public interface UserDetailsService {
    List<UserDetails> getUserDetailsList();

    UserDetails getUserDetailsById(long user_id);

    UserDetails saveUserDetails(UserDetails userDetails);

    void deleteUserDetailsById(long user_id);

    UserDetails updateUserDetailsById(long user_id, UserDetails userDetails);

}
