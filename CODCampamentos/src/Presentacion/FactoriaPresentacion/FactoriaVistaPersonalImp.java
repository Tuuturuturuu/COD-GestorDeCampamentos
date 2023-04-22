package Presentacion.FactoriaPresentacion;

import java.util.Set;


import Negocio.Personal.TPersonal;

import Presentacion.Personal.VPersonal;
import Presentacion.Personal.VAltaPersonal.VAltaPersonal;
import Presentacion.Personal.VBajaPersonal.VBajaPersonal;
import Presentacion.Personal.VModificarPersonal.VModificarPersonal;
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
}
