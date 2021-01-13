package principal.produto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import principal.Produto;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class EditarProduto {

	private JFrame frame;
	private JTextField txtCodigo;
	private JTextField txtCodigoD;
	private JTextField txtPreco;
	private JTextField txtNome;
	private JTextField txtQuantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarProduto window = new EditarProduto();
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
	public EditarProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GerenciamentoProduto tela = new GerenciamentoProduto();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 13));
		btnVoltar.setBounds(10, 21, 48, 23);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblEditarProduto = new JLabel("Editar Produto");
		lblEditarProduto.setFont(new Font("Arial", Font.BOLD, 22));
		lblEditarProduto.setBounds(122, 11, 198, 36);
		frame.getContentPane().add(lblEditarProduto);
		
		JLabel lblNewLabel_1 = new JLabel("Insira o c\u00F3digo");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(53, 61, 99, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboTipo = new JComboBox();
		comboTipo.setEnabled(false);
		comboTipo.setBounds(10, 164, 113, 22);
		comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Rede", "Hardware", "Impressora", "Periféricos", "Mídias"}));
		frame.getContentPane().add(comboTipo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(162, 59, 113, 20);
		frame.getContentPane().add(txtCodigo);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 13));
		btnLimpar.setEnabled(false);
		btnLimpar.setBounds(128, 207, 79, 23);
		frame.getContentPane().add(btnLimpar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = txtNome.getText();
				String tipo = comboTipo.getSelectedItem().toString();
				float preco = 0;
				int quantidade = 0, codigo = 0;
				try {
					codigo = Integer.parseInt(txtCodigoD.getText());
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "O valor de código não é numérico");
					return ;
				}
				try {
					preco = Float.parseFloat(txtPreco.getText());
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "O valor de preço não é numérico");
					return ;
				}
				
				try {
					quantidade = Integer.parseInt(txtQuantidade.getText());
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "O valor de quantidade não é numérico");
					return ;
				}
				
				if(nome.length() < 5) {
					JOptionPane.showMessageDialog(null, "O nome deve conter ao menos 5 caracteres");
					return;
				}
				
				if(preco <= 0) {
					JOptionPane.showMessageDialog(null, "O preço não pode ser negativo ou zero");
					return;
				}
				
				if(quantidade < 0) {
					JOptionPane.showMessageDialog(null, "A quantidade não pode ser negativa");
					return;
				}
				
				Produto produto = new Produto(preco, nome, tipo, quantidade, codigo);
				try {
					produto.editar();
					JOptionPane.showMessageDialog(null, "Produto editado com sucesso");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Falha na edição");
					e.printStackTrace();
				}
				txtNome.setText("");
				txtPreco.setText("");
				txtQuantidade.setText("");
				comboTipo.setSelectedIndex(0);
				txtCodigoD.setText("");
				
				txtNome.setEditable(false);
				txtPreco.setEditable(false);
				txtQuantidade.setEditable(false);
				comboTipo.setEnabled(false);
				
				btnLimpar.setEnabled(false);
				btnEditar.setEnabled(false);
				
				
			}
		});
		btnEditar.setFont(new Font("Arial", Font.BOLD, 13));
		btnEditar.setEnabled(false);
		btnEditar.setBounds(217, 207, 79, 23);
		frame.getContentPane().add(btnEditar);
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText("");
				txtPreco.setText("");
				txtQuantidade.setText("");
				comboTipo.setSelectedIndex(0);
				txtCodigoD.setText("");
				
				txtNome.setEditable(false);
				txtPreco.setEditable(false);
				txtQuantidade.setEditable(false);
				comboTipo.setEnabled(false);
				
				btnLimpar.setEnabled(false);
				btnEditar.setEnabled(false);
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = 0;
				try {
					id = Integer.parseInt(txtCodigo.getText());
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Código deve ser um valor inteiro");
				}
				
				try {
					ResultSet resultado = Produto.consultarID(id);
					if(resultado.next()) {
						txtNome.setText(resultado.getString("nome"));
						txtPreco.setText(resultado.getString("preco"));
						txtQuantidade.setText(resultado.getString("quantidade"));
						comboTipo.setSelectedItem(resultado.getString("tipo"));
						txtCodigoD.setText(resultado.getString("codigo"));
						
						txtNome.setEditable(true);
						txtPreco.setEditable(true);
						txtQuantidade.setEditable(true);
						comboTipo.setEnabled(true);
						
						btnLimpar.setEnabled(true);
						btnEditar.setEnabled(true);
					}else {
						JOptionPane.showMessageDialog(null, "Produto não encontrado");
						txtNome.setText("");
						txtPreco.setText("");
						txtQuantidade.setText("");
						comboTipo.setSelectedIndex(0);
						txtCodigoD.setText("");
						
						txtNome.setEditable(false);
						txtPreco.setEditable(false);
						txtQuantidade.setEditable(false);
						comboTipo.setEnabled(false);
						
						btnLimpar.setEnabled(false);
						btnEditar.setEnabled(false);
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Erro ao consultar");
					e.printStackTrace();
				}
			}
		});
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 13));
		btnBuscar.setBounds(285, 57, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(295, 96, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		txtCodigoD = new JTextField();
		txtCodigoD.setEditable(false);
		txtCodigoD.setColumns(10);
		txtCodigoD.setBounds(295, 117, 113, 20);
		frame.getContentPane().add(txtCodigoD);
		
		txtPreco = new JTextField();
		txtPreco.setEditable(false);
		txtPreco.setColumns(10);
		txtPreco.setBounds(151, 117, 113, 20);
		frame.getContentPane().add(txtPreco);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Pre\u00E7o");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(151, 96, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 96, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(10, 117, 113, 20);
		frame.getContentPane().add(txtNome);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Tipo");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_2.setBounds(10, 148, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Quantidade");
		lblNewLabel_1_1_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_3.setBounds(151, 149, 89, 14);
		frame.getContentPane().add(lblNewLabel_1_1_3);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setEditable(false);
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(151, 165, 113, 20);
		frame.getContentPane().add(txtQuantidade);
		
	}
	public void MostrarTela() {
		frame.setVisible(true);
	}
}
