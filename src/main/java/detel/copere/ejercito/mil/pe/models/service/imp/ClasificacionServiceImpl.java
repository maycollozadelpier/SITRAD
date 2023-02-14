package detel.copere.ejercito.mil.pe.models.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import detel.copere.ejercito.mil.pe.models.dao.IClasificacionDao;
import detel.copere.ejercito.mil.pe.models.entity.Clasificacion;
import detel.copere.ejercito.mil.pe.models.service.IClasificacionService;

@Service
public class ClasificacionServiceImpl implements IClasificacionService {

	@Autowired
	private IClasificacionDao ClasificacionDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Clasificacion> findAll() {
		return (List<Clasificacion>) ClasificacionDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Clasificacion> findAll(Pageable pageable) {
		return ClasificacionDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Clasificacion Clasificacion) {
		ClasificacionDao.save(Clasificacion);
	}

	@Override
	@Transactional(readOnly = true)
	public Clasificacion findById(String ClasificacionCodigo) {
		return ClasificacionDao.findById(ClasificacionCodigo).orElse(null);
	}

	@Override
	@Transactional
	public void delete(String ClasificacionCodigo) {
		ClasificacionDao.deleteById(ClasificacionCodigo);
	}

}
