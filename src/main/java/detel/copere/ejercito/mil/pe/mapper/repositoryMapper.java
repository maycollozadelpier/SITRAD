package detel.copere.ejercito.mil.pe.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import detel.copere.ejercito.mil.pe.models.entity.Documents;


public class repositoryMapper implements RowMapper<Documents> {

	@Override
	public Documents mapRow(ResultSet rs, int rowNum) throws SQLException {
		Documents e = new Documents();
		
		try {
			
			
			e.setDocumentoId(rs.getString("NID_DOCUMENTO"));
			e.setUnidadResponsable(rs.getString("UNIDESTINO"));
			
			e.setAcronimoTipoDoc(rs.getString("TIPODOC"));
			 e.setNumDoc(rs.getString("VNUMERO_DOCUMENTO"));
			//e.setFechaDoc(rs.getString("DFECHA_DOCUMENTO"));
			e.setFechaRecepcionDoc(rs.getString("DFECHA_REC_DOCUMENTO"));
		   
		e.setAcronimoClasificacion(rs.getString("VREF_DOCUMENTO"));
		e.setAsunto(rs.getString("VASUNTO_DOCUMENTO"));
			
			
	
			
//			e.setRespuesta(rs.getString("TIPODOC"));
//			e.setDocumentoId(rs.getLong("NID_DOCUMENTO"));
//			e.setAsunto(rs.getString("VASUNTO_DOCUMENTO"));
			
//			e.setDocumentoReferencia(rs.getString("VREF_DOCUMENTO"));
//			e.setFechaDocumento(rs.getDate("DFECHA_DOCUMENTO"));
//			e.setFechaRecepcion(rs.getDate("DFECHA_REC_DOCUMENTO"));
//			e.setNumeroDocumento(rs.getString("VNUMERO_DOCUMENTO"));
//			e.setUnidadRemitente(rs.getString("VUNIDAD_CODIGO_REMIT"));
//			e.setUnidadregistro(rs.getString("UNIDAD_REGISTRO"));
//			e.setUnidadResponsable(rs.getString("UNIDESTINO"));
			
//
//			NID_DOCUMENTO
//			VANIO_DOCUMENTO
//			VNUMERO_DOCUMENTO
//			VTIPO_ORGANIZACION
//			VID_TIPO_DOC
//			VDESCRIPCION_DOC
//			NID_TIPO_CLASIFICACION
//			VDESCRIPCION_CLASIFICACION
//			VID_TIPO_ESTADO
//			VDESCRIPCION_ESTADO
//			VASUNTO_DOCUMENTO
//			VDESCRIPCION_DOCUMENTO
//			VREF_DOCUMENTO
//			NESTADO_REGISTRO
//			DFECHA_DOCUMENTO
//			DFECHA_REC_DOCUMENTO
//			VRESPUESTA_DOCUMENTO
//			VDOC_ARCHIVO
//			VNUCLEO_CODIGO_REMIT
//			NN_REMITE
//			VACTIVIDAD_CODIGO_REMIT
//			GGUU_REMITE
//			VUNIDAD_CODIGO_REMIT
//			UU_REMITE
//			VNUCLEO_CODIGO_RESP
//			NN_RESP
//			VACTIVIDAD_CODIGO_RESP
//			GGUU_RESP
//			VUNIDAD_CODIGO_RESP
//			UU_DESC_RESP
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}
}
