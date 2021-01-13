package principal.gerente;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

import principal.ConexaoBD;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;



public class CadastrarFunc {

	private JFrame frame;
	private JTextField txtNome;
	private JLabel lblNewLabel_2;
	private JPasswordField txtSenha;
	private JLabel lblNewLabel_3;
	private JTextField txtUsuario;
	private JLabel lblNewLabel_4;
	private JTextField txtCPF;
	private JLabel lblNewLabel_5;
	private JTextField txtContato;
	private JLabel lblNewLabel_6;
	private JTextField txtEndereco;
	private JPasswordField txtCSenha;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarFunc window = new CadastrarFunc();
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
	public CadastrarFunc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 527, 317);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro Funcion\u00E1rio");
		lblNewLabel.setBounds(154, 10, 219, 36);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 62, 59, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(78, 58, 200, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 120, 59, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(78, 118, 200, 20);
		frame.getContentPane().add(txtSenha);
		
		lblNewLabel_3 = new JLabel("Usu\u00E1rio");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 91, 59, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(78, 87, 200, 20);
		frame.getContentPane().add(txtUsuario);
		
		lblNewLabel_4 = new JLabel("CPF");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_4.setBounds(296, 62, 59, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(337, 58, 164, 20);
		frame.getContentPane().add(txtCPF);
		
		lblNewLabel_5 = new JLabel("Contato");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_5.setBounds(295, 91, 59, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		txtContato = new JTextField();
		txtContato.setColumns(10);
		txtContato.setBounds(376, 87, 125, 20);
		frame.getContentPane().add(txtContato);
		
		lblNewLabel_6 = new JLabel("Endere\u00E7o");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_6.setBounds(294, 122, 69, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(376, 116, 125, 20);
		frame.getContentPane().add(txtEndereco);
		
		JComboBox comboEstado = new JComboBox();
		comboEstado.setBounds(376, 149, 125, 20);
		comboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO"}));
		frame.getContentPane().add(comboEstado);
		
		JComboBox comboAcesso = new JComboBox();
		comboAcesso.setBounds(376, 182, 125, 20);
		comboAcesso.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Gerente", "Funcionario"}));
		frame.getContentPane().add(comboAcesso);
		
		JLabel lblNewLabel_2_1 = new JLabel("Confirma\u00E7\u00E3o Senha");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(10, 153, 138, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		txtCSenha = new JPasswordField();
		txtCSenha.setBounds(158, 149, 120, 20);
		frame.getContentPane().add(txtCSenha);
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = txtNome.getText();
				String usuario = txtUsuario.getText();
				String senha = new String(txtSenha.getPassword());
				String CPF = txtCPF.getText();
				String contato = txtContato.getText();
				String endereco = txtEndereco.getText();
				String csenha = new String(txtCSenha.getPassword());
				String estado = comboEstado.getSelectedItem().toString();

				if(nome.length() < 5) {
					JOptionPane.showMessageDialog(null, "Nome deve conter pelo menos 5 caracteres");
					return;
				}

				if(usuario.length() < 5) {
					JOptionPane.showMessageDialog(null, "Usuário deve conter pelo menos 5 caracteres");
					return;
				}
				
				if(senha.length() < 5) {
					JOptionPane.showMessageDialog(null, "Senha deve conter pelo menos 8 caracteres");
					return;
				}
				
				if(!senha.equals(csenha)) {
					JOptionPane.showMessageDialog(null, "Senhas não correspondem");
					return;
				}
				
				if(CPF.length() != 11) {
					JOptionPane.showMessageDialog(null, "CPF deve conter exatamente 11 caracteres");
					return;
				}
				
				if(contato.length() < 8) {
					JOptionPane.showMessageDialog(null, "Contato deve conter pelo menos 8 caracteres");
					return;
				}
				
				if(endereco.length() < 9) {
					JOptionPane.showMessageDialog(null, "Endereço deve conter pelo menos 9 caracteres");
					return;
				}
				
				if(estado.length() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um estado");
					return;
				}
				
				principal.Funcionario func = new principal.Funcionario(nome, usuario, CPF, endereco, contato, estado);
				
				try {
					String acesso = comboAcesso.getSelectedItem().toString();
					func.criarLogin(senha, acesso);
					func.adicionar();
					JOptionPane.showMessageDialog(null, "Dados inseridos");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Não foi possivel inserir");
					e.printStackTrace();
					return;
				}
				txtNome.setText("");
				txtUsuario.setText("");
				txtSenha.setText("");
				txtCSenha.setText("");
				txtCPF.setText("");
				txtContato.setText("");
				txtEndereco.setText("");
				comboEstado.setSelectedIndex(0);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.setBounds(213, 223, 101, 38);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_6_1 = new JLabel("Estado");
		lblNewLabel_6_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_6_1.setBounds(296, 152, 69, 14);
		frame.getContentPane().add(lblNewLabel_6_1);
		
		JButton btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GerenciamentoFunc window = new GerenciamentoFunc();
				window.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 13));
		btnVoltar.setBounds(10, 20, 48, 23);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Acesso");
		lblNewLabel_6_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_6_1_1.setBounds(296, 185, 69, 14);
		frame.getContentPane().add(lblNewLabel_6_1_1);
		
	
		

	
	}
	public void MostrarTela() {
		frame.setVisible(true);
	}
}
