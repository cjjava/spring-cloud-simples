package cloud.simple.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name="simple")
public interface FileUploadClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "/upload")
	String upload(@RequestParam("username") String username,
			MultipartFile file);

}
