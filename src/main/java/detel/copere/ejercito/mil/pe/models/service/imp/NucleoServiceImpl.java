package detel.copere.ejercito.mil.pe.models.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import detel.copere.ejercito.mil.pe.models.dao.INucleoDao;
import detel.copere.ejercito.mil.pe.models.entity.Nucleo;
import detel.copere.ejercito.mil.pe.models.service.INucleoService;

@Service
public class NucleoServiceImpl implements INucleoService {

	@Autowired
	private INucleoDao nucleoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Nucleo> findAll() {
		return (List<Nucleo>) nucleoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Nucleo> findAll(Pageable pageable) {
		return nucleoDao.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Nucleo nucleo) {
		nucleoDao.save(nucleo);
	}

	@Override
	@Transactional(readOnly = true)
	public Nucleo findById(String nucleoCodigo) {
		return nucleoDao.findById(nucleoCodigo).orElse(null);
	}

	@Override
	@Transactional
	public void delete(String nucleoCodigo) {
		nucleoDao.deleteById(nucleoCodigo);
	}

}
