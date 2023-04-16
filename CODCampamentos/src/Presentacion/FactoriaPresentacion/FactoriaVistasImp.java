
package Presentacion.FactoriaPresentacion;

import Presentacion.IGUI;
import Presentacion.VistaGeneral;


public class FactoriaVistasImp extends FactoriaVistas {
	
	public IGUI generarVistas(Integer idVista) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	@Override
	public FactoriaVistaGeneralAux getVistaGeneralAux() {
		return new FactoriaVistaGeneralAuxImp();
	}

	@Override
	public VistaGeneral getVistaGeneral() {
		return new VistaGeneral();
	}

	@Override
	public FactoriaVistaActividad getVistaActividad() {
		return new FactoriaVistaActividadImp();
	}

	@Override
	public FactoriaVistaPersonal getVistaPersonal() {
		return new FactoriaVistaPersonalImp();
	}

	@Override
	public FactoriaVistaFactura getVistaFactura() {
		return new FactoriaVistaFacturaImp();
	}

	@Override
	public FactoriaVistaMaterial getVistaMaterial() {
		return new FactoriaVistaMaterialImp();
	}

	@Override
	public FactoriaVistaTurno getVistaTurno() {
		return new FactoriaVistaTurnoImp();
	}
}