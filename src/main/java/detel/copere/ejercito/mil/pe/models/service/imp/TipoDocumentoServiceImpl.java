package detel.copere.ejercito.mil.pe.models.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import detel.copere.ejercito.mil.pe.models.dao.ITipoDocumentoDao;
import detel.copere.ejercito.mil.pe.models.entity.TipoDocumento;
import detel.copere.ejercito.mil.pe.models.service.ITipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements ITipoDocumentoService {

	@Autowired
	private ITipoDocumentoDao TipoDocumentoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoDocumento> findAll() {
		return (List<TipoDocumento>) TipoDocumentoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<TipoDocumento> findAll(Pageable pageable) {
		return TipoDocumentoDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(TipoDocumento TipoDocumento) {
		TipoDocumentoDao.save(TipoDocumento);
	}

	@Override
	@Transactional(readOnly = true)
	public TipoDocumento findById(String TipoDocumentoCodigo) {
		return TipoDocumentoDao.findById(TipoDocumentoCodigo).orElse(null);
	}

	@Override
	@Transactional
	public void delete(String TipoDocumentoCodigo) {
		TipoDocumentoDao.deleteById(TipoDocumentoCodigo);
	}

}
