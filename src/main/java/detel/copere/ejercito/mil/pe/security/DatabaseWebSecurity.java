package detel.copere.ejercito.mil.pe.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
				"select vusername_usuario, vpassword_usuario, nestado_registro from sitrad_usuario  where vusername_usuario=?")
				.authoritiesByUsernameQuery(
						"SELECT u.vusername_usuario, p.vnombre_perfil  FROM  SITRAD_USUARIO u, SITRAD_PERFIL p  WHERE   u.nid_perfil=p.nid_perfil and u.vusername_usuario=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// los recursos estaticos no requieren autenticacion
				.antMatchers(
						"/assets/**").permitAll()
				//las vistas publicas no requiern autenticacion
//				.antMatchers("/pdfRecibidos").permitAll()
				
				//asignar permisos a URL por Roles
//				.antMatchers("/documents/*").hasAnyAuthority("Administrador")
				.antMatchers("/documents/lista-decretar").hasAnyAuthority("Administrador","Secretario")
				.antMatchers("/documents/dependecias-responsables").hasAnyAuthority("Administrador","Secretario")
				.antMatchers("/documents/pendientes").hasAnyAuthority("Administrador","Secretario")
				.antMatchers("/documents/lista-documentos").hasAnyAuthority("Administrador","usuario")
				.antMatchers("/documents/remitidos").hasAnyAuthority("Administrador","MesaPartesCopere", "usuario", "Secretario")
				.antMatchers("/documents/registro").hasAnyAuthority("Administrador","MesaPartesCopere")
				.antMatchers("/layout").hasAnyAuthority("Administrador","MesaPartesCopere", "usuario", "Secretario")
				.antMatchers("/profile").hasAnyAuthority("Administrador","MesaPartesCopere", "usuario", "Secretario")
				
				//mantenimiento
				.antMatchers("/listar").hasAnyAuthority("Administrador")
				
				//reportes
				.antMatchers("/pdfRecibidos").hasAnyAuthority("Administrador","MesaPartesCopere","Secretario","usuario")
				.antMatchers("/pdfRemitidos").hasAnyAuthority("Administrador","MesaPartesCopere","Secretario","usuario")
				.antMatchers("/pdfDiario").hasAnyAuthority("Administrador","Secretario","usuario")
				.antMatchers("/pdfDiarioMesaPartes").hasAnyAuthority("Administrador","MesaPartesCopere")
				.antMatchers("/reporteprueba").hasAnyAuthority("Administrador","MesaPartesCopere","Secretario","usuario")
	
				//url que requieren autenticacion
				.anyRequest().authenticated()
				// formulario de login no requiere autenticacion
				.and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/inicio/dashboard",true) // URL después de iniciar sesión correctamente
				.permitAll();
//				.and().formLogin().permitAll(); //login por defecto de spring security
				http.headers().frameOptions().sameOrigin();//permitir el acceso al local para los reportes en el iframe
				
				
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
