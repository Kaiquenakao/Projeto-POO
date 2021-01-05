package principal;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD{
	public static java.sql.Connection generateConnection () throws SQLException{
		final String USUARIO = "root";
        final String SENHA = "";
        final String URL = "jdbc:mysql://localhost/loja";
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}

