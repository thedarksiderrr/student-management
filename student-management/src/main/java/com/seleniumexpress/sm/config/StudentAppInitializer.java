package com.seleniumexpress.sm.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class StudentAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(ConfigureFile.class);

		// create dispatcher servlet object
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

		// register dispatcher servlet with servlet context
		ServletRegistration.Dynamic customDispatcherServlet = servletContext.addServlet("studentServlet", dispatcherServlet);

		customDispatcherServlet.setLoadOnStartup(1);
		customDispatcherServlet.addMapping("/");

	}

}
