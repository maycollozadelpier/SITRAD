package detel.copere.ejercito.mil.pe.models.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import detel.copere.ejercito.mil.pe.mapper.repositoryMapper;
import detel.copere.ejercito.mil.pe.models.dao.RepositoryDao;
import detel.copere.ejercito.mil.pe.models.entity.Documents;

@Repository
public class RepositoryDaoImpl implements RepositoryDao{

	
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Documents> getListRecibidos(String idEstado, String tipoDoc, String unidadResponsable, String fechaRecepcionDocI,
		String fechaRecepcionDocF) {
		String sql = "SELECT * FROM SITRAD.SITRAD_LISTA_DOCUMENTOS\r\n"
				+ "where vid_tipo_doc like '%"+tipoDoc+"%'\r\n"
				+ "AND vid_tipo_estado like '%"+idEstado+"%' and vunidad_codigo_resp= '"+unidadResponsable+"'";
//				+ "AND dfecha_documento between '"+fechaRecepcionDocI+"' and '"+fechaRecepcionDocF+"'";
		
		if(!fechaRecepcionDocI.isEmpty()) {
			sql += "AND dfecha_documento between '"+fechaRecepcionDocI+"' and '"+fechaRecepcionDocF+"'";
		}else if(!fechaRecepcionDocI.isEmpty()  && !fechaRecepcionDocF.isEmpty()) {
			sql += "AND dfecha_documento between '"+fechaRecepcionDocI+"' and to_char(sysdate, 'dd/MM/yy')";
		}
//		String sql ="select * from SITRAD.SITRAD_LISTA_DOCUMENTOS";
//		 and '"+fechaRecepcionDocF+"'"
			
		List<Documents> listatributos = this.jdbcTemplate.query(sql, new repositoryMapper());
		return listatributos;
	}
	@Override
	public List<Documents> getListRemitidos( String tipoDoc, String unidadremite, String fechaDociIni,
			String fechaDocFin)  {
			String sql = "SELECT doc.NID_DOCUMENTO,\r\n"
					+ "					unidos.vabrev_unidad UNIDESTINO,\r\n"
					+ "					acro.vdescripcion_doc TIPODOC,\r\n"
					+ "					VNUMERO_DOCUMENTO,\r\n"
					+ "					to_char(DFECHA_REC_DOCUMENTO, 'dd/mm/yy') DFECHA_REC_DOCUMENTO,\r\n"
					+ "					(CASE WHEN VREF_DOCUMENTO IS NULL THEN 'SIN REFERENCIA' ELSE VREF_DOCUMENTO END) AS VREF_DOCUMENTO ,\r\n"
					+ "					VASUNTO_DOCUMENTO \r\n"
					+ "									from SITRAD.sitrad_documento doc,\r\n"
					+ "									sitrad.sitrad_tipo_documento acro,\r\n"
					+ "									sitrad.sitrad_unidad uni,\r\n"
					+ "									sitrad.sitrad_unidad unidos\r\n"
					+ "									where \r\n"
					+ "									acro.VID_TIPO_DOC = doc.VID_TIPO_DOC\r\n"
					+ "									and doc.VUNIDAD_CODIGO_REMIT  = uni.VCOD_UNIDAD\r\n"
					+ "									and doc.VUNIDAD_CODIGO_RESP = unidos.VCOD_UNIDAD\r\n"
					+ "					        AND ACRO.VID_TIPO_DOC LIKE '%"+tipoDoc+"%'\r\n"
					+ "						     AND doc.VUNIDAD_CODIGO_REMIT= '"+unidadremite+"'";
//					+ "        AND DFECHA_DOCUMENTO between '"+fechaDociIni+"' AND '"+fechaDocFin+"'";
			if(!fechaDociIni.isEmpty()) {
				sql += "AND DFECHA_DOCUMENTO between '"+fechaDociIni+"' and '"+fechaDocFin+"'";
			}else if(!fechaDociIni.isEmpty()  && !fechaDocFin.isEmpty()) {
				sql += "AND DFECHA_DOCUMENTO between '"+fechaDociIni+"' and to_char(sysdate, 'dd/MM/yy')";
			}
//			String sql ="select * from SITRAD.SITRAD_LISTA_DOCUMENTOS";
//			 and '"+fechaRecepcionDocF+"'"
				
			List<Documents> listatributos = this.jdbcTemplate.query(sql, new repositoryMapper());
			return listatributos;
	}
	@Override
	public List<Documents> getListRemitidosDiario(String unidadremite) {
		String sql="select * from sitrad_lista_documentos \r\n"
				+ "where vunidad_codigo_resp = '"+unidadremite+"'\r\n"
				+ "AND dfecha_documento  = to_char(sysdate, 'dd/MM/yy') order by vdescripcion_estado";
		List<Documents> listatributos = this.jdbcTemplate.query(sql, new repositoryMapper());
		return listatributos;
	}

	
}
