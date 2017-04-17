package cloud.simple.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloud.simple.dao.UserRepository;
import cloud.simple.domain.User;
import cloud.simple.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<User> searchAll() {
		try {
			Thread.sleep(5000);//模拟耗时操作
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return userRepository.findAll();
	}

}
