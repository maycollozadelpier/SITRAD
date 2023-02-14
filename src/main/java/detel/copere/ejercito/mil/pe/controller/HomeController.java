package detel.copere.ejercito.mil.pe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import detel.copere.ejercito.mil.pe.models.entity.Usuario;
import detel.copere.ejercito.mil.pe.models.service.IUsuarioService;

@Controller
public class HomeController {

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/login")
	public String mostrarLogin() {
		return "login";
	}
 
	// recuperar datos de autenticacion del usuario
	@GetMapping("/index")
	public String mostrarIndex(Authentication authentication, HttpSession session) {
		// Como el usuario ya ingreso, ya podemos agregar a la session el objeto
		// usuario.
		String username = authentication.getName();

		for (GrantedAuthority rol : authentication.getAuthorities()) {
			System.out.println("ROL: " + rol.getAuthority());
		}
		if (session.getAttribute("usuario") == null) {
			Usuario usuario = usuarioService.buscarPorUsername(username);
//			 System.out.println("Usuario: " + usuario);
//			session.setAttribute("usuario", usuario);
			
		}
		return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {

		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		
		logoutHandler.logout(request, null, null);
		return "redirect:/";
	}
}
