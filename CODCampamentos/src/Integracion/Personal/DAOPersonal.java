/**
 * 
 */
package Integracion.Personal;

import Negocio.Personal.TPersonal;
import java.util.Set;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author airam
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public interface DAOPersonal {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param tPersonal
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer CrearPersonal(TPersonal tPersonal);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param IdPersonal
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer EliminarPersonal(Integer IdPersonal);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param IdPersonal
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TPersonal MostrarUno(Integer IdPersonal);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set<TPersonal> MostrarTodos();

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param IdTurno
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set<TPersonal> MostrarPersonalPorTurno(Integer IdTurno);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param tPersonal
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer ModificarPersonal(TPersonal tPersonal);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param idPersonal
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer activar(Integer idPersonal);
}