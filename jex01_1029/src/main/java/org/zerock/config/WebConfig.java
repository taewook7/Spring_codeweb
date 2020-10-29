package org.zerock.config;

//import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}
	
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}
	
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	
//	
//	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
//
//	}
} 
