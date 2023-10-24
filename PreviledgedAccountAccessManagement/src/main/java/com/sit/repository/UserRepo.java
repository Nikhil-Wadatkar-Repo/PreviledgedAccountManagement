package com.sit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sit.bean.UserDetails;
import com.sit.dto.AppLevel_I;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer> {
	String queryLevelI = "select ud.user_id as userId, ud.USER_NAME as userName,ud.name as name,(select ROLE_NAME from role_Details where ROLE_ID = ud.role_id ) as role,(select md.MODULE_NAME from module_Details md where md.MODULE_ID = ud.MODILE_ID) as moduleName "
			+ "from user_details ud where  ud.enrolled =(select status_id from status_details where STATUS_NAME like 'Approved') and ud.STATUS_LEVEL_I =(select status_id from status_details where STATUS_NAME like 'New')";
String queryLevelII="select ud.user_id as userId, ud.USER_NAME as userName, ud.name as name,(select ROLE_NAME from role_Details where ROLE_ID = ud.role_id ) as role,(select md.MODULE_NAME from module_Details md where md.MODULE_ID = ud.MODILE_ID) as moduleName  from user_details ud where  ud.enrolled =(select status_id from status_details where STATUS_NAME like 'Approved') and  ud.STATUS_LEVEL_I =(select status_id from status_details where STATUS_NAME like 'Approved')and ud.STATUS_LEVEL_II =(select status_id from status_details where STATUS_NAME like 'New')";

String queryLevelIII="select ud.user_id as userId,  ud.USER_NAME as userName,ud.name as name,(select ROLE_NAME from role_Details where ROLE_ID = ud.role_id ) as role,(select md.MODULE_NAME from module_Details md where md.MODULE_ID = ud.MODILE_ID) as moduleName  \r\n"
		+ "from user_details ud where  \r\n"
		+ "ud.enrolled =(select status_id from status_details where STATUS_NAME like 'Approved') and \r\n"
		+ "ud.STATUS_LEVEL_I =(select status_id from status_details where STATUS_NAME like 'Approved')and\r\n"
		+ "ud.STATUS_LEVEL_II =(select status_id from status_details where STATUS_NAME like 'Approved')and\r\n"
		+ "ud.STATUS_LEVEL_III =(select status_id from status_details where STATUS_NAME like 'New')";
	@Query(value = "select * from user_details ud where ud.enrolled =(select status_id from status_details where STATUS_NAME like 'New')", nativeQuery = true)
	List<UserDetails> getAllNewRecords();

	@Query(value = queryLevelI, nativeQuery = true)
	List<AppLevel_I> showLevelIApplications();

	@Query(value = queryLevelII, nativeQuery = true)
	List<AppLevel_I> showLevelIIApplications();

	@Query(value = queryLevelIII, nativeQuery = true)
	List<AppLevel_I> showLevelIIIApplications();

	@Query(value = "select * from user_details where ENROLLED like 'Approved' and STATUS_LEVELIII like 'Approved' ", nativeQuery = true)
	List<UserDetails> showUserAccessList();

//	@Query(value = "update user_details set user_details.enrolled = :status where USER_ID = :id", nativeQuery = true)
//	Integer makeEnrollment(@Param("id") Integer userID, @Param("status") String status);

}
