
package Integracion.Factura;

import java.util.Set;

import Negocio.Factura.TFactura;

public interface DAOFactura {

	public TFactura cerrarFactura(TFactura tFactura);

	public TFactura devolverFactura(TFactura tfactura);

	public TFactura mostrarFactura(TFactura tfactura);

	public Set<TFactura> mostrarFacturas();
}