package principal.funcionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarCli {

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
					EditarCli window = new EditarCli();
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
	public EditarCli() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 293);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEditarCliente = new JLabel("Editar Cliente");
		lblEditarCliente.setFont(new Font("Arial", Font.BOLD, 22));
		lblEditarCliente.setBounds(151, 11, 136, 36);
		frame.getContentPane().add(lblEditarCliente);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(162, 58, 113, 20);
		frame.getContentPane().add(textField);
		
		JButton btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciamentoCli tela = new GerenciamentoCli();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 13));
		btnVoltar.setBounds(10, 20, 48, 23);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel_1 = new JLabel("Insira o CPF");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(72, 60, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 13));
		btnBuscar.setBounds(285, 56, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(295, 95, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(295, 116, 113, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(151, 116, 113, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Contato");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(151, 95, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Endere\u00E7o");
		lblNewLabel_1_1_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_3.setBounds(151, 148, 60, 14);
		frame.getContentPane().add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Estado");
		lblNewLabel_1_1_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_1_2.setBounds(295, 147, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_2);
		
		JComboBox comboEstado = new JComboBox();
		comboEstado.setEnabled(false);
		comboEstado.setEditable(true);
		comboEstado.setBounds(295, 164, 48, 20);
		frame.getContentPane().add(comboEstado);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(10, 164, 113, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("CPF");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_2.setBounds(10, 147, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(10, 116, 113, 20);
		frame.getContentPane().add(textField_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 95, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 13));
		btnLimpar.setEnabled(false);
		btnLimpar.setBounds(120, 208, 77, 23);
		frame.getContentPane().add(btnLimpar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial", Font.BOLD, 13));
		btnEditar.setEnabled(false);
		btnEditar.setBounds(227, 208, 89, 23);
		frame.getContentPane().add(btnEditar);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(151, 164, 113, 20);
		frame.getContentPane().add(textField_5);
		
		
		
	}
	public void MostrarTela() {
		frame.setVisible(true);
	}

}
