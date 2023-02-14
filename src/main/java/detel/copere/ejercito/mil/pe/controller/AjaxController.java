package detel.copere.ejercito.mil.pe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import detel.copere.ejercito.mil.pe.models.dao.IDatosGeneralesDao;
import detel.copere.ejercito.mil.pe.models.entity.Brigada;
import detel.copere.ejercito.mil.pe.models.entity.Clasificacion;
import detel.copere.ejercito.mil.pe.models.entity.ComentarioDocumento;
import detel.copere.ejercito.mil.pe.models.entity.CopiaInformativa;
import detel.copere.ejercito.mil.pe.models.entity.DatosGenerales;
import detel.copere.ejercito.mil.pe.models.entity.DetalleDependencia;
import detel.copere.ejercito.mil.pe.models.entity.DetalleRemitentes;
import detel.copere.ejercito.mil.pe.models.entity.DistribucionDocumento;
import detel.copere.ejercito.mil.pe.models.entity.DocRegistrado;
import detel.copere.ejercito.mil.pe.models.entity.Documento;
import detel.copere.ejercito.mil.pe.models.entity.Documents;
import detel.copere.ejercito.mil.pe.models.entity.GenericoNative;
import detel.copere.ejercito.mil.pe.models.entity.ListaDependencia;
import detel.copere.ejercito.mil.pe.models.entity.ListasNative;
import detel.copere.ejercito.mil.pe.models.entity.Nucleo;
import detel.copere.ejercito.mil.pe.models.entity.TipoDocumento;
import detel.copere.ejercito.mil.pe.models.entity.TotalTipoDocRemitido;
import detel.copere.ejercito.mil.pe.models.entity.TotalTipoDocumento;
import detel.copere.ejercito.mil.pe.models.entity.Unidad;
import detel.copere.ejercito.mil.pe.models.entity.Usuario;
import detel.copere.ejercito.mil.pe.models.service.IBrigadaService;
import detel.copere.ejercito.mil.pe.models.service.IClasificacionService;
import detel.copere.ejercito.mil.pe.models.service.IComentarioDocumentoService;
import detel.copere.ejercito.mil.pe.models.service.ICopiaInformativaService;
import detel.copere.ejercito.mil.pe.models.service.IDashboardService;
import detel.copere.ejercito.mil.pe.models.service.IDetalleDependenciaService;
import detel.copere.ejercito.mil.pe.models.service.IDetalleRemitentesService;
import detel.copere.ejercito.mil.pe.models.service.IDistribucionDocumentosService;
import detel.copere.ejercito.mil.pe.models.service.IDocRegistradoService;
import detel.copere.ejercito.mil.pe.models.service.IDocumentoService;
import detel.copere.ejercito.mil.pe.models.service.IDocumentsService;
import detel.copere.ejercito.mil.pe.models.service.IListaDependenciaService;
import detel.copere.ejercito.mil.pe.models.service.IListasNativeService;
import detel.copere.ejercito.mil.pe.models.service.INucleoService;
import detel.copere.ejercito.mil.pe.models.service.IQueryNativeService;
import detel.copere.ejercito.mil.pe.models.service.ITipoDocumentoService;
import detel.copere.ejercito.mil.pe.models.service.ITotalTipoDocRemitidoService;
import detel.copere.ejercito.mil.pe.models.service.ITotalTipoDocumentoService;
import detel.copere.ejercito.mil.pe.models.service.IUnidadService;
import detel.copere.ejercito.mil.pe.models.service.IUsuarioService;
import detel.copere.ejercito.mil.pe.models.service.UnidadService;

@RestController
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired
	private INucleoService srvnucleo;

	@Autowired
	private IBrigadaService srvbrigada;

	@Autowired
	private IUnidadService srvunidad;

	@Autowired
	private ITipoDocumentoService srvtipodocumento;

	@Autowired
	private IClasificacionService srvclasificacion;

	@Autowired
	private IDocumentoService documentoService;

	@Autowired
	private IDocumentsService docuService;

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private IDetalleDependenciaService detalleDependenciaService;

	@Autowired
	private IDetalleRemitentesService detalleRemitentesService;

	@Autowired
	private IListaDependenciaService listaDependenciaService;

	@Autowired
	private IDashboardService dashoardService;

	@Autowired
	private ITotalTipoDocumentoService totalTipoDocumentoService;

	@Autowired
	private ITotalTipoDocRemitidoService totalTipoDocRemitidoService;

	@Autowired
	private ICopiaInformativaService srvcopiaInf;

	@Autowired
	private IDistribucionDocumentosService srvDistribucionDocu;

	@Autowired
	private IComentarioDocumentoService srvComentarioDocu;

	@Autowired
	private IQueryNativeService srvnative;

	@Autowired
	private IListasNativeService listasNstiveService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private IDatosGeneralesDao datosGeneralesDao;
	
	@Autowired
	private UnidadService unidadservice; 
		
	@Autowired
	private IDocRegistradoService docregservice;  // blas: documento registrado/unidad
	@GetMapping("/insertarunidadregistra")
	public String registrodoc(@RequestParam("codunidaddocregistra") String codunidaddocregistra, @RequestParam("estado") String estado, @RequestParam("iddocumento") String iddocumento) {
		DocRegistrado dataset = new DocRegistrado();
		//dataset.setCodDocRegistrado(coddocregistrado);@RequestParam("coddocregistrado") int coddocregistrado,
		dataset.setCodUnidadDocRegistra(codunidaddocregistra);
		dataset.setEstado(estado);
		dataset.setIdDocumento(iddocumento);
		docregservice.save(dataset);
		return "blas";	
	}
	
//	@GetMapping("/updateestado")
//	public String updateestado(@RequestParam("iddoc") Long iddoc, @RequestParam("estado") String estado) {
//		documentoService.updatetipoestado(iddoc, estado);
//		return "se actualizo";
//	}
	
	
	@GetMapping("/listarnucleos")
	public List<Nucleo> listarNucleo() {
		List<Nucleo> lista = srvnucleo.findAll();
		return lista;
	}
	
	@GetMapping("/modificarclave")
	public String listarUsuario(@RequestParam("username") String username,@RequestParam("password") String password)throws Exception {
		usuarioService.cambiarclavesitrad(username, passwordEncoder.encode(password));
		return  "CONTRASEÑA ACTUALIZADA";
	}
	
	
	@GetMapping("/estadocopinf")
	public String estadocopinf(@RequestParam("iddoc") String iddoc,@RequestParam("idcopinf") String idcopinf,@RequestParam("estdado") String estdado)throws Exception {
		srvcopiaInf.estadocopiainformativa(iddoc, idcopinf, estdado);
		return  "redirect:/documents/lista-documentos";
	}

	@GetMapping("/listarbrigadas")
	public List<Brigada> listarbrigadas(@RequestParam("codnucleo") String codnucleo) {
		List<Brigada> lista = srvbrigada.listarporNucleo(codnucleo);
		return lista;
	}

//	@GetMapping("/listarunidades")
//	public List<Unidad> listarunidades(@RequestParam("codnucleo") String codnucleo,
//			@RequestParam("codbrigada") String codbrigada) {
//		List<Unidad> lista = srvunidad.listarunidades(codbrigada);
//		return lista;
//	}
	
	
//	@GetMapping("/listarunidadesblas")
//	public List<Unidad> listarunidadesblas(@RequestParam("listarunidad") String listarunidad) {
//		return unidadservice.listarpcquinceuunidad(listarunidad);
//	}
	
//	
//	@GetMapping("/listarunidades")
//	public List<Unidad> listarunidades(@RequestParam("codnucleo") String codnucleo,
//			@RequestParam("codbrigada") String codbrigada) {
//		List<Unidad> lista = srvunidad.listarunidades(codbrigada);
//		return lista;
//	}
	@GetMapping("/listarunidades")
	public List<Unidad> listarunidadesblas(@RequestParam("codbrigada") String codbrigada) {
		return unidadservice.listarpcquinceuunidad(codbrigada);
	}

	/// combo nucleo remitente
	@GetMapping("/listarnucleosremitente")
	public List<Nucleo> listarNucleoRemitente() {
		List<Nucleo> lista = srvnucleo.findAll();
		return lista;
	}

	// COMOBO BRIGADAS REMITENTES
	@GetMapping("/listarbrigadasremitente")
	public List<Brigada> listarBrigadasRemitente(@RequestParam("codnucleo") String codnucleo) {
		List<Brigada> lista = srvbrigada.listarporNucleo(codnucleo);
		return lista;
	}

	// COMBOS UNIDADES REMITENTES
//	@GetMapping("/listarunidadesremitente")
//	public List<Unidad> listarUnidadesRemitente(@RequestParam("codnucleo") String codnucleo,
//			@RequestParam("codbrigada") String codbrigada) {
//		List<Unidad> lista = srvunidad.listarunidades(codbrigada);
//		return lista;
//	}
	

	@GetMapping("/listarunidadesremitente")
	public List<Unidad> listarUnidadesRemitente(@RequestParam("codbrigada") String codbrigada) {
		return unidadservice.listarpcquinceuunidad(codbrigada);
	}

	@GetMapping("/listartipodocumentos")
	public List<TipoDocumento> listarTipoDocumentos() {
		List<TipoDocumento> lista = srvtipodocumento.findAll();
		return lista;
	}

	@GetMapping("/listarclasificacion")
	public List<Clasificacion> listarClasificacion() {
		List<Clasificacion> lista = srvclasificacion.findAll();
		return lista;
	}

	@GetMapping("/decretoAjax")
	public List<Documento> decretoAjax(@RequestParam("id") Long documentoId) {
		List<Documento> lista = new ArrayList<>();
		Documento doc = documentoService.listaxID(documentoId);
		lista.add(doc);

		return lista;
	}

	@GetMapping("/decretoview")
	public List<Documents> decretoAjaxview(@RequestParam("id") String documentoId) {
		List<Documents> lista = new ArrayList<>();
		Documents doc = docuService.listaxID(documentoId);
		lista.add(doc);

		return lista;
	}

	@GetMapping("/listadependecias")
	public List<ListaDependencia> listDepencenciasAjax() {

		List<ListaDependencia> listaDependencias = listaDependenciaService.listaDependencias();

		return listaDependencias;
	}

	@GetMapping("/detalleremitentes")
	public List<DetalleRemitentes> detalleremitentesAjax() {

		List<DetalleRemitentes> detalleremitente = detalleRemitentesService.DetalleRemitentes();

		return detalleremitente;
	}

	@GetMapping("/detalleresponsable")
	public List<DetalleDependencia> detalleresponsableAjax() {

		List<DetalleDependencia> detalleresponsable = detalleDependenciaService.detalleDependencia("RESPONSABLE");

		return detalleresponsable;
	}

	@GetMapping("/dashboard")
	public List<DetalleDependencia> dashboardCabeceraAjax(@RequestParam("tipUnidad") String tipUnidad,
			Authentication session) {
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		List<DetalleDependencia> lista = new ArrayList<>();

		return dashoardService.detalleXunidad(usuario.getUnidad(), tipUnidad);
	}

	@GetMapping("/totaltipodocumento")
	public List<TotalTipoDocumento> listarTotalTipoDocumento(Authentication session, Model model) {

		Usuario usuario = usuarioService.buscarPorUsername(session.getName());

		return totalTipoDocumentoService.totalTipoDoc(usuario.getUnidad());
	}

	@GetMapping("/totalDocRemitidos")
	public List<TotalTipoDocRemitido> listarTotalDocRemitidos(Authentication session, Model model) {

		Usuario usuario = usuarioService.buscarPorUsername(session.getName());

		return totalTipoDocRemitidoService.totalTipoDocRemitido(usuario.getUnidad());
	}

	@GetMapping("/copia-informativa")
	public boolean copiaInformativa(@RequestParam("cod_doc") String cod_doc,
			@RequestParam("cod_copi_info") String cod_copi_info) {
		CopiaInformativa dataset = new CopiaInformativa();
		dataset.setCodUnidadCopiaInformativa(cod_copi_info);
		dataset.setIdDocumento(cod_doc);
		dataset.setEstado("0");
		srvcopiaInf.save(dataset);
		System.out.println("code: " + cod_copi_info);

		return true;
	}

	@GetMapping("/distribucion")
	public boolean distribucion(@RequestParam("cod_doc") String cod_doc, @RequestParam("cod_dist") String cod_dist) {
		DistribucionDocumento dataset = new DistribucionDocumento();
		dataset.setIdDistribucion(cod_dist);
		dataset.setIdDocumento(cod_doc);

		srvDistribucionDocu.save(dataset);

		System.out.println("code: " + cod_dist);

		return true;
	}

	@GetMapping("/comentario")
	public boolean comentarios(@RequestParam("cod_doc") String cod_doc, @RequestParam("observacion") String observacion,
			@RequestParam("prioridad") String prioridad) {
		ComentarioDocumento dataset = new ComentarioDocumento();
		dataset.setIdDocumento(cod_doc);
		dataset.setComentario(observacion);
		dataset.setPrioridad(prioridad);
		srvComentarioDocu.save(dataset);
		return true;
	}

	@GetMapping("/listadecretonative")
	public List<GenericoNative> listaDecretoUU(Authentication session) throws Exception {
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		return srvnative.listarDecreto(usuario.getUnidad());
		
	}

	@GetMapping("/listacopiainformativa")
	public List<ListasNative> listaCopiaInformativa() throws Exception {
		return listasNstiveService.listarCopiaInformatica();
	}

	
	@GetMapping("/listusuarios")
	public List<DatosGenerales> listusuarios() {
		return datosGeneralesDao.getListaUsuarios();
	}
}
