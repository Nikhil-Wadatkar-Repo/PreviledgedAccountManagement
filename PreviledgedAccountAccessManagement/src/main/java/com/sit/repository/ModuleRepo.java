package com.sit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sit.bean.ModuleDetails;

@Repository
public interface ModuleRepo extends JpaRepository<ModuleDetails, Integer> {
}
