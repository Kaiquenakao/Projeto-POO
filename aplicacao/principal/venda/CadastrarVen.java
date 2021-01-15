package principal.venda;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import principal.Funcionario;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CadastrarVen {

	private JFrame frame;
	private JTextField txtFuncionario;
	private JTextField txtCliente;
	private JTextField txtQuantidade;
	private JTextField txtPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarVen window = new CadastrarVen();
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
	public CadastrarVen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 658, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadastroCliente = new JLabel("Cadastro Venda");
		lblCadastroCliente.setFont(new Font("Arial", Font.BOLD, 22));
		lblCadastroCliente.setBounds(250, 11, 175, 36);
		frame.getContentPane().add(lblCadastroCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(26, 94, 133, 130);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);

		DefaultListModel <String> DLM = new DefaultListModel <String> ();
		ArrayList<String> listaProdutos = new ArrayList<String> ();
		
		DefaultListModel <String> listaCarrinho = new DefaultListModel <String> ();
		ArrayList<String> listaCarrinhoCod = new ArrayList<String> ();
		
		DefaultListModel <String> listaClientes = new DefaultListModel <String> ();
		ArrayList<String> listaCPF = new ArrayList<String> ();
		
		ArrayList<Float> listaPrecos = new ArrayList<Float> ();
		ArrayList<Float> listaPrecosCarrinho = new ArrayList<Float> ();

		try {
			ResultSet resultado = principal.Produto.consultarStatic();
			
			while(resultado.next()) {
				DLM.addElement(resultado.getString("nome") + " - R$" + resultado.getString("preco"));
				listaProdutos.add(resultado.getString("codigo"));
				listaPrecos.add(resultado.getFloat("preco"));
				
			}
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		list.setModel(DLM);
		
		JButton btnNotaFiscal = new JButton("Nota Fiscal");

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(240, 94, 133, 130);
		frame.getContentPane().add(scrollPane_1);
		
		JList list2 = new JList();
		scrollPane_1.setViewportView(list2);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_1.setBounds(441, 94, 133, 130);
		frame.getContentPane().add(scrollPane_1_1);
		
		JList list3 = new JList();
		scrollPane_1_1.setViewportView(list3);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Compra realizada com sucesso");
				principal.Venda ven = new principal.Venda(Funcionario.CPFlogado, listaCPF.get(list3.getSelectedIndex()));
				try {
					ven.adicionar(listaCarrinhoCod, listaPrecosCarrinho);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnFinalizar.setFont(new Font("Arial", Font.BOLD, 13));
		btnFinalizar.setEnabled(false);
		btnFinalizar.setBounds(250, 442, 123, 38);
		frame.getContentPane().add(btnFinalizar);
		

		JButton btnNewButton = new JButton(">>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um produto");
					return;
				}
				listaCarrinho.addElement(list.getSelectedValue().toString());
				listaCarrinhoCod.add(listaProdutos.get(list.getSelectedIndex()));
				listaPrecosCarrinho.add(listaPrecos.get(list.getSelectedIndex()));
				list2.setModel(listaCarrinho);
				if(listaCarrinho.size() != 0 && list3.getSelectedIndex() != -1) {
					btnNotaFiscal.setEnabled(true);
				}
				else {
					btnNotaFiscal.setEnabled(false);
				}
			}
		});
		btnNewButton.setBounds(169, 120, 57, 23);
		frame.getContentPane().add(btnNewButton);
		
		

		
		JButton btnNewButton_1 = new JButton("<<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list2.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um produto do carrinho");
					return;
				}
				//System.out.println(listaPrecosCarrinho.get(list2.getSelectedIndex()));
				listaCarrinhoCod.remove(list2.getSelectedIndex());
				listaPrecosCarrinho.remove(list2.getSelectedIndex());
				listaCarrinho.remove(list2.getSelectedIndex());
				list2.setModel(listaCarrinho);
				if(listaCarrinho.size() != 0 && list3.getSelectedIndex() != -1) {
					btnNotaFiscal.setEnabled(true);
				}
				else {
					btnNotaFiscal.setEnabled(false);
				}
			}
		});
		btnNewButton_1.setBounds(169, 174, 57, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Carrinho");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(270, 72, 70, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Clientes");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(478, 72, 59, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		try {
			ResultSet resultado = principal.Cliente.consultar();
			
			while(resultado.next()) {
				listaClientes.addElement(resultado.getString("CPF") + " - " + resultado.getString("nome"));
				listaCPF.add(resultado.getString("CPF"));
			}
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		list3.setModel(listaClientes);
		list3.setSelectedIndex(0);
		if(DLM.size() == 0) {
			JOptionPane.showMessageDialog(null, "Não há produtos cadastrados, por favor cadastre ao menos um produto");

		}
		if(listaClientes.size() == 0) {
			JOptionPane.showMessageDialog(null, "Não há clientes cadastrados, por favor cadastre ao menos um cliente");
		}
		
		btnNotaFiscal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCliente.setText(list3.getSelectedValue().toString());
				Funcionario func = new Funcionario();
				func.setCPF(Funcionario.CPFlogado);
				try {
					ResultSet resultado = func.consultarCPF();
					if(resultado.next()) {
						txtFuncionario.setText(resultado.getString("nome"));
					}
					else {
						JOptionPane.showMessageDialog(null, "Erro ao encontrar o funcionário");
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Verifique se passou no processo de login");
					e.printStackTrace();
				}
				txtQuantidade.setText(listaPrecosCarrinho.size() + "");
				float soma = 0;
				for(int i = 0; i < listaPrecosCarrinho.size(); i++) {
					soma += listaPrecosCarrinho.get(i);
				}
				txtPreco.setText(soma + "");
				btnFinalizar.setEnabled(true);
			}
		});
	
		
		JLabel lblNewLabel_1_2 = new JLabel("Produtos");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(53, 72, 70, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		btnNotaFiscal.setEnabled(false);
		btnNotaFiscal.setFont(new Font("Arial", Font.BOLD, 13));
		btnNotaFiscal.setBounds(250, 246, 123, 38);
		frame.getContentPane().add(btnNotaFiscal);
		
		JLabel lblNewLabel_1_3 = new JLabel("Funcion\u00E1rio");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(169, 318, 92, 14);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		txtFuncionario = new JTextField();
		txtFuncionario.setEditable(false);
		txtFuncionario.setColumns(10);
		txtFuncionario.setBounds(169, 343, 200, 20);
		frame.getContentPane().add(txtFuncionario);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Cliente");
		lblNewLabel_1_3_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_3_1.setBounds(169, 374, 92, 14);
		frame.getContentPane().add(lblNewLabel_1_3_1);
		
		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setColumns(10);
		txtCliente.setBounds(169, 397, 200, 20);
		frame.getContentPane().add(txtCliente);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Quantidade");
		lblNewLabel_1_3_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_3_1_1.setBounds(383, 319, 92, 14);
		frame.getContentPane().add(lblNewLabel_1_3_1_1);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setEditable(false);
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(383, 343, 92, 20);
		frame.getContentPane().add(txtQuantidade);
		
		JLabel lblNewLabel_1_3_1_1_1 = new JLabel("Pre\u00E7o total");
		lblNewLabel_1_3_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_3_1_1_1.setBounds(383, 374, 92, 14);
		frame.getContentPane().add(lblNewLabel_1_3_1_1_1);
		
		txtPreco = new JTextField();
		txtPreco.setEditable(false);
		txtPreco.setColumns(10);
		txtPreco.setBounds(383, 398, 92, 20);
		frame.getContentPane().add(txtPreco);
		

	}
	public void MostrarTela() {
		frame.setVisible(true);
	}
}
