package principal.produto;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GerenciamentoProduto {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciamentoProduto window = new GerenciamentoProduto();
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
	public GerenciamentoProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 396, 287);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnFuncionarios = new JButton("Remover");
		btnFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeletarProduto tela = new DeletarProduto();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnFuncionarios.setFont(new Font("Arial", Font.BOLD, 12));
		btnFuncionarios.setBounds(220, 175, 105, 36);
		frame.getContentPane().add(btnFuncionarios);
		
		JButton btnProdutos = new JButton("Editar");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				principal.produto.EditarProduto tela = new principal.produto.EditarProduto();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnProdutos.setFont(new Font("Arial", Font.BOLD, 12));
		btnProdutos.setBounds(220, 91, 105, 36);
		frame.getContentPane().add(btnProdutos);
		
		JButton btnVendas = new JButton("Cadastrar");
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarProduto tela = new CadastrarProduto();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnVendas.setFont(new Font("Arial", Font.BOLD, 12));
		btnVendas.setBounds(51, 91, 105, 36);
		frame.getContentPane().add(btnVendas);
		
		JButton btnClientes = new JButton("Consultar");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarProduto tela = new ConsultarProduto();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnClientes.setFont(new Font("Arial", Font.BOLD, 12));
		btnClientes.setBounds(51, 175, 105, 36);
		frame.getContentPane().add(btnClientes);
		
		JLabel lblNewLabel = new JLabel("Gerenciamento Produto");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel.setBounds(51, 22, 281, 36);
		frame.getContentPane().add(lblNewLabel);
	}
	public void MostrarTela() {
		frame.setVisible(true);
	}
}
