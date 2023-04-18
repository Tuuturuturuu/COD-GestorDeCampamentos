
package Presentacion.Controlador;

import java.util.Set;

import Negocio.Actividad.TActividad;
import Presentacion.Evento;
import Presentacion.FactoriaPresentacion.FactoriaVistas;


public class ControladorImp extends Controlador {
	
	private FactoriaVistas gui;
	
	public ControladorImp() {
		gui = gui.obtenerInstancia();
	}

	@Override
	public void run(Object Obj, Evento Evento) {
		//TActividad auxActividad = null;
		
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
		
		case EAltaMaterial:
			gui.getVistaMaterial().getVista_AltaActividad();
			break;
		
		case EBajaMaterial:
			gui.getVistaMaterial().getVista_BajaActividad();
			break;	
			
		case EModificarMaterial:
			gui.getVistaMaterial().getVista_ModificarActividad();
			break;
		
		case EMostrarUnMaterial:
			gui.getVistaMaterial().getVista_MostrarActividad();
			break;
			
		case EMostrarTodosLosMateriales:
			//Set<TMaterial> listaMarca = Factoria_SA.get_SA_Factoria().get_SA_Marca().mostrar_TodasMarcas();
			//gui.getVistaMaterial().getVista_MostrarTodosMateriales(listaMarca);
			break;
		
		default:
			gui.getVistaGeneralAux().getVistaGeneral();
			break;
			
		
		
		}
	}

}