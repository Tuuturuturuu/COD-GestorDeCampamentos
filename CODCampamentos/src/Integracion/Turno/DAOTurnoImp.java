/**
 * 
 */
package Integracion.Turno;

import Negocio.Turno.TTurno;

import java.util.Date;
import java.util.Set;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import Integracion.Connection.ConnectorBD;

public class DAOTurnoImp implements DAOTurno {
	
	public TTurno CrearTurno(TTurno tTurno) {
		
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
				ConnectorBD.password);

		PreparedStatement ps;
		ps = conexion.prepareStatement(
				"INSERT INTO Turno (Nombre, Fecha, Hora, IdTurno, Activo) VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE activo = ?",
				PreparedStatement.RETURN_GENERATED_KEYS);
		
		//CONTINUAR A PARTIR DE AQUI
		
		
		ps.setString(1, tTurno.getNombre());
		ps.setDate(2, tTurno.getFecha());
		ps.setInt(4, tTurno.getId());
		ps.setTime(3, tTurno.getHora());
		
		
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();

		if (rs.next())
			tTurno.setId(rs.getInt(4));

		rs.close();
		ps.close();
		conexion.close();
		// cerrar conexion y tratar excepciones
	} 
	catch (SQLException | ClassNotFoundException ex) {
		ex.printStackTrace();
	}
		return tTurno;
		// end-user-code
}

	
	public Integer EliminarTurno(Integer id) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	
	public Integer ModificarTurno(TTurno tTurno) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	
	public TTurno MostrarTurno(Integer idTurno) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);
			PreparedStatement ps;
			ps = conexion.prepareStatement("SELECT * FROM Actividad WHERE IdTurno = ?");
			ps.setInt(1, );
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				//CAMBIAR ESTO POR LOS ATRIBUTOS E TURNO
				tActividad.setIdActividad(rs.getInt(1));
				tActividad.setNombre(rs.getString(1));
				tActividad.setLugar(rs.getString(3));
				tActividad.setNumplazas(rs.getInt(4));
				tActividad.setPrecio(rs.getFloat(5));
				tActividad.setIdPersonal(rs.getInt(6));
				tActividad.setActivo(rs.getBoolean(7));
			} else
				tTurno.(-1);


			rs.close();
			ps.close();
			conexion.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return tTurno;
		// end-user-code
	}

	public Set<TTurno> MostrarAllTurnos() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public TTurno buscarPorNombre(String nombreTurno) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public void activar() {
		
	}
}