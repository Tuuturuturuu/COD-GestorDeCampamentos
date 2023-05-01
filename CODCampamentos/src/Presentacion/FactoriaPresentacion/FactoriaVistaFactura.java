package Presentacion.FactoriaPresentacion;

import java.util.Set;

import Negocio.Factura.TCarrito;
import Negocio.Factura.TFactura;
import Presentacion.Factura.VistaGeneralFactura;
import Presentacion.Factura.VAbrirFactura.VAbrirFactura;
import Presentacion.Factura.VAbrirFactura.VAbrirFacturaOk;
import Presentacion.Factura.VDevolverFactura.VDevolverFactura;
import Presentacion.Factura.VMostrarFactura.VMostrarFactura;
import Presentacion.Factura.VMostrarFacturaPorActividad.VMostrarFacturaPorActividad;
import Presentacion.Factura.VMostrarTodasFacturas.VMostrarTodasFacturas;

public interface FactoriaVistaFactura {
	public VAbrirFactura getVista_AbrirFactura();

	public VAbrirFacturaOk getVista_AbrirFacturaOk(TCarrito tCarrito);

	public VMostrarTodasFacturas getVista_MostrarTodasFacturas(Set<TFactura> listaFacturas);

	public VMostrarFactura getVista_MostrarUnaFactura();

	public VMostrarFacturaPorActividad getVista_MostrarFacturaPorActividad();

	public VDevolverFactura getVista_DevolverFactura();

	public VistaGeneralFactura getVista_VistaFacturaGeneral();
}