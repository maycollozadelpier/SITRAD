package detel.copere.ejercito.mil.pe.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import detel.copere.ejercito.mil.pe.models.dao.IDatosGeneralesDao;
import detel.copere.ejercito.mil.pe.models.entity.DatosGenerales;
import detel.copere.ejercito.mil.pe.models.entity.ListaDependencia;
import detel.copere.ejercito.mil.pe.models.entity.ListasNative;
import detel.copere.ejercito.mil.pe.models.entity.Usuario;
import detel.copere.ejercito.mil.pe.models.service.IDecretoService;
import detel.copere.ejercito.mil.pe.models.service.IDocumentsService;
import detel.copere.ejercito.mil.pe.models.service.IListaDependenciaService;
import detel.copere.ejercito.mil.pe.models.service.IQueryNativeService;
import detel.copere.ejercito.mil.pe.models.service.IUsuarioService;

@Controller
@RequestMapping("/documents")
public class ListasController {
	@Autowired
	private IDocumentsService svrDocuments;
	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IDocumentsService documentsService;
	
	@Autowired
	private IListaDependenciaService listaDependenciaService;

	@Autowired
	private IDecretoService decretoService;
	
	@Autowired
	IDatosGeneralesDao datosGeneralesDao;
	
	@Autowired
	private IQueryNativeService srvnative;

	
	@GetMapping("/lista-decretar")
	public String listDecreto(Authentication session, Model model) {
		
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		DatosGenerales datosGrls = null;		
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
		model.addAttribute("grls", datosGrls);
		model.addAttribute("comen", documentsService.listarcomentario());
		model.addAttribute("titulopage", "SISMEP | LISTA-DECRETAR");
		System.out.println("listaXunidades: " + documentsService.listaXestadoYunidadResponsable("0001", usuario.getUnidad()));

		model.addAttribute("listarecibidos", documentsService.listaXestadoYunidadResponsable("0001", usuario.getUnidad()));
		
		model.addAttribute("listadecretados", documentsService.listaDecretoSecretario(9)); //9 es el tipo decretado por el secretario del copere
		System.out.println("listaDecretados: " + documentsService.listaDecretoSecretario(9));
		return "documents/listaDecretar";
	}
	
	@GetMapping("/dependecias-responsables")
	public String listDepencencias(Authentication session, Model model) {
		
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		DatosGenerales datosGrls = null;
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
		model.addAttribute("grls", datosGrls);
		List<ListaDependencia> listaDependencias = listaDependenciaService.listaDependencias();
		
		model.addAttribute("titulopage", "SISMEP | LISTA-DEPENDECNCIAS");
		System.out.println("Uidad:  " + usuario.getUnidad());
		System.out.println("lista de pendencias: " + listaDependencias);
		
		model.addAttribute("listadependencia",listaDependencias);
		return "reportes/listaDependencias";
	}
	//LISTA DE DOCUMENTOS lAS DEPENDENCIAS
	@GetMapping("/lista-documentos") 
	public String listDocumentos(Authentication session, Model model) throws Exception {
		
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		DatosGenerales datosGrls = null;
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
		
		model.addAttribute("copiainformativa",srvnative.listarDecreto(usuario.getUnidad()));//blas listar copian informativa
		model.addAttribute("decretocopinf",srvnative.listarCopiaInformativa(usuario.getUnidad()));//blas liistar copia informativa archivado
		model.addAttribute("grls", datosGrls);
		model.addAttribute("titulopage", "SISMEP | LISTA-DOCUMENTOS");
		model.addAttribute("listadocumentos", documentsService.listaXestadoYunidadResponsable("0001", usuario.getUnidad()));
		System.out.print("listadocumentos BLAS" +documentsService.listaXestadoYunidadResponsable("0001", usuario.getUnidad()));
		//el codigo 0003 es REMITIDO
		model.addAttribute("listaremitidos", documentsService.listaXestadoYunidadRemitente("0003", usuario.getUnidad()));
		
		model.addAttribute("listarespondidos", documentsService.listaXestadoYunidadRemitente("0004", usuario.getUnidad()));
		
		
		model.addAttribute("listaremitidos", svrDocuments.listaunidadremite(usuario.getUnidad()));///por blas
		
		
	
		model.addAttribute("listaarchivados", documentsService.listaXestadoYunidadResponsable("0005", usuario.getUnidad()));
		
		model.addAttribute("decreto", decretoService.listaCopiaInformativa("0001", usuario.getUnidad()));
		//System.out.print("lista decreto documentos DDDDDDDDDDDD "+decretoService.listaCopiaInformativa("0001", usuario.getUnidad()));
		return "documents/listaDocumentos";
	}
	
	//LISTA DE DOCUMENTOS lAS DEPENDENCIAS
		@GetMapping("/repo-recibidos")
		public String listReportes(Authentication session, Model model) {
			
			Usuario usuario = usuarioService.buscarPorUsername(session.getName());
			DatosGenerales datosGrls = null;
			datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
			model.addAttribute("grls", datosGrls);
			model.addAttribute("titulopage", "SISMEP | REPORTES");
			
			model.addAttribute("listadocumentos", documentsService.listaXestadoYunidadResponsable("0001", usuario.getUnidad()));
			
			model.addAttribute("listaremitidos", documentsService.listaXestadoYunidadResponsable("REMITIDO", usuario.getUnidad()));
			model.addAttribute("listarespondidos", documentsService.listaXestadoYunidadResponsable("RESPONDIDO", usuario.getUnidad()));
			model.addAttribute("listaarchivados", documentsService.listaXestadoYunidadResponsable("ARCHIVADO", usuario.getUnidad()));
			return "reportes/repoRecibidos";
		}
		
		//LISTA DE DOCUMENTOS lAS DEPENDENCIAS
		@GetMapping("/repo-remitidos")
		public String docRemitidos(Authentication session, Model model) {
			Usuario usuario = usuarioService.buscarPorUsername(session.getName());
			DatosGenerales datosGrls = null;
			datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
			model.addAttribute("grls", datosGrls);
			
			model.addAttribute("titulopage", "SISMEP | REMITIDOS");
			//el codigo 0003 es REMITIDO
			//model.addAttribute("listaremitidos", documentsService.listaXestadoYunidadRemitente("0003", usuario.getUnidad()));
			model.addAttribute("listaremitidos", svrDocuments.listaunidadremite(usuario.getUnidad()));
			return "reportes/repoRemitidos";
		}
	
		// LISTA DE DOCUMENTOS PENDIENTES DE TODAS LAS DEPENDENCIAS
		@GetMapping("/pendientes")
		public String pendientes(Authentication session,Model model) {
			Usuario usuario = usuarioService.buscarPorUsername(session.getName());
			DatosGenerales datosGrls = null;
			datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
			model.addAttribute("grls", datosGrls);
			
			model.addAttribute("titulopage", "SISMEP | PENDIENTES");
			model.addAttribute("pendientes", documentsService.pendientes("0001"));
			model.addAttribute("respondido", documentsService.listardocumentosrespondidos());
			
			return "reportes/listaPendientes";
		}
	
}
