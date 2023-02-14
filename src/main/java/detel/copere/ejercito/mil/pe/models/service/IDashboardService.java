package detel.copere.ejercito.mil.pe.models.service;

import java.util.List;

import detel.copere.ejercito.mil.pe.models.entity.DetalleDependencia;

public interface IDashboardService {
	List<DetalleDependencia> detalleXunidad(String codigoUnidad, String tipUnidad);
//	DetalleDependencia detalleXCodigoUnidad(String codigoUnidad);
}
