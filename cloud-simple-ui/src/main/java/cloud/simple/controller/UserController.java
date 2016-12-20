package cloud.simple.controller;



import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cloud.simple.domain.User;
import cloud.simple.feign.UserService;

@RestController
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@HystrixCommand(fallbackMethod = "fallBackCall")
	@RequestMapping(value="/users")
	public List<User> readUserInfo(){
		return userService.searchAll();		
	}
	
	public List<User> fallBackCall(Throwable e) {
        LOGGER.error("In fallback: ", e);
        List<User> fallback = new ArrayList<User>();
        User user = new User();
        user.setId("1");
        user.setUsername("fallback user");
        fallback.add(user);
        return fallback;
    }
}
