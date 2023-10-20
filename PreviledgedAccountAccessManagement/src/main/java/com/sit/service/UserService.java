package com.sit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sit.bean.UserDetails;
import com.sit.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public UserDetails createUserDetails(UserDetails userDetails) {
		userDetails.setEnrolled("new");
		userDetails.setStatusLevelI("new");
		userDetails.setStatusLevelII("new");
		userDetails.setStatusLevelIII("new");
		return userRepo.save(userDetails);
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

	public List<UserDetails> getAllUserDetails() {
		return userRepo.getAllNewRecords();
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

	public List<UserDetails> getenrolledById(Integer id, String status) {
		Optional<UserDetails> findById = userRepo.findById(id);
		findById.ifPresent(ovj -> {
			ovj.setEnrolled(status);
			userRepo.save(ovj);
		});
		return userRepo.getAllNewRecords();
	}

	public List<UserDetails> showLevelIRequests() {
		return userRepo.showLevelIApplications();
	}

	public List<UserDetails> showLevelIIRequests() {
		return userRepo.showLevelIIApplications();
	}

	public List<UserDetails> showLevelIIIRequests() {
		return userRepo.showLevelIIIApplications();
	}

	public List<UserDetails> changeRequests(Integer userID, Integer level, String status) {
		Optional<UserDetails> findById = userRepo.findById(userID);
		findById.ifPresent(obj -> {
			switch (level) {
			case 1: {
				obj.setStatusLevelI(status);
			}
				break;
			case 2: {
				obj.setStatusLevelII(status);
			}
				break;
			case 3: {
				obj.setStatusLevelIII(status);

			}
				break;
			}

			userRepo.save(obj);
		});
		;

		return userRepo.findAll();

	}

	public List<UserDetails> showUserAccessList() {
		return userRepo.showUserAccessList();
	}
}
