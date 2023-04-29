/**
 * 
 */
package Negocio.Factura;

import java.util.Set;

public class TCarrito {
	private TFactura tFactura;

	public TCarrito(TFactura tFactura, Set<TLineaFactura> tLineaFactura) {
		super();
		this.tFactura = tFactura;
		this.tLineaFactura = tLineaFactura;
	}

	public TCarrito() {
		// TODO Auto-generated constructor stub
	}

	private Set<TLineaFactura> tLineaFactura;

	public TFactura gettFactura() {
		return tFactura;
	}

	public void settFactura(TFactura tFactura) {
		this.tFactura = tFactura;
	}

	public Set<TLineaFactura> gettLineaFactura() {
		return tLineaFactura;
	}

	public void settLineaFactura(Set<TLineaFactura> tLineaFactura) {
		this.tLineaFactura = tLineaFactura;
	}
}