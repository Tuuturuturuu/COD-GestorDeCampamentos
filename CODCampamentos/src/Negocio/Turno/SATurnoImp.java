/**
 * 
 */
package Negocio.Turno;

import java.util.Set;

import Integracion.Turno.DAOTurno;
import Integracion.Actividad.DAOActividad;
import Integracion.FactoriaIntegracion.FactoriaIntegracion;
import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Negocio.ComprobacionesRequisitosBBDD.ComprobacionesRequisitosBBDD_IMP;


public class SATurnoImp implements SATurno {
	
	private ComprobacionesRequisitosBBDD_IMP compr = (ComprobacionesRequisitosBBDD_IMP) ComprobacionesRequisitosBBDD_IMP
			.getComprobacionesRequisitosBBDD();
	private DAOTurno daoTurno = FactoriaIntegracionImp.obtenerInstancia().generaDAOTurno();
	
	
	
	
	//CONTINUAR A APARTIR DE AQUI
	
	
	public Integer crearTurno(TTurno tTurno) {
		
		TTurno turnoBBDD = new TTurno();
		Integer idTurno;
		if(!compr.nombreValido(tTurno.getNombre())){
			
		}
		return null;
		// end-user-code
	}

	
	public Integer ModificarTurno(TTurno tTurno) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	
	public Integer BorrarTurno(Integer idTurno) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	
	public TTurno MostrarTurno(Integer idTurno) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Set<TTurno> MostrarTurnos() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}