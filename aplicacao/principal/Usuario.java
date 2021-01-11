package principal;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public abstract class Usuario {
	private String nome;
	private String usuario;
	private String CPF;
	private String endereco;
	private String contato;
	
	
	public boolean dadosValidos() {
		if(nome.length() < 5) {
			return false;
		}

		if(usuario.length() < 5) {
			return false;
		}
		
		if(CPF.length() != 11) {
			return false;
		}
		
		if(contato.length() < 8) {
			return false;
		}
		
		if(endereco.length() < 9) {
			return false;
		}
		
		if(estado.length() == 0) {
			return false;
		}
		return true;
	}
	
	
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	private String estado;
	
	public Usuario(){
		super();
	}
	
	public Usuario(String nome, String usuario, String CPF, String endereco, String contato, String estado) {
		this.nome = nome;
		this.usuario = usuario;
		this.CPF = CPF;
		this.endereco = endereco;
		this.contato = contato;
		this.estado = estado;
	}
	
	abstract public void adicionar() throws SQLException;
	abstract public ResultSet consultarCPF() throws SQLException;
	abstract public void remover() throws SQLException;
	abstract public void editar(String cpfOriginal) throws SQLException;
	
}
