/**
 * 
 */
package Integracion.Personal;

import Negocio.Personal.TPersonal;
import Negocio.Turno.TTurno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import Integracion.Connection.ConnectorBD;

public class DAOPersonalImp implements DAOPersonal {

	@Override
	public TPersonal CrearPersonal(TPersonal tPersonal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TPersonal EliminarPersonal(TPersonal IdPersonal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TPersonal MostrarUno(Integer idPersonal) {
		TPersonal tPersonal = new TPersonal();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM Personal WHERE IdPersonal = ?");
			ps.setInt(1, idPersonal);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				tPersonal.setDNI(rs.getString(1));
				tPersonal.setIdPersonal(rs.getInt(2));
				tPersonal.setNombre(rs.getString(3));
				tPersonal.setTipoPersonal(rs.getString(4));
				tPersonal.setIdTurno(rs.getInt(5));
				tPersonal.setActivo(rs.getBoolean(6));
			} else {
				tPersonal.setIdPersonal(-1);
			}
			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tPersonal;
	}

	@Override
	public Set<TPersonal> MostrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<TPersonal> MostrarPersonalPorTurno(TTurno tTurno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TPersonal ModificarPersonal(TPersonal tPersonal) {
		// TODO Auto-generated method stub
		return null;
	}

}