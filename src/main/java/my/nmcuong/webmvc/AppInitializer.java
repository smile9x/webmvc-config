package my.nmcuong.webmvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(WebConfig.class);
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
		Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);
		registration.addMapping("/");
		registration.setLoadOnStartup(1);
	}

}
