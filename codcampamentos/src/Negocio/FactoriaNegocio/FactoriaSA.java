
package Negocio.FactoriaNegocio;

import Negocio.Turno.SATurno;
import Negocio.Material.SAMaterial;
import Negocio.Personal.SAPersonal;
import Negocio.Actividad.SAActividad;
import Negocio.Factura.SAFactura;


public abstract class FactoriaSA {

	private static FactoriaSA instancia;

	public static FactoriaSA obtenerInstancia() {
		if (instancia == null)
			instancia = new FactoriaSAImp();
		return instancia;
	}
	
	public abstract SATurno generarSATurno();

	public abstract SAPersonal generarSAPersonal();

	public abstract SAMaterial generarSAMaterial();

	public abstract SAActividad generarSAActividad();

	public abstract SAFactura generarSAFactura();
}