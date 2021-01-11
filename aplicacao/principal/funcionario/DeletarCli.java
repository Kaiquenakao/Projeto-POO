package principal.funcionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeletarCli {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletarCli window = new DeletarCli();
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
	public DeletarCli() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 281);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GerenciamentoCli tela = new GerenciamentoCli();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 13));
		btnVoltar.setBounds(10, 20, 48, 23);
		frame.getContentPane().add(btnVoltar);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(162, 58, 113, 20);
		frame.getContentPane().add(textField);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 13));
		btnBuscar.setBounds(285, 56, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(295, 116, 113, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(295, 95, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(151, 116, 113, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(151, 164, 113, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Endere\u00E7o");
		lblNewLabel_1_1_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_3.setBounds(151, 148, 60, 14);
		frame.getContentPane().add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Estado");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(151, 95, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 95, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("CPF");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_2.setBounds(10, 147, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(10, 164, 113, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(10, 116, 113, 20);
		frame.getContentPane().add(textField_5);
		
		JLabel lblNewLabel_1 = new JLabel("Insira o CPF");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(72, 60, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Arial", Font.BOLD, 13));
		btnDeletar.setEnabled(false);
		btnDeletar.setBounds(160, 208, 89, 23);
		frame.getContentPane().add(btnDeletar);
		
		JLabel lblDeletarCliente = new JLabel("Deletar Cliente");
		lblDeletarCliente.setFont(new Font("Arial", Font.BOLD, 22));
		lblDeletarCliente.setBounds(151, 10, 148, 36);
		frame.getContentPane().add(lblDeletarCliente);
	}
	public void MostrarTela() {
		frame.setVisible(true);
	}

}
