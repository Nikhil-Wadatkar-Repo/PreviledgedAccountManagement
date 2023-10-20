package com.sit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sit.bean.UserDetails;

@Repository
public interface UserRepo  extends JpaRepository<UserDetails, Integer>{

}
