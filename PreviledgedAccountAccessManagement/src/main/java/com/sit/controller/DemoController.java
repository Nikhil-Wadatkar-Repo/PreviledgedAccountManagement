package com.sit.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sit.bean.ModuleDetails;
import com.sit.bean.StatusDetails;
import com.sit.bean.UserDetails;
import com.sit.dto.UserDTO;
import com.sit.repository.ModuleRepo;
import com.sit.repository.StatusRepo;
import com.sit.repository.UserRepo;

@RestController
public class DemoController {
	@Autowired
	private ModuleRepo moduleRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private StatusRepo statusRepo;

	@PostMapping("/saveUserDetails")
	public UserDetails saveUserDetails(@RequestBody UserDTO dto) {
		System.out.println(dto);
		UserDetails details = new UserDetails();

		ModuleDetails findById = moduleRepo.findById(dto.getModuleId()).get();
		StatusDetails status1 =statusRepo.findById(dto.getStatusLevelI()).get();

		BeanUtils.copyProperties(dto, details);
		details.setModuleDetails(findById);
		details.setStatusLevelI(status1);
		
		UserDetails save = userRepo.save(details);

		return save;
	}

	@GetMapping("/get/{id}")
	public UserDetails getUserDetailsByID(@PathVariable("id") Integer id) {
		return userRepo.findById(id).get();
	}
}
