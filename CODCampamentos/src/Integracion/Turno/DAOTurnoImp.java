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
	
	public Integer CrearTurno(TTurno tTurno) {
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
		ps.setInt(3, tActividad.getNumplazas());
		ps.setString(4, tActividad.getLugar());
		ps.setFloat(5, tActividad.getPrecio());
		ps.setInt(6, tActividad.getIdPersonal());
		ps.setBoolean(7, tActividad.getActivo());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();

		if (rs.next())
			tActividad.setIdActividad(rs.getInt(1));

		rs.close();
		ps.close();
		conexion.close();
		// cerrar conexion y tratar excepciones
	} catch (SQLException | ClassNotFoundException ex) {
		ex.printStackTrace();
	}
		return null;
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
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
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
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}