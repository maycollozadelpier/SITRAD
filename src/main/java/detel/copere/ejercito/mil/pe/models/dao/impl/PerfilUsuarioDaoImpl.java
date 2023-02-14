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

import detel.copere.ejercito.mil.pe.models.dao.IPerfilUsuario;
import detel.copere.ejercito.mil.pe.models.entity.Perfil;
import detel.copere.ejercito.mil.pe.models.entity.Persona;

@Repository
public class PerfilUsuarioDaoImpl implements IPerfilUsuario {
	private static final Logger LOG = LoggerFactory.getLogger(DatosGeneralesDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Perfil> getPerfil() {
		String query = "select * from SITRAD_PERFIL";
		List<Perfil> listaPerfil = this.jdbcTemplate.query(query, new mapper());

		return listaPerfil;
	}

	private static final class mapper implements RowMapper<Perfil> {
		public Perfil mapRow(ResultSet rs, int rowNum) throws SQLException {
			Perfil e = new Perfil();
			try {
				e.setNombre(rs.getString("VNOMBRE_PERFIL"));
				e.setPerfilId(rs.getLong("NID_PERFIL"));

			} catch (Exception ex) {
				LOG.error("ERROR! DatosGenerales", e.toString());
				System.out.println("ERROR! DatosGenerales" + e);
				ex.printStackTrace();
			}
			return e;
		}
	}

	@Override
	public Long idpersona() {
		String sql = "SELECT MAX(NID_PERSONA) IDpersona  FROM SITRAD_PERSONA";
		Long codigo = null;
		List<Persona> lista = this.jdbcTemplate.query(sql, new rowMapperidpersona());
		for (Persona p : lista) {
			codigo = p.getPersonaId();
		}

		return codigo;
	}

	private static final class rowMapperidpersona implements RowMapper<Persona> {

		@Override
		public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
			Persona e = new Persona();
			try {
				e.setPersonaId(rs.getLong("IDpersona"));

			} catch (Exception ex) {
				LOG.error("ERROR! DatosGenerales", e.toString());
				System.out.println("ERROR! DatosGenerales" + e);
				ex.printStackTrace();
			}
			return e;
		}

	}

	@Override
	public void actualizarFoto(Long personaId, String foto) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE SITRAD_PERSONA SET ");
		sb.append("VFOTO_PERSONA='").append(foto).append("' WHERE NID_PERSONA =").append(personaId);
		this.jdbcTemplate.execute(sb.toString());
	}

}
