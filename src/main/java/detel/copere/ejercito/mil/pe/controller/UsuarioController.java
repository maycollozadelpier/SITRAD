package detel.copere.ejercito.mil.pe.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;


import detel.copere.ejercito.mil.pe.models.dao.IDatosGeneralesDao;
import detel.copere.ejercito.mil.pe.models.dao.IPerfilUsuario;
import detel.copere.ejercito.mil.pe.models.entity.DatosGenerales;
import detel.copere.ejercito.mil.pe.models.entity.Documento;
import detel.copere.ejercito.mil.pe.models.entity.Perfil;
import detel.copere.ejercito.mil.pe.models.entity.Persona;
import detel.copere.ejercito.mil.pe.models.entity.TipoEstado;
import detel.copere.ejercito.mil.pe.models.entity.Usuario;
import detel.copere.ejercito.mil.pe.models.entity.UsuarioPerfil;
import detel.copere.ejercito.mil.pe.models.service.IPersonaService;
import detel.copere.ejercito.mil.pe.models.service.IUsuarioService;
import detel.copere.ejercito.mil.pe.util.paginator.Utileria;

@Controller
//@SessionAttributes("/usuario")
@RequestMapping("/usuario")
public class UsuarioController {
	

	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	IDatosGeneralesDao datosGeneralesDao;
	
	@Autowired
	IPerfilUsuario srvPerfil;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	@GetMapping("/listarusuarios")
//	public String listarUsuario(@RequestParam("username") String username,@RequestParam("password") String password, Usuario usuario)throws Exception {
//		
//		usuario.setUsername(username);
//		usuario.setPassword(passwordEncoder.encode(password));
//		//System.out.println("menaajsaaaaaaaaaaaaaaa"+usuarioService.cambiarclavesitrad(username, passwordEncoder.encode(password)));
//		
//		usuarioService.cambiarclavesitrad(username, password);
//		return  "fragments/topNav";
//
//	}
	
	@GetMapping("/blascontrasena")
	public String listarUsuario(@RequestParam("username") String username,@RequestParam("password") String password,Authentication session,Model model)throws Exception {
		DatosGenerales datosGrls = null;

		model.addAttribute("titulopage", "SIMEP | USUARIO");
		model.addAttribute("grls", datosGrls);
	
		System.out.println("menaajsaaaaaaaaaaaaaaa"+usuarioService.cambiarclavesitrad(username, passwordEncoder.encode(password)));
		usuarioService.cambiarclavesitrad(username, passwordEncoder.encode(password));
		return "usuario/nuevoUsuario";
		

	}
	
	
	//metodo para mostrar el perfil del usuario 
	@GetMapping("/profile")
	public String layout(Authentication session, Model model) {
		Persona persona = new Persona(); //creando la instancia - objeto de negocio
		
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		DatosGenerales datosGrls = null;
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
		
		model.addAttribute("titulopage", "SIMEP | PERFIL");
		model.addAttribute("grls", datosGrls);
		model.addAttribute("persona", persona);
		System.out.println("datos generales " + datosGrls);
		return "usuario/profile";
	}
	
	//metodo para mostrar el formulario al usuario 
		@GetMapping("/listar")
		public String listar(UsuarioPerfil usuarioPerfil, Authentication session, Model model) {
			
			Usuario usuario = usuarioService.buscarPorUsername(session.getName());
			DatosGenerales datosGrls = null;
			datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
			List<DatosGenerales> listaUsuarios = datosGeneralesDao.getListaUsuarios();
			model.addAttribute("titulopage", "SIMEP | USUARIO");
			model.addAttribute("grls", datosGrls);
		
			model.addAttribute("listaUsuarios", listaUsuarios);
			model.addAttribute("listaPerfil", srvPerfil.getPerfil());
			System.out.println("datos generales " + listaUsuarios);
			
			return "usuario/nuevoUsuario";
		}
		
		@GetMapping("/usuariocambiar")
		public String usuariocambiar(UsuarioPerfil usuarioPerfil, Authentication session, Model model) {
			
			Usuario usuario = usuarioService.buscarPorUsername(session.getName());
			DatosGenerales datosGrls = null;
			datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
			List<DatosGenerales> listaUsuarios = datosGeneralesDao.getListaUsuarios();
			model.addAttribute("titulopage", "SIMEP | USUARIO");
			model.addAttribute("grls", datosGrls);
		
			model.addAttribute("listaUsuarios", listaUsuarios);
			model.addAttribute("listaPerfil", srvPerfil.getPerfil());
			System.out.println("datos generales DE LOS USUARIOS " + datosGrls);
			
			return "fragments/topNav";
		}
		
	//metodo para guardar los datos del formulario 
	@PostMapping("/save-persona")
	public String guardarDocumento(@Validated UsuarioPerfil usuarioPerfil,  BindingResult result,Authentication session,Model model,
			 SessionStatus status,@RequestParam("archivoImg") MultipartFile file) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				//mostrar errores en la consola
				System.out.println("ocurrio un error " + error.getDefaultMessage());
			}
			model.addAttribute("titulopage", "SIMEP | USUARIO");
			return "usuario/nuevoUsuarionn";
			
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (!file.isEmpty()) {
			String ruta = "c:/mesaPartes/fotoPerfil/";
			String nombrefoto = Utileria.guardarArchivo(file, ruta);
			if (nombrefoto != null) {
				usuarioPerfil.setFoto(nombrefoto);
			}
		}
		
		Persona persona = new Persona();
		persona.setPersonaId(usuarioPerfil.getPersonaId());
		persona.setApellidoMaterno(usuarioPerfil.getApellidoMaterno());
		persona.setApellidoPaterno(usuarioPerfil.getApellidoPaterno());
		persona.setNombres(usuarioPerfil.getNombres());
		persona.setCelular(usuarioPerfil.getCelular());
		persona.setCorreo(usuarioPerfil.getCorreo());
		persona.setEstadoRegistro(usuarioPerfil.getEstadoRegistro());
		persona.setFoto(usuarioPerfil.getFoto());
		persona.setNumeroDocumento(usuarioPerfil.getNumeroDocumento());
		
		System.out.println("DATOS DEL USUARIO A REGISTRAR " + usuarioPerfil);
		personaService.save(persona);
		
		//TABLA PERFIL-USUARIO
		Usuario user = new Usuario();
		Persona personaregistrada = new Persona();
		Perfil perfil = new Perfil();
		
		//RETORNAMOS EL ID DEL ULTIMO REGISTRO
		personaregistrada.setPersonaId(srvPerfil.idpersona());
		user.setPersona(personaregistrada);
		
		user.setDivision(usuarioPerfil.getDivision());
		user.setEstadoRegistro(usuarioPerfil.getEstadoRegistro());
		user.setGranUnidad(usuarioPerfil.getGranUnidad());
		user.setUnidad(usuarioPerfil.getUnidad());
		user.setUsername(usuarioPerfil.getUsername());
		user.setUsuarioId(usuarioPerfil.getUsuarioId());
		
		perfil.setPerfilId(usuarioPerfil.getPerfil());
		user.setPerfil(perfil);
		
		//encriptar password
		String encode = passwordEncoder.encode(usuarioPerfil.getPassword());
		user.setPassword(encode);
			
		System.out.println("datos de usuario a registrar" + user);
		usuarioService.guardar(user);		
		return "redirect:/listar";
	}

	
	@PostMapping("/actualizar-foto")
	public String actualizarFoto(@RequestParam("archivoImg") MultipartFile file,@RequestParam("personaId") Long personaId) {
		String foto = null;
		if (!file.isEmpty()) {
			String ruta = "c:/mesaPartes/fotoPerfil/";
			
			String nombrefoto = Utileria.guardarArchivo(file, ruta);
			if (nombrefoto != null) {
				foto = nombrefoto;
			}
		}
		
		srvPerfil.actualizarFoto(personaId, foto);
		return "redirect:/profile";
	}
}
