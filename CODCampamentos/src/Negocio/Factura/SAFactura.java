/**
 * 
 */
package Negocio.Factura;

import java.util.Set;

import Negocio.Actividad.TActividad;

public interface SAFactura {

	public TCarrito abrirVenta(Integer idCliente);

	public Set<TFactura> mostrarFacturas();

	public Integer cerrarVenta(Integer idFactura);

	public TCarrito mostarVenta(Integer idFactura);

	public void modificarVenta(Integer idActividad, Integer newCantidad, Integer idFactura);

	public TCarrito aniadirActividad(TActividad tActividad, TCarrito tCarrito);

	public void quitarActividad(Integer idActividad);

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param idFactura
	 * @return
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Float devolucionVenta(Integer idFactura);

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param idCliente
	 * @return
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
}