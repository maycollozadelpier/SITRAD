package detel.copere.ejercito.mil.pe.models.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import detel.copere.ejercito.mil.pe.models.dao.IListaDependenciaDao;
import detel.copere.ejercito.mil.pe.models.entity.ListaDependencia;
import detel.copere.ejercito.mil.pe.models.service.IListaDependenciaService;

@Service
public class ListaDependenciaServiceImpl implements IListaDependenciaService{

	@Autowired
	private IListaDependenciaDao listaDependenciaDao;
	@Override
	public List<ListaDependencia> listaDependencias() {
		// TODO Auto-generated method stub
		return listaDependenciaDao.findAll();
	}

}
