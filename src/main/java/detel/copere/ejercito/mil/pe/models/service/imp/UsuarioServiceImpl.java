package detel.copere.ejercito.mil.pe.models.service.imp;

import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import detel.copere.ejercito.mil.pe.models.dao.IUsuarioDao;
import detel.copere.ejercito.mil.pe.models.entity.Usuario;
import detel.copere.ejercito.mil.pe.models.service.IUsuarioService;
@Service
public class UsuarioServiceImpl implements IUsuarioService{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	public void guardar(Usuario usuario) {
		usuarioDao.save(usuario);		
	}

	@Override
	public void eliminar(Long usuarioId) {
		usuarioDao.deleteById(usuarioId);
	}

	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return usuarioDao.findAll();
	}

	@Override
	public Usuario buscarPorUsername(String username) {
		return usuarioDao.findByUsername(username);
	}
	@Transactional
	@Override
	public String cambiarclavesitrad(String username, String password) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE  sitrad.sitrad_usuario SET ");
		sb.append("VPASSWORD_USUARIO='").append(password).append("' WHERE VUSERNAME_USUARIO ='").append(username).append("'");
		System.out.println("Cambiar clave usuario sistema " + sb.toString());
		this.jdbcTemplate.execute(sb.toString());
		//String sql = "UPDATE  sitrad.sitrad_usuario SET VPASSWORD_USUARIO='"+password+"'  WHERE VUSERNAME_USUARIO ='"+username+"'";
		return null;
	}

}
