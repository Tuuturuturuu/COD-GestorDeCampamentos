/**
 * 
 */
package Negocio.Turno;

import java.util.HashSet;
import java.util.Set;

import Integracion.FactoriaIntegracion.FactoriaIntegracionImp;
import Integracion.Personal.DAOPersonal;
import Integracion.Turno.DAOTurno;
import Negocio.ComprobacionesRequisitosBBDD.ComprobacionesRequisitosBBDD_IMP;
import Negocio.Personal.TPersonal;

public class SATurnoImp implements SATurno {

	private ComprobacionesRequisitosBBDD_IMP compr = (ComprobacionesRequisitosBBDD_IMP) ComprobacionesRequisitosBBDD_IMP
			.getComprobacionesRequisitosBBDD();
	private DAOTurno daoTurno = FactoriaIntegracionImp.obtenerInstancia().generaDAOTurno();
	private DAOPersonal daoPersonal = FactoriaIntegracionImp.obtenerInstancia().generaDAOPersonal();

	public TTurno crearTurno(TTurno tTurno) {
		TTurno tTurnoBBDD = new TTurno();
		if (tTurno.getIdTurno() >= 0) {
			if (tTurno.getNombreTurno().isEmpty())
				tTurno.setIdTurno(-37);
			else if (!compr.nombreValido(tTurno.getNombreTurno()))
				tTurno.setIdTurno(-2); // Faltan comprobaciones
			else if (!compr.checkString(tTurno.getNombreTurno()))
				tTurno.setIdTurno(-38);
			else {
				// Comprobar que el nombre no esta repetido
				tTurnoBBDD = daoTurno.BuscarTurnoPorNombre(tTurno.getNombreTurno());
				if (tTurnoBBDD.getIdTurno() != -1) {// encontrado en bbdd
					if (tTurnoBBDD.getActivo() == true)
						tTurno.setIdTurno(-30);// ERROR: ya esta activo
					else {
						Integer correct = daoTurno.activar(tTurnoBBDD.getIdTurno());
						tTurno.setIdTurno(correct);
					}
				} else {
					tTurno = daoTurno.CrearTurno(tTurno);
				}
			}
		}
		return tTurno;
	}

	public TTurno ModificarTurno(TTurno tTurno) {
		if (tTurno.getIdTurno() >= 0) {

			TTurno tTurnoBBDD = new TTurno();
			TTurno tTurnoBBDDNombre = new TTurno();
			tTurnoBBDD = daoTurno.MostrarTurno(tTurno.getIdTurno());
			// Comprobar que existe el turno en BBDD
			if (tTurnoBBDD.getIdTurno() == -1)
				tTurno.setIdTurno(-1);
			else {
				// no esta activo
				if (tTurnoBBDD.getActivo() == false)
					tTurno.setIdTurno(-5);
			}

			// Comprobamos que el campo hora no esta vacio
			// En caso de estarlo le ponemos el de la base de datos
			if (tTurno.getHora().equals("") && tTurno.getIdTurno() > 0) {
				// los campos modificables que vengan en nulo los rellenamos con
				// los
				// valores de bbdd
				tTurno.setHora(tTurnoBBDD.getHora());
			} else if (tTurno.getNombreTurno().equals("") && tTurno.getIdTurno() > 0) {
				// Cambiar el nombre del turno
				// los campos modificables que vengan en nulo los rellenamos con
				// los
				// valores de bbdd
				tTurno.setNombreTurno(tTurnoBBDD.getNombreTurno());
			} else if (tTurno.getIdTurno() > 0) {
				// Comprobar que el nombre ha sido escrito correctamente
				if (!compr.nombreValido(tTurno.getNombreTurno()))
					tTurno.setIdTurno(-52);
				if (!compr.checkString(tTurno.getNombreTurno()))
					tTurno.setIdTurno(-38);
				else

				{// Comprobar que el nombre no es repetido
					tTurnoBBDDNombre = daoTurno.BuscarTurnoPorNombre(tTurno.getNombreTurno());
					if (tTurnoBBDDNombre.getIdTurno() != -1) // encontrado en
																// bbdd un turno
																// con mismo
																// nombre
						tTurno.setIdTurno(-29);
				}
			}

			// No ha habido ningun error, entonces procede a modificar
			if (tTurno.getIdTurno() > 0) {
				tTurno = daoTurno.ModificarTurno(tTurno);
			}
		}

		return tTurno;
	}

	public TTurno BorrarTurno(TTurno tTurno) { // Baja turno
		Integer idTurno = tTurno.getIdTurno();
		TTurno tTurnoBBDD = new TTurno();
		Set<TPersonal> PersonalTurno = new HashSet<TPersonal>();
		tTurnoBBDD = daoTurno.MostrarTurno(idTurno);

		// Comprobamos para el caso de que ingresen datos incorrectos en el
		// integer
		if (tTurno.getIdTurno() >= 0) {
			if (tTurno.getIdTurno() == 0)
				tTurnoBBDD.setIdTurno(-37);
			else {
				// Comprobar que el id Turno existe
				if (tTurnoBBDD.getIdTurno() != -1) {
					// Comprobar que no este desactivado
					if (tTurnoBBDD.getActivo() == true) {
						// Comprobar que no haya personales con ese turno
						PersonalTurno = daoPersonal.MostrarPersonalActivoPorTurno(idTurno);
						if (PersonalTurno.isEmpty()) {
							// Si no hay personal con el turno, entonces puedo
							// dar de
							// baja
							tTurnoBBDD.setIdTurno(idTurno);
							tTurnoBBDD = daoTurno.EliminarTurno(tTurnoBBDD);
						} else // Si hay personal con ese turno, envio error
								// indicando
								// que no puede eliminarlo
							tTurnoBBDD.setIdTurno(-31);
					} else {
						tTurnoBBDD.setIdTurno(-5);
					}
				}
			}
		}

		return tTurnoBBDD;
	}

	public TTurno MostrarTurno(TTurno tTurno) {

		TTurno tTurnoBBDD = daoTurno.MostrarTurno(tTurno.getIdTurno());
		if (tTurnoBBDD.getIdTurno() != -1) {
			if (tTurnoBBDD.getActivo() == false)
				tTurnoBBDD.setIdTurno(-5);
		}

		return tTurnoBBDD;
	}

	public Set<TTurno> MostrarTurnos() {
		return daoTurno.MostrarAllTurnos();
	}
}