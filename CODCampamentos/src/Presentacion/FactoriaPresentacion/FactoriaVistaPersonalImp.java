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

public class FactoriaVistaPersonalImp implements FactoriaVistaPersonal {
	@Override
	public VAltaPersonal getVista_AltaPersonal() {

		return new VAltaPersonal();
	}

	@Override
	public VBajaPersonal getVista_BajaPersonal() {

		return new VBajaPersonal();
	}

	@Override
	public VModificarPersonal getVista_ModificarPersonal() {

		return new VModificarPersonal();
	}

	@Override
	public VMostrarUno getVista_MostrarPersonal() {

		return new VMostrarUno();
	}

	@Override
	public VMostrarTodos getVista_MostrarTodosPersonal(Set<TPersonal> listaPersonal) {

		return new VMostrarTodos(listaPersonal);
	}

	@Override
	public VPersonal getVista_VistaPersonalGeneral() {

		return new VPersonal();
	}

	@Override
	public VAltaPersonalCocinero getVista_AltaCocinero(TPersonalCocinero tCocinero) {
				return new VAltaPersonalCocinero(tCocinero);
	}

	@Override
	public VAltaPersonalMonitor getVista_Altamonitor(TPersonalMonitor tMonitor) {
				return new VAltaPersonalMonitor(tMonitor);
	}

	@Override
	public VMostrarPersonalPorTurno getVista_MostrarPersonalPorTurno() {
		// TODO Auto-generated method stub
		return new VMostrarPersonalPorTurno();
	}

	@Override
	public VMostrarPersonalPorTurnoOK getVista_MostrarPersonalPorTurnoOK(Set<TPersonal> listaPersonal) {
		// TODO Auto-generated method stub
		return new VMostrarPersonalPorTurnoOK(listaPersonal) ;
	}

	
}
