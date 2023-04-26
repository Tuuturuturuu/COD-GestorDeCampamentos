package Negocio.Personal;

import java.util.HashSet;
import java.util.Set;

import Integracion.Actividad.DAOActividad;
import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Integracion.Personal.DAOPersonal;
import Integracion.Turno.DAOTurno;
import Negocio.Actividad.TActividad;
import Negocio.ComprobacionesRequisitosBBDD.ComprobacionesRequisitosBBDD_IMP;
import Negocio.Turno.TTurno;

public class SAPersonalImp implements SAPersonal {
	private DAOPersonal daoPersonal = FactoriaIntegracionImp.obtenerInstancia().generaDAOPersonal();
	private ComprobacionesRequisitosBBDD_IMP compr = (ComprobacionesRequisitosBBDD_IMP) ComprobacionesRequisitosBBDD_IMP
			.getComprobacionesRequisitosBBDD();
	private DAOTurno daoTurno = FactoriaIntegracionImp.obtenerInstancia().generaDAOTurno();
	private DAOActividad daoActividad = FactoriaIntegracionImp.obtenerInstancia().generaDAOActividad();
	

	@Override
	public TPersonal crearPersonal(TPersonal tPersonal) {
		TPersonal bbddPersona = null;
		TTurno tTurno = daoTurno.MostrarTurno(tPersonal.getIdTurno());
			
		if (tPersonal.getNombre().isEmpty() || tPersonal.getDNI().isEmpty() || tPersonal.getIdTurno() == 0)
			tPersonal.setIdPersonal(-37);
		else if ((tTurno.getIdTurno() < 0))
			tPersonal.setIdPersonal(-1);
		else if (!tTurno.getActivo())
			tPersonal.setIdPersonal(-34);
		else if (tPersonal.getIdPersonal() < 0) {
			return tPersonal;
		} else {
			if (!compr.dniValido(tPersonal.getDNI()) && tPersonal.getIdPersonal() == 0 )
				tPersonal.setIdPersonal(-32);
			
			if (!compr.nombreValido(tPersonal.getNombre()) && tPersonal.getIdPersonal() == 0)
				tPersonal.setIdPersonal(-9);
			
			if(!compr.checkString(tPersonal.getNombre()))
				tPersonal.setIdPersonal(-38);
			
			if (tPersonal.getIdPersonal() == 0){
				if (tPersonal.getTipo() == 0) {// Monitor
					if (((TPersonalMonitor) tPersonal).getEspecialidad().isEmpty() || ((TPersonalMonitor) tPersonal).getEstudios().isEmpty())
						tPersonal.setIdPersonal(-37);
					else if (!compr.nombreValido(((TPersonalMonitor) tPersonal).getEspecialidad()))
						tPersonal.setIdPersonal(-16);
					else if(!compr.checkString(((TPersonalMonitor) tPersonal).getEspecialidad()))
						tPersonal.setIdPersonal(-38);
					else if(!compr.nombreValido(((TPersonalMonitor) tPersonal).getEstudios()))
						tPersonal.setIdPersonal(-17);
					else if(!compr.checkString(((TPersonalMonitor) tPersonal).getEstudios()))
						tPersonal.setIdPersonal(-38);
					}
					else {
						bbddPersona = new TPersonalMonitor();
						bbddPersona.setIdPersonal(tPersonal.getIdPersonal());
						bbddPersona.setDNI(tPersonal.getDNI());
					}
				} else if(tPersonal.getTipo() == 1){ // Cocinero
					if (((TPersonalCocinero) tPersonal).getPuestoEnCocina().isEmpty() || ((TPersonalCocinero) tPersonal).getAniosExperiencia() == 0)
						tPersonal.setIdPersonal(-37);
					else if (!compr.nombreValido(((TPersonalCocinero) tPersonal).getPuestoEnCocina()))
						tPersonal.setIdPersonal(-18);
					else if(!compr.checkString(((TPersonalCocinero) tPersonal).getPuestoEnCocina()))
						tPersonal.setIdPersonal(-38);
					else if (!compr.aniosExp(((TPersonalCocinero) tPersonal).getAniosExperiencia()))
						tPersonal.setIdPersonal(-19);
					else {
						bbddPersona = new TPersonalCocinero();
						bbddPersona.setIdPersonal(tPersonal.getIdPersonal());
					}
				}
		}
		if(tPersonal.getIdPersonal() == 0 && bbddPersona.getIdPersonal() == 0){
			TPersonal aux = daoPersonal.buscarPorDNI(bbddPersona);
				if (aux.getIdPersonal() != -1){ 					// Se ha encontrado una persona con ese DNI en la bbdd
					if(aux.getIsActivo() == true)
						tPersonal.setIdPersonal(-38);
					else
						tPersonal.setIdPersonal(daoPersonal.activar(aux.getIdPersonal()));
				}else if (tPersonal.getIdPersonal() == 0)
					tPersonal = daoPersonal.CrearPersonal(tPersonal);
		}
		return tPersonal;
	}

	@Override
	public TPersonal eliminarPersonal(TPersonal tPersonal) {
		TPersonal p = daoPersonal.MostrarUno(tPersonal.getIdPersonal());
		Set<TActividad> actividadesPersonal = new HashSet<TActividad>();
		
		if (p.getIdPersonal() < 0 || !p.getIsActivo()) {
			p.setIdPersonal(-5);

		} else {
			actividadesPersonal = daoActividad.mostrarActividadesActivasporPersonal(p.getIdPersonal());
			if(actividadesPersonal.isEmpty()){ 
				p = daoPersonal.EliminarPersonal(p);
			}else //Si hay personal con ese turno, envio error indicando que no puede eliminarlo
				p.setIdPersonal(-35);
		}
		return p;
	}

	@Override
	public TPersonal modificarPersonal(TPersonal tPersonal) {
		TPersonal tPersonalBBDD = new TPersonal();
		//Buscar que existe el personal con dicho id en la BBDD
		tPersonalBBDD = daoPersonal.MostrarUno(tPersonal.getIdPersonal());
		
		TTurno tTurno = daoTurno.MostrarTurno(tPersonal.getIdTurno());

		// si no ha encontrado el personal a modificar no se le puede cambiar el
		// nombre
		if (tPersonalBBDD.getIdPersonal() == -1)
			tPersonal.setIdPersonal(-1);
		else{
			// no esta activo
			if (tPersonalBBDD.getIsActivo() == false)
				tPersonal.setIdPersonal(-28);
		}
		//Se pone el campo DNI con su valor original
		if (tPersonal.getDNI().equals("") && tPersonal.getIdPersonal() > 0) {
			// los campos modificables que vengan en nulo los rellenamos con los
			// valores de bbdd
			tPersonal.setDNI(tPersonalBBDD.getDNI());
		} 
		else if(!compr.dniValido(tPersonal.getDNI()))
			tPersonal.setIdPersonal(-38);
		//Se pone el campo TipoPersonal con su valor original
		if (tPersonal.getTipo() == 0 && tPersonal.getIdPersonal() > 0) {
			// los campos modificables que vengan en nulo los rellenamos con los
			// valores de bbdd
			tPersonal.setTipo(tPersonalBBDD.getTipo());
		} 
		
		// se quiere cambiar el nombre
		if (tPersonal.getNombre().equals("") && tPersonal.getIdPersonal() > 0) {
			// los campos modificables que vengan en nulo los rellenamos con los
			// valores de bbdd
			tPersonal.setNombre(tPersonalBBDD.getNombre());
		} else if (tPersonal.getIdPersonal() > 0) {
			if (!compr.nombreValido(tPersonal.getNombre()))
				tPersonal.setIdPersonal(-2);
			else if(!compr.checkString(tPersonal.getNombre()))
				tPersonal.setIdPersonal(-38);
		}		
		
		// se quiere cambiar idTurno Y DEBERIAMOS COMPROBAR QUE ID DE Turno EXISTA EN LA BASE DE DATOS
		
		if ((tTurno.getIdTurno() < 0))
			tPersonal.setIdPersonal(-1);
		if (!tTurno.getActivo())
			tPersonal.setIdPersonal(-34);
		if (tPersonal.getIdPersonal() > 0)
			tPersonal.setIdTurno(tPersonalBBDD.getIdTurno());

		// si no ha habido ningun codigo de error puede modificarse.
		if (tPersonal.getIdPersonal()> 0) {
			tPersonal = daoPersonal.ModificarPersonal(tPersonal);
		}
		return tPersonal;		
	}

	@Override
	public TPersonal mostrarUno(TPersonal tPersonal) {
		if( daoPersonal.MostrarUno(tPersonal.getIdPersonal()).getIsActivo() == false )
			tPersonal.setIdPersonal(-5);
				return tPersonal;
	}

	@Override
	public Set<TPersonal> mostrarTodos() {
		return daoPersonal.MostrarTodos();
	}

	@Override
	public Set<TPersonal> mostrarPersonalPorTurno(Integer idTurno) {
		Set<TPersonal> Personal = new HashSet<TPersonal>();
		 
		//Comprobar que el Turno existe y esta activo
				//Buscar las actividades de dicho personal
		Personal = daoPersonal.MostrarPersonalPorTurno(idTurno);
	
		// TODO Auto-generated method stub
		return Personal;
	}

	
}