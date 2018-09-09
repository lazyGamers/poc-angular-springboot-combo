package com.lazygamers.poc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class Config {

	@Bean
	public WebMvcConfigurer cors() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// In dev mode we run angular with its own CLI, which runs on port 4200, so we add CORS headers to
				// allow us to call API
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:4200")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
						.allowCredentials(true)
						.allowedHeaders("*");
			}
			
			// static content will be served from folder src/main/resources/angular
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry
					.addResourceHandler("/**")
					.addResourceLocations("classpath:/angular/");
			}
			
			// when we hit root / we will be sent index.html, which is the entry point to angular app.
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("forward:/index.html");
			}
		};
}

}