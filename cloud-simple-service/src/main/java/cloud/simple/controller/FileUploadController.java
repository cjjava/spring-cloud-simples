package cloud.simple.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@RequestMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam("username") String username,
			@RequestParam("file") MultipartFile file) {
		System.out.println(
				String.format("username=%s,filename=%s,size=%dB", username, 
						file.getOriginalFilename(), file.getSize()));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("upload ok");
	}

}
