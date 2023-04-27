package Negocio.FactoriaNegocio;

import Negocio.Actividad.SAActividad;
import Negocio.Actividad.SAActividadImp;
import Negocio.Factura.SAFactura;
import Negocio.Factura.SAFacturaImp;
import Negocio.Material.SAMaterial;
import Negocio.Material.SAMaterialImp;
import Negocio.Personal.SAPersonal;
import Negocio.Personal.SAPersonalImp;
import Negocio.Turno.SATurno;
import Negocio.Turno.SATurnoImp;

public class FactoriaSAImp extends FactoriaSA {

	public SATurno generarSATurno() {
		return new SATurnoImp();
	}

	public SAPersonal generarSAPersonal() {
		return new SAPersonalImp();
	}

	public SAMaterial generarSAMaterial() {
		return new SAMaterialImp();
	}

	public SAActividad generarSAActividad() {
		return new SAActividadImp();
	}

	public SAFactura generarSAFactura() {
		return new SAFacturaImp();
	}
}