
package Negocio.Factura;

import java.util.Set;

public class TCarrito {
	private TFactura tFactura;

	public TCarrito(TFactura tFactura, Set<TLineaFactura> tGenera) {
		super();
		this.tFactura = tFactura;
		this.tGenera = tGenera;
	}

	public TCarrito() {
		// TODO Auto-generated constructor stub
	}

	private Set<TLineaFactura> tGenera;

	public TFactura gettFactura() {
		return tFactura;
	}

	public void settFactura(TFactura tFactura) {
		this.tFactura = tFactura;
	}

	public Set<TLineaFactura> gettGenera() {
		return tGenera;
	}

	public void settGenera(Set<TLineaFactura> tGenera) {
		this.tGenera = tGenera;
	}
}