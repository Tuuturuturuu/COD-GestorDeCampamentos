/**
 * 
 */
package Integracion.Factura;

import java.util.Set;

import Negocio.Factura.TLineaFactura;

public interface DAOLineaFactura {

	public Integer crearLineaFactura(TLineaFactura tLinea);

	public Integer eliminarLineaFactura(Integer idFactura);

	public Set<TLineaFactura> mostrarLineaFacturaPorActividad(Integer idActividad);

	public Set<TLineaFactura> mostrarLineaFacturaPorFactura(Integer idFactura);
}