package detel.copere.ejercito.mil.pe.models.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import detel.copere.ejercito.mil.pe.models.dao.IDetalleDependenciaDao;
import detel.copere.ejercito.mil.pe.models.entity.DetalleDependencia;
import detel.copere.ejercito.mil.pe.models.service.IDetalleDependenciaService;


	@Service
	public class DetalleDependenciaServiceImpl implements IDetalleDependenciaService {

	@Autowired
	private IDetalleDependenciaDao detalleDependenciaDao;

	@Override
	public List<DetalleDependencia> detalleDependencia( String tipUnidad) {
	
		return detalleDependenciaDao.findByTipUnidad(tipUnidad);
	}

}
