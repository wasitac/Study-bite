package himedia.project.studybite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import himedia.project.studybite.interceptor.LoginInterceptor;

public class WebConfig implements WebMvcConfigurer {
	/**
	 * 모든 요청에 대한 인터셉터생성
	 * @author 이지홍
	 *
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor())
			.order(1)
			.addPathPatterns("/**")
			.excludePathPatterns("/css/**", "/*.ico", "/error");
	}
	
	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}

}
