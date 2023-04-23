/**
 * 
 */
package Negocio.Turno;

import java.util.Set;
import Integracion.Turno.DAOTurno;
import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Negocio.ComprobacionesRequisitosBBDD.ComprobacionesRequisitosBBDD_IMP;

public class SATurnoImp implements SATurno {
	
	private ComprobacionesRequisitosBBDD_IMP compr = (ComprobacionesRequisitosBBDD_IMP) ComprobacionesRequisitosBBDD_IMP.getComprobacionesRequisitosBBDD();
	private DAOTurno daoTurnos = FactoriaIntegracionImp.obtenerInstancia().generaDAOTurno();
	
	public TTurno crearTurno(TTurno tTurno) {
		TTurno turnoBBDD = new TTurno();
		if(!compr.nombreValido(tTurno.getNombre())){
			tTurno.setId(-2);
		}
		else{
			//turnoBBDD = daoTurnos.buscarPorNombre(tTurno);
			if(turnoBBDD.getId() != -1){
				if(turnoBBDD.getActivo() == true){
					tTurno.setId(-4);
				}
				else{
					tTurno.setId(-6);
				}
			}
			else{
				//tTurno = daoTurnos.CrearTurno(tTurno);
			}
		}
		return tTurno;
	}

	public Integer ModificarTurno(TTurno tTurno) {
		
		return null;
	}
	
	//LA CABECERA ESTABA CON INTEGER IDTURNO PERO LO HE CAMBIADO 
	public Integer BorrarTurno(TTurno tTurno) {
		TTurno turno = daoTurnos.MostrarTurno(tTurno.getId());
		if((turno.getId() < 0) || (!turno.getActivo())){
			turno.setId(-5);
		}
		else{
			daoTurnos.EliminarTurno(turno);
		}
		return daoTurnos.EliminarTurno(turno);
	}

	//LA CABECERA ESTABA CON INTEGER IDTURNO PERO LO HE CAMBIADO 
	public TTurno MostrarTurno(TTurno tTurno) {
		return daoTurnos.MostrarTurno(tTurno.getId());
		
	}


	public Set<TTurno> MostrarTurnos() {
		return daoTurnos.MostrarAllTurnos();
	}
}