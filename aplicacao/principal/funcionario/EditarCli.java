package principal.funcionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EditarCli {

	private JFrame frame;
	private JTextField txtCPF;
	private JTextField txtUsuario;
	private JTextField txtContato;
	private JTextField txtCPFD;
	private JTextField txtNome;
	private JTextField txtEndereco;

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
		
		JComboBox comboEstado = new JComboBox();
		comboEstado.setEnabled(false);
		comboEstado.setEditable(true);
		comboEstado.setBounds(295, 164, 48, 20);
		comboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO"}));
		frame.getContentPane().add(comboEstado);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(162, 58, 113, 20);
		frame.getContentPane().add(txtCPF);
		
		JButton btnLimpar = new JButton("Limpar");
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.Cliente cli = new principal.Cliente();
				cli.setNome(txtNome.getText());
				cli.setUsuario(txtUsuario.getText());
				cli.setContato(txtContato.getText());
				cli.setCPF(txtCPF.getText());
				cli.setEndereco(txtEndereco.getText());
				cli.setEstado(comboEstado.getSelectedItem().toString());
				
				try {
					cli.editar(txtCPF.getText());
					JOptionPane.showMessageDialog(null, "Cliente editado");
					
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Falha na edição");
					
					e1.printStackTrace();
				}
				
				finally {
					txtCPF.setText("");
					txtNome.setText("");
					txtCPFD.setText("");
					comboEstado.setSelectedIndex(0);
					txtUsuario.setText("");
					txtEndereco.setText("");
					txtContato.setText("");
					
					txtNome.setEnabled(false);
					txtCPFD.setEnabled(false);
					txtNome.setEnabled(false);
					comboEstado.setEnabled(false);
					txtUsuario.setEnabled(false);
					txtEndereco.setEnabled(false);
					txtContato.setEnabled(false);
					btnEditar.setEnabled(false);
					btnLimpar.setEnabled(false);
					txtCPF.setEnabled(true);
				}
			}
		});
		btnEditar.setFont(new Font("Arial", Font.BOLD, 13));
		btnEditar.setEnabled(false);
		btnEditar.setBounds(227, 208, 89, 23);
		frame.getContentPane().add(btnEditar);
		
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

		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCPF.setText("");
				txtNome.setText("");
				txtCPFD.setText("");
				comboEstado.setSelectedIndex(0);
				txtUsuario.setText("");
				txtEndereco.setText("");
				txtContato.setText("");
				
				txtNome.setEnabled(false);
				txtCPFD.setEnabled(false);
				txtNome.setEnabled(false);
				comboEstado.setEnabled(false);
				txtUsuario.setEnabled(false);
				txtEndereco.setEnabled(false);
				txtContato.setEnabled(false);
				btnEditar.setEnabled(false);
				btnLimpar.setEnabled(false);
				txtCPF.setEnabled(true);
			}
		});
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 13));
		btnLimpar.setEnabled(false);
		btnLimpar.setBounds(120, 208, 77, 23);
		frame.getContentPane().add(btnLimpar);
		
		JLabel lblNewLabel_1 = new JLabel("Insira o CPF");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(72, 60, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		

		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCPF.getText().length() != 11) {
					JOptionPane.showMessageDialog(null, "CPF não representa 11 caracteres");
					return;
				}
				
				principal.Cliente cli = new principal.Cliente();
				cli.setCPF(txtCPF.getText());
				
				try {
					ResultSet resultado = cli.consultarCPF();
					if(resultado.next()) {
						txtNome.setText(resultado.getString("nome"));
						txtCPFD.setText(resultado.getString("CPF"));
						comboEstado.setSelectedItem(resultado.getString("estado"));
						txtUsuario.setText(resultado.getString("usuario"));
						txtEndereco.setText(resultado.getString("endereco"));
						txtContato.setText(resultado.getString("contato"));
						
						//Habilitando
						txtNome.setEnabled(true);
						txtCPFD.setEnabled(true);
						txtNome.setEnabled(true);
						comboEstado.setEnabled(true);
						txtUsuario.setEnabled(true);
						txtEndereco.setEnabled(true);
						txtContato.setEnabled(true);
						btnEditar.setEnabled(true);
						btnLimpar.setEnabled(true);
						txtCPF.setEnabled(false);
					}else {
						JOptionPane.showMessageDialog(null, "CPF não encontrado");
						txtNome.setText("");
						txtCPFD.setText("");
						comboEstado.setSelectedIndex(0);
						txtUsuario.setText("");
						txtEndereco.setText("");
						txtContato.setText("");
						btnEditar.setEnabled(false);
						btnLimpar.setEnabled(false);
						txtCPF.setEnabled(true);
						
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
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(295, 95, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setEnabled(false);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(295, 116, 113, 20);
		frame.getContentPane().add(txtUsuario);
		
		txtContato = new JTextField();
		txtContato.setEnabled(false);
		txtContato.setColumns(10);
		txtContato.setBounds(151, 116, 113, 20);
		frame.getContentPane().add(txtContato);
		
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
		
		txtCPFD = new JTextField();
		txtCPFD.setEnabled(false);
		txtCPFD.setColumns(10);
		txtCPFD.setBounds(10, 164, 113, 20);
		frame.getContentPane().add(txtCPFD);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("CPF");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_2.setBounds(10, 147, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setColumns(10);
		txtNome.setBounds(10, 116, 113, 20);
		frame.getContentPane().add(txtNome);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 95, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtEndereco = new JTextField();
		txtEndereco.setEnabled(false);
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(151, 164, 113, 20);
		frame.getContentPane().add(txtEndereco);
		
		
		
	}
	public void MostrarTela() {
		frame.setVisible(true);
	}

}
