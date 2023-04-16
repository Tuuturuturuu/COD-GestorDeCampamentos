/**
 * 
 */
package Integracion.Actividad;

import Negocio.Actividad.TActividadMaterial;
import java.util.Set;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author airam
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public interface DAOActividadMaterial {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param actividadMaterial
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer vincular(TActividadMaterial actividadMaterial);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param idActividad
	* @param idMaterial
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer desvincular(Integer idActividad, Integer idMaterial);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param idActividad
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set<TActividadMaterial> BuscarporActividad(Integer idActividad);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param idMaterial
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set<TActividadMaterial> BuscarporMaterial(Integer idMaterial);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param idActividad
	* @param idMaterial
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TActividadMaterial BuscarActividadMaterial(Integer idActividad, Integer idMaterial);
}