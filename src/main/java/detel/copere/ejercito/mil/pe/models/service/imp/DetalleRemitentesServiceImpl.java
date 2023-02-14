package detel.copere.ejercito.mil.pe.models.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import detel.copere.ejercito.mil.pe.models.dao.IDetalleRemitentesDao;
import detel.copere.ejercito.mil.pe.models.service.IDetalleRemitentesService;

@Service
public class DetalleRemitentesServiceImpl implements IDetalleRemitentesService{

	@Autowired
	private IDetalleRemitentesDao detalleRemitentes;

	@Override
	public List<detel.copere.ejercito.mil.pe.models.entity.DetalleRemitentes> DetalleRemitentes() {
		// TODO Auto-generated method stub
		return detalleRemitentes.findAll();
	}
}
