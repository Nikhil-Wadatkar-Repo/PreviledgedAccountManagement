package com.sit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sit.bean.RoleDetails;

@Repository
public interface RoleRepo extends JpaRepository<RoleDetails, Integer> {

}
