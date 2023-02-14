package detel.copere.ejercito.mil.pe.models.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import detel.copere.ejercito.mil.pe.models.dao.ITotalTipoDocRemitidoDao;
import detel.copere.ejercito.mil.pe.models.entity.TotalTipoDocRemitido;
import detel.copere.ejercito.mil.pe.models.service.ITotalTipoDocRemitidoService;

@Service
public class TotalTipoDocRemitidoServiceImp implements ITotalTipoDocRemitidoService{

	@Autowired
	private ITotalTipoDocRemitidoDao totalTipoDocRemitidoDao;
	@Override
	public List<TotalTipoDocRemitido> totalTipoDocRemitido(String codUnidadRemi) {
		// TODO Auto-generated method stub
		return totalTipoDocRemitidoDao.findByCodUnidadRemi(codUnidadRemi);
	}

}
