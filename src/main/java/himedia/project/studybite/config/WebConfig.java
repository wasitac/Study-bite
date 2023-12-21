package himedia.project.studybite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import himedia.project.studybite.interceptor.LoginInterceptor;

public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor())
			.order(1)
			.addPathPatterns("/**");
	}
	
	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}

}
