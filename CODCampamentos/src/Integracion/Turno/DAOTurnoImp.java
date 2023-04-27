/**
 * 
 */
package Integracion.Turno;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import Integracion.Connection.ConnectorBD;
import Negocio.Turno.TTurno;

public class DAOTurnoImp implements DAOTurno {
	public TTurno CrearTurno(TTurno tTurno) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement(
					"INSERT INTO Turno ( NombreTurno, Fecha, Hora, Activo) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE Activo = ?",
					PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, tTurno.getNombreTurno());
			ps.setDate(2, new java.sql.Date(tTurno.getFecha().getTime()));
			ps.setString(3, tTurno.getHora());
			ps.setBoolean(4, tTurno.getActivo());
			ps.setBoolean(5, tTurno.getActivo());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next())
				tTurno.setIdTurno(rs.getInt(1));

			rs.close();
			ps.close();
			conexion.close();
			// cerrar conexion y tratar excepciones
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tTurno;
	}

	public TTurno EliminarTurno(TTurno tTurno) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement("UPDATE Turno SET Activo = ? WHERE IdTurno = ?",
					Statement.RETURN_GENERATED_KEYS);
			tTurno.setActivo(false);
			ps.setBoolean(1, tTurno.getActivo());
			ps.setInt(2, tTurno.getIdTurno());
			int result = ps.executeUpdate();
			if (result < 1)
				tTurno.setIdTurno(-15);
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tTurno;
	}

	public TTurno ModificarTurno(TTurno tTurno) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement("UPDATE Turno SET NombreTurno = ?, Fecha = ?, Hora = ?, WHERE IdTurno = ? ",
					Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, tTurno.getNombreTurno());
			ps.setDate(2, new java.sql.Date(tTurno.getFecha().getTime()));
			ps.setString(3, tTurno.getHora());
			ps.setInt(4, tTurno.getIdTurno());
			ps.executeUpdate();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tTurno;
	}

	public TTurno MostrarTurno(Integer idTurno) {
		TTurno tturno = new TTurno();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM Turno WHERE IdTurno = ?");
			ps.setInt(1, idTurno);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				tturno.setIdTurno(rs.getInt(1));
				tturno.setNombreTurno(rs.getString(2));
				tturno.setFecha(rs.getDate(3));
				tturno.setHora(rs.getString(4));
				tturno.setActivo(rs.getBoolean(5));
			} else {
				tturno.setIdTurno(-1);
			}
			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return tturno;
	}

	public Set<TTurno> MostrarAllTurnos() {
		Set<TTurno> Turnos = new HashSet<TTurno>();
		TTurno e;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM Turno");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new TTurno(rs.getInt("IdTurno"), rs.getString("NombreTurno"), rs.getDate("Fecha"),
						rs.getString("Hora"), rs.getBoolean("Activo"));
				Turnos.add(e);
			}
			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return Turnos;
	}

	@Override
	public TTurno BuscarTurnoPorNombre(String NombreTurno) {
		TTurno tTurno = new TTurno();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM Turno WHERE NombreTurno = ?");
			ps.setString(1, NombreTurno);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				tTurno.setIdTurno(rs.getInt(1));
				tTurno.setNombreTurno(rs.getString(2));
				tTurno.setFecha(rs.getDate(3));
				tTurno.setHora(rs.getString(4));
				tTurno.setActivo(rs.getBoolean(5));
			} else {
				tTurno.setIdTurno(-1);
			}
			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tTurno;
	}

	@Override
	public Integer activar(Integer IdTurno) {
		Integer correcto = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement("UPDATE Turno SET Activo = 1 WHERE IdTurno = ? ",
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, IdTurno);
			ps.executeUpdate();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return correcto;
	}
}