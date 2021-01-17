package principal.venda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.mysql.jdbc.PreparedStatement;

import principal.ConexaoBD;
import principal.Funcionario;
import principal.Venda;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarVen {

	private JFrame frame;
	private JTextField txtFuncionario;
	private JTextField txtCliente;
	private JTextField txtPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarVen window = new ConsultarVen();
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
	public ConsultarVen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 573, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblConsultaVenda = new JLabel("Consulta Venda");
		lblConsultaVenda.setFont(new Font("Arial", Font.BOLD, 25));
		lblConsultaVenda.setBounds(176, 11, 194, 36);
		frame.getContentPane().add(lblConsultaVenda);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(43, 83, 169, 163);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		DefaultListModel <String> DLM = new DefaultListModel <String> ();
		ArrayList<String> listaCodNota = new ArrayList<String> ();
		
		try {
			ResultSet resultado = Venda.consultarNotaFiscal();
			while(resultado.next()) {
				Date data = resultado.getDate("datavenda");
				SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
				String stringDate= DateFor.format(data);
				DLM.addElement(resultado.getString("codnota") + " - " + stringDate);
				listaCodNota.add(resultado.getString("codnota"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list.setModel(DLM);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(334, 82, 169, 163);
		frame.getContentPane().add(scrollPane_1);
		
		JList list2 = new JList();
		scrollPane_1.setViewportView(list2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nota Fiscal");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(86, 58, 83, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Produtos");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_2_1.setBounds(376, 58, 83, 14);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Funcion\u00E1rio");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(120, 297, 92, 14);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		txtFuncionario = new JTextField();
		txtFuncionario.setEditable(false);
		txtFuncionario.setColumns(10);
		txtFuncionario.setBounds(120, 322, 200, 20);
		frame.getContentPane().add(txtFuncionario);
		
		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setColumns(10);
		txtCliente.setBounds(120, 376, 200, 20);
		frame.getContentPane().add(txtCliente);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Cliente");
		lblNewLabel_1_3_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_3_1.setBounds(120, 353, 92, 14);
		frame.getContentPane().add(lblNewLabel_1_3_1);
		
		txtPreco = new JTextField();
		txtPreco.setEditable(false);
		txtPreco.setColumns(10);
		txtPreco.setBounds(334, 377, 92, 20);
		frame.getContentPane().add(txtPreco);
		
		JLabel lblNewLabel_1_3_1_1_1 = new JLabel("Pre\u00E7o total");
		lblNewLabel_1_3_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_3_1_1_1.setBounds(334, 353, 92, 14);
		frame.getContentPane().add(lblNewLabel_1_3_1_1_1);
		
		
		DefaultListModel <String> DLM2 = new DefaultListModel <String> ();
		ArrayList<String> listaProdutos = new ArrayList<String> ();
		
		JButton btnNewButton = new JButton(">>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Selecione uma nota fiscal");
					return;
				}
				
				principal.Venda ven = new principal.Venda();
				ven.setCodnota(Integer.parseInt(listaCodNota.get(list.getSelectedIndex())));
				try {
					ResultSet resultado = ven.consultarProdutosVenda();
					ResultSet venda = ven.consultarVendaID();
					if(venda.next()) {
						principal.Funcionario func = new principal.Funcionario();
						func.setCPF(venda.getString("codfunc"));
						ResultSet funcionario = func.consultarCPF();
						if(funcionario.next()) {
							txtFuncionario.setText(funcionario.getString("nome"));
						}
					}
					venda.beforeFirst();
					if(venda.next()) {
						principal.Cliente cli = new principal.Cliente();
						cli.setCPF(venda.getString("codcli"));
						ResultSet cliente = cli.consultarCPF();
						if(cliente.next()) {
							txtCliente.setText(cliente.getString("nome"));
						}
					}
					
					
					DLM2.clear();
					listaProdutos.clear();
					while(resultado.next()) {						
						java.sql.Connection conn = ConexaoBD.generateConnection();
						String query = "select * from produto where codigo = '" + resultado.getString("codpro") + "'";
						PreparedStatement comando = (PreparedStatement) conn.prepareStatement(query);
						ResultSet resultado2 = comando.executeQuery();
						if(resultado2.next()) {
							DLM2.addElement(resultado2.getString("nome") + " - R$" + resultado.getString("preco"));
							listaProdutos.add(resultado.getString("preco"));
						}
					}
					int codnota = Integer.parseInt(listaCodNota.get(list.getSelectedIndex()));
					principal.Funcionario func = new principal.Funcionario();

					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				list2.setModel(DLM2);
				
				float precoTotal = 0;
				for(int i = 0; i < listaProdutos.size(); i++) {
					precoTotal += Float.parseFloat(listaProdutos.get(i));
				}
				txtPreco.setText(precoTotal + "");
				
			}
		});
		btnNewButton.setBounds(237, 122, 57, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
