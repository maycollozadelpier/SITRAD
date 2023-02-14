package detel.copere.ejercito.mil.pe.models.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import detel.copere.ejercito.mil.pe.models.dao.ITotalTipoDocumentoDao;
import detel.copere.ejercito.mil.pe.models.entity.TotalTipoDocumento;
import detel.copere.ejercito.mil.pe.models.service.ITotalTipoDocumentoService;

@Service
public class TotalTipoDocumentoServiceImp implements ITotalTipoDocumentoService{

	@Autowired
	private ITotalTipoDocumentoDao totalTipoDocumentoDao;
	@Override
	public List<TotalTipoDocumento> totalTipoDoc(String codUnidad) {
		// TODO Auto-generated method stub
		return totalTipoDocumentoDao.findByCodUnidad(codUnidad);
	}

}
