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

import detel.copere.ejercito.mil.pe.models.entity.ListasNative;
import detel.copere.ejercito.mil.pe.models.service.IListasNativeService;

@Repository
public class ListasNativeServiceImpl implements IListasNativeService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<ListasNative> listarCopiaInformatica() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select dc.nid_documento,d.vnumero_documento,d.vid_tipo_doc, d.vdescripcion_doc, d.nid_tipo_clasificacion, d.vdescripcion_clasificacion, \r\n" + 
				"				d.vid_tipo_estado, d.vdescripcion_estado, d. vasunto_documento, d.dfecha_documento, d.dfecha_rec_documento, dc.id_distribucion,\r\n" + 
				"				dt.descripcion,ci.vcod_unidad_copia_informativa, uu.vabrev_unidad, c.comentario,\r\n" + 
				"				DECODE  (c.prioridad, '0', 'EN LA FECHA','1','URGENTE','2','MUY URGENTE') PRIORIDAD\r\n" + 
				"				from SITRAD_distribucion_documento dc , SITRAD_distribucion dt,SITRAD_copia_informativa ci, SITRAD_lista_documentos d, SITRAD_comentario_documento c, SITRAD_unidad uu\r\n" + 
				"				where dc.id_distribucion = dt.id_distribucion and dc.nid_documento = ci.nid_documento AND  dc.nid_documento=d.nid_documento and dc.nid_documento=c.nid_documento\r\n" + 
				"				and d.vid_tipo_estado='0001' and ci.vcod_unidad_copia_informativa=uu.vcod_unidad";
		List<ListasNative> listaCopiaInformativa = this.jdbcTemplate.query(sql, new returnlistaCopiaInformativa());
		return listaCopiaInformativa;
	}
	
	private static final class returnlistaCopiaInformativa implements RowMapper<ListasNative> {

		@Override
		public ListasNative mapRow(ResultSet rs, int rowNum) throws SQLException {
			ListasNative ci = new ListasNative();
			try {
				ci.setIdDocumento(rs.getString("nid_documento"));
				ci.setNumDoc(rs.getString("vnumero_documento"));
				ci.setDescripTipoDoc(rs.getString("vdescripcion_doc"));
				ci.setDescripClasificacion(rs.getString("vdescripcion_clasificacion"));
				ci.setDescripEstado(rs.getString("vdescripcion_estado"));
				ci.setComentario(rs.getString("comentario"));
				ci.setfDocumento(rs.getString("dfecha_documento"));
				ci.setfRegDocumento(rs.getString("dfecha_rec_documento"));
				ci.setPrioridad(rs.getString("PRIORIDAD"));
				ci.setUnidadResponsable(rs.getString("vabrev_unidad"));
				ci.setDecreto(rs.getString("descripcion"));

			} catch (Exception ex) {
				System.out.println("ERROR! QueryNative :" + ci.toString());
				System.out.println("ERROR! QueryNative " + ci);
				ex.printStackTrace();
			}
			return ci;
		}
		
	}

}
