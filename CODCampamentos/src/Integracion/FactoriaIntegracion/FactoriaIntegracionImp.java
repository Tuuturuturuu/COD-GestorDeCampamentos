
package Integracion.FactoriaIntegracion;

import Negocio.Actividad.TActividadMaterial;
import Integracion.Turno.DAOTurno;
import Integracion.Turno.DAOTurnoImp;
import Integracion.Material.DAOMaterial;
import Integracion.Material.DAOMaterialImp;
import Integracion.Personal.DAOPersonal;
import Integracion.Personal.DAOPersonalImp;
import Integracion.Actividad.DAOActividad;
import Integracion.Actividad.DAOActividadImp;
import Integracion.Actividad.DAOActividadMaterial;
import Integracion.Actividad.DAOActividadMaterialImp;
import Integracion.Factura.DAOFactura;
import Integracion.Factura.DAOFacturaImp;
import Integracion.Factura.DAOGenera;
import Integracion.Factura.DAOGeneraImp;


public class FactoriaIntegracionImp extends FactoriaIntegracion {
	
	public DAOActividadMaterial generaDAOActividadMaterial() {
		return new DAOActividadMaterialImp();
	}

	public DAOTurno generaDAOTurno() {
		return new DAOTurnoImp();

	}
	
	public DAOPersonal generaDAOPersonal() {

		return new DAOPersonalImp();

	}

	public DAOMaterial generaDAOMaterial() {

		return new DAOMaterialImp();
	}


	public DAOActividad generaDAOActividad() {

		return new DAOActividadImp();

	}

	public DAOFactura generaDAOFactura() {
		return new DAOFacturaImp();

	}

	public DAOGenera generaDAOGenera() {
		return new DAOGeneraImp();
	}
}