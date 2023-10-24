package com.sit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sit.bean.ModuleDetails;
import com.sit.bean.StatusDetails;

@Repository
public interface StatusRepo extends JpaRepository<StatusDetails, Integer> {
}
