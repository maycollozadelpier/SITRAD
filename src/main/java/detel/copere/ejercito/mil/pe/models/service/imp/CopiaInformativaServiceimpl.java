package detel.copere.ejercito.mil.pe.models.service.imp;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import detel.copere.ejercito.mil.pe.models.dao.ICopiaInformativaDao;
import detel.copere.ejercito.mil.pe.models.entity.CopiaInformativa;
import detel.copere.ejercito.mil.pe.models.service.ICopiaInformativaService;

@Service
public class CopiaInformativaServiceimpl implements ICopiaInformativaService {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Autowired
	private ICopiaInformativaDao distribucionDao;

	@Override
	@Transactional
	public void save(CopiaInformativa CopiaInformativa) {
		// TODO Auto-generated method stub
		distribucionDao.save(CopiaInformativa);
	}
	@Transactional
	@Override
	public String estadocopiainformativa(String iddoc, String idcopinf, String estdado) throws Exception {
		String sql = "UPDATE  sitrad.sitrad_copia_informativa SET VCOD_TIPO_ESTADO='"+estdado+"'  WHERE NID_DOCUMENTO = '"+iddoc+"' and COD_COPIA_INFORMATIVA ='"+idcopinf+"'";
		this.jdbcTemplate.execute(sql.toString());
		return null;
	}

}
