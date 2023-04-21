package Presentacion.FactoriaPresentacion;

import Presentacion.VistaGeneral;


public abstract class FactoriaVistas {
	
	private static FactoriaVistas factoriaVistas = null;


	
	public static FactoriaVistas obtenerInstancia() {
		if (factoriaVistas == null)
			factoriaVistas = new FactoriaVistasImp();
		return factoriaVistas;
	}
	
	public abstract FactoriaVistaGeneralAux getVistaGeneralAux();

	public abstract VistaGeneral getVistaGeneral();

	public abstract FactoriaVistaActividad getVistaActividad();

	public abstract FactoriaVistaPersonal getVistaPersonal();

	public abstract FactoriaVistaFactura getVistaFactura();

	public abstract FactoriaVistaMaterial getVistaMaterial();

	public abstract FactoriaVistaTurno getVistaTurno();

}