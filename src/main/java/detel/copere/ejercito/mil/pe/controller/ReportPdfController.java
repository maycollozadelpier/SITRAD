package detel.copere.ejercito.mil.pe.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import detel.copere.ejercito.mil.pe.models.dao.IDatosGeneralesDao;
import detel.copere.ejercito.mil.pe.models.dao.RepositoryDao;
import detel.copere.ejercito.mil.pe.models.dao.impl.RepositoryDaoImpl;
import detel.copere.ejercito.mil.pe.models.entity.DatosGenerales;
import detel.copere.ejercito.mil.pe.models.entity.Documento;
import detel.copere.ejercito.mil.pe.models.entity.Documents;
import detel.copere.ejercito.mil.pe.models.entity.Usuario;
import detel.copere.ejercito.mil.pe.models.service.IDocumentsService;
import detel.copere.ejercito.mil.pe.models.service.IUsuarioService;
import detel.copere.ejercito.mil.pe.util.paginator.Global;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.swing.JEditorPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;

@Controller
//@RequestMapping("/api-reportes")
//@CrossOrigin("*")
public class ReportPdfController {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IDocumentsService documentsService;
	@Autowired
	private RepositoryDaoImpl repositoryDao;

	@Autowired
	IDatosGeneralesDao datosGeneralesDao;
	
	@GetMapping("/searchs")
	public String apireportes() {
		
		return "OLA BLAS";
	}


//	@RequestMapping(value= "/pdfRecibidos", method = RequestMethod.GET)
//	public void generatePdfRecibidos(Authentication session, Documento documento, String tipoDocumento,  String fechaRecepcionDocI, String fechaRecepcionDocF,  HttpServletRequest request,
//			HttpServletResponse response ) throws ServletException, IOException, JRException {
//
//		Connection connection = null;
//		
//			
//		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
//		System.out.println(usuario.getUsername());
//		DatosGenerales datosGrls = null;
//		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
//        
//		String ip = "";
//		if (request.getHeader("HTTP_X_FORWARDED_FOR") == null) {
//			ip = request.getRemoteAddr();
//		} else {
//			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//		}
//		System.out.println("========================================================================");
//
//		System.out.println("[IP] = " + ip);
//
//		System.out.println("========================================================================");
//
//		Date date = new Date();
//		// Caso 1: obtener la hora y salida por pantalla con formato:
//		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
//		System.out.println("Hora: " + hourFormat.format(date));
//		// Caso 2: obtener la fecha y salida por pantalla con formato:
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
//		System.out.println("Fecha: " + dateFormat.format(date));
//		// Caso 3: obtenerhora y fecha y salida por pantalla con formato:
//		DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
//		// Caso 3: obtenerhora y fecha y salida por pantalla con formato:
//		DateFormat anioFormat = new SimpleDateFormat("yyyy");
// 
//		
//        
//        
////		String anio = anioFormat.format(date);
//	//	System.out.println("Ano format: " + anio);
//
//		String fecha = dateFormat.format(date);
//		System.out.println("fecha con formato para bd: " + fecha);
//		String HoraFecha = hourdateFormat.format(date);
//		System.out.println("Hora y fecha: " + HoraFecha);
//
////		documento.getTipoDocumento();
////
////		System.out.println("tipo de documento seleccionado " + documento.getTipoDocumento());
////		
//		
//		try {
//		String rutaImg = Global.RUTA_IMAGEN;
//
//		String rutaFile = Global.RUTA_REPORTES + "DocumentsRecibidos.jrxml";
//
//		JasperReport jasperReport = JasperCompileManager.compileReport(rutaFile);
//
//		Map<String, Object> map = new HashMap<>();
//		map.put("P_USUARIO", usuario.getUsername());
//		map.put("P_IP", ip);
//		map.put("P_RUTA_IMG", rutaImg);
//		
//		map.put("P_TIPO_DOC", tipoDocumento);
//		map.put("P_FEC_INI", fechaRecepcionDocI);
//		map.put("P-FEC_FIN", fechaRecepcionDocF);
//		
//		
//		byte[] reporte = null;
//		connection = this.jdbcTemplate.getDataSource().getConnection();
//		if (connection != null) {
//			System.out.println("[CONECTADA] " + connection.getMetaData().getMaxTableNameLength());
//			System.out.println("[CONECTADA] " + connection.getMetaData().getDriverName());
//			System.out.println("[CONECTADA] " + connection.getMetaData().getDatabaseProductName());
//			System.out.println("[CONECTADA] " + connection.getMetaData().getUserName());
//			System.out.println("[CONECTADA] " + connection.getMetaData().getMaxTablesInSelect());
//
//			System.out.println("[connection connection] " + connection);
//		}
//
//		reporte = JasperRunManager.runReportToPdf(jasperReport, map, connection);
//		response.setContentType("application/pdf");
//		response.setHeader("Content-disposition", "inline; filename=Comprobante.pdf");
//		response.setHeader("Cache-Control", "max-age=30");
//		response.setHeader("Pragma", "No-cache");
//		response.setDateHeader("Expires", 0);
//		response.setContentLength(reporte.length);
//		ServletOutputStream out = response.getOutputStream();
//		out.write(reporte, 0, reporte.length);
//		out.flush();
//		out.close();
//
//	}catch (Exception e) {
//		System.out.println("ERROR! reporte archivos justificatorios " + e.toString());
//		System.out.println("ERROR! reporte archivos justificatorios " + e);
//		response.setContentType("text/html");
//		PrintWriter pw = response.getWriter();
//		pw.println("<html>");
//		pw.println("<head><title>Pagina de error</title></title>");
//		pw.println("<body>");
//		pw.println("<h2>Se produjo un error inesperado</h2>");
//		pw.println("</body></html>");
//	} finally {
//		if (connection != null) {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				System.out.println("ERROR! EN cerrar conexion");
//				System.out.println("ERROR! EN cerrar conexion");
//			}
//		}
//	}
//
//}

	@RequestMapping(value = "/pdfRecibidos", method = RequestMethod.GET)
	public ResponseEntity<byte[]> generatePdfRecibidos(Authentication session, HttpServletRequest request,
			Documento documento, String tipoDocumento, String fechaRecepcionDocI, String fechaRecepcionDocF,String archivo,
			Model model) throws Exception, JRException {
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
				repositoryDao.getListRecibidos("0001", tipoDocumento, usuario.getUnidad(), fechaRecepcionDocI,
						fechaRecepcionDocF));
		System.out.println("reporte de documentos: " + beanCollectionDataSource);
		String rutaImg = Global.RUTA_IMAGEN;

		String rutaFile = Global.RUTA_REPORTES + "DocumentsRecibidos.jrxml";

		JasperReport compileReport = JasperCompileManager.compileReport(rutaFile);

		Map<String, Object> map = new HashMap<>();
		map.put("P_USUARIO", usuario.getUnidad());
		map.put("P_IP", "10.64.4.5");
		map.put("P_RUTA_IMAGEN", rutaImg);
		map.put("P_RUTA_ARCHIVO", rutaFile);
		map.put("P_TIPO_DOC", tipoDocumento);
		map.put("P_FEC_INI", fechaRecepcionDocI);
		map.put("P-FEC_FIN", fechaRecepcionDocF);
		JasperPrint report = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
		byte[] data = JasperExportManager.exportReportToPdf(report);
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=invoice.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}
	

	@GetMapping("/pdfRemitidos")
	public ResponseEntity<byte[]> generatePdfRecibido(Authentication session, HttpServletRequest request,
			Documento documento, String tipoDocumento, String fechaRecepcionDocI, String fechaRecepcionDocF,String archivo,
			Model model) throws Exception, JRException {
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
				repositoryDao.getListRemitidos( tipoDocumento, usuario.getUnidad(), fechaRecepcionDocI,
						fechaRecepcionDocF));
		System.out.println("reporte de documentos: " + beanCollectionDataSource);
		String rutaImg = Global.RUTA_IMAGEN;

		String rutaFile = Global.RUTA_REPORTES + "DocumentsRemitidos.jrxml";

		JasperReport compileReport = JasperCompileManager.compileReport(rutaFile);

		Map<String, Object> map = new HashMap<>();
		map.put("P_USUARIO", usuario.getUnidad());
		map.put("P_IP", "10.64.4.5");
		map.put("P_RUTA_IMAGEN", rutaImg);
		map.put("P_RUTA_ARCHIVO", rutaFile);
		map.put("P_TIPO_DOC", tipoDocumento);
		map.put("P_FEC_INI", fechaRecepcionDocI);
		map.put("P-FEC_FIN", fechaRecepcionDocF);
		JasperPrint report = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
		byte[] data = JasperExportManager.exportReportToPdf(report);
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=invoice.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}
	

	// REPORTE DE DOCUMENTOS REMITIDOS
//	@RequestMapping(value = "/pdfRemitidos", method = RequestMethod.POST)
//	public ResponseEntity<byte[]> generatePdfRemitidos(Authentication session, HttpServletRequest request,
//			Documento documento, String tipoDocumento, String anio, String fechaRecepcionDocI,
//			String fechaRecepcionDocF, Model model) throws Exception, JRException {
//
//		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
//		DatosGenerales datosGrls = null;
//		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
//		model.addAttribute("grls", datosGrls);
//
//		model.addAttribute("documento", documento);
//
//		String ip = "";
//		if (request.getHeader("HTTP_X_FORWARDED_FOR") == null) {
//			ip = request.getRemoteAddr();
//		} else {
//			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//		}
//		System.out.println("========================================================================");
//
//		System.out.println("[IP] = " + ip);
//
//		System.out.println("========================================================================");
//
//		Date date = new Date();
//		// Caso 1: obtener la hora y salida por pantalla con formato:
//		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
//		System.out.println("Hora: " + hourFormat.format(date));
//		// Caso 2: obtener la fecha y salida por pantalla con formato:
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
//		System.out.println("Fecha: " + dateFormat.format(date));
//		// Caso 3: obtenerhora y fecha y salida por pantalla con formato:
//		DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
//
//		String fechaRecepcion = dateFormat.format(date);
//		System.out.println("fecha con formato para bd: " + fechaRecepcion);
//		String fecha = hourdateFormat.format(date);
//		System.out.println("Hora y fecha: " + fecha);
//
//		documento.getTipoDocumento();
//
//		System.out.println("tipo de documento seleccionado " + tipoDocumento);
//		System.out.println("datos de formulario " + tipoDocumento + " " + anio + " " + fechaRecepcionDocI + " "
//				+ fechaRecepcionDocF);
//		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(documentsService
//				.reporteRemitidos("0003", usuario.getUnidad(), anio, fechaRecepcionDocI, fechaRecepcionDocF));
//		System.out.println("reporte de documentos: " + beanCollectionDataSource);
//		System.out.println("reporte datos: " + documentsService.reporteRemitidos("0001", usuario.getUnidad(), anio,
//				fechaRecepcionDocI, fechaRecepcionDocF));
//
//		JasperReport compileReport = JasperCompileManager.compileReport(
//				new FileInputStream("src/main/resources/templates/jasperReport/DocumentsRemitidos.jrxml"));
//
//		Map<String, Object> map = new HashMap<>();
//		map.put("P_USUARIO", usuario.getUsername());
//		map.put("P_IP", ip);
//		JasperPrint report = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
//		byte[] data = JasperExportManager.exportReportToPdf(report);
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=invoice.pdf");
//
//		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
//	}
//	 REPORTE DIARIO DE LAS DEPENDENCIAS-------------**DIARIO**-------------
	@GetMapping("/pdfDiario")
	public ResponseEntity<byte[]> pdfdiario(Authentication session, HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception, JRException {

		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
				repositoryDao.getListRemitidosDiario(usuario.getUnidad()));
		System.out.println("reporte de documentos: " + beanCollectionDataSource);
		String rutaImg = Global.RUTA_IMAGEN;

		String rutaFile = Global.RUTA_REPORTES + "DocumentsDiario.jrxml";

		JasperReport compileReport = JasperCompileManager.compileReport(rutaFile);

		Map<String, Object> map = new HashMap<>();
		map.put("P_USUARIO", usuario.getUnidad());
		map.put("P_IP", "10.64.4.5");
		map.put("P_RUTA_IMAGEN", rutaImg);
		map.put("P_RUTA_ARCHIVO", rutaFile);
		JasperPrint report = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
		byte[] data = JasperExportManager.exportReportToPdf(report);
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=invoice.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}
	
	@GetMapping("/pruebados")
	public void reporteprueba(Authentication session, HttpServletRequest request, HttpServletResponse response,
			Model model)
			throws ServletException, IOException, JRException {

		
		Connection connection = null;
		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		String rutaImg = Global.RUTA_IMAGEN;
		try {
			JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
					repositoryDao.getListRemitidosDiario(usuario.getUnidad()));
			
			String rutaFile = "C:/mesaPartes/REPORTES/DocumentsDiario.jrxml"; //request.getSession().getServletContext().getRealPath("/nuevo.jrxml");
			//rutaArchivo = request.getSession().getServletContext().getRealPath("");
			JasperReport jasperReport = JasperCompileManager.compileReport(rutaFile);
			Map<String, Object> map = new HashMap<>();
			

			byte[] reporte = null;

			connection = this.jdbcTemplate.getDataSource().getConnection();

			if (connection != null) {
				System.out.println("[CONECTADA] " + connection.getMetaData().getMaxTableNameLength());
				System.out.println("[CONECTADA] " + connection.getMetaData().getDriverName());
				System.out.println("[CONECTADA] " + connection.getMetaData().getDatabaseProductName());
				System.out.println("[CONECTADA] " + connection.getMetaData().getUserName());
				System.out.println("[CONECTADA] " + connection.getMetaData().getMaxTablesInSelect());

				System.out.println("[connection connection] " + connection);
			}
			
	
			map.put("P_USUARIO", usuario.getUnidad());
			map.put("P_IP", "10.64.4.5");
			map.put("P_RUTA_IMAGEN", rutaImg);
			map.put("P_RUTA_ARCHIVO", rutaFile);
			
			JasperPrint report = JasperFillManager.fillReport(jasperReport, map, beanCollectionDataSource);
			//reporte = JasperRunManager.runReportToPdf(jasperReport, map, connection);

			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "inline; filename=CopiaInformativa.pdf");
			response.setHeader("Cache-Control", "max-age=30");
			response.setHeader("Pragma", "No-cache");
			response.setDateHeader("Expires", 0);
			response.setContentLength(reporte.length);
			ServletOutputStream out = response.getOutputStream();
			out.write(reporte, 0, reporte.length);
			out.flush();
			out.close();

		} catch (Exception e) {
			System.out.println("ERROR! reporte copia informativa " + e.toString());
			System.out.println("ERROR! reporte copia informativa " + e);
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.println("<head><title>Pagina de error</title></title>");
			pw.println("<body>");
			pw.println("<h2>Se produjo un error inesperado</h2>");
			pw.println("</body></html>");
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("ERROR! EN cerrar conexion");
					System.out.println("ERROR! EN cerrar conexion");
				}
			}
		}

	}
	

	
	
	
//	@GetMapping("/pdfDiario")
//	public ResponseEntity<byte[]> reporteDiario(Authentication session, HttpServletRequest request, Documento documento)
//			throws Exception, JRException {
//
//		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
//		DatosGenerales datosGrls = null;
//		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());
//
//		String ip = "";
//		if (request.getHeader("HTTP_X_FORWARDED_FOR") == null) {
//			ip = request.getRemoteAddr();
//		} else {
//			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//		}
//		System.out.println("========================================================================");
//
//		System.out.println("[IP] = " + ip);
//
//		System.out.println("========================================================================");
//
//		Date date = new Date();
//		// Caso 1: obtener la hora y salida por pantalla con formato:
//		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
//		System.out.println("Hora: " + hourFormat.format(date));
//		// Caso 2: obtener la fecha y salida por pantalla con formato:
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
//		System.out.println("Fecha: " + dateFormat.format(date));
//		// Caso 3: obtenerhora y fecha y salida por pantalla con formato:
//		DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
//		// Caso 3: obtenerhora y fecha y salida por pantalla con formato:
//		DateFormat anioFormat = new SimpleDateFormat("yyyy");
//
//		String anio = anioFormat.format(date);
//		System.out.println("Ano format: " + anio);
//
//		String fecha = dateFormat.format(date);
//		System.out.println("fecha con formato para bd: " + fecha);
//		String HoraFecha = hourdateFormat.format(date);
//		System.out.println("Hora y fecha: " + HoraFecha);
//
//		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
//				documentsService.reporteDiario(usuario.getUnidad(), anio, fecha));
//		System.out.println("reporte de documentos: " + beanCollectionDataSource);
//		System.out
//				.println("reporte de documentos: " + documentsService.reporteDiario(usuario.getUnidad(), anio, fecha));
//		JasperReport compileReport = JasperCompileManager
//				.compileReport(new FileInputStream("src/main/resources/templates/jasperReport/DocumentsDiario.jrxml"));
//
//		Map<String, Object> map = new HashMap<>();
//		map.put("P_USUARIO", usuario.getUsername());
//		map.put("P_IP", ip);
//		JasperPrint report = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
//		byte[] data = JasperExportManager.exportReportToPdf(report);
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=invoice.pdf");
//
//		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
//
//	}

	// MESA DE PARTES
	// REPORTE DIARIO DE DOCUMENTOS REGISTRADOS POR DIA DE
	@GetMapping("/pdfDiarioMesaPartes")
	public void reporteDiarioMesaPartes(Authentication session, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, JRException {

		Connection connection = null;

		Usuario usuario = usuarioService.buscarPorUsername(session.getName());
		DatosGenerales datosGrls = null;
		datosGrls = datosGeneralesDao.getDatosGenerales(usuario.getUsername());

		String ip = "";
		if (request.getHeader("HTTP_X_FORWARDED_FOR") == null) {
			ip = request.getRemoteAddr();
		} else {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		System.out.println("========================================================================");

		System.out.println("[IP] = " + ip);

		System.out.println("========================================================================");

		Date date = new Date();
		// Caso 1: obtener la hora y salida por pantalla con formato:
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		System.out.println("Hora: " + hourFormat.format(date));
		// Caso 2: obtener la fecha y salida por pantalla con formato:
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		System.out.println("Fecha: " + dateFormat.format(date));
		// Caso 3: obtenerhora y fecha y salida por pantalla con formato:
		DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
		// Caso 3: obtenerhora y fecha y salida por pantalla con formato:
		DateFormat anioFormat = new SimpleDateFormat("yyyy");

		String anio = anioFormat.format(date);
		System.out.println("Ano format: " + anio);

		String fecha = dateFormat.format(date);
		System.out.println("fecha con formato para bd: " + fecha);
		String HoraFecha = hourdateFormat.format(date);
		System.out.println("Hora y fecha: " + HoraFecha);

//			documento.getTipoDocumento();
//
//			System.out.println("tipo de documento seleccionado " + documento.getTipoDocumento());
//			

		try {
			String rutaImg = Global.RUTA_IMAGEN;

			String rutaFile = Global.RUTA_REPORTES + "DocumentsDiarioMesaPartes.jrxml";

			JasperReport jasperReport = JasperCompileManager.compileReport(rutaFile);

			Map<String, Object> map = new HashMap<>();
			map.put("P_USUARIO", usuario.getUsername());
			map.put("P_IP", ip);
			map.put("P_RUTA_IMG", rutaImg);
			byte[] reporte = null;
			connection = this.jdbcTemplate.getDataSource().getConnection();
			if (connection != null) {
				System.out.println("[CONECTADA] " + connection.getMetaData().getMaxTableNameLength());
				System.out.println("[CONECTADA] " + connection.getMetaData().getDriverName());
				System.out.println("[CONECTADA] " + connection.getMetaData().getDatabaseProductName());
				System.out.println("[CONECTADA] " + connection.getMetaData().getUserName());
				System.out.println("[CONECTADA] " + connection.getMetaData().getMaxTablesInSelect());

				System.out.println("[connection connection] " + connection);
			}

			reporte = JasperRunManager.runReportToPdf(jasperReport, map, connection);
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "inline; filename=Comprobante.pdf");
			response.setHeader("Cache-Control", "max-age=30");
			response.setHeader("Pragma", "No-cache");
			response.setDateHeader("Expires", 0);
			response.setContentLength(reporte.length);
			ServletOutputStream out = response.getOutputStream();
			out.write(reporte, 0, reporte.length);
			out.flush();
			out.close();

		} catch (Exception e) {
			System.out.println("ERROR! reporte archivos justificatorios " + e.toString());
			System.out.println("ERROR! reporte archivos justificatorios " + e);
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.println("<head><title>Pagina de error</title></title>");
			pw.println("<body>");
			pw.println("<h2>Se produjo un error inesperado</h2>");
			pw.println("</body></html>");
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("ERROR! EN cerrar conexion");
					System.out.println("ERROR! EN cerrar conexion");
				}
			}
		}

	}

	@GetMapping("/reporteprueba")
	public void reporteprueba(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, JRException {
		Connection connection = null;
		try {
			String rutaFile = "";

			JasperReport jasperReport = JasperCompileManager.compileReport(
					new FileInputStream("src/main/resources/templates/jasperReport/DocumentsCopiaInformativa.jrxml"));
			Map<String, Object> parametros = new HashMap<>();
			parametros.put("P_DEPENDENCIA", "A10133");

			byte[] reporte = null;

			connection = this.jdbcTemplate.getDataSource().getConnection();

			if (connection != null) {
				System.out.println("[CONECTADA] " + connection.getMetaData().getMaxTableNameLength());
				System.out.println("[CONECTADA] " + connection.getMetaData().getDriverName());
				System.out.println("[CONECTADA] " + connection.getMetaData().getDatabaseProductName());
				System.out.println("[CONECTADA] " + connection.getMetaData().getUserName());
				System.out.println("[CONECTADA] " + connection.getMetaData().getMaxTablesInSelect());

				System.out.println("[connection connection] " + connection);
			}

			reporte = JasperRunManager.runReportToPdf(jasperReport, parametros, connection);

			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "inline; filename=CopiaInformativa.pdf");
			response.setHeader("Cache-Control", "max-age=30");
			response.setHeader("Pragma", "No-cache");
			response.setDateHeader("Expires", 0);
			response.setContentLength(reporte.length);
			ServletOutputStream out = response.getOutputStream();
			out.write(reporte, 0, reporte.length);
			out.flush();
			out.close();

		} catch (Exception e) {
			System.out.println("ERROR! reporte copia informativa " + e.toString());
			System.out.println("ERROR! reporte copia informativa " + e);
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.println("<head><title>Pagina de error</title></title>");
			pw.println("<body>");
			pw.println("<h2>Se produjo un error inesperado</h2>");
			pw.println("</body></html>");
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("ERROR! EN cerrar conexion");
					System.out.println("ERROR! EN cerrar conexion");
				}
			}
		}

	}

	@InitBinder
	public void initBinder(WebDataBinder webdatabinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		webdatabinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
