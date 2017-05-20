package cloud.simple.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cloud.simple.domain.User;
import cloud.simple.feign.UserClient;

@Service
public class HystrixWrappedUserClient {
	protected Logger logger = LoggerFactory.getLogger(HystrixWrappedUserClient.class);

	@Autowired
	private UserClient userClient;

	@HystrixCommand(fallbackMethod = "fallBackCall")
	public List<User> searchAll() {
		return userClient.searchAll();
	}

	public List<User> fallBackCall(Throwable e) {
		logger.error("In fallback: ", e);
		List<User> fallback = new ArrayList<User>();
		User user = new User();
		user.setId("1");
		user.setUsername("fallback user");
		fallback.add(user);
		return fallback;
	}

}
