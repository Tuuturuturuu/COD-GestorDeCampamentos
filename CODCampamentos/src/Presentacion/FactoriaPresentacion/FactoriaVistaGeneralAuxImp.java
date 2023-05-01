package Presentacion.FactoriaPresentacion;

import Negocio.Factura.TCarrito;
import Presentacion.ConfirmDialog;
import Presentacion.ConfirmDialogActivar;
import Presentacion.ConfirmDialogMostrarFactura;
import Presentacion.ConfirmDialogMostrarUna;
import Presentacion.FailureDialog;
import Presentacion.FailureDialogFactura;
import Presentacion.VistaGeneral;

public class FactoriaVistaGeneralAuxImp implements FactoriaVistaGeneralAux {

	@Override
	public VistaGeneral getVistaGeneral() {
		return new VistaGeneral();
	}

	@Override
	public FailureDialog getFailureDialg() {
		return new FailureDialog();
	}

	@Override
	public ConfirmDialog getConfirmDialg() {
		return new ConfirmDialog();
	}

	@Override
	public ConfirmDialogMostrarUna getConfirmDialogMostrarUna() {
		return new ConfirmDialogMostrarUna();
	}

	@Override
	public ConfirmDialogActivar getConfirmDialogActivar() {
		// TODO Auto-generated method stub
		return new ConfirmDialogActivar();
	}

	@Override
	public FailureDialogFactura getFailureDialgFactura(TCarrito tCarrito) {
		// TODO Auto-generated method stub
		return new FailureDialogFactura(tCarrito);
	}

	@Override
	public ConfirmDialogMostrarFactura getConfirmDialogMostrarFactura() {
		// TODO Auto-generated method stub
		return new ConfirmDialogMostrarFactura();
	}

}
