package principal.gerente;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import principal.Funcionario;

import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ConsultarFunc {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtEndereco;
	private JTextField txtContato;
	private JTextField txtUsuario;
	private JTextField txtEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarFunc window = new ConsultarFunc();
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
	public ConsultarFunc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 762, 277);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(36, 45, 169, 163);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);

		DefaultListModel <String> DLM = new DefaultListModel <String> ();
		ArrayList<String> listaCPFs = new ArrayList<String> ();

		try {
			ResultSet resultado = principal.Funcionario.consultar();
			
			while(resultado.next()) {
				DLM.addElement(resultado.getString("CPF") + " - " + resultado.getString("nome"));
				listaCPFs.add(resultado.getString("CPF"));
			}
			
			list.setModel(DLM);
			
			JButton btnConsultar = new JButton(">>");
			btnConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = list.getSelectedIndex();
					principal.Funcionario func = new principal.Funcionario();
					func.setCPF(listaCPFs.get(index));
					try {
						ResultSet resultado = func.consultarCPF();
						if(resultado.next()) {
							txtNome.setText(resultado.getString("nome"));
							txtContato.setText(resultado.getString("contato"));
							txtCPF.setText(resultado.getString("CPF"));
							txtEndereco.setText(resultado.getString("endereco"));
							txtUsuario.setText(resultado.getString("usuario"));
							txtEstado.setText(resultado.getString("estado"));
							JOptionPane.showMessageDialog(null, "Funcionário encontrado");
						}
						else {
							JOptionPane.showMessageDialog(null, "Erro de conexão");
						}	
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Erro de conexão");
						e1.printStackTrace();
					}
					
					
					
				}
			});
			btnConsultar.setBounds(230, 101, 55, 23);
			frame.getContentPane().add(btnConsultar);
			
			JLabel lblNewLabel_1_1_1_1 = new JLabel("Usu\u00E1rio");
			lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
			lblNewLabel_1_1_1_1.setBounds(591, 68, 52, 14);
			frame.getContentPane().add(lblNewLabel_1_1_1_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("Nome");
			lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
			lblNewLabel_1_1.setBounds(306, 68, 52, 14);
			frame.getContentPane().add(lblNewLabel_1_1);
			
			txtNome = new JTextField();
			txtNome.setEditable(false);
			txtNome.setColumns(10);
			txtNome.setBounds(306, 89, 113, 20);
			frame.getContentPane().add(txtNome);
			
			JLabel lblNewLabel_1_1_2 = new JLabel("CPF");
			lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 13));
			lblNewLabel_1_1_2.setBounds(306, 120, 52, 14);
			frame.getContentPane().add(lblNewLabel_1_1_2);
			
			txtCPF = new JTextField();
			txtCPF.setEditable(false);
			txtCPF.setColumns(10);
			txtCPF.setBounds(306, 137, 113, 20);
			frame.getContentPane().add(txtCPF);
			
			JLabel lblNewLabel_1_1_3 = new JLabel("Endere\u00E7o");
			lblNewLabel_1_1_3.setFont(new Font("Arial", Font.BOLD, 13));
			lblNewLabel_1_1_3.setBounds(447, 121, 60, 14);
			frame.getContentPane().add(lblNewLabel_1_1_3);
			
			txtEndereco = new JTextField();
			txtEndereco.setEditable(false);
			txtEndereco.setColumns(10);
			txtEndereco.setBounds(447, 137, 113, 20);
			frame.getContentPane().add(txtEndereco);
			
			JLabel lblNewLabel_1_1_1_2 = new JLabel("Estado");
			lblNewLabel_1_1_1_2.setFont(new Font("Arial", Font.BOLD, 13));
			lblNewLabel_1_1_1_2.setBounds(591, 120, 52, 14);
			frame.getContentPane().add(lblNewLabel_1_1_1_2);
			
			txtContato = new JTextField();
			txtContato.setEditable(false);
			txtContato.setColumns(10);
			txtContato.setBounds(447, 89, 113, 20);
			frame.getContentPane().add(txtContato);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Contato");
			lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
			lblNewLabel_1_1_1.setBounds(447, 68, 52, 14);
			frame.getContentPane().add(lblNewLabel_1_1_1);
			
			txtUsuario = new JTextField();
			txtUsuario.setEditable(false);
			txtUsuario.setColumns(10);
			txtUsuario.setBounds(591, 89, 113, 20);
			frame.getContentPane().add(txtUsuario);
			
			txtEstado = new JTextField();
			txtEstado.setEditable(false);
			txtEstado.setColumns(10);
			txtEstado.setBounds(591, 137, 52, 20);
			frame.getContentPane().add(txtEstado);
			
			
			JLabel lblConsultar = new JLabel("Consultar Funcion\u00E1rio");
			lblConsultar.setFont(new Font("Arial", Font.BOLD, 22));
			lblConsultar.setBounds(374, 22, 241, 36);
			frame.getContentPane().add(lblConsultar);
			
			JButton btnVoltar = new JButton("<");
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GerenciamentoFunc func = new GerenciamentoFunc();
					func.MostrarTela();
					frame.setVisible(false);
				}
			});
			btnVoltar.setFont(new Font("Arial", Font.BOLD, 13));
			btnVoltar.setBounds(10, 11, 48, 23);
			frame.getContentPane().add(btnVoltar);
			
			

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		

		
	}
}
