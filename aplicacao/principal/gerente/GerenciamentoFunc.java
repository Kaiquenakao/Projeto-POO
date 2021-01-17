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
		frame.setBounds(100, 100, 432, 271);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gerenciamento Funcion\u00E1rio");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel.setBounds(67, 11, 281, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				principal.gerente.CadastrarFunc tela = new principal.gerente.CadastrarFunc();
				tela.MostrarTela();
				frame.setVisible(false);
				
				
				
				
				
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCadastrar.setBounds(72, 80, 105, 36);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarFunc tela = new EditarFunc();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnEditar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEditar.setBounds(241, 80, 105, 36);
		frame.getContentPane().add(btnEditar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.gerente.ConsultarFunc tela = new principal.gerente.ConsultarFunc();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 12));
		btnConsultar.setBounds(72, 164, 105, 36);
		frame.getContentPane().add(btnConsultar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletarFunc window = new DeletarFunc();
				window.MostrarTela();
				frame.setVisible(false);
				
			}
		});
		btnRemover.setFont(new Font("Arial", Font.BOLD, 12));
		btnRemover.setBounds(241, 164, 105, 36);
		frame.getContentPane().add(btnRemover);
		
		JButton btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.TelaPrincipal tela = new principal.TelaPrincipal();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 13));
		btnVoltar.setBounds(9, 11, 48, 23);
		frame.getContentPane().add(btnVoltar);
	}
	public void MostrarTela() {
		frame.setVisible(true);
	}
}
