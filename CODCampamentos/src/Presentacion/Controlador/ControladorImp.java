
package Presentacion.Controlador;

import java.util.Set;

import Negocio.Actividad.TActividad;
import Negocio.FactoriaNegocio.FactoriaSAImp;
import Negocio.Material.TMaterial;
import Presentacion.Evento;
import Presentacion.FactoriaPresentacion.FactoriaVistas;


public class ControladorImp extends Controlador {
	
	private FactoriaVistas gui;
	
	public ControladorImp() {
		gui = gui.obtenerInstancia();
	}

	@Override
	public void run(Object Obj, Evento Evento) {
		TActividad auxActividad = null;
		TMaterial auxMaterial=null;
		
		switch(Evento){
		
		case EVistaGeneral:
			gui.getVistaGeneralAux().getVistaGeneral();
			break;
			
		//Actividad
		case EVistaActividadGeneral:
			gui.getVistaActividad().getVista_VistaActividadGeneral();
			break;
		
		case EAltaActividad:
			gui.getVistaActividad().getVista_AltaActividad();
			break;
			
		case EAltaActividadOK:
			auxActividad = FactoriaSAImp.obtenerInstancia().generarSAActividad().crearActividad((TActividad)Obj);
			if(auxActividad.getIdActividad() <= 0){
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxActividad.getIdActividad(), null);
			}
			else{
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxActividad.getIdActividad(), null);
			}
			break;
		
		case EBajaActividad:
			gui.getVistaActividad().getVista_BajaActividad();
			break;
			
		case EBajaActividadOK:
			auxActividad = FactoriaSAImp.obtenerInstancia().generarSAActividad().borrarActividad((TActividad)Obj);
			if(auxActividad.getIdActividad() <= 0){
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxActividad.getIdActividad(), null);
			}
			else{
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxActividad.getIdActividad(), null);
			}
			break;
			
		case EModificarActividad:
			gui.getVistaActividad().getVista_ModificarActividad();
			break;
		case EModificarActividadOK:
			auxActividad = FactoriaSAImp.obtenerInstancia().generarSAActividad().modificarActividad((TActividad)Obj);
			if(auxActividad.getIdActividad() <= 0){
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxActividad.getIdActividad(), null);
			}
			else{
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxActividad.getIdActividad(), null);
			}
			break;
		
		case EMostrarUnActividad:
			gui.getVistaActividad().getVista_MostrarActividad();
			break;
		
		case EMostrarUnActividadOK:
			auxActividad = FactoriaSAImp.obtenerInstancia().generarSAActividad().mostrarActividad((TActividad)Obj);
			if(auxActividad.getIdActividad() <= 0){
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxActividad.getIdActividad(), null);
			}
			else{
				gui.getVistaGeneralAux().getConfirmDialogMostrarUna().actualizar(auxActividad.toString(), null);
			}
			break;
			
		case EMostrarTodosLosActividad:
			Set<TActividad> listaActividades = FactoriaSAImp.obtenerInstancia().generarSAActividad().mostrarActividades();
			gui.getVistaActividad().getVista_MostrarTodosActividad(listaActividades);
			break;
			//Material
		case EVistaMaterialGeneral:
			gui.getVistaMaterial().getVista_VistaMaterialGeneral();
			break;
		case EAltaMaterial:
			gui.getVistaMaterial().getVista_AltaMaterial();
			break;
		case EAltaMaterialOK:
			auxMaterial = FactoriaSAImp.obtenerInstancia().generarSAMaterial().crearMaterial((TMaterial)Obj);
			if(auxMaterial.getId() <= 0){
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxMaterial.getId(), null);
			}
			else{
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxMaterial.getId(), null);
			}
			break;
		case EBajaMaterial:
			gui.getVistaMaterial().getVista_BajaMaterial();
			break;	
		case EBajaMaterialOK:
			auxMaterial = FactoriaSAImp.obtenerInstancia().generarSAMaterial().eliminarMaterial((TMaterial)Obj);
			if(auxMaterial.getId() <= 0){
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxMaterial.getId(), null);
			}
			else{
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxMaterial.getId(), null);
			}
			break;
		case EModificarMaterial:
			gui.getVistaMaterial().getVista_ModificarMaterial();
			break;
		case EModificarMaterialOK:
			auxMaterial = FactoriaSAImp.obtenerInstancia().generarSAMaterial().modificarMaterial((TMaterial)Obj);
			if(auxMaterial.getId() <= 0){
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxMaterial.getId(), null);
			}
			else{
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxMaterial.getId(), null);
			}
			break;
		case EMostrarUnMaterial:
			gui.getVistaMaterial().getVista_MostrarMaterial();
			break;
		case EMostrarUnMaterialOK:
			auxMaterial = FactoriaSAImp.obtenerInstancia().generarSAMaterial().mostrarMaterial((TMaterial)Obj);
			if(auxMaterial.getId() <= 0){
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxMaterial.getId(), null);
			}
			else{
				gui.getVistaGeneralAux().getConfirmDialogMostrarUna().actualizar(auxMaterial.toString(), null);
			}
			break;
		case EMostrarTodosLosMateriales:
			Set<TMaterial> listaMateriales = FactoriaSAImp.obtenerInstancia().generarSAMaterial().mostrarTodosMateriales();
			gui.getVistaMaterial().getVista_MostrarTodosMateriales(listaMateriales);
			break;
			
		case EMostrarMaterialPorActividad:
			gui.getVistaMaterial().getVista_MostrarMaterialPorActividad();
			break;
		case EMostrarUnMaterialPorActividadOK:
			Set<TMaterial> listaMateriales2=FactoriaSAImp.obtenerInstancia().generarSAMaterial().listarMaterialPorActividad((int)Obj);
			if(listaMateriales2==null){
				gui.getVistaGeneralAux().getFailureDialg().actualizar(-13, null);
			}
			else{
				gui.getVistaMaterial().getVista_MostrarTodosMateriales(listaMateriales2);
			}
			break;
		default:
			gui.getVistaGeneralAux().getVistaGeneral();
			break;
			
		
		
		}
	}

}