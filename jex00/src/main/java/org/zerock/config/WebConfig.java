package org.zerock.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}
	
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}
	
	protected String[] getServletMappings() {
		return null;
	}
}
