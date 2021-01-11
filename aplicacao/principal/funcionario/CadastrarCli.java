package principal.funcionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarCli {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		frame.setBounds(100, 100, 527, 275);
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(78, 59, 200, 20);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 63, 59, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Usu\u00E1rio");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 92, 59, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(78, 88, 200, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 121, 59, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(78, 119, 200, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Confirma\u00E7\u00E3o Senha");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(10, 154, 138, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.setBounds(211, 189, 101, 38);
		frame.getContentPane().add(btnNewButton);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(158, 150, 120, 20);
		frame.getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Estado");
		lblNewLabel_6_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_6_1.setBounds(296, 155, 69, 14);
		frame.getContentPane().add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6 = new JLabel("Endere\u00E7o");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_6.setBounds(294, 121, 69, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("Contato");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_5.setBounds(295, 92, 59, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(337, 59, 164, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_4 = new JLabel("CPF");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_4.setBounds(296, 63, 59, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(376, 88, 125, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(376, 115, 125, 20);
		frame.getContentPane().add(textField_4);
		
		JComboBox comboEstado = new JComboBox();
		comboEstado.setBounds(376, 152, 48, 20);
		frame.getContentPane().add(comboEstado);
	}
	public void MostrarTela() {
		frame.setVisible(true);
	}
}
