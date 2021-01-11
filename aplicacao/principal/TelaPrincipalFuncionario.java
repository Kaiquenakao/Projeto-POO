package principal;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaPrincipalFuncionario {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalFuncionario window = new TelaPrincipalFuncionario();
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
	public TelaPrincipalFuncionario() {
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
		
		JLabel lblNewLabel = new JLabel("Tela Principal");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(136, 11, 163, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnVendas = new JButton("Vendas");
		btnVendas.setFont(new Font("Arial", Font.BOLD, 12));
		btnVendas.setBounds(87, 80, 105, 36);
		frame.getContentPane().add(btnVendas);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setFont(new Font("Arial", Font.BOLD, 12));
		btnClientes.setBounds(256, 80, 105, 36);
		frame.getContentPane().add(btnClientes);
	}
	public void MostrarTela() {
		frame.setVisible(true);
	}
}
