package principal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;



public class Venda{
	private int codnota;
	private String codfunc;
	private String codcli;

	public Venda() {
		super();
	}
	
	public Venda(String codfunc, String codcli) {
		this.codfunc = codfunc;
		this.codcli = codcli;
	}

	public void adicionar(ArrayList<String> listaProdutos, ArrayList<Float> listaPrecos) throws SQLException {
		java.sql.Connection conn = ConexaoBD.generateConnection();
		if(listaProdutos.size() != listaPrecos.size() || listaProdutos.size() == 0) {
			JOptionPane.showMessageDialog(null, "Dados inválidos");
			return;
		}

		String query = "insert into venda(codnota, codfunc, codcli) values('" + getCodnota() + "','" + getCodfunc() + "','" + getCodcli() + "')";
		
		Statement stmt = null;
		ResultSet rs = null;
		stmt = conn.createStatement();
		stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		
		int autoIncKeyFromApi = -1;

	    rs = stmt.getGeneratedKeys();

	    if (rs.next()) {
	        autoIncKeyFromApi = rs.getInt(1);
	    } else {

	        // throw an exception from here
	    } 
	    System.out.println("Key returned from getGeneratedKeys():"
	            + autoIncKeyFromApi);
	    
	    this.codnota = autoIncKeyFromApi;
	    
	    if (rs != null) {
	        try {
	            rs.close();
	        } catch (SQLException ex) {
	            // ignore
	        }
	    }

	    if (stmt != null) {
	        try {
	            stmt.close();
	        } catch (SQLException ex) {
	            // ignore
	        }
	    }
		
		for(int i = 0; i < listaProdutos.size(); i++) {
			String query2 = "insert into venda_produto(codvenda, codpro, preco) values('" + getCodnota() + "','" + listaProdutos.get(i) + "','" + listaPrecos.get(i) + "')";
			PreparedStatement comando2 = (PreparedStatement) conn.prepareStatement(query2);
			comando2.execute();
		}
	}

	public void remover() throws SQLException {
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = "delete from venda where codnota = '" + getCodnota() + "'";
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		comando.execute();
	}
	
	
	public ResultSet consultar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void editar() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
	public int getCodnota() {
		return codnota;
	}
	public void setCodnota(int codnota) {
		this.codnota = codnota;
	}
	public String getCodfunc() {
		return codfunc;
	}
	public void setCodfunc(String codfunc) {
		this.codfunc = codfunc;
	}
	public String getCodcli() {
		return codcli;
	}
	public void setCodcli(String codcli) {
		this.codcli = codcli;
	}
	
	
	
}
