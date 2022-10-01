package com.cts.userinfo.userdetails.repository;

import com.cts.userinfo.userdetails.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

    UserDetails findByUserId(int userId);
}
