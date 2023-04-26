package Presentacion.FactoriaPresentacion;

import java.util.Set;

import Negocio.Factura.TFactura;
import Presentacion.Factura.VistaGeneralFactura;
import Presentacion.Factura.VAbrirFactura.VAbrirFactura;
import Presentacion.Factura.VAniadirActividadAFactura.VAniadirActividadAFactura;
import Presentacion.Factura.VCerrarFactura.VCerrarFactura;
import Presentacion.Factura.VDevolverUnaActividadAFactura.VDevolverUnaActividadAFactura;
import Presentacion.Factura.VMostrarFactura.VMostrarFactura;
import Presentacion.Factura.VMostrarFacturaPorActividad.VMostrarFacturaPorActividad;
import Presentacion.Factura.VMostrarTodasFacturas.VMostrarTodasFacturas;
import Presentacion.Factura.VQuitarActividadAFactura.VQuitarActividadAFactura;


public interface FactoriaVistaFactura {
	public VAbrirFactura getVista_AbrirFactura();

	public VCerrarFactura getVista_CerrarFactura();

	public VAniadirActividadAFactura getVista_AniadirActividadFactura();

	public VQuitarActividadAFactura getVista_QuitarActividadFactura();

	public VMostrarTodasFacturas getVista_MostrarTodasFacturas(Set<TFactura> listaFacturas);
	
	public VMostrarFactura getVista_MostrarUnaFactura();
	
	public VMostrarFacturaPorActividad getVista_MostrarFacturaPorActividad();
	
	public VDevolverUnaActividadAFactura getVista_DevolverUnaActividadAFactura();

	public VistaGeneralFactura getVista_VistaFacturaGeneral();
}
