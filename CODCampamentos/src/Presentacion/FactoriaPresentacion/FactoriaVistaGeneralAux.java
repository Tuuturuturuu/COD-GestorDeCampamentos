package Presentacion.FactoriaPresentacion;

import Negocio.Factura.TCarrito;
import Presentacion.ConfirmDialog;
import Presentacion.ConfirmDialogActivar;
import Presentacion.ConfirmDialogMostrarFactura;
import Presentacion.ConfirmDialogMostrarUna;
import Presentacion.FailureDialog;
import Presentacion.FailureDialogFactura;
import Presentacion.VistaGeneral;

public interface FactoriaVistaGeneralAux {

	public abstract VistaGeneral getVistaGeneral();

	public abstract FailureDialog getFailureDialg();

	public abstract FailureDialogFactura getFailureDialgFactura(TCarrito tCarrito);

	public abstract ConfirmDialog getConfirmDialg();

	public abstract ConfirmDialogActivar getConfirmDialogActivar();

	public abstract ConfirmDialogMostrarUna getConfirmDialogMostrarUna();

	public abstract ConfirmDialogMostrarFactura getConfirmDialogMostrarFactura();

}
