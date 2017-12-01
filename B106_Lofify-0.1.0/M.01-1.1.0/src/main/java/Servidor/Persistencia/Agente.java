package Servidor.Persistencia;

import java.sql.*;

public class Agente {
	private String driver = "com.mysql.jdbc.Driver";
	private Connection conexion;

	public Agente() {
		conectar(this.driver);
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	/* Metodo que conecta con la base de datos */
	public void conectar(String driver) {

		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/BaseDatos", "root", "root");
			System.out.println("Ha conectado con la base de datos");

		} catch (Exception e) {
			System.out.println("Error al conectar con la base de datos");

		}
	}

	public ResultSet leer(String sql) throws SQLException {
		PreparedStatement st = conexion.prepareStatement(sql);
		return st.executeQuery(sql);
	}

	public int modificar(String sql) throws SQLException {
		PreparedStatement st = conexion.prepareStatement(sql);
		return st.executeUpdate();
	}

}