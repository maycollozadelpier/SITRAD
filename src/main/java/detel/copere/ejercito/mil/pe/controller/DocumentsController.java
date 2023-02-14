package detel.copere.ejercito.mil.pe.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import detel.copere.ejercito.mil.pe.models.dao.IDatosGeneralesDao;
import detel.copere.ejercito.mil.pe.models.entity.DatosGenerales;
import detel.copere.ejercito.mil.pe.models.entity.DocRegistrado;
import detel.copere.ejercito.mil.pe.models.entity.Documento;
import detel.copere.ejercito.mil.pe.models.entity.TipoEstado;
import detel.copere.ejercito.mil.pe.models.entity.Usuario;
import detel.copere.ejercito.mil.pe.models.service.ICopiaInformativaService;
import detel.copere.ejercito.mil.pe.models.service.IDistribucionService;
import detel.copere.ejercito.mil.pe.models.service.IDocumentoService;
import detel.copere.ejercito.mil.pe.models.service.IDocumentsService;
import detel.copere.ejercito.mil.pe.models.service.IUnidadService;
import detel.copere.ejercito.mil.pe.models.service.IUsuarioService;
import detel.copere.ejercito.mil.pe.util.paginator.Global;
import detel.copere.ejercito.mil.pe.util.paginator.PageRender;
import detel.copere.ejercito.mil.pe.util.paginator.Utileria;

@Controller
@RequestMapping("/documents")
public class DocumentsController {

	@Autowired
	private IDocumentoService documentoService;
	@Autowired
	private IDocumentsService svrDocuments;

	@Autowired
	private IUnidadService srvUnidad;

	@Autowired
	private IDistribucionService destribucionService;

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private IDocumentsService documentsService;

	@Autowired
	IDatosGeneralesDao datosGeneralesDao;

	@Autowired
	private ICopiaInformativaService srvcopiaInf;

	@GetMapping("/registro")
	public String recibidos(Authentication session, Model model) {
		Documento documento = new Documento();
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		DatosGenerales datosGrls = null;
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
		model.addAttribute("grls", datosGrls);
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		String fechaRecepcion = dateFormat.format(date);
		System.out.println("fecha con formato para bd: " + fechaRecepcion);
		model.addAttribute("titulopage", "SISMEP | REGISTRO");
		model.addAttribute("localDate", LocalDate.now());
		model.addAttribute("documento", documento);
		// model.addAttribute("registrosDiarios",
		// svrDocuments.listaRegistroDiario(fechaRecepcion));
		model.addAttribute("listadoc", svrDocuments.listaunidadregistra(usuario.getUnidad()));// blas lista todo
																								// documento que
																								// registra
		model.addAttribute("respondido", documentsService.listardocumentosrespondidos());
		return "documents/formRegistro";
	}

	@GetMapping("/registro-remitidos")
	public String remitidos(Authentication session, Model model) {
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());

		DatosGenerales datosGrls = null;
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
		model.addAttribute("grls", datosGrls);

		System.out.println("uridad Remitente" + usuario.getUnidad());
		
		LocalDate fecha = LocalDate.now();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Documento documento = new Documento();
		model.addAttribute("titulopage", "SISMEP | REMITIDOS");
		model.addAttribute("localDate",fecha );
		
		
		model.addAttribute("standardDate", new Date());
		model.addAttribute("localDateTime", LocalDateTime.now());
		model.addAttribute("localDate", LocalDate.now());
		model.addAttribute("timestamp", Instant.now());
		
		System.out.println("fechaaaaaaaaaaaaaaasssssssssssss" + fecha);
		documento.setUnidadregistro(usuario.getUnidad());
		// el codigo 0003 es REMITIDOSDS
		// model.addAttribute("listaremitidos",
		// svrDocuments.listaXestadoYunidadRemitente("0003", usuario.getUnidad()));
		model.addAttribute("listaremitidos", svrDocuments.listaunidadremite(usuario.getUnidad()));
		
		model.addAttribute("respondido", svrDocuments.listardocumentosrespondidos());

		model.addAttribute("documento", documento);
		model.addAttribute("usuario", usuario);
		return "documents/formRemitidos";
	}

	@GetMapping("/lisusuario")
	public String user(Authentication session, Model model) {
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());

		DatosGenerales datosGrls = null;
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
		model.addAttribute("grls", datosGrls);

		System.out.println("uridad Remitente" + usuario.getUnidad());
		Documento documento = new Documento();
		model.addAttribute("titulopage", "SISMEP | REMITIDOS");
		model.addAttribute("localDate", LocalDate.now());
		// el codigo 0003 es REMITIDO
		model.addAttribute("listaremitidos", svrDocuments.listaXestadoYunidadRemitente("0003", usuario.getUnidad()));
		model.addAttribute("documento", documento);
		model.addAttribute("usuario", usuario);
		return "usuario/user";
	}

	@GetMapping("/decreto")
	public String decreto(@RequestParam("id") Long documentoId, Authentication session, Model model) {
		String ruta = Global.RUTA_PDF;

		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		DatosGenerales datosGrls = null;
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
		model.addAttribute("grls", datosGrls);
		Documento documentolista = documentoService.listaxID(documentoId);

		Documento documento = new Documento();
		// codigo 0001 es pendiente
		model.addAttribute("listarecibidos",
				documentsService.listaXestadoYunidadResponsable("0001", usuario.getUnidad()));
		model.addAttribute("titulopage", "SISMEP | DECRETO");
		model.addAttribute("documento", documento);
		model.addAttribute("rutapdf", ruta);
		model.addAttribute("codigo", documentolista.getDocumentoId());
		model.addAttribute("namefile", documentolista.getArchivo());
		return "documents/formDecreto";
	}

	@GetMapping("/remitidos")
	public String remitidos(@RequestParam("id") Long documentoId, Authentication session, Model model) {
if(documentoId != null) {
		Documento doc = documentoService.listaxID(documentoId);
		TipoEstado tip = new TipoEstado();
		tip.setTipoEstadoId("0004");
		doc.setTipoEstado(tip);
		Documento newdoc = doc;
		this.guardarArchivado(newdoc);
}
		
		
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		DatosGenerales datosGrls = null;
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
		model.addAttribute("grls", datosGrls);
		Documento lista = documentoService.listaxID(documentoId);
		Documento documento = new Documento();
		model.addAttribute("titulopage", "SISMEP | REMITIDOS");
		model.addAttribute("localDate", LocalDate.now());
		model.addAttribute("documento", documento);
		model.addAttribute("numDocumento", lista.getNumeroDocumento());
		model.addAttribute("usuario", usuario);
		return "documents/formRemitidos";
	}

	// LISTA DOCUMENTOS
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Authentication session,
			Model model) {
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());

		DatosGenerales datosGrls = null;
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
		model.addAttribute("grls", datosGrls);

		Pageable pageRequest = PageRequest.of(page, 10);

		Page<Documento> nucleos = documentoService.findAll(pageRequest);

		PageRender<Documento> pageRender = new PageRender<Documento>("/listar", nucleos);
		model.addAttribute("titulopage", "SISMEP | NUCLEOS");
		model.addAttribute("nucleos", nucleos);
		model.addAttribute("page", pageRender);
		return "nucleo/listar";

	}

	@PostMapping("/save-recibidos")
	public String guardarDocumento(Documento documento, Authentication session,
			@RequestParam("archivopdf") MultipartFile multiPart) {

		if (!multiPart.isEmpty()) {
			String ruta = "c:/mesaPartes/";
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null) {
				documento.setArchivo(nombreImagen);
			}
		}

		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		documento.setUsuarioRegistro(session.getName());
		documento.setUsuarioActualizacion(session.getName());
		TipoEstado tip = new TipoEstado();
		tip.setTipoEstadoId("0001");
		documento.setTipoEstado(tip);
		documento.setUnidadregistro(usuario.getUnidad());
		documento.setAnio("2021");
		System.out.println("lista : " + documento);

		documentoService.save(documento);
		// return
		// "redirect:/documents/copia-informativa?id="+documento.getDocumentoId();

		return "redirect:/documents/distribucion-documento?id=" + documento.getDocumentoId(); // MODIFICADO POR BLAS
																								// PARA GUARDAR EN COPIA
																								// INFORMATIVA
	}

	@PostMapping("/save-remitidos")
	public String guardarDocumentoRem(Authentication session, Documento documento,
			@RequestParam("archivopdf") MultipartFile multiPart) throws ParseException {
		java.util.Date fechaSistema = new Date();
		
		System.out.println("fecha de ssitema "+ fechaSistema);
		
		DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaNace = fechaHora.parse(documento.getFechaDocumento());
//		Date frecepcion=fechaHora.parse(documento.getFechaRecepcion());
		// Fecha en formato SHORT: 6/10/12
		DateFormat formatFech = DateFormat.getDateInstance(DateFormat.SHORT);
		String f_nace = formatFech.format(fechaNace);
//		String F_recepcion=formatFech.format(frecepcion);
		System.out.println("fecha converida"+f_nace);
		
		
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		if (!multiPart.isEmpty()) {
			String ruta = "c:/mesaPartes/";
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null) {
				documento.setArchivo(nombreImagen);
			}
		}
		
		
		documento.setUsuarioRegistro(session.getName());
		documento.setEstadoRegistro(1);
		documento.setTipoOrganizacion("I");
		documento.setFechaDocumento(f_nace);
		documento.setFechaRecepcion(fechaSistema);
		documento.setUnidadregistro(usuario.getUnidad());
	
	
		
		documento.setDescripcionDocumento("REMITIDO");
		TipoEstado tip = new TipoEstado();
		tip.setTipoEstadoId("0001");
		documento.setTipoEstado(tip);
//		}
		documento.setAnio("2022");
		
		
		documentoService.save(documento);

		return "redirect:/documents/distribucion-documento?id=" + documento.getDocumentoId();
//		return null;
	}

	@PostMapping("/save-decreto")
	public String guardarDecreto(Authentication session, Documento documento) {
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		documento.setUsuarioRegistro(session.getName());
		documento.setUsuarioActualizacion(session.getName());
		TipoEstado tip = new TipoEstado();
		tip.setTipoEstadoId("0001");
		documento.setTipoEstado(tip);

		documento.setAnio("2023");
		documento.setUnidadregistro(usuario.getUnidad());
		documentoService.save(documento);

		System.out.println("actualizacion Registro DECRETO SECRTARIO : " + documento);
		return "redirect:/documents/distribucion-documento?id=" + documento.getDocumentoId();
	}

	/// archivar documento

	@GetMapping("/archivar-documento")
	public String archivarDocumento(@RequestParam("id") Long documentoId, Authentication session) {
		Documento documento = documentoService.listaxID(documentoId);
		TipoEstado tip = new TipoEstado();
		tip.setTipoEstadoId("0005");//codigo 0004 es RESPONDIDO
		documento.setTipoEstado(tip);
		Documento newdoc = documento;
		this.guardarArchivado(newdoc);

		return "redirect:/documents/lista-documentos";
	}

	public void guardarArchivado(Documento documento) {
		documentoService.save(documento);
	}

	@GetMapping("/copia-informativa")
	public String CopiaInformativa(@RequestParam("id") Long documentoId, Authentication session, Model model) {
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		DatosGenerales datosGrls = null;
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
		model.addAttribute("grls", datosGrls);

		Documento documentolista = documentoService.listaxID(documentoId);

		model.addAttribute("titulopage", "SISMEP | DISTRIBUCION");
		model.addAttribute("codigo", documentolista.getDocumentoId());
		model.addAttribute("dependencias", srvUnidad.listaDependencias("20", "0702"));
		model.addAttribute("distribucion", destribucionService.findAll());

		return "/documents/formCopiaInformativa";

	}

	@GetMapping("/distribucion-documento")
	public String DistribucionDocumento(@RequestParam("id") Long documentoId, Authentication session, Model model) {

		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		DatosGenerales datosGrls = null;
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
		model.addAttribute("grls", datosGrls);
		Documento documentolista = documentoService.listaxID(documentoId);

		System.out.println("listaaaaaaaaaaaaaaaaaaaaasssssssssssssssssssssssssssssssssss "
				+ documentoService.listaxID(documentoId));

		model.addAttribute("titulopage", "SISMEP | DISTRIBUCION");
		model.addAttribute("codigo", documentolista.getDocumentoId());
		model.addAttribute("porid", documentoService.listaxID(documentoId));/// por blas para obtener por id todo

		// model.addAttribute("dependencias", srvUnidad.listaDependencias("20",
		// "0702"));
		model.addAttribute("dependencias", srvUnidad.listarunidadescopiainf());

		model.addAttribute("distribucion", destribucionService.findAll());
		return "/documents/formDecretoGeneral";

	}

	@GetMapping("/archivar-copinfo")
	public String archivarCopInf(@RequestParam("iddoc") String iddoc, @RequestParam("idcopinf") String idcopinf,
			@RequestParam("estdado") String estdado, Authentication session) throws Exception {
		srvcopiaInf.estadocopiainformativa(iddoc, idcopinf, estdado);
		return "redirect:/documents/lista-documentos";
	}
}
