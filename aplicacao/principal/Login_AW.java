package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

// Import ConexaoBD.java
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Login_AW {

	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_AW window = new Login_AW();
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
	public Login_AW() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbLogin = new JLabel("Login");
		lbLogin.setFont(new Font("Arial", Font.BOLD, 25));
		lbLogin.setBounds(181, 34, 85, 29);
		frame.getContentPane().add(lbLogin);
		
		JLabel lbUsuario = new JLabel("Usu\u00E1rio");
		lbUsuario.setFont(new Font("Arial", Font.BOLD, 16));
		lbUsuario.setBounds(105, 91, 64, 14);
		frame.getContentPane().add(lbUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(179, 90, 148, 20);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setFont(new Font("Arial", Font.BOLD, 16));
		lbSenha.setBounds(105, 122, 64, 14);
		frame.getContentPane().add(lbSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(179, 121, 148, 20);
		frame.getContentPane().add(txtSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					java.sql.Connection conn = ConexaoBD.generateConnection();
					String query = "Insert into login(usuario, senha, nivel) values("
							+ "'Teste@123', '123','Funcionario')";
					PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
					comando.execute();
					comando.close();
					JOptionPane.showMessageDialog(null, "Sucesso");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Falha");
				}
				
				
				
			}
		});
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 11));
		btnEntrar.setBounds(181, 166, 89, 29);
		frame.getContentPane().add(btnEntrar);
	}
}
