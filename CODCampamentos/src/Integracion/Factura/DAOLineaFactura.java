/**
 * 
 */
package Integracion.Factura;

import java.util.Set;

import Negocio.Factura.TLineaFactura;

public interface DAOLineaFactura {

	public Integer crearLineaFactura(TLineaFactura tLinea);

	public Integer eliminarLineaFactura(Integer idFactura, Integer idActividad);

	public Integer modificarLineaFactura(TLineaFactura tLinea);

	public TLineaFactura mostrarLineaFactura(Integer idActividad, Integer idFactura);

	public Set<TLineaFactura> mostrarAllLineaFacturas();

	public TLineaFactura mostrarLineaFacturaPorActividad(Integer idActividad);

	public Set<TLineaFactura> mostrarLineaFacturaPorFactura(Integer idFactura);
}