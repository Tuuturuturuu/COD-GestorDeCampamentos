package Presentacion.FactoriaPresentacion;

import java.util.Set;

import Negocio.Factura.TFactura;
import Presentacion.Factura.VistaGeneralFactura;
import Presentacion.Factura.VAbrirFactura.VAbrirFactura;
import Presentacion.Factura.VAniadirActividadAFactura.VAniadirActividadAFactura;
import Presentacion.Factura.VCerrarFactura.VCerrarFactura;
import Presentacion.Factura.VMostrarFactura.VMostrarFactura;
import Presentacion.Factura.VMostrarFacturaPorActividad.VMostrarFacturaPorActividad;
import Presentacion.Factura.VMostrarTodasFacturas.VMostrarTodasFacturas;
import Presentacion.Factura.VQuitarActividadAFactura.VQuitarActividadAFactura;


public interface FactoriaVistaFactura {
	public VAbrirFactura getVista_AbrirFactura();

	public VCerrarFactura getVista_CerrarFactura();

	public VAniadirActividadAFactura getVista_AniadirActividadFactura();

	public VQuitarActividadAFactura getVista_QuitarActividadFactura();

	public VMostrarTodasFacturas getVista_MostrarTodosActividad(Set<TFactura> listaFacturas);
	
	public VMostrarFactura getVista_MostrarUnaActividad();
	
	public VMostrarFacturaPorActividad getVista_MostrarActividadPorPersonalOK(Set<TFactura> listaFacturas);
	
	public VMostrarActividadesPorMaterial getVista_MostrarActividadPorMaterial();
	public MostrarActividadPorMaterialOK getVista_MostrarActividadPorMaterialOK(Set<TFactura> listaFacturas);

	public VVincularActividadConMaterial getVista_Vincular();
	public VistaGeneralFactura getVista_VistaFacturaGeneral();
}
