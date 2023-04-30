
package Presentacion.Controlador;

import java.util.Set;

import Negocio.Actividad.TActividad;
import Negocio.FactoriaNegocio.FactoriaSAImp;
import Negocio.Factura.TCarrito;
import Negocio.Material.TMaterial;
import Negocio.Personal.TPersonal;
import Negocio.Personal.TPersonalCocinero;
import Negocio.Personal.TPersonalMonitor;
import Negocio.Turno.TTurno;
import Presentacion.ClaseContenedora;
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
		TPersonal auxPersonal = null;
		TTurno auxTurno = null;
		TCarrito auxCarrito = null;

		switch (Evento) {

		case EVistaGeneral:
			gui.getVistaGeneralAux().getVistaGeneral();
			break;

		// ACTIVIDAD
		case EVistaActividadGeneral:
			gui.getVistaActividad().getVista_VistaActividadGeneral();
			break;

		case EAltaActividad:
			gui.getVistaActividad().getVista_AltaActividad();
			break;

		case EAltaActividadOK:
			auxActividad = FactoriaSAImp.obtenerInstancia().generarSAActividad().crearActividad((TActividad) Obj);
			if (auxActividad.getIdActividad() < 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxActividad.getIdActividad(), null);
			} else if (auxActividad.getIdActividad() == 0) {
				gui.getVistaGeneralAux().getConfirmDialogActivar().actualizar(auxActividad.getIdActividad(), null);
			} else
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxActividad.getIdActividad(), null);
			break;
		case EBajaActividad:
			gui.getVistaActividad().getVista_BajaActividad();
			break;

		case EBajaActividadOK:
			auxActividad = FactoriaSAImp.obtenerInstancia().generarSAActividad().borrarActividad((TActividad) Obj);
			if (auxActividad.getIdActividad() <= 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxActividad.getIdActividad(), null);
			} else {
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxActividad.getIdActividad(), null);
			}
			break;

		case EModificarActividad:
			gui.getVistaActividad().getVista_ModificarActividad();
			break;
		case EModificarActividadOK:
			auxActividad = FactoriaSAImp.obtenerInstancia().generarSAActividad().modificarActividad((TActividad) Obj);
			if (auxActividad.getIdActividad() <= 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxActividad.getIdActividad(), null);
			} else {
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxActividad.getIdActividad(), null);
			}
			break;

		case EMostrarUnActividad:
			gui.getVistaActividad().getVista_MostrarActividad();
			break;

		case EMostrarUnActividadOK:
			auxActividad = FactoriaSAImp.obtenerInstancia().generarSAActividad().mostrarActividad((TActividad) Obj);
			if (auxActividad.getIdActividad() <= 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxActividad.getIdActividad(), null);
			} else {
				gui.getVistaGeneralAux().getConfirmDialogMostrarUna().actualizar(auxActividad.toString(), null);
			}
			break;

		case EMostrarTodosLosActividad:
			Set<TActividad> listaActividades = FactoriaSAImp.obtenerInstancia().generarSAActividad()
					.mostrarActividades();
			gui.getVistaActividad().getVista_MostrarTodosActividad(listaActividades);
			break;
		case EMostrarTodosLosActividadporMaterial:
			gui.getVistaActividad().getVista_MostrarActividadPorMaterial();
			break;
		case EMostrarTodosLosActividadporMaterialOK:
			Set<TActividad> Actividades = FactoriaSAImp.obtenerInstancia().generarSAActividad()
					.mostarActividadporMaterial((Integer) Obj);
			if (Actividades.size() == 1) {
				TActividad actividadUnica = Actividades.iterator().next();
				if (actividadUnica.getIdActividad() <= 0)
					gui.getVistaGeneralAux().getFailureDialg().actualizar(actividadUnica.getIdActividad(), null);
				else
					gui.getVistaActividad().getVista_MostrarActividadPorMaterialOK(Actividades);
			} else {
				gui.getVistaActividad().getVista_MostrarActividadPorMaterialOK(Actividades);
			}
			break;
		case EMostrarTodosLosActividadporPersonal:
			gui.getVistaActividad().getVista_MostrarActividadPorPersonal();
			break;
		case EMostrarTodosLosActividadporPersonalOK:
			Set<TActividad> listaActividadesPersonal = FactoriaSAImp.obtenerInstancia().generarSAActividad()
					.mostrarActividadesporPersonal((Integer) Obj);
			if (listaActividadesPersonal.size() == 1) {
				TActividad actividadUnica = listaActividadesPersonal.iterator().next();
				if (actividadUnica.getIdActividad() <= 0)
					gui.getVistaGeneralAux().getFailureDialg().actualizar(actividadUnica.getIdActividad(), null);
				else
					gui.getVistaActividad().getVista_MostrarActividadPorPersonalOK(listaActividadesPersonal);
			} else {
				gui.getVistaActividad().getVista_MostrarActividadPorPersonalOK(listaActividadesPersonal);
			}
			break;
		case EVincularActividadMaterial:
			gui.getVistaActividad().getVista_Vincular();
			break;
		case EVincularActividadMaterialOK:
			auxMaterial = FactoriaSAImp.obtenerInstancia().generarSAMaterial()
					.vincularMaterialActividad((TMaterial) Obj);
			if (auxMaterial.getId() <= 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxMaterial.getId(), null);
			} else {
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxMaterial.getId(), null);
			}
			break;

		// MATERIAL
		case EVistaMaterialGeneral:
			gui.getVistaMaterial().getVista_VistaMaterialGeneral();
			break;
		case EAltaMaterial:
			gui.getVistaMaterial().getVista_AltaMaterial();
			break;
		case EAltaMaterialOK:
			auxMaterial = FactoriaSAImp.obtenerInstancia().generarSAMaterial().crearMaterial((TMaterial) Obj);
			if (auxMaterial.getId() < 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxMaterial.getId(), null);
			} else if (auxMaterial.getId() == 0) {
				gui.getVistaGeneralAux().getConfirmDialogActivar().actualizar(auxMaterial.getId(), null);
			} else
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxMaterial.getId(), null);
			break;
		case EBajaMaterial:
			gui.getVistaMaterial().getVista_BajaMaterial();
			break;
		case EBajaMaterialOK:
			auxMaterial = FactoriaSAImp.obtenerInstancia().generarSAMaterial().eliminarMaterial((TMaterial) Obj);
			if (auxMaterial.getId() <= 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxMaterial.getId(), null);
			} else {
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxMaterial.getId(), null);
			}
			break;
		case EModificarMaterial:
			gui.getVistaMaterial().getVista_ModificarMaterial();
			break;
		case EModificarMaterialOK:
			auxMaterial = FactoriaSAImp.obtenerInstancia().generarSAMaterial().modificarMaterial((TMaterial) Obj);
			if (auxMaterial.getId() <= 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxMaterial.getId(), null);
			} else {
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxMaterial.getId(), null);
			}
			break;
		case EMostrarUnMaterial:
			gui.getVistaMaterial().getVista_MostrarMaterial();
			break;
		case EMostrarUnMaterialOK:
			auxMaterial = FactoriaSAImp.obtenerInstancia().generarSAMaterial().mostrarMaterial((TMaterial) Obj);
			if (auxMaterial.getId() <= 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxMaterial.getId(), null);
			} else {
				gui.getVistaGeneralAux().getConfirmDialogMostrarUna().actualizar(auxMaterial.toString(), null);
			}
			break;
		case EMostrarTodosLosMateriales:
			Set<TMaterial> listaMateriales = FactoriaSAImp.obtenerInstancia().generarSAMaterial()
					.mostrarTodosMateriales();
			gui.getVistaMaterial().getVista_MostrarTodosMateriales(listaMateriales);
			break;

		case EMostrarMaterialPorActividad:
			gui.getVistaMaterial().getVista_MostrarMaterialPorActividad();
			break;
		case EMostrarUnMaterialPorActividadOK:
			Set<TMaterial> Materiales = FactoriaSAImp.obtenerInstancia().generarSAMaterial()
					.listarMaterialPorActividad((Integer) Obj);
			if (Materiales.size() == 1) {
				TMaterial materialUnico = Materiales.iterator().next();
				if (materialUnico.getId() <= 0)
					gui.getVistaGeneralAux().getFailureDialg().actualizar(materialUnico.getId(), null);
				else
					gui.getVistaMaterial().getVista_MostrarTodosMateriales(Materiales);
			} else {
				gui.getVistaMaterial().getVista_MostrarTodosMateriales(Materiales);
			}
			break;
		case EVincularMaterialActividad:
			gui.getVistaMaterial().getVista_VincularMaterialActividad();
			break;
		case EVincularMaterialActividadOK:
			auxMaterial = FactoriaSAImp.obtenerInstancia().generarSAMaterial()
					.vincularMaterialActividad((TMaterial) Obj);
			if (auxMaterial.getId() <= 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxMaterial.getId(), null);
			} else {
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxMaterial.getId(), null);
			}
			break;

		// PERSONAL
		case EVistaPersonalGeneral:
			gui.getVistaPersonal().getVista_VistaPersonalGeneral();
			break;

		case EAltaPersonal:
			gui.getVistaPersonal().getVista_AltaPersonal();
			break;

		case EAltaPersonalOK:
			auxPersonal = (TPersonal) Obj;
			if (auxPersonal.getTipo() == 0) {
				gui.getVistaPersonal().getVista_Altamonitor((TPersonalMonitor) auxPersonal);
			} else {
				gui.getVistaPersonal().getVista_AltaCocinero((TPersonalCocinero) auxPersonal);
			}
			break;

		case EAltaMonitorOK:
			auxPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal().crearPersonal((TPersonal) Obj);
			if (auxPersonal.getIdPersonal() < 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxPersonal.getIdPersonal(), null);
			} else if (auxPersonal.getIdPersonal() == 0) {
				gui.getVistaGeneralAux().getConfirmDialogActivar().actualizar(auxPersonal.getIdPersonal(), null);
			} else
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxPersonal.getIdPersonal(), null);
			break;

		case EAltaCocineroOK:
			auxPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal().crearPersonal((TPersonal) Obj);
			if (auxPersonal.getIdPersonal() <= 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxPersonal.getIdPersonal(), null);
			} else if (auxPersonal.getIdPersonal() == 0) {
				gui.getVistaGeneralAux().getConfirmDialogActivar().actualizar(auxPersonal.getIdPersonal(), null);
			} else
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxPersonal.getIdPersonal(), null);
			break;

		case EBajaPersonal:
			gui.getVistaPersonal().getVista_BajaPersonal();
			break;

		case EBajaPersonalOK:
			auxPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal().eliminarPersonal((TPersonal) Obj);
			if (auxPersonal.getIdPersonal() <= 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxPersonal.getIdPersonal(), null);
			} else {
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxPersonal.getIdPersonal(), null);
			}
			break;

		case EModificarPersonal:
			gui.getVistaPersonal().getVista_ModificarPersonal();
			break;
		case EModificarPersonalOK:
			auxPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal().modificarPersonal((TPersonal) Obj);
			if (auxPersonal.getIdPersonal() <= 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxPersonal.getIdPersonal(), null);
			} else {
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxPersonal.getIdPersonal(), null);
			}
			break;

		case EMostrarUnPersonal:
			gui.getVistaPersonal().getVista_MostrarPersonal();
			break;

		case EMostrarUnPersonalOK:
			auxPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal().mostrarUno((TPersonal) Obj);
			if (auxPersonal.getIdPersonal() <= 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxPersonal.getIdPersonal(), null);
			} else {
				gui.getVistaGeneralAux().getConfirmDialogMostrarUna().actualizar(auxPersonal.toString(), null);
			}
			break;

		case EMostrarTodosPersonal:
			Set<TPersonal> listaPersonal = FactoriaSAImp.obtenerInstancia().generarSAPersonal().mostrarTodos();
			gui.getVistaPersonal().getVista_MostrarTodosPersonal(listaPersonal);
			break;
		case EMostrarTodosPersonalporTurno:
			gui.getVistaPersonal().getVista_MostrarPersonalPorTurno();
			break;

		case EMostrarTodosPersonalporTurnoOK:
			Set<TPersonal> listaPersonales = FactoriaSAImp.obtenerInstancia().generarSAPersonal()
					.mostrarPersonalPorTurno((Integer) Obj);
			if (listaPersonales.size() == 1) {
				TPersonal personalUnico = listaPersonales.iterator().next();
				if (personalUnico.getIdPersonal() <= 0)
					gui.getVistaGeneralAux().getFailureDialg().actualizar(personalUnico.getIdPersonal(), null);
				else
					gui.getVistaPersonal().getVista_MostrarPersonalPorTurnoOK(listaPersonales);
			} else {
				gui.getVistaPersonal().getVista_MostrarPersonalPorTurnoOK(listaPersonales);
			}
			break;

		// TURNO
		case EVistaTurnoGeneral:
			gui.getVistaTurno().getVista_VistaTurnoGeneral();
			break;
		case EAltaTurno:
			gui.getVistaTurno().getVista_AltaTurno();
			break;
		case EAltaTurnoOK:
			auxTurno = FactoriaSAImp.obtenerInstancia().generarSATurno().crearTurno((TTurno) Obj);
			if (auxTurno.getIdTurno() < 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxTurno.getIdTurno(), null);
			} else if (auxTurno.getIdTurno() == 0) {
				gui.getVistaGeneralAux().getConfirmDialogActivar().actualizar(auxTurno.getIdTurno(), null);
			} else
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxTurno.getIdTurno(), null);
			break;
		case EBajaTurno:
			gui.getVistaTurno().getVista_BajaTurno();
			break;
		case EBajaTurnoOK:
			auxTurno = FactoriaSAImp.obtenerInstancia().generarSATurno().BorrarTurno((TTurno) Obj);
			if (auxTurno.getIdTurno() <= 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxTurno.getIdTurno(), null);
			} else {
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxTurno.getIdTurno(), null);
			}
			break;
		case EModificarTurno:
			gui.getVistaTurno().getVista_ModificarTurno();
			break;
		case EModificarTurnoOK:
			auxTurno = FactoriaSAImp.obtenerInstancia().generarSATurno().ModificarTurno((TTurno) Obj);
			if (auxTurno.getIdTurno() <= 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxTurno.getIdTurno(), null);
			} else {
				gui.getVistaGeneralAux().getConfirmDialg().actualizar(auxTurno.getIdTurno(), null);
			}
			break;
		case EMostrarUnTurno:
			gui.getVistaTurno().getVista_MostrarTurno();
			break;
		case EMostrarUnTurnoOK:
			auxTurno = FactoriaSAImp.obtenerInstancia().generarSATurno().MostrarTurno((TTurno) Obj);
			if (auxTurno.getIdTurno() <= 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxTurno.getIdTurno(), null);
			} else {
				gui.getVistaGeneralAux().getConfirmDialogMostrarUna().actualizar(auxTurno.toString(), null);
			}
			break;
		case EMostrarTodosLosTurnos:
			Set<TTurno> listaTurnos = FactoriaSAImp.obtenerInstancia().generarSATurno().MostrarTurnos();
			gui.getVistaTurno().getVista_MostrarTodosTurnos(listaTurnos);
			break;
		// Factura
		case EVistaFacturaGeneral:
			gui.getVistaFactura().getVista_VistaFacturaGeneral();
			break;
		case EVistaCrearFactura:
			gui.getVistaFactura().getVista_AbrirFactura();
			break;
		case EVistaCrearFacturaOK:
			auxCarrito = FactoriaSAImp.obtenerInstancia().generarSAFactura().abrirVenta((Integer) Obj);
			if (auxCarrito.gettFactura().getIdCliente() < 0) {
				gui.getVistaGeneralAux().getFailureDialg().actualizar(auxCarrito.gettFactura().getIdCliente(), null);
			} else
				gui.getVistaFactura().getVista_AbrirFacturaOk(auxCarrito);
			break;
		case EVistaCrearFacturaFailure:
			gui.getVistaFactura().getVista_AbrirFacturaOk((TCarrito) Obj);
			break;
		case EAnadirActividadFactura:
			ClaseContenedora contenedor = (ClaseContenedora) Obj;
			auxCarrito = FactoriaSAImp.obtenerInstancia().generarSAFactura()
					.aniadirActividad(contenedor.gettActividad(), contenedor.gettCarrito());
			if (auxCarrito.gettFactura().getIdCliente() < 0) {
				gui.getVistaGeneralAux().getFailureDialgFactura(auxCarrito).actualizar(auxCarrito, null);
			} else
				gui.getVistaFactura().getVista_AbrirFacturaOk(auxCarrito);
			break;
		case EQuitarActividadFactura:
			ClaseContenedora contenedorOut = (ClaseContenedora) Obj;
			auxCarrito = FactoriaSAImp.obtenerInstancia().generarSAFactura()
					.quitarActividad(contenedorOut.gettActividad(), contenedorOut.gettCarrito());
			if (auxCarrito.gettFactura().getIdCliente() < 0) {
				gui.getVistaGeneralAux().getFailureDialgFactura(auxCarrito).actualizar(auxCarrito, null);
			} else
				gui.getVistaFactura().getVista_AbrirFacturaOk(auxCarrito);
			break;
		case ECerrarFactura:
			auxCarrito = FactoriaSAImp.obtenerInstancia().generarSAFactura().cerrarVenta((TCarrito) Obj);
			if (auxCarrito.gettFactura().getIdCliente() < 0) {
				gui.getVistaGeneralAux().getFailureDialgFactura(auxCarrito).actualizar(auxCarrito, null);
			} else
				gui.getVistaGeneralAux().getConfirmDialogMostrarFactura()
						.actualizar(auxCarrito.gettFactura().toString(), null);
			break;
		default:
			gui.getVistaGeneralAux().getVistaGeneral();
			break;

		}
	}

}