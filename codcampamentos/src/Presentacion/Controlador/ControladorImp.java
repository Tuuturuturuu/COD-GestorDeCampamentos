
package Presentacion.Controlador;

import java.util.Set;

import Negocio.Actividad.TActividad;
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
		TMaterial auxMaterial = null;
		
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
		
		case EBajaActividad:
			gui.getVistaActividad().getVista_BajaActividad();
			break;	
			
		case EModificarActividad:
			gui.getVistaActividad().getVista_ModificarActividad();
			break;
		
		case EMostrarUnActividad:
			gui.getVistaActividad().getVista_MostrarActividad();
			break;
			
		case EMostrarTodosLosActividad:
			//Set<TActividad> listaMarca = Factoria_SA.get_SA_Factoria().get_SA_Marca().mostrar_TodasMarcas();
			//gui.getVistaActividad().getVista_MostrarTodosActividad(listaMarca);
			break;
			
		//Material
		case EVistaMaterialGeneral:
			gui.getVistaMaterial().getVista_VistaMaterialGeneral();
			break;
<<<<<<< Updated upstream
		case EAltaMaterial:
			gui.getVistaMaterial().getVista_AltaMaterial();
=======
		case EBajaMaterial:
			gui.getVistaMaterial().getVista_BajaMaterial();
>>>>>>> Stashed changes
			break;
		
		case EBajaMaterial:
			gui.getVistaMaterial().getVista_BajaMaterial();
			break;	
			
		case EModificarMaterial:
			gui.getVistaMaterial().getVista_ModificarMaterial();
			break;
		
		case EMostrarUnMaterial:
			gui.getVistaMaterial().getVista_MostrarMaterial();
			break;
			
		case EMostrarTodosLosMateriales:
			gui.getVistaMaterial().getVista_MostrarTodosMateriales();
			break;
			
		case EMostrarMaterialPorActividad:
			gui.getVistaMaterial().getVista_MostrarMaterialPorActividad();
			break;
		default:
			gui.getVistaGeneralAux().getVistaGeneral();
			break;
			
		
		
		}
	}

}