package principal.funcionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeletarCli {

	private JFrame frame;
	private JTextField txtCPF;
	private JTextField txtUsuario;
	private JTextField txtEstado;
	private JTextField txtEndereco;
	private JTextField txtCPFD;
	private JTextField txtNome;

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
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(162, 58, 113, 20);
		frame.getContentPane().add(txtCPF);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					principal.Cliente func = new principal.Cliente();
					String CPF = txtCPFD.getText();
					func.setCPF(CPF);
					func.remover();
					txtCPF.setText("");
					txtNome.setText("");
					txtCPFD.setText("");
					txtEstado.setText("");
					txtUsuario.setText("");
					txtEndereco.setText("");
					btnDeletar.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao deletar");
					e1.printStackTrace();
				}
			}
		});
		btnDeletar.setFont(new Font("Arial", Font.BOLD, 13));
		btnDeletar.setEnabled(false);
		btnDeletar.setBounds(160, 208, 89, 23);
		frame.getContentPane().add(btnDeletar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtCPF.getText().length() != 11) {
					JOptionPane.showMessageDialog(null, "CPF não representa 11 caracteres");
					return;
				}
				
				principal.Cliente func = new principal.Cliente();
				func.setCPF(txtCPF.getText());
				
				try {
					ResultSet resultado = func.consultarCPF();
					if(resultado.next()) {
						txtNome.setText(resultado.getString("nome"));
						txtCPFD.setText(resultado.getString("CPF"));
						txtEstado.setText(resultado.getString("estado"));
						txtUsuario.setText(resultado.getString("usuario"));
						txtEndereco.setText(resultado.getString("endereco"));
						btnDeletar.setEnabled(true);
					}else {
						JOptionPane.showMessageDialog(null, "CPF não encontrado");
						txtCPF.setText("");
						txtNome.setText("");
						txtCPFD.setText("");
						txtEstado.setText("");
						txtUsuario.setText("");
						txtEndereco.setText("");
						btnDeletar.setEnabled(false);
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 13));
		btnBuscar.setBounds(285, 56, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(295, 116, 113, 20);
		frame.getContentPane().add(txtUsuario);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(295, 95, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBounds(151, 116, 113, 20);
		frame.getContentPane().add(txtEstado);
		
		txtEndereco = new JTextField();
		txtEndereco.setEditable(false);
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(151, 164, 113, 20);
		frame.getContentPane().add(txtEndereco);
		
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
		
		txtCPFD = new JTextField();
		txtCPFD.setEditable(false);
		txtCPFD.setColumns(10);
		txtCPFD.setBounds(10, 164, 113, 20);
		frame.getContentPane().add(txtCPFD);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(10, 116, 113, 20);
		frame.getContentPane().add(txtNome);
		
		JLabel lblNewLabel_1 = new JLabel("Insira o CPF");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(72, 60, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblDeletarCliente = new JLabel("Deletar Cliente");
		lblDeletarCliente.setFont(new Font("Arial", Font.BOLD, 22));
		lblDeletarCliente.setBounds(151, 10, 148, 36);
		frame.getContentPane().add(lblDeletarCliente);
	}
	public void MostrarTela() {
		frame.setVisible(true);
	}

}
