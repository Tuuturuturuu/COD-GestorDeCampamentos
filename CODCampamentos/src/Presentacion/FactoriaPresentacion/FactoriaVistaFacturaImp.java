package Presentacion.FactoriaPresentacion;

import java.util.Set;

import Negocio.Factura.TCarrito;
import Negocio.Factura.TFactura;
import Presentacion.Factura.VistaGeneralFactura;
import Presentacion.Factura.VAbrirFactura.VAbrirFactura;
import Presentacion.Factura.VAbrirFactura.VAbrirFacturaOk;
import Presentacion.Factura.VAniadirActividadAFactura.VAniadirActividadAFactura;
import Presentacion.Factura.VCerrarFactura.VCerrarFactura;
import Presentacion.Factura.VDevolverUnaActividadAFactura.VDevolverUnaActividadAFactura;
import Presentacion.Factura.VMostrarFactura.VMostrarFactura;
import Presentacion.Factura.VMostrarFacturaPorActividad.VMostrarFacturaPorActividad;
import Presentacion.Factura.VMostrarTodasFacturas.VMostrarTodasFacturas;
import Presentacion.Factura.VQuitarActividadAFactura.VQuitarActividadAFactura;

public class FactoriaVistaFacturaImp implements FactoriaVistaFactura {

	@Override
	public VAbrirFactura getVista_AbrirFactura() {
		return new VAbrirFactura();
	}

	@Override
	public VCerrarFactura getVista_CerrarFactura() {
		return new VCerrarFactura();
	}

	@Override
	public VAniadirActividadAFactura getVista_AniadirActividadFactura() {
		return new VAniadirActividadAFactura();
	}

	@Override
	public VQuitarActividadAFactura getVista_QuitarActividadFactura() {
		return new VQuitarActividadAFactura();
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
	public VDevolverUnaActividadAFactura getVista_DevolverUnaActividadAFactura() {
		return new VDevolverUnaActividadAFactura();
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

}
