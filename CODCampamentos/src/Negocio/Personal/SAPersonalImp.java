package Negocio.Personal;

import java.util.Set;

import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Integracion.Personal.DAOPersonal;
import Integracion.Turno.DAOTurno;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TPersonal modificarPersonal(TPersonal tPersonal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TPersonal mostrarUno(TPersonal tPersonal) {
		// TODO Auto-generated method stub
		return null;
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