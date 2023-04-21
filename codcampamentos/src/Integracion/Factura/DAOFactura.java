/**
 * 
 */
package Integracion.Factura;

import Negocio.Factura.TFactura;
import Negocio.Factura.TFacturaConActividades;
import java.util.Set;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author airam
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public interface DAOFactura {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param tFactura
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer cerrarFactura(TFactura tFactura);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param tfactura
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer modificarFactura(TFactura tfactura);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param idFactura
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TFacturaConActividades mostrarFactura(TFactura idFactura);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set<TFactura> mostrarFacturas();

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param idCliente
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set<TFactura> mostrarFacturasporCliente(Integer idCliente);
}