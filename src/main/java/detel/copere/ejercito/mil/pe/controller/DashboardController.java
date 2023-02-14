package detel.copere.ejercito.mil.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import detel.copere.ejercito.mil.pe.models.dao.IDatosGeneralesDao;
import detel.copere.ejercito.mil.pe.models.entity.DatosGenerales;
import detel.copere.ejercito.mil.pe.models.entity.Usuario;
import detel.copere.ejercito.mil.pe.models.service.ITotalTipoDocumentoService;
import detel.copere.ejercito.mil.pe.models.service.IUsuarioService;

@Controller
@RequestMapping("/inicio")
public class DashboardController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private ITotalTipoDocumentoService totalTipoDocumentoService;
	
	@Autowired
	IDatosGeneralesDao datosGeneralesDao;
	
	@GetMapping("/dashboard")
	public String dashboard(Authentication session, Model model) {
		
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());

		DatosGenerales datosGrls = null;
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
		model.addAttribute("grls", datosGrls);
		System.out.println("datos generales " + datosGrls);
		
		
		model.addAttribute("titulopage", "SISMEP | DASHBOARD");
		System.out.println("unidad del usuario  " + usuario.getUnidad());
		
		model.addAttribute("totalTipoDocu", totalTipoDocumentoService.totalTipoDoc(usuario.getUnidad()));
		System.out.println("total de tipo de documento : " + totalTipoDocumentoService.totalTipoDoc(usuario.getUnidad()));
		
		
		
		return "dashboard/dashboard";
	}

	@GetMapping("/layout")
	public String layout(Authentication session, Model model) {
		
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		DatosGenerales datosGrls = null;
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
		model.addAttribute("titulopage", "STD | dOCUMENTOS");
		model.addAttribute("grls", datosGrls);
		System.out.println("datos generales " + datosGrls);
		return "layout/layout";

	}

}
