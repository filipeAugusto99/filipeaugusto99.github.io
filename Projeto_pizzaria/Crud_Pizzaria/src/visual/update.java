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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Toolkit;

public class update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update frame = new update();
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
	public update() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(update.class.getResource("/image/icon-pizza.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(87, 68, 154, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(87, 99, 154, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Produto:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 68, 57, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descrição:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 99, 67, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Novo Preço:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(296, 98, 85, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Número do Pedido:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(251, 66, 126, 20);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//validacao update
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo 'produto' deve ser preenchido!");
					textField.requestFocus();
				} else if(textField_1.getText().isEmpty()) { 
					JOptionPane.showMessageDialog(null, "O campo 'descrição' deve ser preenchido!");
					textField_1.requestFocus();
				} else if(textField_2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo 'numero do pedido' deve ser preenchido!");
					textField_2.requestFocus();
				} else if(textField_3.getText().isEmpty()) { 
					JOptionPane.showMessageDialog(null, "O campo 'valor' deve ser preenchido!");
					textField_3.requestFocus();
				} else {
				
				double valor = Double.parseDouble(textField_3.getText());
				int id = Integer.parseInt(textField_2.getText());
				
				Produtos produto = new Produtos();
				produto.setNomePedido(textField.getText());
				produto.setDescricao(textField_1.getText());
				produto.setValor(valor);
				produto.setNumeroPedido(id);
				
				ProdutosDAO produtoDao = new ProdutosDAO();
				produtoDao.update(produto);
				}
			}
		});
		btnNewButton.setBounds(154, 162, 120, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Atualização dos Produtos");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(95, 11, 237, 30);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(382, 68, 42, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(382, 99, 42, 20);
		contentPane.add(textField_3);
	}

	
}
