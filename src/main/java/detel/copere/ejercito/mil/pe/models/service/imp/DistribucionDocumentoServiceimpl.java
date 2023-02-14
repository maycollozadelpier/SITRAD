package detel.copere.ejercito.mil.pe.models.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import detel.copere.ejercito.mil.pe.models.dao.IDistribucionDocumentoDao;
import detel.copere.ejercito.mil.pe.models.entity.DistribucionDocumento;
import detel.copere.ejercito.mil.pe.models.service.IDistribucionDocumentosService;

@Service
public class DistribucionDocumentoServiceimpl implements IDistribucionDocumentosService {
	@Autowired
	private IDistribucionDocumentoDao distribucionDocumentoDao;

	@Override
	@Transactional
	public void save(DistribucionDocumento DistribucionDocumento) {
		// TODO Auto-generated method stub
		distribucionDocumentoDao.save(DistribucionDocumento);
	}

}
