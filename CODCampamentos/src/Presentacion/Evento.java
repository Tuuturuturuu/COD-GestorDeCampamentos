
package Presentacion;

public enum Evento {
	
	EVistaGeneral,
	
	//Actividad
	EVistaActividadGeneral,
	EAltaActividad,
	EAltaActividadOK,
	EBajaActividad,
	EBajaActividadOK,
	EModificarActividad,
	EModificarActividadOK,
	EMostrarUnActividad,
	EMostrarUnActividadOK,
	EMostrarTodosLosActividad,
	EMostrarTodosLosActividadporPersonal,
	EMostrarTodosLosActividadporPersonalOK,
	EMostrarTodosLosActividadporMaterial,
	EMostrarTodosLosActividadporMaterialOK,
	//Personal
	EVistaPersonalGeneral,
	EAltaPersonal,
	EAltaPersonalOK,
	EAltaCocineroOK,
	EAltaMonitorOK,
	EBajaPersonal,    
	EBajaPersonalOK,
	EModificarPersonal,
	EModificarPersonalOK,
	EMostrarUnPersonal,
	EMostrarUnPersonalOK,
	EMostrarTodosPersonal,
	
	//Factura
	EVistaFacturaGeneral,
	
	//Material
	EVistaMaterialGeneral,
	EAltaMaterial,
	EAltaMaterialOK,
	EBajaMaterial,
	EBajaMaterialOK, 
	EModificarMaterial,
	EModificarMaterialOK,
	EMostrarUnMaterial,
	EMostrarUnMaterialOK,
	EMostrarTodosLosMateriales,
	EMostrarMaterialPorActividad,
	EMostrarUnMaterialPorActividadOK, 
	EVincularMaterialActividad,
	EVincularMaterialActividadOK,
	
	//Turno
	EVistaTurnoGeneral,      
	
}