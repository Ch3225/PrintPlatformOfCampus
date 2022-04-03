package pfpsc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class FileUploadConfiguration {
	@Bean
	public CommonsMultipartResolver commonMultipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
		commonsMultipartResolver.setDefaultEncoding("utf-8");
		
		//最大上传50MB
		commonsMultipartResolver.setMaxUploadSize(52428800);
		return commonsMultipartResolver;
	}
	

	
}
