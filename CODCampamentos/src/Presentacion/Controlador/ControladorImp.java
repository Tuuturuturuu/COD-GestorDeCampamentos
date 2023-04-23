
package Presentacion.Controlador;

import java.util.HashSet;
import java.util.Set;

import Negocio.Actividad.TActividad;
import Negocio.FactoriaNegocio.FactoriaSAImp;
import Negocio.Material.TMaterial;
import Negocio.Personal.TPersonal;
import Negocio.Personal.TPersonalCocinero;
import Negocio.Personal.TPersonalMonitor;
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
		TPersonal auxPersonal=null;
		
		switch(Evento){
		
		case EVistaGeneral:
			gui.getVistaGeneralAux().getVistaGeneral();
			break;
			
		//ACTIVIDAD
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
		case EMostrarTodosLosActividadporMaterial:
			gui.getVistaActividad().getVista_MostrarActividadPorMaterial();
			break;
		case EMostrarTodosLosActividadporMaterialOK:
			Set<TActividad> Actividades = FactoriaSAImp.obtenerInstancia().generarSAActividad().mostarActividadporMaterial((Integer)Obj);
			if(Actividades.size() == 1){
				 TActividad actividadUnica = Actividades.iterator().next();
				 if(actividadUnica.getIdActividad() <= 0)
					 gui.getVistaGeneralAux().getFailureDialg().actualizar(actividadUnica.getIdActividad(), null);
				 else
					gui.getVistaActividad().getVista_MostrarActividadPorMaterialOK(Actividades);
			}
			else{
				gui.getVistaActividad().getVista_MostrarActividadPorMaterialOK(Actividades);
			}
			break;
		case EMostrarTodosLosActividadporPersonal:
			gui.getVistaActividad().getVista_MostrarActividadPorPersonal();
			break;
		case EMostrarTodosLosActividadporPersonalOK:
			Set<TActividad> listaActividadesPersonal = FactoriaSAImp.obtenerInstancia().generarSAActividad().mostrarActividadesporPersonal((Integer)Obj);
			if(listaActividadesPersonal.size() == 1){
				 TActividad actividadUnica = listaActividadesPersonal.iterator().next();
				 if(actividadUnica.getIdActividad() <= 0)
					 gui.getVistaGeneralAux().getFailureDialg().actualizar(actividadUnica.getIdActividad(), null);
				 else
					gui.getVistaActividad().getVista_MostrarActividadPorPersonalOK(listaActividadesPersonal);
			}
			else{
				gui.getVistaActividad().getVista_MostrarActividadPorPersonalOK(listaActividadesPersonal);
			}
			break;			
			
			//MATERIAL
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
//			Set<TMaterial> listaMateriales2=FactoriaSAImp.obtenerInstancia().generarSAMaterial().listarMaterialPorActividad((int)Obj);
//			if(listaMateriales2 == null){
//				gui.getVistaGeneralAux().getFailureDialg().actualizar(-13, null);
//			}
//			else{
//				gui.getVistaMaterial().getVista_MostrarTodosMateriales(listaMateriales2);
//			}
			Set<TMaterial> Materiales = FactoriaSAImp.obtenerInstancia().generarSAMaterial().listarMaterialPorActividad((Integer)Obj);
			if(Materiales.size() == 1){
				 TMaterial materialUnico = Materiales.iterator().next();
				 if(materialUnico.getId() <= 0)
					 gui.getVistaGeneralAux().getFailureDialg().actualizar(materialUnico.getId(), null);
				 else
					gui.getVistaMaterial().getVista_MostrarTodosMateriales(Materiales);
			}
			else{
				gui.getVistaMaterial().getVista_MostrarTodosMateriales(Materiales);
			}
			break;
			
			//PERSONAL
			case EVistaPersonalGeneral:
				gui.getVistaPersonal().getVista_VistaPersonalGeneral();
				break;
			
			case EAltaPersonal:
				gui.getVistaPersonal().getVista_AltaPersonal();
				break;
				
			case EAltaPersonalOK:
				auxPersonal = (TPersonal) Obj;
				if(auxPersonal.getTipo() == 0){
					gui.getVistaPersonal().getVista_Altamonitor((TPersonalMonitor)auxPersonal);
				}
				else{
					gui.getVistaPersonal().getVista_AltaCocinero((TPersonalCocinero)auxPersonal);
				}
				break;
				
			case EAltaMonitorOK:
				auxPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal().crearPersonal((TPersonal) Obj);
				if(auxPersonal.getIdPersonal() <= 0){
					gui.getVistaGeneralAux().getFailureDialg().actualizar(auxPersonal.getIdPersonal(), null);
				}
				else{
					gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxPersonal.getIdPersonal(), null);
				}
				break;
			
			case EAltaCocineroOK:
				auxPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal().crearPersonal((TPersonal) Obj);
				if(auxPersonal.getIdPersonal() <= 0){
					gui.getVistaGeneralAux().getFailureDialg().actualizar(auxPersonal.getIdPersonal(), null);
				}
				else{
					gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxPersonal.getIdPersonal(), null);
				}
				break;
			
			case EBajaPersonal:
				gui.getVistaPersonal().getVista_BajaPersonal();
				break;
				
			case EBajaPersonalOK:
				auxPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal().eliminarPersonal((TPersonal)Obj);
				if(auxPersonal.getIdPersonal() <= 0){
					gui.getVistaGeneralAux().getFailureDialg().actualizar(auxPersonal.getIdPersonal(), null);
				}
				else{
					gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxPersonal.getIdPersonal(), null);
				}
				break;
				
			case EModificarPersonal:
				gui.getVistaPersonal().getVista_ModificarPersonal();
				break;
			case EModificarPersonalOK:
				auxPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal().modificarPersonal((TPersonal)Obj);
				if(auxPersonal.getIdPersonal() <= 0){
					gui.getVistaGeneralAux().getFailureDialg().actualizar(auxPersonal.getIdPersonal(), null);
				}
				else{
					gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxPersonal.getIdPersonal(), null);
				}
				break;
			
			case EMostrarUnPersonal:
				gui.getVistaPersonal().getVista_MostrarPersonal();
				break;
			
			case EMostrarUnPersonalOK:
				auxPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal().mostrarUno((TPersonal)Obj);
				if(auxPersonal.getIdPersonal() <= 0){
					gui.getVistaGeneralAux().getFailureDialg().actualizar(auxPersonal.getIdPersonal(), null);
				}
				else{
					gui.getVistaGeneralAux().getConfirmDialogMostrarUna().actualizar(auxPersonal.toString(), null);
				}
				break;
				
			case EMostrarTodosPersonal:
				Set<TPersonal> listaPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal().mostrarTodos();
				gui.getVistaPersonal().getVista_MostrarTodosPersonal(listaPersonal);
				break;
		default:
			gui.getVistaGeneralAux().getVistaGeneral();
			break;
			
		
		
		}
	}

}