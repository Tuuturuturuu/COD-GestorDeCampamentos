/**
 * 
 */
package Integracion.Turno;

import Negocio.Turno.TTurno;
import java.util.Set;

import Integracion.Turno.DAOTurno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Set;

import Integracion.Connection.ConnectorBD;

public class DAOTurnoImp implements DAOTurno {
	
	public TTurno CrearTurno(TTurno tTurno) {
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(ConnectorBD.urlBD, ConnectorBD.user,
					ConnectorBD.password);

			PreparedStatement ps;
			ps = conexion.prepareStatement(
					//COMPROBAR TABLA DE LA BASE DE DATOS
					"INSERT INTO Turno (Nombre,Fecha, Hora) VALUES (?,?,?,) ON DUPLICATE KEY UPDATE activo = ?",
					PreparedStatement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, tTurno.getNombre());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = dateFormat.format(tTurno.getFecha());
			ps.setString(2, dateStr);
			
			ps.setTime(3, tTurno.getHora());
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next())
				tTurno.setNombre(rs.getString(1));

			rs.close();
			ps.close();
			conexion.close();
			
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		return tTurno;
			
	}
	
	public TTurno MostrarTurno(Integer idTurno) {	
		return null;
	}

	public Set<TTurno> MostrarAllTurnos() {	
		return null;
	}

	public TTurno buscarPorNombre(String nombreTurno) {	
		return null;
	}

	public void activar() {
		
	}

	public TTurno EliminarTurno(TTurno turno){
		return null;
	}

	public TTurno ModificarTurno(TTurno turno) {
		return null;
	}
}