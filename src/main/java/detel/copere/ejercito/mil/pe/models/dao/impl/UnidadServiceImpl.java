package detel.copere.ejercito.mil.pe.models.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import detel.copere.ejercito.mil.pe.models.entity.Unidad;
import detel.copere.ejercito.mil.pe.models.service.UnidadService;

@Repository
public class UnidadServiceImpl implements UnidadService{
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Unidad> listarpcquinceuunidad(String listarunidad) {

		String sql = "SELECT * FROM SITRAD.sitrad_unidad WHERE vcod_actividad = '"+listarunidad+"'\r\n"
				+ "and vcod_unidad not in ('A10102',\r\n"
				+ "'A10104',\r\n"
				+ "'A10105',\r\n"
				+ "'A10106',\r\n"
				+ "'A10107',\r\n"
				+ "'A10108',\r\n"
				+ "'A10109',\r\n"
				+ "'A10110',\r\n"
				+ "'A10111',\r\n"
				+ "'A10112',\r\n"
				+ "'A10113',\r\n"
				+ "'A10114',\r\n"
				+ "'A10115',\r\n"
				+ "'A10116',\r\n"
				+ "'A10117',\r\n"
				+ "'A10118',\r\n"
				+ "'A10119',\r\n"
				+ "'A10120',\r\n"
				+ "'A10122',\r\n"
				+ "'A10103')\r\n"
				+ "order by vcod_unidad asc";
		List<Unidad> listarpcquiceuni = this.jdbcTemplate.query(sql, new retornarpcquincunidad());
		return listarpcquiceuni;
	}

	private static final class retornarpcquincunidad implements RowMapper<Unidad> {

		@Override
		public Unidad mapRow(ResultSet rs, int rowNum) throws SQLException {
			Unidad e = new Unidad();

			try {
				
				e.setEstadoRegistro(rs.getInt("NESTADO_REGISTRO"));
				e.setNucleoCodigo(rs.getString("VCOD_NUCLEO"));

				e.setBrigadaCodigo(rs.getString("VCOD_ACTIVIDAD"));
				e.setUnidadAbreviatura(rs.getString("VABREV_UNIDAD"));

				e.setUnidadCodigo(rs.getString("VCOD_UNIDAD"));
				e.setUnidadDescripcion(rs.getString("VDESCRIPCION_UNIDAD"));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return e;

		}
	}

}
