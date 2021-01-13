package principal.produto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

import principal.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeletarProduto {

	private JFrame frame;
	private JTextField txtQuantidade;
	private JTextField txtTipo;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtID;
	private JTextField txtCodigoD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletarProduto window = new DeletarProduto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeletarProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 280);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produto produto = new Produto();
				produto.setCodigo(Integer.parseInt(txtCodigoD.getText()));
				try {
					produto.remover();
					JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
					txtNome.setText("");
					txtPreco.setText("");
					txtQuantidade.setText("");
					txtTipo.setText("");
					txtCodigoD.setText("");
					btnDeletar.setEnabled(false);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Falha na remoção");
					e.printStackTrace();
				}
			}
		});
		btnDeletar.setFont(new Font("Arial", Font.BOLD, 13));
		btnDeletar.setEnabled(false);
		btnDeletar.setBounds(185, 207, 79, 23);
		frame.getContentPane().add(btnDeletar);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setEditable(false);
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(151, 164, 113, 20);
		frame.getContentPane().add(txtQuantidade);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Quantidade");
		lblNewLabel_1_1_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_3.setBounds(151, 148, 89, 14);
		frame.getContentPane().add(lblNewLabel_1_1_3);
		
		txtTipo = new JTextField();
		txtTipo.setEditable(false);
		txtTipo.setColumns(10);
		txtTipo.setBounds(10, 164, 113, 20);
		frame.getContentPane().add(txtTipo);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Tipo");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_2.setBounds(10, 147, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(10, 116, 113, 20);
		frame.getContentPane().add(txtNome);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 95, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Pre\u00E7o");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(151, 95, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		txtPreco = new JTextField();
		txtPreco.setEditable(false);
		txtPreco.setColumns(10);
		txtPreco.setBounds(151, 116, 113, 20);
		frame.getContentPane().add(txtPreco);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(162, 58, 113, 20);
		frame.getContentPane().add(txtID);
		
		txtCodigoD = new JTextField();
		txtCodigoD.setEditable(false);
		txtCodigoD.setColumns(10);
		txtCodigoD.setBounds(295, 116, 113, 20);
		frame.getContentPane().add(txtCodigoD);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = 0;
				try {
					id = Integer.parseInt(txtID.getText());
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Código deve ser um valor inteiro");
				}
				
				try {
					ResultSet resultado = Produto.consultarID(id);
					if(resultado.next()) {
						txtNome.setText(resultado.getString("nome"));
						txtPreco.setText(resultado.getString("preco"));
						txtQuantidade.setText(resultado.getString("quantidade"));
						txtTipo.setText(resultado.getString("tipo"));
						txtCodigoD.setText(resultado.getString("codigo"));
						btnDeletar.setEnabled(true);
					}else {
						JOptionPane.showMessageDialog(null, "Produto não encontrado");
						txtNome.setText("");
						txtPreco.setText("");
						txtQuantidade.setText("");
						txtTipo.setText("");
						txtCodigoD.setText("");
						btnDeletar.setEnabled(false);
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Erro ao consultar");
					e.printStackTrace();
				}
			}
		});
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 13));
		btnBuscar.setBounds(285, 56, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		
		JLabel lblNewLabel_1 = new JLabel("Insira o c\u00F3digo");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(53, 60, 99, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblDeletarProduto = new JLabel("Deletar Produto");
		lblDeletarProduto.setFont(new Font("Arial", Font.BOLD, 22));
		lblDeletarProduto.setBounds(122, 10, 198, 36);
		frame.getContentPane().add(lblDeletarProduto);
		
		JButton btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GerenciamentoProduto gerenciamento = new GerenciamentoProduto();
				gerenciamento.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 13));
		btnVoltar.setBounds(10, 20, 48, 23);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(295, 95, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);	
	
	}
	public void MostrarTela() {
		frame.setVisible(true);
	}
}
