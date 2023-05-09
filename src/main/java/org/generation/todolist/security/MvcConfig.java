package org.generation.todolist.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//This Class is to perform action on URL Routing and mapping when a HTTP request comes in
//E.g. if user key in localhost:8080 in the browser, browser will send a HTTP GET
// request to the server (back-end). The back-end will need to handle which HTML to
// response back to the browser (client) - index.html
@Configuration
public class MvcConfig implements WebMvcConfigurer {
	public void addViewControllers(ViewControllerRegistry registry) {
		//Map the browser's URL to a specific View (HTML) inside resources/templates directory
		registry.addViewController("/").setViewName("todolist");
		registry.addViewController("/todolist").setViewName("todolist");
		registry.addViewController("/todolistForm").setViewName("todolistForm");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static")
				.addResourceLocations("classpath:/static/")
				.setCachePeriod(0);
	}
}
