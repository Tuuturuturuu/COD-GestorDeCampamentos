/**
 * 
 */
package Integracion.Material;

import Negocio.Material.TMaterial;
import java.util.Set;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author airam
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public interface DAOMaterial {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param tMaterial
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TMaterial crearMaterial(TMaterial tMaterial);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param id
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer eliminarMaterial(Integer id);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param tMaterial
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer modificarMaterial(TMaterial tMaterial);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param idMaterial
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TMaterial mostrarMaterial(Integer idMaterial);

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set<TMaterial> mostrarTodosMateriales();

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param idActividad
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set<TMaterial> listarMaterialPorActividad(Integer idActividad);
}