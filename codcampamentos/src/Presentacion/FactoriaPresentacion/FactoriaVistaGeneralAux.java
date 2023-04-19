package Presentacion.FactoriaPresentacion;

import Presentacion.ConfirmDialog;
import Presentacion.ConfirmDialogMostrarUna;
import Presentacion.FailureDialog;
import Presentacion.VistaGeneral;

public interface FactoriaVistaGeneralAux {
	
	public abstract VistaGeneral getVistaGeneral();

	public abstract FailureDialog getFailureDialg();

	public abstract ConfirmDialog getConfirmDialg();

	public abstract ConfirmDialogMostrarUna getConfirmDialogMostrarUna();

}
