package com.sit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sit.bean.ModuleDetails;
import com.sit.bean.RoleDetails;
import com.sit.bean.StatusDetails;
import com.sit.bean.UserDetails;
import com.sit.dto.AppLevel_I;
import com.sit.dto.UserDTO;
import com.sit.dto.UserDetailsResponse;
import com.sit.service.UserService;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/createUserDetails")
	public UserDetails createUserDetails(@RequestBody UserDTO dto) {
		
		return userService.createUserDetails(dto);
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
	public List<UserDetailsResponse> getAllUserDetails() {
		return userService.getAllUserDetails();
	}

	@DeleteMapping("/deleteUserDetailsByID/{id}")
	public String deleteUserDetailsByID(Integer appID) {
		return userService.deleteUserDetailsByID(appID);
	}

	@GetMapping("/enrolledById/{userId}/{status}")
	public List<UserDetailsResponse> getEnrolledById(@PathVariable("userId") Integer userID,
			@PathVariable("status") Integer status) {
		userService.getenrolledById(userID, status);
		return userService.getAllUserDetails();
	}

	@GetMapping("/showLevelIRequests")
	public List<AppLevel_I> showLevelIRequests() {
		return userService.showLevelIRequests();
	}

	@GetMapping("/showLevelIIRequests")
	public List<AppLevel_I> showLevelIIRequests() {
		return userService.showLevelIIRequests();
	}

	@GetMapping("/showLevelIIIRequests")
	public List<AppLevel_I> showLevelIIIRequests() {
		return userService.showLevelIIIRequests();
	}

	@GetMapping("/showUserAccessList")
	public List<UserDetails> showUserAccessList() {
		return userService.showUserAccessList();
	}

	@GetMapping("/changeRequests/{level}/{userId}/{status}")
	public List<UserDetailsResponse> changeRequests(@PathVariable("userId") Integer userID,
			@PathVariable("level") Integer level, @PathVariable("status") Integer statusId) {
		return userService.changeRequests(userID, level, statusId);
	}

	@GetMapping("/showModuleList")
	public List<ModuleDetails> showModuleList() {
		return userService.showUserModuleList();
	}

	@GetMapping("/showStatusList")
	public List<StatusDetails> showStatusList() {
		return userService.showStatusList();
	}

	@GetMapping("/showRoleList")
	public List<RoleDetails> showRoleList() {
		return userService.showRoleList();
	}
}
