package detel.copere.ejercito.mil.pe.models.service.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import detel.copere.ejercito.mil.pe.models.dao.IDocumentsDao;
import detel.copere.ejercito.mil.pe.models.entity.Documento;
import detel.copere.ejercito.mil.pe.models.entity.Documents;
import detel.copere.ejercito.mil.pe.models.entity.ListasNative;
import detel.copere.ejercito.mil.pe.models.service.IDocumentsService;



@Service
public class DocumentServiceImpl implements IDocumentsService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Autowired
	private IDocumentsDao DocumentsDao;

	@Override
	@Transactional(readOnly = true)
	public List<Documents> findAll() {
		return (List<Documents>) DocumentsDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Documents> findAll(Pageable pageable) {
		return DocumentsDao.findAll(pageable);
	}

	@Override
	public Documents listaxID(String documentoId) {
		// TODO Auto-generated method stub
		return DocumentsDao.findBydocumentoId(documentoId);
	}

	@Override
	public List<Documents> listaXestadoYunidadRemitente(String idEstado, String idUnidadRemitente) {
		// TODO Auto-generated method stub
		return DocumentsDao.findByIdEstadoAndIdUnidadRemitente(idEstado, idUnidadRemitente);
	}

	@Override
	public List<Documents> listaDecretoSecretario(Integer estadoRegistro) {
		// TODO Auto-generated method stub
		return DocumentsDao.findByEstadoRegistro(estadoRegistro);
	}

	@Override
	public List<Documents> reporteDiario(String unidadResponsable, String anio, String fechaRecepcionDoc) {
		// TODO Auto-generated method stub
		return DocumentsDao.findByIdUnidadResponsableAndAnioAndFechaRecepcionDoc(unidadResponsable, anio,
				fechaRecepcionDoc);
	}

	@Override
	public List<Documents> reporteRecibidos(String idEstado, String unidadResponsable, String anio,
			String fechaRecepcionDocI, String fechaRecepcionDocF) {
		return DocumentsDao.findByIdEstadoAndIdUnidadResponsableAndAnioAndFechaRecepcionDocBetween(idEstado,
				unidadResponsable, anio, fechaRecepcionDocI, fechaRecepcionDocF);

	}

	@Override
	public List<Documents> reporteRemitidos(String idEstado, String idUnidadRemitente, String anio,
			String fechaRecepcionDocI, String fechaRecepcionDocF) {
		// TODO Auto-generated method stub
//		String sql = "";
//		if(!idUnidadRemitente.isEmpty()) {
//			sql += " and uu = " + idUnidadRemitente;
//		}
//		if(!idUnidadRemitente.isEmpty()) {
//			sql += " and uu = " + idUnidadRemitente;
//		}
		return DocumentsDao.findByIdEstadoAndIdUnidadRemitenteAndAnioAndFechaRecepcionDocBetween(idEstado,
				idUnidadRemitente, anio, fechaRecepcionDocI, fechaRecepcionDocF);
	}

	@Override
	public List<Documents> listaXunidadResponsable(String unidadResponsable) {
		// TODO Auto-generated method stub
		return DocumentsDao.findByIdUnidadResponsable(unidadResponsable);
	}
/////ESTO
	@Override
	public List<Documents> listaXestadoYunidadResponsable(String idEstado, String idUnidadResponsable) {
		// TODO Auto-generated method stub
		return DocumentsDao.findByIdEstadoAndIdUnidadResponsable(idEstado, idUnidadResponsable);
	}

	@Override
	public List<Documents> listaRegistroDiario(String fechaRecepcionDoc) {
		// TODO Auto-generated method stub
		return DocumentsDao.findByFechaRecepcionDoc(fechaRecepcionDoc);
	}

	@Override
	public List<Documents> reporteDiarioMesaPartes(Integer estadoRegistro, String anio, String fechaRecepcionDoc) {
		// TODO Auto-generated method stub
		return DocumentsDao.findByEstadoRegistroAndAnioAndFechaRecepcionDoc(estadoRegistro, anio, fechaRecepcionDoc);
	}

	@Override
	public List<Documents> pendientes(String idEstado) {
		// TODO Auto-generated method stub
		return DocumentsDao.findByIdEstado(idEstado);
	}

	@Override
	public List<ListasNative> listarcomentario() {
		String sql = "SELECT COD_COMENTARIO_DOCUEMENTO,\r\n"
				+ "COMENTARIO,\r\n"
				+ "NID_DOCUMENTO,\r\n"
				+ "decode(PRIORIDAD,'0','EN LA FECHA','1','URGENTE','2','MUY URGENTE') PRIORIDAD\r\n"
				+ "FROM SITRAD_COMENTARIO_DOCUMENTO";
		List<ListasNative> lista = this.jdbcTemplate.query(sql, new returningresogastocambio());
		return lista;
	}
	
	private static final class returningresogastocambio implements RowMapper<ListasNative> {
		@Override
		public ListasNative mapRow(ResultSet rs, int rowNum) throws SQLException {
			ListasNative e = new ListasNative();
			try {
				e.setIddomentario(rs.getInt("COD_COMENTARIO_DOCUEMENTO"));
				e.setComentario(rs.getString("COMENTARIO"));
				e.setIdDocumento(rs.getString("NID_DOCUMENTO"));
				e.setPrioridad(rs.getNString("PRIORIDAD"));
			} catch (Exception ex) {
				System.out.println("ERROR! FotoMapper :" + e.toString());
				System.out.println("ERROR! FotoMapper " + e);
				ex.printStackTrace();
			}
			return e;
		}

	}

	@Override
	public List<Documents> listardocumentosrespondidos() {
		String sql = "SELECT NID_DOCUMENTO,\r\n"
				+ "vnumero_documento,\r\n"
				+ "vref_documento ,\r\n"
				+ "vdoc_archivo,\r\n"
				+ "vasunto_documento\r\n"
				+ "FROM SITRAD.SITRAD_DOCUMENTO ";
		List<Documents> lista = this.jdbcTemplate.query(sql, new retornarlistarespondido());
		return lista;
	}
	
	private static final class retornarlistarespondido implements RowMapper<Documents> {
		@Override
		public Documents mapRow(ResultSet rs, int rowNum) throws SQLException {
			Documents e = new Documents();
			try {
				e.setDocumentoId(rs.getString("NID_DOCUMENTO"));
				e.setNumDoc(rs.getString("vnumero_documento"));
				e.setDocumentoReferencia(rs.getString("vref_documento"));
				e.setArchivo(rs.getString("vdoc_archivo"));
				e.setAsunto(rs.getString("vasunto_documento"));
			
			} catch (Exception ex) {
				System.out.println("ERROR! FotoMapper :" + e.toString());
				System.out.println("ERROR! FotoMapper " + e);
				ex.printStackTrace();
			}
			return e;
		}

	}

	@Override
	public List<Documento> listaunidadregistra(String unidad) {
		String sql = "select\r\n"
				+ "				acro.vdescripcion_doc TIPODOC,\r\n"
				+ "				doc.NID_DOCUMENTO,\r\n"
				+ "				VDOC_ARCHIVO,\r\n"
				+ "				VASUNTO_DOCUMENTO,\r\n"
				+ "				VREF_DOCUMENTO,\r\n"
				+ "				DFECHA_DOCUMENTO,\r\n"
				+ "				DFECHA_REC_DOCUMENTO,\r\n"
				+ "				VNUMERO_DOCUMENTO,\r\n"
				+ "				uni.vabrev_unidad   VUNIDAD_CODIGO_REMIT,\r\n"
				+ "				UNIDAD_REGISTRO\r\n"
				+ "				from SITRAD.sitrad_documento doc,\r\n"
				+ "				sitrad.sitrad_tipo_documento acro,\r\n"
				+ "				sitrad.sitrad_unidad uni,\r\n"
				+ "        SITRAD.sitrad_documento_registrado UNIREG\r\n"
				+ "				where \r\n"
				+ "				acro.VID_TIPO_DOC = doc.VID_TIPO_DOC\r\n"
				+ "				and doc.VUNIDAD_CODIGO_REMIT  = uni.VCOD_UNIDAD\r\n"
				+ "      AND DOC.NID_DOCUMENTO = UNIREG.NID_DOCUMENTO\r\n"
				+ "AND unireg.vcod_unidad_doc_registra = '"+unidad+"'\r\n"
				+ " order by dfecha_rec_documento desc";
		List<Documento> lista = this.jdbcTemplate.query(sql, new retornarlistaunidadregistro());
		return lista;
	}
	
	private static final class retornarlistaunidadregistro implements RowMapper<Documento> {
		@Override
		public Documento mapRow(ResultSet rs, int rowNum) throws SQLException {
			Documento e = new Documento();
			try {
				e.setRespuesta(rs.getString("TIPODOC"));
				e.setDocumentoId(rs.getLong("NID_DOCUMENTO"));
				e.setArchivo(rs.getString("VDOC_ARCHIVO"));
				e.setAsunto(rs.getString("VASUNTO_DOCUMENTO"));
				e.setDocumentoReferencia(rs.getString("VREF_DOCUMENTO"));
				e.setFechaDocumento(rs.getString("DFECHA_DOCUMENTO"));
				e.setFechaRecepcion(rs.getDate("DFECHA_REC_DOCUMENTO"));
				e.setNumeroDocumento(rs.getString("VNUMERO_DOCUMENTO"));
				e.setUnidadRemitente(rs.getString("VUNIDAD_CODIGO_REMIT"));
				e.setUnidadregistro(rs.getString("UNIDAD_REGISTRO"));
			
			} catch (Exception ex) {
				System.out.println("ERROR! FotoMapper :" + e.toString());
				System.out.println("ERROR! FotoMapper " + e);
				ex.printStackTrace();
			}
			return e;
		}

	}

	@Override
	public List<Documento> listaunidadremite(String unidad) {
		String sql = "select acro.vdescripcion_doc TIPODOC,\r\n"
				+ "doc.NID_DOCUMENTO,\r\n"
				+ "VDOC_ARCHIVO,\r\n"
				+ "VASUNTO_DOCUMENTO,\r\n"
				+ "VREF_DOCUMENTO,\r\n"
				+ "DFECHA_DOCUMENTO,\r\n"
				+ "DFECHA_REC_DOCUMENTO,\r\n"
				+ "VNUMERO_DOCUMENTO,\r\n"
				+ "uni.vabrev_unidad   VUNIDAD_CODIGO_REMIT,\r\n"
				+ "UNIDAD_REGISTRO,\r\n"
				+ "unidos.vabrev_unidad UNIDESTINO\r\n"
				+ "from SITRAD.sitrad_documento doc,\r\n"
				+ "sitrad.sitrad_tipo_documento acro,\r\n"
				+ "sitrad.sitrad_unidad uni,\r\n"
				+ "sitrad.sitrad_unidad unidos\r\n"
				+ "where \r\n"
				+ "acro.VID_TIPO_DOC = doc.VID_TIPO_DOC\r\n"
				+ "and doc.VUNIDAD_CODIGO_REMIT  = uni.VCOD_UNIDAD\r\n"
				+ "and doc.VUNIDAD_CODIGO_RESP = unidos.VCOD_UNIDAD\r\n"
				+ "AND doc.VUNIDAD_CODIGO_REMIT=        '"+unidad+"'\r\n"
				+ "order by dfecha_rec_documento desc";
		List<Documento> lista = this.jdbcTemplate.query(sql, new retornarlistaunidadremitido());
		return lista;
	}
	
	private static final class retornarlistaunidadremitido implements RowMapper<Documento> {
		@Override
		public Documento mapRow(ResultSet rs, int rowNum) throws SQLException {
			Documento e = new Documento();
		
			
			
			try {
				e.setRespuesta(rs.getString("TIPODOC"));
				e.setDocumentoId(rs.getLong("NID_DOCUMENTO"));
				e.setArchivo(rs.getString("VDOC_ARCHIVO"));
				e.setAsunto(rs.getString("VASUNTO_DOCUMENTO"));
				e.setDocumentoReferencia(rs.getString("VREF_DOCUMENTO"));
				e.setFechaDocumento(rs.getString("DFECHA_DOCUMENTO"));
				e.setFechaRecepcion(rs.getDate("DFECHA_REC_DOCUMENTO"));
				e.setNumeroDocumento(rs.getString("VNUMERO_DOCUMENTO"));
				e.setUnidadRemitente(rs.getString("VUNIDAD_CODIGO_REMIT"));
				e.setUnidadregistro(rs.getString("UNIDAD_REGISTRO"));
				e.setUnidadResponsable(rs.getString("UNIDESTINO"));
				
			
			
			} catch (Exception ex) {
				System.out.println("ERROR! FotoMapper :" + e.toString());
				System.out.println("ERROR! FotoMapper " + e);
				ex.printStackTrace();
			}
			return e;
		}

	}

}
