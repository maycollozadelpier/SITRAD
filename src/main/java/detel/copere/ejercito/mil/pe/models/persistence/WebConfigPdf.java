package detel.copere.ejercito.mil.pe.models.persistence;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigPdf implements WebMvcConfigurer{
	
	public void addResourceHandlers(ResourceHandlerRegistry register) {
		register.addResourceHandler("/archivo/**").addResourceLocations("file:c:/mesaPartes/");
	}

}
