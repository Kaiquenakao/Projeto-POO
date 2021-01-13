package principal;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class Produto implements CRUD{
	
	
	private float preco;
	private String nome;
	private String tipo;
	private int quantidade;
	private int codigo;
	
	//GETS and SETS
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	//constructors
	public Produto() {
		super();
	}
	
	public Produto(float preco, String nome, String tipo, int quantidade, int codigo) {
		this.preco = preco;
		this.nome = nome;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.codigo = codigo;
	}
	
	@Override
	public void adicionar() throws SQLException {
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = "insert into produto(nome, tipo, quantidade, preco) values('" + getNome() + "', '"+ getTipo() + "', '"+ getQuantidade() + "', '" + getPreco() + "')";
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		comando.execute();
	}
	@Override
	public void remover() throws SQLException {
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = "delete from produto where codigo = "+this.getCodigo();
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		comando.execute();	
	}
	@Override
	public ResultSet consultar() throws SQLException {
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = "select * from produto";
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		ResultSet resultado = comando.executeQuery();
		return resultado;
	}
	
	public static ResultSet consultarStatic() throws SQLException {
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = "select * from produto";
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		ResultSet resultado = comando.executeQuery();
		return resultado;
	}
	
	public static ResultSet consultarID(int id) throws SQLException {
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = "select * from produto where codigo = "+id;
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		ResultSet resultado = comando.executeQuery();
		return resultado;
	}
	@Override
	public void editar() throws SQLException {
		java.sql.Connection conn = ConexaoBD.generateConnection();
		String query = "update produto set preco=" + this.getPreco() + ", nome='" + this.getNome() + "', tipo='" + this.getTipo() + "', quantidade=" + this.getQuantidade() + " where codigo ="+this.codigo;
		PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
		comando.execute();	
	}
	
	
	
}
