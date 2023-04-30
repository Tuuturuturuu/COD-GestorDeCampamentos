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

	public void modificarVenta(Integer idActividad, Integer newCantidad, Integer idFactura);

	public TCarrito aniadirActividad(TActividad tActividad, TCarrito tCarrito);

	public TCarrito quitarActividad(TActividad tActividad, TCarrito tCarrito);

	public Float devolucionVenta(Integer idFactura);

}