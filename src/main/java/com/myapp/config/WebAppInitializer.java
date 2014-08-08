// {!begin top}
package com.myapp.config;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	// {!end top}

	// {!begin onStartup}
	@Override
	public void onStartup(ServletContext servletContext) {
		WebApplicationContext rootContext = createRootContext(servletContext);

		configureSpringMvc(servletContext, rootContext);
	}

	// {!end onStartup}

	// {!begin createRootContext}
	private WebApplicationContext createRootContext(
			ServletContext servletContext) {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

		
		servletContext.addListener(new ContextLoaderListener(rootContext));
		servletContext.setInitParameter("defaultHtmlEscape", "true");

		return rootContext;
	}

	// {!end createRootContext}

	// {!begin configureTop}
	private void configureSpringMvc(ServletContext servletContext,
			WebApplicationContext rootContext) {

		
		AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
		
		mvcContext.register(MVCConfig.class, JPAConfig.class);
//
//		mvcContext.refresh();
		
		mvcContext.setParent(rootContext);

	
		
		// {!end configureTop}
		// {!begin configureBottom}
		ServletRegistration.Dynamic appServlet = servletContext.addServlet(
				"webservice", new DispatcherServlet(mvcContext));
		appServlet.setLoadOnStartup(1);
		Set<String> mappingConflicts = appServlet.addMapping("/rest/*");

		if (!mappingConflicts.isEmpty()) {
			for (String s : mappingConflicts) {
			}
			throw new IllegalStateException(
					"'webservice' cannot be mapped to '/'");
		}
		// {!end configureBottom}
	}
}
