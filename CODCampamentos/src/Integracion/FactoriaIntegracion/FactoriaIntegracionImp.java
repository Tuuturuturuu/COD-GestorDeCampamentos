
package Integracion.FactoriaIntegracion;

import Integracion.Actividad.DAOActividad;
import Integracion.Actividad.DAOActividadImp;
import Integracion.Actividad.DAOActividadMaterial;
import Integracion.Actividad.DAOActividadMaterialImp;
import Integracion.Factura.DAOFactura;
import Integracion.Factura.DAOFacturaImp;
import Integracion.Factura.DAOLineaFactura;
import Integracion.Factura.DAOLineaFacturaImp;
import Integracion.Material.DAOMaterial;
import Integracion.Material.DAOMaterialImp;
import Integracion.Personal.DAOPersonal;
import Integracion.Personal.DAOPersonalImp;
import Integracion.Turno.DAOTurno;
import Integracion.Turno.DAOTurnoImp;

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

	public DAOLineaFactura generaDAOLineaFactura() {
		return new DAOLineaFacturaImp();
	}
}