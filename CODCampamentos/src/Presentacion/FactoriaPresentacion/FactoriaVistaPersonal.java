package Presentacion.FactoriaPresentacion;

import java.util.Set;

import Negocio.Personal.TPersonal;
import Negocio.Personal.TPersonalCocinero;
import Negocio.Personal.TPersonalMonitor;
import Presentacion.Personal.VPersonal;
import Presentacion.Personal.VAltaPersonal.VAltaPersonal;
import Presentacion.Personal.VAltaPersonalCocinero.VAltaPersonalCocinero;
import Presentacion.Personal.VAltaPersonalMonitor.VAltaPersonalMonitor;
import Presentacion.Personal.VBajaPersonal.VBajaPersonal;
import Presentacion.Personal.VModificarPersonal.VModificarPersonal;
import Presentacion.Personal.VMostrarPersonalPorTurno.VMostrarPersonalPorTurno;
import Presentacion.Personal.VMostrarPersonalPorTurno.VMostrarPersonalPorTurnoOK;
import Presentacion.Personal.VMostrarTodos.VMostrarTodos;
import Presentacion.Personal.VMostrarUno.VMostrarUno;

public interface FactoriaVistaPersonal {

	VAltaPersonal getVista_AltaPersonal();
	
	VAltaPersonalCocinero getVista_AltaCocinero(TPersonalCocinero tCocinero);
	
	VAltaPersonalMonitor getVista_Altamonitor(TPersonalMonitor tMonitor);

	VBajaPersonal getVista_BajaPersonal();

	VModificarPersonal getVista_ModificarPersonal();

	VMostrarUno getVista_MostrarPersonal();

	VMostrarTodos getVista_MostrarTodosPersonal(Set<TPersonal> listaPersonal);
	
	VMostrarPersonalPorTurno getVista_MostrarPersonalPorTurno();
	
	VMostrarPersonalPorTurnoOK getVista_MostrarPersonalPorTurnoOK(Set<TPersonal> listaPersonal);

	VPersonal getVista_VistaPersonalGeneral();
}
