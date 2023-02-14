package detel.copere.ejercito.mil.pe.models.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import detel.copere.ejercito.mil.pe.models.dao.IDocRegistroDao;
import detel.copere.ejercito.mil.pe.models.entity.DocRegistrado;
import detel.copere.ejercito.mil.pe.models.service.IDocRegistradoService;

@Service
public class DocRegistroServiceImpl implements IDocRegistradoService{
	@Autowired
	private IDocRegistroDao dao;

	@Override
	@Transactional
	public void save(DocRegistrado docregistrado) {
		dao.save(docregistrado);
	}


}
