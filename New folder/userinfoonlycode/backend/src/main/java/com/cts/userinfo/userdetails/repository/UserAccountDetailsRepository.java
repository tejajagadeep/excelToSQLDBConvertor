package com.cts.userinfo.userdetails.repository;

import com.cts.userinfo.userdetails.entity.UserAccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccountDetailsRepository extends JpaRepository<UserAccountDetails, Integer> {
}
