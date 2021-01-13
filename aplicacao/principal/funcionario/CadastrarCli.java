package principal.funcionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CadastrarCli {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtUsuario;
	private JTextField txtCPF;
	private JTextField txtContato;
	private JTextField txtEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCli window = new CadastrarCli();
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
	public CadastrarCli() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 527, 242);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadastroCliente = new JLabel("Cadastro Cliente");
		lblCadastroCliente.setFont(new Font("Arial", Font.BOLD, 22));
		lblCadastroCliente.setBounds(178, 11, 175, 36);
		frame.getContentPane().add(lblCadastroCliente);
		
		JButton btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciamentoCli tela = new GerenciamentoCli();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 13));
		btnVoltar.setBounds(10, 21, 48, 23);
		frame.getContentPane().add(btnVoltar);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(78, 59, 200, 20);
		frame.getContentPane().add(txtNome);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 63, 59, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Usu\u00E1rio");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 92, 59, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(78, 88, 200, 20);
		frame.getContentPane().add(txtUsuario);
		
		JComboBox comboEstado = new JComboBox();
		comboEstado.setBounds(374, 119, 48, 20);
		comboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO"}));
		frame.getContentPane().add(comboEstado);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = txtNome.getText();
				String usuario = txtUsuario.getText();
				String CPF = txtCPF.getText();
				String contato = txtContato.getText();
				String endereco = txtEndereco.getText();
				String estado = comboEstado.getSelectedItem().toString();
				
				if(nome.length() < 5) {
					JOptionPane.showMessageDialog(null, "Nome deve conter pelo menos 5 caracteres");
					return;
				}

				if(usuario.length() < 5) {
					JOptionPane.showMessageDialog(null, "Usuário deve conter pelo menos 5 caracteres");
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
				
				principal.Cliente cli = new principal.Cliente();
				cli.setNome(nome);
				cli.setUsuario(usuario);
				cli.setCPF(CPF);
				cli.setContato(contato);
				cli.setEndereco(endereco);
				cli.setEstado(estado);
				
				try {
					cli.adicionar();
					JOptionPane.showMessageDialog(null, "Dados inseridos");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Não foi possivel inserir");
					e.printStackTrace();
					return;
				}		
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.setBounds(210, 150, 101, 38);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_6_1 = new JLabel("Estado");
		lblNewLabel_6_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_6_1.setBounds(295, 121, 69, 14);
		frame.getContentPane().add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6 = new JLabel("Endere\u00E7o");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 121, 69, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("Contato");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_5.setBounds(295, 92, 59, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(337, 59, 164, 20);
		frame.getContentPane().add(txtCPF);
		
		JLabel lblNewLabel_4 = new JLabel("CPF");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_4.setBounds(296, 63, 59, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtContato = new JTextField();
		txtContato.setColumns(10);
		txtContato.setBounds(376, 88, 125, 20);
		frame.getContentPane().add(txtContato);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(88, 119, 125, 20);
		frame.getContentPane().add(txtEndereco);
		
	}
	public void MostrarTela() {
		frame.setVisible(true);
	}
}
