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

public class FactoriaVistaFacturaImp implements FactoriaVistaFactura {

	@Override
	public VAbrirFactura getVista_AbrirFactura() {
		return new VAbrirFactura();
	}

	@Override
	public VMostrarTodasFacturas getVista_MostrarTodasFacturas(Set<TFactura> listaFacturas) {
		return new VMostrarTodasFacturas(listaFacturas);
	}

	@Override
	public VMostrarFactura getVista_MostrarUnaFactura() {
		return new VMostrarFactura();
	}

	@Override
	public VMostrarFacturaPorActividad getVista_MostrarFacturaPorActividad() {
		return new VMostrarFacturaPorActividad();
	}

	@Override
	public VistaGeneralFactura getVista_VistaFacturaGeneral() {
		return new VistaGeneralFactura();
	}

	@Override
	public VAbrirFacturaOk getVista_AbrirFacturaOk(TCarrito tCarrito) {
		// TODO Auto-generated method stub
		return new VAbrirFacturaOk(tCarrito);
	}

	@Override
	public VDevolverFactura getVista_DevolverFactura() {
		// TODO Auto-generated method stub
		return new VDevolverFactura();
	}

}
