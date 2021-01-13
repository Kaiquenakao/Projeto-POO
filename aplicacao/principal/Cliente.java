package principal;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class Cliente {
	private String nome;
	private String usuario;
	private String CPF;
	private String endereco;
	private String contato;
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}


	private String estado;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	
	
	public void adicionar() throws SQLException {
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = "insert into cliente(nome, usuario, CPF, contato, endereco, estado) values('" + getNome() + "', '" + getUsuario() + "', '" + getCPF() + "', '" + getContato() + "', '" + getEndereco() +  "', '" + getEstado() + "')";
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		comando.execute();
	}
	
	public static ResultSet consultar() throws SQLException {
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = "select * from cliente";
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		ResultSet resultado = comando.executeQuery();
		return resultado;
	}

	public ResultSet consultarCPF() throws SQLException {
		if(getCPF().length() == 0) {
			JOptionPane.showMessageDialog(null, "Dados da classe inválidos");
			ResultSet r = null;
			return r;
		}
		
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = "select * from cliente where CPF = '" + getCPF() + "'";
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		ResultSet resultado = comando.executeQuery();
		return resultado;
	}
	

	public void remover() throws SQLException {
		if(getCPF().length() == 0) {
			JOptionPane.showMessageDialog(null, "Dados da classe inválidos");
			return;
		}
		
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = "delete from cliente where CPF = '" + getCPF() + "'";
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		comando.execute();
	}

	public void editar(String cpfOriginal) throws SQLException {
		if(cpfOriginal.length() != 11) {
			JOptionPane.showMessageDialog(null, "CPF inválido");
			return;
		}
	
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = String.format("update cliente set nome = '%1$2s', usuario = '%2$2s', CPF = '%3$2s', contato = '%4$2s', endereco = '%5$2s', estado = '%6$2s' where CPF = '%7$2s'", getNome(), getUsuario(), getCPF(), getContato(), getEndereco(), getEstado(), cpfOriginal);
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		comando.execute();
	}
	
	
}
