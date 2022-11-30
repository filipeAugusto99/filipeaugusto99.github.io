package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ProdutosDAO;
import sistema.Produtos;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class cadastrarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastrarProduto frame = new cadastrarProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public cadastrarProduto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(cadastrarProduto.class.getResource("/image/icon-pizza.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(132, 61, 212, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(132, 92, 212, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(132, 123, 212, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Pedido:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(59, 58, 67, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescrico = new JLabel("Descricão:");
		lblDescrico.setForeground(Color.BLACK);
		lblDescrico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescrico.setBounds(36, 91, 93, 17);
		contentPane.add(lblDescrico);
		
		JLabel lblNewLabel_1_1 = new JLabel("Valor:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(70, 120, 53, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Adicionar Produto");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(132, 4, 164, 37);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//validacao do cadastro
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo 'nome' deve ser preenchido!");
					textField.requestFocus();
				} else if(textField_1.getText().isEmpty()) { 
					JOptionPane.showMessageDialog(null, "O campo 'descrição' deve ser preenchido!");
					textField_1.requestFocus();
				} else if(textField_2.getText().isEmpty()) { 
						JOptionPane.showMessageDialog(null, "O campo 'valor' deve ser preenchido!");
						textField_2.requestFocus();
				} else {
					
					double valor = Double.parseDouble(textField_2.getText());
					
					Produtos produto = new Produtos();
					produto.setNomePedido(textField.getText());
					produto.setDescricao(textField_1.getText());
					produto.setValor(valor);
					
					ProdutosDAO cadastra = new ProdutosDAO();
					cadastra.save(produto);	
					
				}
			}
			});
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(143, 180, 137, 37);
		contentPane.add(btnNewButton);
	}
}

