package detel.copere.ejercito.mil.pe.models.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import detel.copere.ejercito.mil.pe.models.dao.IDatosGeneralesDao;
import detel.copere.ejercito.mil.pe.models.entity.DatosGenerales;
import detel.copere.ejercito.mil.pe.models.entity.Documento;

@Repository
public class DatosGeneralesDaoImpl implements IDatosGeneralesDao{

	private static final Logger LOG = LoggerFactory.getLogger(DatosGeneralesDaoImpl.class);
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public DatosGenerales getDatosGenerales(String username) {
		DatosGenerales datGrls = null;
		String query = "select * from SITRAD_datos_grls\r\n" + 
				"where vusername_usuario = '" + username + "'";

		List<DatosGenerales> listaFoto = this.jdbcTemplate.query(query, new ListaDatosGrls());
		if (listaFoto != null && listaFoto.size() > 0) {
			datGrls = listaFoto.get(0);
		}
		return datGrls;
	}
	
	private static final class ListaDatosGrls implements RowMapper<DatosGenerales> {
		public DatosGenerales mapRow(ResultSet rs, int rowNum) throws SQLException {
			DatosGenerales e = new DatosGenerales();
			try {
				e.setDni(rs.getString("VDNI_PERSONA"));
				e.setUsername(rs.getString("VUSERNAME_USUARIO"));
				e.setNombre(rs.getString("NOMBRE"));
				e.setFoto(rs.getString("VFOTO_PERSONA"));
				e.setAcronimoNucleo(rs.getString("VABREV_NUCLEO"));
				e.setAcronimoGGUU(rs.getString("VABREV_ACTIVIDAD"));
				e.setAcronimoUnidad(rs.getString("VABREV_UNIDAD"));
				e.setAcronimoGrado(rs.getString("VGRADOS_DESCOR"));
				e.setAcronimoArma(rs.getString("VARMAS_DESCOR"));
				e.setAcronimoGradoD(rs.getString("VGRADOS_DESLAR"));
				e.setAcronimoArmaD(rs.getString("VARMAS_DESLAR"));
				e.setEmail(rs.getString("VEMAIL_PERSONA"));
				e.setIdPersona(rs.getLong("NID_PERSONA"));
				e.setPerfil(rs.getString("VDESCRIPCION_PERFIL"));
				e.setEstado(rs.getString("NESTADO_REGISTRO"));
				
			} catch (Exception ex) {
				LOG.error("ERROR! DatosGenerales", e.toString());
				System.out.println("ERROR! DatosGenerales" + e);
				ex.printStackTrace();
			}
			return e;
		}
	}

	
	private static final class docreferencia implements RowMapper<Documento> {
		public Documento mapRow(ResultSet rs, int rowNum) throws SQLException {
			Documento e = new Documento();
			try {
				e.setDocumentoReferencia(rs.getString("VREF_DOCUMENTO"));
				e.setDocumentoId(rs.getLong("NID_DOCUMENTO"));
				e.setNumeroDocumento(rs.getString("VNUMERO_DOCUMENTO"));
				
			} catch (Exception ex) {
				LOG.error("ERROR! documento referencia", e.toString());
				System.out.println("ERROR! documento referencia" + e);
				ex.printStackTrace();
			}
			return e;
		}
	}
	
	@Override
	public List<DatosGenerales> getListaUsuarios() {
		// TODO Auto-generated method stub
		
		DatosGenerales datGrls = null;
		String query = "select * from SITRAD_datos_grls";

		List<DatosGenerales> listaUsuarios = this.jdbcTemplate.query(query, new ListaDatosGrls());
		
		return listaUsuarios;
	}


	@Override
	public Documento getDocReferencia(String docreferencia) {
		Documento doc = null;
		String query = "select * from SITRAD_documento\r\n" + 
				"where vnumero_documento = '" + docreferencia + "'";

		List<Documento> listadoc = this.jdbcTemplate.query(query, new docreferencia());
		if (listadoc != null && listadoc.size() > 0) {
			doc = listadoc.get(0);
		}
		return doc;
	}
}
