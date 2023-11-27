package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.ModificacionException;
import model.Empleado;

public class EmpleadoService {

	public boolean grabarEmpleado(Empleado e) {
		String cadena = "jdbc:mysql://localhost:3306/empresa";
		String user = "root", pwd = "root";

		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			String sql = "insert into empleados (nombre, email, departamento, salario) " + "values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getNombre());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getDepartamento());
			ps.setDouble(4, e.getSalario());
			ps.execute();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean borrarEmpleado(String email) {
		String cadena = "jdbc:mysql://localhost:3306/empresa";
		String user = "root", pwd = "root";

		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			String sql = "delete from empleados where email = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.execute();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public void actualizarSalario(int id, double salario) throws ModificacionException {
														/* Propaga la excepción al punto de llamada del método (2)
														A partir de aquí JModificaciones da error si no se trata la excepción */
		String cadena = "jdbc:mysql://localhost:3306/empresa";
		String user = "root", pwd = "root";

		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			String sql = "update empleados set salario = ? where idEmpleado = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, salario);
			ps.setInt(2, id);
			ps.execute();
			
		} catch (SQLException ex) {
			// ex.printStackTrace();					// Pa' qué, si ya estamos capturando la excepción.
			String m;
			switch (ex.getErrorCode()) {				// Chorrada ejemplo para personalizar el mensaje.
				case 100:
					m = "error sql de código 100";
					break;
				case 200:
					m = "error sql de código 200";
					break;
				default:
					m = "error no determinado";
			}
			throw new ModificacionException(m);			// Lanza la excepción (1)
		}
	}
}