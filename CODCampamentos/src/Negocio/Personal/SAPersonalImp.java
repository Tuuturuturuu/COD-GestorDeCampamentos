package Negocio.Personal;

import java.util.Set;

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
	

	@Override
	public TPersonal crearPersonal(TPersonal tPersonal) {
		TPersonal bbddPersona = null;

	//	TTurno tTurno = daoTurno.MostrarTurno(tPersonal.getIdTurno());
				
		/*if ((tTurno.getIdTurno() < 0) || (!tTurno.getActivo())){
			tPersonal.setIdPersonal(-1);
		}*/
		if (tPersonal.getIdPersonal() < 0) {
			return tPersonal;
		} else {
			if (!compr.dniValido(tPersonal.getDNI()) && tPersonal.getIdPersonal() == 0 ){
				tPersonal.setIdPersonal(-1);
			}
			if (!compr.nombreValido(tPersonal.getNombre()) && tPersonal.getIdPersonal() == 0)
				tPersonal.setIdPersonal(-9);

			if (tPersonal.getIdPersonal() == 0)
				if (tPersonal.getTipo() == 0) {// Monitor
					if (!compr.nombreValido(((TPersonalMonitor) tPersonal).getEspecialidad()))
						tPersonal.setIdPersonal(-16);
					if(!compr.nombreValido(((TPersonalMonitor) tPersonal).getEstudios())){
						tPersonal.setIdPersonal(-17);
					}
					else {
						bbddPersona = new TPersonalMonitor();
						bbddPersona.setIdPersonal(tPersonal.getIdPersonal());
					}
				} else { // Cocinero
					if (!compr.nombreValido(((TPersonalCocinero) tPersonal).getPuestoEnCocina()))
						tPersonal.setIdPersonal(-18);
					if (!compr.aniosExp(((TPersonalCocinero) tPersonal).getAniosExperiencia()))
						tPersonal.setIdPersonal(-19);
					else {
						bbddPersona = new TPersonalCocinero();
						bbddPersona.setIdPersonal(tPersonal.getIdPersonal());
					}
				}
		}
		if(tPersonal.getIdPersonal() == 0)
			if (bbddPersona.getIdPersonal() < 0)
				if (daoPersonal.buscarPorDNI(bbddPersona).getDNI()
						.equalsIgnoreCase(tPersonal.getDNI()))
					tPersonal.setIdPersonal(-4);

		if (tPersonal.getIdPersonal() == 0)
			tPersonal = daoPersonal.CrearPersonal(tPersonal);
		return tPersonal;
	}

	@Override
	public TPersonal eliminarPersonal(TPersonal tPersonal) {
		TPersonal persona = daoPersonal.MostrarUno(tPersonal.getIdPersonal());
		if (persona.getIdPersonal() < 0 || !persona.getIsActivo()) {
			persona.setIdPersonal(-5);

		} else {
			daoPersonal.EliminarPersonal(persona);
		}
		return persona;
	}

	@Override
	public TPersonal modificarPersonal(TPersonal tPersonal) {
		TPersonal tPersonalBBDD = new TPersonal();
		//Buscar que existe el personal con dicho id en la BBDD
		tPersonalBBDD = daoPersonal.MostrarUno(tPersonal.getIdPersonal());

		// si no ha encontrado el personal a modificar no se le puede cambiar el
		// nombre
		if (tPersonalBBDD.getIdPersonal() == -1)
			tPersonal.setIdPersonal(-1);
		else{
			// no esta activo
			if (tPersonalBBDD.getIsActivo() == false)
				tPersonal.setIdPersonal(-5);
		}
		//Se pone el campo DNI con su valor original
		if (tPersonal.getDNI().equals("") && tPersonal.getIdPersonal() > 0) {
			// los campos modificables que vengan en nulo los rellenamos con los
			// valores de bbdd
			tPersonal.setDNI(tPersonalBBDD.getDNI());
		} 
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
		}		
		
		// se quiere cambiar idTurno Y DEBERIAMOS COMPROBAR QUE ID DE Turno EXISTA EN LA BASE DE DATOS
		if (tPersonal.getIdTurno() != 0 && tPersonal.getIdPersonal() > 0 ) {
			//Aqui debemos usar el Dao de turno para ver si existe el TURNO
			//if (daoPersonal.MostrarUno(tActividad.getIdPersonal()).getIdPersonal() == -1) //Comprobar que el id de Personal existe
				//tActividad.setIdActividad(-9);
		} else if (tPersonal.getIdPersonal() > 0)
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
	public Set<TPersonal> mostrarPersonalPorTurno(TTurno turno) {
		// TODO Auto-generated method stub
		return null;
	}

	
}