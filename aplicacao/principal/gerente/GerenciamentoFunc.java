package principal.gerente;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GerenciamentoFunc {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciamentoFunc window = new GerenciamentoFunc();
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
	public GerenciamentoFunc() {
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
		
		JLabel lblNewLabel = new JLabel("Gerenciamento Funcion\u00E1rio");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel.setBounds(80, 11, 281, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnVendas = new JButton("Cadastrar");
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				principal.gerente.CadastrarFunc tela = new principal.gerente.CadastrarFunc();
				tela.MostrarTela();
				frame.setVisible(false);
				
				
				
				
				
			}
		});
		btnVendas.setFont(new Font("Arial", Font.BOLD, 12));
		btnVendas.setBounds(87, 80, 105, 36);
		frame.getContentPane().add(btnVendas);
		
		JButton btnProdutos = new JButton("Editar");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarFunc tela = new EditarFunc();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnProdutos.setFont(new Font("Arial", Font.BOLD, 12));
		btnProdutos.setBounds(256, 80, 105, 36);
		frame.getContentPane().add(btnProdutos);
		
		JButton btnClientes = new JButton("Consultar");
		btnClientes.setFont(new Font("Arial", Font.BOLD, 12));
		btnClientes.setBounds(87, 164, 105, 36);
		frame.getContentPane().add(btnClientes);
		
		JButton btnFuncionarios = new JButton("Remover");
		btnFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletarFunc window = new DeletarFunc();
				window.MostrarTela();
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
