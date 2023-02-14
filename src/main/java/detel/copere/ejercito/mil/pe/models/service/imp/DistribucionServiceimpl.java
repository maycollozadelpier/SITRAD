package detel.copere.ejercito.mil.pe.models.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import detel.copere.ejercito.mil.pe.models.dao.IDistribucionDao;
import detel.copere.ejercito.mil.pe.models.entity.Distribucion;
import detel.copere.ejercito.mil.pe.models.service.IDistribucionService;

@Service
public class DistribucionServiceimpl implements IDistribucionService {
	@Autowired
	private IDistribucionDao distribucionDao;

	@Override
	public List<Distribucion> findAll() {
		// TODO Auto-generated method stub
		return distribucionDao.findAll();
	}
}
