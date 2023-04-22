/**
 * 
 */
package Integracion.Personal;

import Negocio.Personal.TPersonal;
import Negocio.Personal.TPersonalCocinero;
import Negocio.Personal.TPersonalMonitor;
import Negocio.Turno.TTurno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import Integracion.Connection.ConnectorBD;

public class DAOPersonalImp implements DAOPersonal {

	@SuppressWarnings("resource")
	@Override
	public TPersonal CrearPersonal(TPersonal tPersonal) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement(
					"INSERT INTO Personal (DNI, Nombre, TipoPersonal, IdTurno, Activo) VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE activo = ?",
					PreparedStatement.RETURN_GENERATED_KEYS);
			// ON DUPLICATE KEY UPDATE activo = ? lo que hace es que si ya
			// existe el ID pone el empleado activo. (ya se ha comprobado en
			// negocio q este inactivo)

			ps.setString(1, tPersonal.getDNI());
			ps.setString(2, tPersonal.getNombre());
			ps.setDouble(3, tPersonal.getTipo());
			ps.setInt(4, tPersonal.getIdTurno());
			ps.setBoolean(5, tPersonal.getIsActivo());
			ps.setBoolean(6, tPersonal.getIsActivo());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next())
				tPersonal.setIdPersonal(rs.getInt(1));

			if (tPersonal.getTipo() == 0) {
				ps = conexion.prepareStatement("INSERT INTO Monitores (idPersonal, especialidad, estudios) VALUES (?,?,?)");
				ps.setInt(1, tPersonal.getIdPersonal());
				ps.setString(2, ((TPersonalMonitor) tPersonal).getEspecialidad());
				ps.setString(3, ((TPersonalMonitor) tPersonal).getEstudios());
				ps.executeUpdate();

			} else {
				ps = conexion.prepareStatement("INSERT INTO Cocineros (idPersonal, puesto, experiencia) VALUES (?,?,?)");
				ps.setInt(1, tPersonal.getIdPersonal());
				ps.setString(2, ((TPersonalCocinero) tPersonal).getPuestoEnCocina());
				ps.setInt(2, ((TPersonalCocinero) tPersonal).getAniosExperiencia());
				ps.executeUpdate();
				ps.close();

			}

			rs.close();
			ps.close();
			conexion.close();
			// cerrar conexion y tratar excepciones
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tPersonal;
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
				tPersonal.setTipo(rs.getInt(4));
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
		Set<TPersonal> personal = new HashSet<TPersonal>();
		TPersonal e;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement psl;
			psl = conexion.prepareStatement(
					"Select Personal.IdPersonal,DNI,Nombre,TipoPersonal,IdTurno,Activo,especialidad,estudios From Personal, Monitores Where Personal.IdPersonal = Monitores.IdPersonal");
			ResultSet rsl = psl.executeQuery();
			while (rsl.next()) {
				e = new TPersonalMonitor(rsl.getInt("IdPersonal"), rsl.getString("DNI"), rsl.getString("Nombre"),
						rsl.getInt("TipoPersonal"), rsl.getInt("IdTurno"), rsl.getBoolean("Activo"),
						rsl.getString("especialidad"), rsl.getString("estudios"));
				personal.add(e);
			}
			rsl.close();
			psl.close();

			PreparedStatement psg = conexion.prepareStatement(
					"Select Personal.IdPersonal,DNI,Nombre,TipoPersonal,IdTurno,Activo,puesto,experiencia From Personal, Cocineros Where Personal.IdPersonal = Cocineros.IdPersonal");
			ResultSet rsg = psg.executeQuery();
			while (rsg.next()) {
				e = new TPersonalCocinero(rsl.getInt("IdPersonal"), rsl.getString("DNI"), rsl.getString("Nombre"),
						rsl.getInt("TipoPersonal"), rsl.getInt("IdTurno"), rsl.getBoolean("Activo"),
						rsl.getString("puesto"), rsl.getInt("experiencia"));
				personal.add(e);
			}
			rsg.close();
			psg.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return personal;
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

	@Override
	public TPersonal buscarPorDNI(TPersonal tPersonal) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM Personal WHERE DNI = ? ");
			ps.setString(1, tPersonal.getDNI());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				tPersonal.setDNI(rs.getString(1));
				tPersonal.setNombre(rs.getString(2));
				tPersonal.setTipo(rs.getInt(3));
				tPersonal.setIdTurno(rs.getInt(4));
				tPersonal.setActivo(rs.getBoolean(7));
			} else
				tPersonal.setIdPersonal(-1);
			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tPersonal;
	}

}