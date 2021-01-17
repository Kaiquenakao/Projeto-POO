package principal;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import principal.funcionario.GerenciamentoCli;
import principal.venda.CadastrarVen;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JLabel lblNewLabel = new JLabel("Tela Principal - Funcion\u00E1rio");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(59, 11, 327, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnVendas = new JButton("Vendas");
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarVen tela = new CadastrarVen();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnVendas.setFont(new Font("Arial", Font.BOLD, 12));
		btnVendas.setBounds(59, 81, 145, 36);
		frame.getContentPane().add(btnVendas);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GerenciamentoCli cli = new GerenciamentoCli();
				cli.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnClientes.setFont(new Font("Arial", Font.BOLD, 12));
		btnClientes.setBounds(228, 81, 145, 36);
		frame.getContentPane().add(btnClientes);
		
		JButton btnConsultarVendas = new JButton("Consultar Vendas");
		btnConsultarVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				principal.venda.ConsultarVen tela = new principal.venda.ConsultarVen();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnConsultarVendas.setFont(new Font("Arial", Font.BOLD, 12));
		btnConsultarVendas.setBounds(59, 147, 145, 36);
		frame.getContentPane().add(btnConsultarVendas);
	}
	public void MostrarTela() {
		frame.setVisible(true);
	}
}
