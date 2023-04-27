
package Integracion.FactoriaIntegracion;

import Negocio.Actividad.TActividadMaterial;
import Integracion.Turno.DAOTurno;
import Integracion.Personal.DAOPersonal;
import Integracion.Material.DAOMaterial;
import Integracion.Factura.DAOFactura;
import Integracion.Factura.DAOLineaFactura;
import Integracion.Actividad.DAOActividad;
import Integracion.Actividad.DAOActividadMaterial;;

public abstract class FactoriaIntegracion {

	private static FactoriaIntegracion instancia;

	public static FactoriaIntegracion obtenerInstancia() {
		if (instancia == null)
			instancia = new FactoriaIntegracionImp();
		return instancia;
	}

	
	public abstract DAOActividadMaterial generaDAOActividadMaterial();

	public abstract DAOTurno generaDAOTurno();

	public abstract DAOPersonal generaDAOPersonal();

	public abstract DAOMaterial generaDAOMaterial();

	public abstract DAOActividad generaDAOActividad();

	public abstract DAOFactura generaDAOFactura();

	public abstract DAOLineaFactura generaDAOLineaFactura();
}