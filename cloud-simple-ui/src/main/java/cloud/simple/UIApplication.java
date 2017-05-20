package cloud.simple;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;

import feign.codec.Encoder;
import feign.form.FormEncoder;
import feign.form.spring.SpringFormEncoder;

/** 
 * @author 陈均 
 * @date 2016年12月19日 下午2:01:39 
 * @version 1.0 
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UIApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(UIApplication.class, args);
	}
	
	@Autowired
	private ObjectFactory<HttpMessageConverters> messageConverters;
	
	@Bean
	public Encoder encoder(){
		//return new SpringFormEncoder(new SpringEncoder(messageConverters));
		//return new FormEncoder(new SpringEncoder(messageConverters));
		return new SpringFormEncoder(new FormEncoder(new SpringEncoder(messageConverters)));
	}
	
}