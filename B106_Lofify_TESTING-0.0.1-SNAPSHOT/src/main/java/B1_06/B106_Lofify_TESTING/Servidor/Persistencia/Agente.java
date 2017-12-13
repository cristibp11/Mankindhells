package B1_06.B106_Lofify_TESTING.Servidor.Persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Agente {
	
	private static Connection conn;

	public Agente() throws ClassNotFoundException, SQLException{
		try{
			if(conn==null){
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conn = DriverManager.getConnection("jdbc:odbc:ruta_de_la_bdd");
			}
		}catch (NullPointerException npe){
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection("jdbc:odbc:ruta_de_la_bdd");
		}
	}

	public ResultSet leer(String sql) throws SQLException {
		PreparedStatement st = conn.prepareStatement(sql);
		return st.executeQuery(sql);
	}

	public int modificar(String sql) throws SQLException {
		PreparedStatement st = conn.prepareStatement(sql);
		return st.executeUpdate();
	}

}
