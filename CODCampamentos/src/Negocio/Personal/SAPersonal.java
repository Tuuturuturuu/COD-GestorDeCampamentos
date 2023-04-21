/**
 * 
 */
package Negocio.Personal;

import java.util.Set;
import Negocio.Turno.TTurno;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author airam
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public interface SAPersonal {
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
	public Class EiminarPersonal(TPersonal IdPersonal);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param tPersonal
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Class ModificarPersonal(Object tPersonal);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param IdPersonal
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TPersonal MostrarUno(TPersonal IdPersonal);

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
	* @param idTurno
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set<TPersonal> MostrarPersonalPorTurno(TTurno idTurno);
}