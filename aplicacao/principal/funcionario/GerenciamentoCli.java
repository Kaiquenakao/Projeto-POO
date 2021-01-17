package principal.funcionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import principal.Funcionario;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GerenciamentoCli {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciamentoCli window = new GerenciamentoCli();
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
	public GerenciamentoCli() {
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
		
		JLabel lblGerenciamentoCliente = new JLabel("Gerenciamento Cliente");
		lblGerenciamentoCliente.setFont(new Font("Arial", Font.BOLD, 22));
		lblGerenciamentoCliente.setBounds(108, 11, 231, 36);
		frame.getContentPane().add(lblGerenciamentoCliente);
		
		JButton btnVendas = new JButton("Cadastrar");
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarCli cli = new CadastrarCli();
				cli.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnVendas.setFont(new Font("Arial", Font.BOLD, 12));
		btnVendas.setBounds(84, 80, 105, 36);
		frame.getContentPane().add(btnVendas);
		
		JButton btnClientes = new JButton("Consultar");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarCli cli = new ConsultarCli();
				cli.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnClientes.setFont(new Font("Arial", Font.BOLD, 12));
		btnClientes.setBounds(84, 164, 105, 36);
		frame.getContentPane().add(btnClientes);
		
		JButton btnFuncionarios = new JButton("Remover");
		btnFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletarCli tela = new DeletarCli();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnFuncionarios.setFont(new Font("Arial", Font.BOLD, 12));
		btnFuncionarios.setBounds(253, 164, 105, 36);
		frame.getContentPane().add(btnFuncionarios);
		
		JButton btnProdutos = new JButton("Editar");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarCli tela = new EditarCli();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnProdutos.setFont(new Font("Arial", Font.BOLD, 12));
		btnProdutos.setBounds(253, 80, 105, 36);
		frame.getContentPane().add(btnProdutos);
		
		JButton btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Funcionario.gerente) {
					principal.TelaPrincipal tela = new principal.TelaPrincipal();
					tela.MostrarTela();
					frame.setVisible(false);
				}
				else {
					principal.TelaPrincipalFuncionario tela = new principal.TelaPrincipalFuncionario();
					tela.MostrarTela();
					frame.setVisible(false);
				}
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 13));
		btnVoltar.setBounds(10, 11, 48, 23);
		frame.getContentPane().add(btnVoltar);
	}
	public void MostrarTela() {
		frame.setVisible(true);
	}
}
