
package Negocio.Turno;

import java.util.Set;
import Integracion.Turno.DAOTurno;
import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Negocio.ComprobacionesRequisitosBBDD.ComprobacionesRequisitosBBDD_IMP;

import java.sql.Date;
import java.sql.Time;


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
				tTurno = daoTurnos.CrearTurno(tTurno);
			}
		}
		return tTurno;
	}
	

	//
	public TTurno ModificarTurno(TTurno tTurno) {
			
		TTurno tTurnoBBDD= new TTurno();
		
		//EXISTE EN LA BASE DE DATOS
		tTurnoBBDD.setId(tTurnoBBDD.getId());
		tTurnoBBDD= daoTurnos.buscarPorNombre(tTurnoBBDD.getNombre());
		
		if(tTurnoBBDD.getId()==-1){
			tTurno.setId(-1);
		}
		if(tTurnoBBDD.getActivo()==false){
			tTurno.setId(-8);
		}
		
		//CAMBIAR EL NOMBRE
		if(tTurno.getNombre()!=null && tTurno.getId()>0){
			if(!compr.nombreValido(tTurno.getNombre())){
				tTurno.setId(-2);
			}
		}else if (tTurno.getId()>0){
			tTurno.setNombre(tTurnoBBDD.getNombre());
		}
		
		
		//CAMBIAR FECHA
		//AÑADIR EN COMPR LA FUNCION DE FECHA ES VALIDAD
		if(tTurno.getFecha()!=null && tTurno.getId()>0){
			if(!compr.fechaValida(tTurno.getFecha())){
				tTurno.setId(-2);
			}
		}else if (tTurno.getId()>0){
			tTurno.serFecha(tTurnoBBDD.getFecha());
		}
		
		//CAMBIAR HORA
		if(tTurno.getHora()!=null && tTurno.getId()>0){
			if(!compr.horaValida(tTurno.getHora())){
				tTurno.setId(-2);
			}
		}else if (tTurno.getId()>0){
			tTurno.getHora();
		}
		
		
		//SI HA PODIDO MODIFICARSE
		if(tTurno.getId()>0){
			tTurno = daoTurnos.ModificarTurno(tTurno);
		}
	
		return tTurno;
	}
	
	//LA CABECERA ESTABA CON INTEGER IDTURNO PERO LO HE CAMBIADO 
	public TTurno BorrarTurno(TTurno tTurno) {
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