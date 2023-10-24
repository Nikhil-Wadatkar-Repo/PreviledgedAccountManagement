package com.sit.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sit.bean.ModuleDetails;
import com.sit.bean.RoleDetails;
import com.sit.bean.StatusDetails;
import com.sit.bean.UserDetails;
import com.sit.dto.AppLevel_I;
import com.sit.dto.UserDTO;
import com.sit.dto.UserDetailsResponse;
import com.sit.repository.ModuleRepo;
import com.sit.repository.RoleRepo;
import com.sit.repository.StatusRepo;
import com.sit.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModuleRepo moduleRepo;
	@Autowired
	private StatusRepo statusRepo;

	@Autowired
	private RoleRepo roleRepo;

	public UserDetails createUserDetails(UserDTO userDetails) {
		UserDetails details = new UserDetails();
		ModuleDetails findById = moduleRepo.findById(userDetails.getModuleId()).get();
		BeanUtils.copyProperties(userDetails, details);
		details.setModuleDetails(findById);

		details.setEnrolled(statusRepo.findById(3).get());
		details.setStatusLevelI(statusRepo.findById(3).get());
		details.setStatusLevelII(statusRepo.findById(3).get());
		details.setStatusLevelIII(statusRepo.findById(3).get());

		details.setRole(roleRepo.findById(userDetails.getRoleId()).get());
		return userRepo.save(details);
	}

	public UserDetails updateUserDetails(UserDetails userDetails) {
		UserDetails existedUserDetailsByID = getUserDetailsByID(userDetails.getUserId());
		if (null != existedUserDetailsByID) {
			existedUserDetailsByID.setName(userDetails.getName());
			existedUserDetailsByID.setRole(userDetails.getRole());
			existedUserDetailsByID.setPassword(userDetails.getPassword());
			existedUserDetailsByID.setUserName(userDetails.getUserName());
		}
		return userRepo.save(existedUserDetailsByID);
	}

	public UserDetails getUserDetailsByID(Integer id) {
		Optional<UserDetails> findById = userRepo.findById(id);
		if (findById.isPresent())
			return findById.get();
		else
			return null;
	}

	public List<UserDetailsResponse> getAllUserDetails() {
		List<UserDetails> allNewRecords = userRepo.findAll();
		List<UserDetailsResponse> detailsResponses = new LinkedList<>();
		allNewRecords.stream().forEach(obj -> {
			UserDetailsResponse detailsResponse = new UserDetailsResponse();
			detailsResponse.setEnrolled(obj.getEnrolled().getStatusName());
			detailsResponse.setModuleName(obj.getModuleDetails().getModuleName());
			detailsResponse.setUserId(obj.getUserId());
			detailsResponse.setName(obj.getName());
			detailsResponse.setPassword(obj.getPassword());
			detailsResponse.setRole(obj.getRole().getRoleName());
			detailsResponse.setStatusLevelI(obj.getStatusLevelI().getStatusName());
			detailsResponse.setStatusLevelII(obj.getStatusLevelII().getStatusName());
			detailsResponse.setStatusLevelIII(obj.getStatusLevelIII().getStatusName());
			detailsResponse.setUserName(obj.getUserName());

			detailsResponses.add(detailsResponse);
		});
		System.out.println(allNewRecords);
		return detailsResponses;
	}

	public String deleteUserDetailsByID(Integer appID) {
		String message = "";
		Optional<UserDetails> findUserDetailsByAppTime = userRepo.findById(appID);

		if (findUserDetailsByAppTime.isPresent()) {
			userRepo.deleteById(findUserDetailsByAppTime.get().getUserId());
			message = "Deleted";
		}
		message = "Not found";
		return message;
	}

	public List<UserDetails> getenrolledById(Integer id, Integer status) {
		Optional<UserDetails> findById = userRepo.findById(id);
		StatusDetails statusDetails = statusRepo.findById(status).get();
		findById.ifPresent(ovj -> {
			ovj.setEnrolled(statusDetails);
			userRepo.save(ovj);
		});
		return userRepo.getAllNewRecords();
	}

	public List<AppLevel_I> showLevelIRequests() {
		return userRepo.showLevelIApplications();
	}

	public List<AppLevel_I> showLevelIIRequests() {
		return userRepo.showLevelIIApplications();
	}

	public List<AppLevel_I> showLevelIIIRequests() {
		return userRepo.showLevelIIIApplications();
	}

	public List<UserDetailsResponse> changeRequests(Integer userID, Integer level, Integer status) {
		Optional<UserDetails> findById = userRepo.findById(userID);
		findById.ifPresent(obj -> {
			switch (level) {
			case 1: {
				obj.setStatusLevelI(statusRepo.findById(status).get());
			}
				break;
			case 2: {
				obj.setStatusLevelII(statusRepo.findById(status).get());
			}
				break;
			case 3: {
				obj.setStatusLevelIII(statusRepo.findById(status).get());

			}
				break;
			}

			userRepo.save(obj);
		});
		;

		return getAllUserDetails();

	}

	public List<UserDetails> showUserAccessList() {
		return userRepo.showUserAccessList();
	}

	public List<ModuleDetails> showUserModuleList() {
		return moduleRepo.findAll();
	}

	public List<StatusDetails> showStatusList() {
		return statusRepo.findAll();
	}

	public List<RoleDetails> showRoleList() {
		return roleRepo.findAll();
	}
}
