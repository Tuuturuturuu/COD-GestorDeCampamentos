package Presentacion.FactoriaPresentacion;

import Presentacion.ConfirmDialog;
import Presentacion.ConfirmDialogActivar;
import Presentacion.ConfirmDialogMostrarUna;
import Presentacion.FailureDialog;
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

}
