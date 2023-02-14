package detel.copere.ejercito.mil.pe.models.service.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import detel.copere.ejercito.mil.pe.models.dao.IUnidadDao;

import detel.copere.ejercito.mil.pe.models.entity.Unidad;
import detel.copere.ejercito.mil.pe.models.service.IUnidadService;

@Service
public class UnidadServiceimpl implements IUnidadService {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Autowired
	private IUnidadDao repo;

	@Override
	@Transactional(readOnly = true)
	public List<Unidad> listarunidades( String brigadaCodigo) {
		return repo.findBybrigadaCodigo( brigadaCodigo);
	}

	@Override
	public List<Unidad> listaDependencias(String nucleoCodigo, String brigadaCodigo) {
		// TODO Auto-generated method stub
		return repo.findByNucleoCodigoAndBrigadaCodigo(nucleoCodigo, brigadaCodigo);
	}


	@Override
	public List<Unidad> listarunidadescopiainf() {
		String sql = "SELECT * FROM SITRAD.SITRAD_UNIDAD WHERE vcod_nucleo = '20' \r\n"
				+ "AND vcod_actividad not in ('1050','1055','1065','1060')order BY VABREV_UNIDAD";
		List<Unidad> listarunidadcopiainf = this.jdbcTemplate.query(sql, new listarunidadcopiainformativa());
		return listarunidadcopiainf;
	}
	
	private static final class listarunidadcopiainformativa implements RowMapper<Unidad> {

		@Override
		public Unidad mapRow(ResultSet rs, int rowNum) throws SQLException {
			Unidad e = new Unidad();

			try {
				
				e.setUnidadCodigo(rs.getString("VCOD_UNIDAD"));
				e.setUnidadAbreviatura(rs.getString("VABREV_UNIDAD"));
			

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return e;

		}
	}


}
