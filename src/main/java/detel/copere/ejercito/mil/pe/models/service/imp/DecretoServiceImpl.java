package detel.copere.ejercito.mil.pe.models.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import detel.copere.ejercito.mil.pe.models.dao.IDecretoDao;
import detel.copere.ejercito.mil.pe.models.entity.Decreto;
import detel.copere.ejercito.mil.pe.models.service.IDecretoService;

@Service
public class DecretoServiceImpl implements IDecretoService {

	@Autowired
	private IDecretoDao DecretoDao;


	@Override
	public List<Decreto> listaCopiaInformativa(String idEstado, String idUnidad) {
		// TODO Auto-generated method stub
		return DecretoDao.findByIdEstadoAndIdUnidad(idEstado, idUnidad);
	}

}
