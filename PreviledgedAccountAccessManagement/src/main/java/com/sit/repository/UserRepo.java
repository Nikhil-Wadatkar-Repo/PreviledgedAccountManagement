package com.sit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sit.bean.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer> {

	@Query(value = "select * from user_details where enrolled like 'new'", nativeQuery = true)
	List<UserDetails> getAllNewRecords();
	
	@Query(value = "select * from user_details where ENROLLED like 'Approved' and  STATUS_LEVELI  like '%ew%'", nativeQuery = true)
	List<UserDetails> showLevelIApplications();
	@Query(value = "select * from user_details where STATUS_LEVELI like 'Approved' and ENROLLED like 'Approved' and STATUS_LEVELII like '%ew%'", nativeQuery = true)
	List<UserDetails> showLevelIIApplications();
	@Query(value = "select * from user_details where ENROLLED like 'Approved' and STATUS_LEVELI like 'Approved' and STATUS_LEVELII like 'Approved' and STATUS_LEVELIII like '%ew%'", nativeQuery = true)
	List<UserDetails> showLevelIIIApplications();
	@Query(value = "select * from user_details where ENROLLED like 'Approved' and STATUS_LEVELIII like 'Approved' ", nativeQuery = true)
	List<UserDetails> showUserAccessList();

//	@Query(value = "update user_details set user_details.enrolled = :status where USER_ID = :id", nativeQuery = true)
//	Integer makeEnrollment(@Param("id") Integer userID, @Param("status") String status);

}
