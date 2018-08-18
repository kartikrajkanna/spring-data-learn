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
		
		ac.register(MvcConfig.class);
		ac.setServletContext(sc);
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);
		
		Dynamic servlet = sc.addServlet("spring", dispatcherServlet);
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
		System.out.println(MvcWebApplicationInitializer.class.getName());
	}
}
