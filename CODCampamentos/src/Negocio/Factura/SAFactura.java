/**
 * 
 */
package Negocio.Factura;

import java.util.Set;

import Negocio.Actividad.TActividad;

public interface SAFactura {

	public TCarrito abrirVenta(Integer idCliente);

	public Set<TFactura> mostrarFacturas();

	public TCarrito cerrarVenta(TCarrito tCarrito);

	public TCarrito mostarVenta(Integer idFactura);

	public TCarrito mostarVentaporActividad(Integer idActividad);

	public TCarrito aniadirActividad(TActividad tActividad, TCarrito tCarrito);

	public TCarrito quitarActividad(TActividad tActividad, TCarrito tCarrito);

	public TFactura devolucionVenta(Integer idFactura);

}