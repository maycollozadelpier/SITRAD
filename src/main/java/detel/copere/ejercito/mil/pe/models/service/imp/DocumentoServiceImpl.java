package detel.copere.ejercito.mil.pe.models.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import detel.copere.ejercito.mil.pe.models.dao.IDocumentoDao;
import detel.copere.ejercito.mil.pe.models.entity.DocRegistrado;
import detel.copere.ejercito.mil.pe.models.entity.Documento;
import detel.copere.ejercito.mil.pe.models.entity.TipoEstado;
import detel.copere.ejercito.mil.pe.models.service.IDocumentoService;

@Service
public class DocumentoServiceImpl implements IDocumentoService {
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private IDocumentoDao DocumentoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Documento> findAll() {
		return (List<Documento>) DocumentoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Documento> findAll(Pageable pageable) {
		return DocumentoDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Documento Documento) {
		DocumentoDao.save(Documento);
	}

	@Override
	@Transactional(readOnly = true)
	public Documento buscarPorId(Long documentoId) {
		return DocumentoDao.findById(documentoId).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long DocumentoCodigo) {
		DocumentoDao.deleteById(DocumentoCodigo);
	}

	@Override
	public List<Documento> listaRecibidos(Integer estadoRegistro) {
		// TODO Auto-generated method stub
		return DocumentoDao.findByestadoRegistro(estadoRegistro);
	}

	@Override
	public Documento listaxID(Long documentoId) {
		// TODO Auto-generated method stub
		return DocumentoDao.findBydocumentoId(documentoId);
	}

	@Transactional
	@Override
	public String DocRegistroIns(DocRegistrado docregistro) {
		String sql = "insert into SITRAD_DOCUMENTO_REGISTRADO values (?,?,?,?')";
		this.jdbcTemplate.execute(sql.toString());
		return null;
	}

	@Transactional
	@Override
	public String updatetipoestado(Long iddoc, String estadodoc) {
		String sql = "UPDATE  sitrad.sitrad_documento SET Vid_TIPO_ESTADO='"+estadodoc+"'  WHERE NID_DOCUMENTO = '"	+ iddoc + "'";
		this.jdbcTemplate.execute(sql.toString());
		return null;

//		StringBuilder sb = new StringBuilder();
//		sb.append("UPDATE  sitrad.sitrad_documento SET ");
//		sb.append("VID_TIPO_ESTADO='").append(estadodoc).append("' WHERE NID_DOCUMENTO ='").append(String.valueOf(iddoc)).append(" '");

//		System.out.println("Cambiar clave usuario sistema " + sb.toString());
//		this.jdbcTemplate.execute(sb.toString());
//		
		//String sql = "UPDATE  sitrad.sitrad_usuario SET VPASSWORD_USUARIO='"+password+"'  WHERE VUSERNAME_USUARIO ='"+username+"'";
	

	}

//	@Override
//	public Documento buscarDocReferencia(String documentoReferencia) {
//		return DocumentoDao.findBydocumentoReferencia(documentoReferencia);
//	}

}
