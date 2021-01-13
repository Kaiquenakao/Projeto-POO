package principal;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CRUD {
	public void adicionar() throws SQLException;
	public void remover() throws SQLException;
	public ResultSet consultar() throws SQLException;
	public void editar() throws SQLException;
}
