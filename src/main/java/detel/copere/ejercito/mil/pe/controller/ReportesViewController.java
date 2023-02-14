package detel.copere.ejercito.mil.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import detel.copere.ejercito.mil.pe.models.dao.IDatosGeneralesDao;
import detel.copere.ejercito.mil.pe.models.entity.DatosGenerales;
import detel.copere.ejercito.mil.pe.models.entity.Usuario;
import detel.copere.ejercito.mil.pe.models.service.IUsuarioService;

@Controller
public class ReportesViewController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	IDatosGeneralesDao datosGeneralesDao;
	
	@GetMapping("/repoDiario")
	private String Diario (Authentication session, Model model) {
		
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		DatosGenerales datosGrls = null;
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
		model.addAttribute("grls", datosGrls);
		
		model.addAttribute("titulopage", "SISMEP | DIARIO");
		
		return "/reportes/repoDiario";
	}
	@GetMapping("/repoDiarioMesaPartes")
	private String DiarioMesaPartes (Authentication session, Model model) {
		
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		DatosGenerales datosGrls = null;
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
		model.addAttribute("grls", datosGrls);
		
		model.addAttribute("titulopage", "SISMEP | DIARIO");
		
		return "/reportes/repoDiarioMesaPartes";
	}
	@GetMapping("/repoDocument")
	private String PorRangoFechas (Authentication session, Model model) {
		
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		DatosGenerales datosGrls = null;
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
		model.addAttribute("grls", datosGrls);
		model.addAttribute("titulopage", "SISMEP | REPORTE");
		
		return "/reportes/repoRangoFechas";
	}
}
