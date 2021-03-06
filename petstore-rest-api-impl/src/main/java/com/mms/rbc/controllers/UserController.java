package com.mms.rbc.controllers;

import java.util.Collection;
import com.mms.rbc.model.user.StoreUser;
import com.mms.rbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String findAllFromRoot() {
		return "Please select add a context: /pet";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{userName}/{password}")
	public ResponseEntity<?> findUser(@ModelAttribute("userName") String userName, @ModelAttribute("password") String password) {
		StoreUser user = userService.findUser(userName, password);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public Collection<StoreUser> findUsers(@ModelAttribute("userName") String userName, @ModelAttribute("password") String password) {
		return userService.findAll();
	}
	
}
