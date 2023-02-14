package detel.copere.ejercito.mil.pe.models.service.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import detel.copere.ejercito.mil.pe.models.entity.GenericoNative;
import detel.copere.ejercito.mil.pe.models.service.IQueryNativeService;

@Repository
public class QueryNativeServiceImpl implements IQueryNativeService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<GenericoNative> listarDecreto(String cod_dependencia) throws Exception {
		// TODO Auto-generated method stub
//		String sql = "select dc.nid_documento,d.vnumero_documento, dc.id_distribucion,dt.descripcion,ci.vcod_unidad_copia_informativa, c.comentario,\r\n" + 
//				"DECODE  (c.prioridad, '0', 'EN LA FECHA','1','URGENTE','2','MUY URGENTE') PRIORIDAD\r\n" + 
//				"from SITRAD_distribucion_documento dc , SITRAD_distribucion dt,SITRAD_copia_informativa ci, SITRAD_documento d, SITRAD_comentario_documento c\r\n" + 
//				"where dc.id_distribucion = dt.id_distribucion and dc.nid_documento = ci.nid_documento AND  dc.nid_documento=d.nid_documento and dc.nid_documento=c.nid_documento\r\n" + 
//				"and d.vid_tipo_estado='0001'\r\n" + 
//				"and ci.vcod_unidad_copia_informativa = '"
//				+ cod_dependencia + "'";
		String sql = "SELECT \r\n"
				+ "d.nid_documento,d.vnumero_documento, d.VASUNTO_DOCUMENTO id_distribucion, uni.VABREV_UNIDAD descripcion,c.vcod_unidad_copia_informativa, tipodoc.vdescripcion_doc comentario,  \r\n"
				+ "						 C.COD_COPIA_INFORMATIVA PRIORIDAD \r\n"
				+ "				FROM SITRAD_DOCUMENTO  D,\r\n"
				+ "			sITRAD_COPIA_INFORMATIVA c ,\r\n"
				+ "      sitrad_tipo_documento tipodoc,\r\n"
				+ "      sitrad_unidad uni\r\n"
				+ "			WHERE C.NID_DOCUMENTO = D.NID_DOCUMENTO \r\n"
				+ "      and tipodoc.VID_TIPO_DOC  =    d.VID_TIPO_DOC   \r\n"
				+ "      and uni.vcod_unidad   = d.vunidad_codigo_remit  and d.vid_tipo_estado='0001' AND C.VCOD_TIPO_ESTADO NOT  IN ('1') \r\n"
				+ "AND c.vcod_unidad_copia_informativa = '"+cod_dependencia+"'";
		List<GenericoNative> lista = this.jdbcTemplate.query(sql, new returnlistadecreto());
		return lista;
	}
	
	private static final class returnlistadecreto implements RowMapper<GenericoNative> {

		@Override
		public GenericoNative mapRow(ResultSet rs, int rowNum) throws SQLException {
			GenericoNative e = new GenericoNative();
			try {
				e.setCod_documento(rs.getString("nid_documento"));
				e.setNum_documento(rs.getString("vnumero_documento"));
				e.setCod_decreto(rs.getString("id_distribucion"));
				e.setComentario(rs.getString("comentario"));
				e.setPrioridad(rs.getString("PRIORIDAD"));
				e.setDecreto(rs.getString("descripcion"));

			} catch (Exception ex) {
				System.out.println("ERROR! QueryNative :" + e.toString());
				System.out.println("ERROR! QueryNative " + e);
				ex.printStackTrace();
			}
			return e;
		}
		
	}

	@Override
	public List<GenericoNative> listarCopiaInformativa(String cod_dependencia) throws Exception {
		// TODO Auto-generated method stub
//		String sql = "select dc.nid_documento,d.vnumero_documento, dc.id_distribucion,dt.descripcion,ci.vcod_unidad_copia_informativa, c.comentario,\r\n" + 
//				"DECODE  (c.prioridad, '0', 'EN LA FECHA','1','URGENTE','2','MUY URGENTE') PRIORIDAD\r\n" + 
//				"from SITRAD_distribucion_documento dc , SITRAD_distribucion dt,SITRAD_copia_informativa ci, SITRAD_documento d, SITRAD_comentario_documento c\r\n" + 
//				"where dc.id_distribucion = dt.id_distribucion and dc.nid_documento = ci.nid_documento AND  dc.nid_documento=d.nid_documento and dc.nid_documento=c.nid_documento\r\n" + 
//				"and d.vid_tipo_estado='0001'\r\n" + 
//				"and ci.vcod_unidad_copia_informativa = '"
//				+ cod_dependencia + "'";
		String sql = "SELECT \r\n"
				+ "d.nid_documento,d.vnumero_documento, d.VASUNTO_DOCUMENTO id_distribucion, uni.VABREV_UNIDAD descripcion,c.vcod_unidad_copia_informativa, tipodoc.vdescripcion_doc comentario,  \r\n"
				+ "						 C.COD_COPIA_INFORMATIVA PRIORIDAD \r\n"
				+ "				FROM SITRAD_DOCUMENTO  D,\r\n"
				+ "			sITRAD_COPIA_INFORMATIVA c ,\r\n"
				+ "      sitrad_tipo_documento tipodoc,\r\n"
				+ "      sitrad_unidad uni\r\n"
				+ "			WHERE C.NID_DOCUMENTO = D.NID_DOCUMENTO \r\n"
				+ "      and tipodoc.VID_TIPO_DOC  =    d.VID_TIPO_DOC   \r\n"
				+ "      and uni.vcod_unidad   = d.vunidad_codigo_remit   AND C.VCOD_TIPO_ESTADO NOT  IN ('0') \r\n"
				+ "AND c.vcod_unidad_copia_informativa = '"+cod_dependencia+"'";
		List<GenericoNative> lista = this.jdbcTemplate.query(sql, new returnlistadecreto());
		return lista;
	}

}
