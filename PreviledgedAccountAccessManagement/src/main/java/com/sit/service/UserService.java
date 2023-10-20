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
		return userRepo.findAll();
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
}
