package principal.produto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CadastrarProduto {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtQuantidade;
	private JTextField txtPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarProduto window = new CadastrarProduto();
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
	public CadastrarProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 573, 300);
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
		btnVoltar.setBounds(26, 21, 48, 23);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("Cadastro Produto");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel.setBounds(167, 21, 219, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(35, 112, 59, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(95, 110, 175, 20);
		frame.getContentPane().add(txtNome);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(388, 139, 130, 20);
		frame.getContentPane().add(txtQuantidade);
		
		JLabel lblNewLabel_5 = new JLabel("Quantidade");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_5.setBounds(288, 143, 98, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(388, 108, 130, 20);
		frame.getContentPane().add(txtPreco);
		
		JLabel lblNewLabel_3 = new JLabel("Pre\u00E7o");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3.setBounds(325, 114, 59, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JComboBox comboTipo = new JComboBox();
		comboTipo.setBounds(95, 141, 175, 22);
		comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Rede", "Hardware", "Impressora", "Periféricos", "Mídias"}));
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = txtNome.getText();
				String tipo = comboTipo.getSelectedItem().toString();
				float preco = 0;
				int quantidade = 0;
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
				
				
				principal.Produto produto = new principal.Produto();
				produto.setNome(nome);
				produto.setPreco(preco);
				produto.setQuantidade(quantidade);
				produto.setTipo(tipo);
				
				try {
					produto.adicionar();
					JOptionPane.showMessageDialog(null, "Produto cadastrado");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Falha no cadastro");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				txtNome.setText("");
				txtQuantidade.setText("");
				comboTipo.setSelectedIndex(0);
				txtPreco.setText("");
				
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCadastrar.setBounds(234, 212, 101, 38);
		frame.getContentPane().add(btnCadastrar);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_4.setBounds(35, 143, 59, 14);
		frame.getContentPane().add(lblNewLabel_4);
		

		frame.getContentPane().add(comboTipo);
	}
	public void MostrarTela() {
		frame.setVisible(true);
	}
}
