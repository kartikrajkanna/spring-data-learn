package org.kxrtik.spring.spring_data_learn.mvc.jsp;

import org.kxrtik.spring.spring_data_learn.mvc.controllers.ViewResolverConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class JstlViewResolverConfig implements ViewResolverConfig {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("./WEB-INF/views");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		return resolver;
	}
}
