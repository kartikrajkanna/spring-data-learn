package org.kxrtik.spring.spring_data_learn.mvc;

import org.kxrtik.spring.spring_data_learn.mvc.configurations.MvcConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

public class MvcWebApplicationInitializer implements WebApplicationInitializer {
	
	public void onStartup(ServletContext sc) throws ServletException {

		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		
		ac.setServletContext(sc);
		ac.scan("org.kxrtik.spring.spring_data_learn.services", "org.kxrtik.spring.spring_data_learn.controllers", "org.kxrtik.spring.spring_data_learn.configurations");
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);
		dispatcherServlet.setContextConfigLocation(MvcConfig.class.getName());
		
		Dynamic servlet = sc.addServlet("spring", dispatcherServlet);
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
		System.out.println(MvcConfig.class.getName());
	}
}
