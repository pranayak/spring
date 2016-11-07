package com.project.hotel;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class WebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext context) {

		// Create the dispatcher servlet's Spring application context
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(ApplicationConfig.class);
		appContext.register(MvcConfig.class);
		appContext.setServletContext(context);

		// register context loader listener
		// context.addListener(new ContextLoaderListener(appContext));

		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = context.addServlet(
				"dispatcher", new DispatcherServlet(appContext));

		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
