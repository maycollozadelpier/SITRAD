package detel.copere.ejercito.mil.pe.models.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import detel.copere.ejercito.mil.pe.models.dao.IBrigadaDao;
import detel.copere.ejercito.mil.pe.models.entity.Brigada;
import detel.copere.ejercito.mil.pe.models.service.IBrigadaService;

@Service
public class BrigadaServiceImpl implements IBrigadaService {
	
	@Autowired
	private IBrigadaDao repo;
	
	@Override
	@Transactional(readOnly = true)
	public List<Brigada> listarporNucleo(String nucleoCodigo) {		
		return repo.findBynucleoCodigo(nucleoCodigo);
	}
	
	

}
