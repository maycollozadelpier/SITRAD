package detel.copere.ejercito.mil.pe.models.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import detel.copere.ejercito.mil.pe.models.dao.IComentarioDocumentoDao;
import detel.copere.ejercito.mil.pe.models.entity.ComentarioDocumento;
import detel.copere.ejercito.mil.pe.models.service.IComentarioDocumentoService;

@Service
public class ComentarioDocumentoServiceimpl implements IComentarioDocumentoService {
	@Autowired
	private IComentarioDocumentoDao comentarioDocuemntoDao;

	@Override
	@Transactional
	public void save(ComentarioDocumento ComentarioDocumento) {
		// TODO Auto-generated method stub
		comentarioDocuemntoDao.save(ComentarioDocumento);
	}

}
