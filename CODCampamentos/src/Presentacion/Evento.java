
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
	EVincularActividadMaterial,
	EVincularActividadMaterialOK,
	
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
	EMostrarTodosPersonalporTurno,
	EMostrarTodosPersonalporTurnoOK,
	
	//Factura
		EVistaFacturaGeneral,
		EVistaCrearFactura,
		EVistaCrearFacturaOK,
		EVistaCrearFacturaFailure,
		ECerrarFactura,
		EAnadirActividadFactura,
		EQuitarActividadFactura,
		EDelvolverFactura,
		EDelvolverFacturaOK,
		EMostrarUnaFactura,
		EMostrarUnaFacturaOK,
		EMostrarTodasLasFacturas,
		EMostrarFacturaPorActividad,
		EMostrarFacturaPorActividadOK,
	
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
	EAltaTurno,
	EAltaTurnoOK,
	EBajaTurno, 
	EBajaTurnoOK,
	EModificarTurno,
	EModificarTurnoOK,
	EMostrarUnTurnoOK, 
	EMostrarUnTurno, 
	EMostrarTodosLosTurnos, 
	
}