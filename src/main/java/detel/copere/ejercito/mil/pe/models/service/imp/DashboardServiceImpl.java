package detel.copere.ejercito.mil.pe.models.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import detel.copere.ejercito.mil.pe.models.dao.IDashboardDao;
import detel.copere.ejercito.mil.pe.models.entity.DetalleDependencia;
import detel.copere.ejercito.mil.pe.models.service.IDashboardService;

@Service
public class DashboardServiceImpl implements IDashboardService{

	@Autowired
	private IDashboardDao dashboardDao;

	@Override
	public List<DetalleDependencia> detalleXunidad(String codigoUnidad, String tipUnidad) {
		// TODO Auto-generated method stub
		return dashboardDao.findByCodigoUnidadAndTipUnidad(codigoUnidad, tipUnidad);
	}


//	@Override
//	public DetalleDependencia detalleXunidad(String codigoUnidad, String tipUnidad) {
//		// TODO Auto-generated method stub
//		return dashboardDao.findByCodigoUnidadAndTipUnidad(codigoUnidad, tipUnidad);
//	}



}
