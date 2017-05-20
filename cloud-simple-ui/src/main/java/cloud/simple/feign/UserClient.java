package cloud.simple.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cloud.simple.domain.User;

/** 
 * @author 陈均 
 * @date 2016年12月19日 下午2:08:26 
 * @version 1.0 
 */
@FeignClient("simple")
public interface UserClient {
  @RequestMapping(method = RequestMethod.GET, value = "/users")
	List<User> searchAll();
}
