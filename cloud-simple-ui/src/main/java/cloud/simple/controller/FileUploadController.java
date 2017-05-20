package cloud.simple.controller;

import java.io.File;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cloud.simple.feign.FileUploadClient;

@Controller
public class FileUploadController {
	@Autowired
	FileUploadClient fileUploadClient;
	
	//第一种方式,直接传递MultipartFile给对方
	@RequestMapping("/upload")
	public ResponseEntity<String> upload(
			@RequestParam("username") String username,
			@RequestParam("file") MultipartFile file) {
		fileUploadClient.upload(username, file);
		return ResponseEntity.ok("upload ok");
	}
	
	//第二种方式,传普通文件对象给对方
	@RequestMapping("/fileUpload")
	public ResponseEntity<String> upload() {
		File file = new File("a.jpg");
		Map<String, ?> data = Collections.singletonMap("file", file);
		fileUploadClient.upload("chenjun", data);
		return ResponseEntity.ok("upload ok");
	}
	
}
