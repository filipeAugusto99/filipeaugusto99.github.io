package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Conexao {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = 	"";
	
	private static final String DATABASE_URL =  "jdbc:mysql://localhost:3306/pizzaria";
	
	public static Connection createConnectionToMySql() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn = createConnectionToMySql();
		
		if (conn != null) {
			System.out.println("Conexao Sucesso");
			conn.close();
		}
		
	}
	
}
