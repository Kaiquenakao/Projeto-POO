package principal;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class Funcionario extends Usuario {
	
	public Funcionario(String nome, String usuario, String CPF, String endereco, String contato, String estado) {
		super(nome, usuario, CPF, endereco, contato, estado);
	}
	
	public Funcionario() {
		super();
	}
	

	@Override
	public void adicionar() throws SQLException {
		if(!dadosValidos()) {
			JOptionPane.showMessageDialog(null, "Dados da classe inválidos");
			return;
		}
		
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = "insert into funcionario(nome, usuario, CPF, contato, endereco, estado) values('" + getNome() + "', '" + getUsuario() + "', '" + getCPF() + "', '" + getContato() + "', '" + getEndereco() +  "', '" + getEstado() + "')";
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		comando.execute();
	}

	public static ResultSet consultar() throws SQLException {
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = "select * from funcionario";
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		ResultSet resultado = comando.executeQuery();
		return resultado;
	}

	@Override
	public ResultSet consultarCPF() throws SQLException {
		if(getCPF().length() == 0) {
			JOptionPane.showMessageDialog(null, "Dados da classe inválidos");
			ResultSet r = null;
			return r;
		}
		
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = "select * from funcionario where CPF = '" + getCPF() + "'";
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		ResultSet resultado = comando.executeQuery();
		return resultado;
	}

	@Override
	public void remover() throws SQLException {
		if(getCPF().length() == 0) {
			JOptionPane.showMessageDialog(null, "Dados da classe inválidos");
			return;
		}
		
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = "delete from funcionario where CPF = '" + getCPF() + "'";
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		comando.execute();
	}

	@Override
	public void editar(String cpfOriginal) throws SQLException {
		if(!dadosValidos()) {
			JOptionPane.showMessageDialog(null, "Dados da classe inválidos");
			return;
		}
		if(cpfOriginal.length() != 11) {
			JOptionPane.showMessageDialog(null, "CPF inválido");
			return;
		}
	
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = String.format("update funcionario set nome = '%1$2s', usuario = '%2$2s', CPF = '%3$2s', contato = '%4$2s', endereco = '%5$2s', estado = '%6$2s' where CPF = '%7$2s'", getNome(), getUsuario(), getCPF(), getContato(), getEndereco(), getEstado(), cpfOriginal);
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		comando.execute();
	}
	
	public void criarLogin(String senha) throws SQLException {
		if(!dadosValidos() && senha.length() < 8) {
			JOptionPane.showMessageDialog(null, "Dados da classe inválidos");
			return;
		}
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = String.format("insert into login(usuario, senha, nivel) values('%1$2s', '%2$2s', '%3$2s')", getUsuario(), senha, "Funcionario");
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		comando.execute();
	}
	
	public void criarLogin(String senha, String acesso) throws SQLException {
		if(!dadosValidos() && senha.length() < 8) {
			JOptionPane.showMessageDialog(null, "Dados da classe inválidos");
			return;
		}
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = String.format("insert into login(usuario, senha, nivel) values('%1$2s', '%2$2s', '%3$2s')", getUsuario(), senha, acesso);
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		comando.execute();
	}
	
	

}
