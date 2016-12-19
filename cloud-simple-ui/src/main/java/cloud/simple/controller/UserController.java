package cloud.simple.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.simple.domain.User;
import cloud.simple.feign.UserService;


@RestController
public class UserController {
		
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/users")
	public List<User> readUserInfo(){
		return userService.searchAll();		
	}
	
}
