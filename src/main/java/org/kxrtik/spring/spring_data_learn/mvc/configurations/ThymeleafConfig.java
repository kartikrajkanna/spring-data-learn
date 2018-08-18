package org.kxrtik.spring.spring_data_learn.mvc.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
public class ThymeleafConfig {
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		return null;
	}
	
	@Bean
	public SpringTemplateEngine springTemplateEngine(ServletContextTemplateResolver templateResolver) {
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		springTemplateEngine.setTemplateResolver(templateResolver);
		return springTemplateEngine;
	}
}
