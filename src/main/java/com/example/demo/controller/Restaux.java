package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDao;
import com.example.demo.model.DAOUser;



@RestController
@RequestMapping("api/restaux")
public class Restaux {
	@Autowired
	private  UserDao restautrepository;

	// get all
	@CrossOrigin(origins ="http://localhost:3000")
	@GetMapping
	public List<DAOUser> getAllRestaux() {
		return (List<DAOUser>) this.restautrepository.findAll();
	}

}
