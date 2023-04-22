package Presentacion.FactoriaPresentacion;

import java.util.Set;

import Negocio.Personal.TPersonal;
import Presentacion.Personal.VPersonal;
import Presentacion.Personal.VAltaPersonal.VAltaPersonal;
import Presentacion.Personal.VBajaPersonal.VBajaPersonal;
import Presentacion.Personal.VModificarPersonal.VModificarPersonal;
import Presentacion.Personal.VMostrarTodos.VMostrarTodos;
import Presentacion.Personal.VMostrarUno.VMostrarUno;

public interface FactoriaVistaPersonal {

	VAltaPersonal getVista_AltaPersonal();

	VBajaPersonal getVista_BajaPersonal();

	VModificarPersonal getVista_ModificarPersonal();

	VMostrarUno getVista_MostrarPersonal();

	VMostrarTodos getVista_MostrarTodosPersonal(Set<TPersonal> listaPersonal);

	VPersonal getVista_VistaPersonalGeneral();
}
