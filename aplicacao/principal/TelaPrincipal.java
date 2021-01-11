package principal;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
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
	public TelaPrincipal() {
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
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVendas.setFont(new Font("Arial", Font.BOLD, 12));
		btnVendas.setBounds(87, 80, 105, 36);
		frame.getContentPane().add(btnVendas);
		
		JButton btnProdutos = new JButton("Produtos");
		btnProdutos.setFont(new Font("Arial", Font.BOLD, 12));
		btnProdutos.setBounds(256, 80, 105, 36);
		frame.getContentPane().add(btnProdutos);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setFont(new Font("Arial", Font.BOLD, 12));
		btnClientes.setBounds(87, 164, 105, 36);
		frame.getContentPane().add(btnClientes);
		
		JButton btnFuncionarios = new JButton("Funcion\u00E1rios");
		btnFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.gerente.GerenciamentoFunc tela = new principal.gerente.GerenciamentoFunc();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnFuncionarios.setFont(new Font("Arial", Font.BOLD, 12));
		btnFuncionarios.setBounds(256, 164, 105, 36);
		frame.getContentPane().add(btnFuncionarios);
	}
	public void MostrarTela() {
		frame.setVisible(true);
	}
}
