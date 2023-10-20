package com.sit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sit.bean.UserDetails;
import com.sit.service.UserService;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/createUserDetails")
	public UserDetails createUserDetails(@RequestBody UserDetails userDetails) {
		return userService.createUserDetails(userDetails);
	}

	@PostMapping("/updateUserDetails")
	public UserDetails updateUserDetails(@RequestBody UserDetails userDetails) {
		return userService.updateUserDetails(userDetails);
	}

	@GetMapping("/getUserDetailsByID/{id}")
	public UserDetails getUserDetailsByID(@PathVariable("id") Integer id) {
		UserDetails findById = userService.getUserDetailsByID(id);
		return findById;
	}

	@GetMapping("/getAllUserDetails")
	public List<UserDetails> getAllUserDetails() {
		return userService.getAllUserDetails();
	}

	@DeleteMapping("/deleteUserDetailsByID/{id}")
	public String deleteUserDetailsByID(Integer appID) {
		return userService.deleteUserDetailsByID(appID);
	}

	@GetMapping("/enrolledById/{userId}/{status}")
	public List<UserDetails> getEnrolledById(@PathVariable("userId") Integer userID,
			@PathVariable("status") String status) {
		userService.getenrolledById(userID, status);
		return userService.getAllUserDetails();
	}
	
	@GetMapping("/showLevelIRequests")
	public List<UserDetails> showLevelIRequests() {		
		return userService.showLevelIRequests();
	}
	@GetMapping("/showLevelIIRequests")
	public List<UserDetails> showLevelIIRequests() {		
		return userService.showLevelIIRequests();
	}
	@GetMapping("/showLevelIIIRequests")
	public List<UserDetails> showLevelIIIRequests() {		
		return userService.showLevelIIIRequests();
	}
	@GetMapping("/showUserAccessList")
	public List<UserDetails> showUserAccessList() {		
		return userService.showUserAccessList();
	}

	@GetMapping("/changeRequests/{level}/{userId}/{status}")
	public List<UserDetails> changeRequests(
			@PathVariable("userId") Integer userID,
			@PathVariable("level") Integer level,
			@PathVariable("status") String status
			) {		
		return userService.changeRequests(userID,level,status);
	}
}
