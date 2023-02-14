package detel.copere.ejercito.mil.pe.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	public void addResourceHandlers(ResourceHandlerRegistry register) {
		register.addResourceHandler("/perfil/**").addResourceLocations("file:c:/mesaPartes/fotoPerfil/");
	}
}
