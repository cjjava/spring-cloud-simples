package cloud.simple.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cloud.simple.domain.User;

/** 
 * @author 陈均 
 * @date 2016年12月19日 下午2:08:26 
 * @version 1.0 
 */
@FeignClient("cloud-simple-service")
public interface UserService {
  @RequestMapping(method = RequestMethod.GET, value = "/users",
  produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	List<User> searchAll();
}
