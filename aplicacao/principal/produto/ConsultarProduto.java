package principal.produto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import principal.Produto;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarProduto {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtQuantidade;
	private JTextField txtCodigo;
	private JTextField txtPreco;
	private JTextField txtTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarProduto window = new ConsultarProduto();
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
	public ConsultarProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 754, 265);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		DefaultListModel <String> DLM = new DefaultListModel <String> ();
		ArrayList<String> listaCodigos = new ArrayList<String> ();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(36, 45, 169, 163);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnConsultar = new JButton(">>");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = list.getSelectedIndex();
				if(index == -1) {
					JOptionPane.showMessageDialog(null, "Escolha um produto");
					return ;
				}
				try {
					ResultSet resultado = Produto.consultarID(Integer.parseInt(listaCodigos.get(index)));
					if(resultado.next()) {
						txtCodigo.setText(resultado.getString("codigo"));
						txtNome.setText(resultado.getString("nome"));
						txtPreco.setText(resultado.getString("preco"));
						txtQuantidade.setText(resultado.getString("quantidade"));
						txtTipo.setText(resultado.getString("tipo"));
					}else {
						JOptionPane.showMessageDialog(null, "Erro ao consultar");
					}
				}catch(SQLException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao consultar");
				}catch(Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao desconhecido");
				}
			}
		});
		btnConsultar.setBounds(230, 101, 55, 23);
		frame.getContentPane().add(btnConsultar);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Tipo");
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
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Quantidade");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_2.setBounds(306, 120, 91, 14);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setEditable(false);
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(306, 137, 113, 20);
		frame.getContentPane().add(txtQuantidade);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("C\u00F3digo");
		lblNewLabel_1_1_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_3.setBounds(447, 121, 60, 14);
		frame.getContentPane().add(lblNewLabel_1_1_3);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(447, 137, 113, 20);
		frame.getContentPane().add(txtCodigo);
		
		txtPreco = new JTextField();
		txtPreco.setEditable(false);
		txtPreco.setColumns(10);
		txtPreco.setBounds(447, 89, 113, 20);
		frame.getContentPane().add(txtPreco);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Pre\u00E7o");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(447, 68, 52, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		txtTipo = new JTextField();
		txtTipo.setEditable(false);
		txtTipo.setColumns(10);
		txtTipo.setBounds(591, 89, 113, 20);
		frame.getContentPane().add(txtTipo);
		
		JLabel lblConsultarProduto = new JLabel("Consultar Produto");
		lblConsultarProduto.setFont(new Font("Arial", Font.BOLD, 22));
		lblConsultarProduto.setBounds(374, 22, 241, 36);
		frame.getContentPane().add(lblConsultarProduto);
		
		JButton btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GerenciamentoProduto tela = new GerenciamentoProduto();
				tela.MostrarTela();
				frame.setVisible(false);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 13));
		btnVoltar.setBounds(10, 11, 48, 23);
		frame.getContentPane().add(btnVoltar);
		
		try {
			ResultSet resultado = Produto.consultarStatic();
			while(resultado.next()) {
				DLM.addElement(resultado.getString("codigo") + " - " + resultado.getString("nome"));
				listaCodigos.add(resultado.getString("codigo"));
			}
			list.setModel(DLM);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void MostrarTela() {
		frame.setVisible(true);
	}
}
