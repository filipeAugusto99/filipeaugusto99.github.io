package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ClientesDAO;
import sistema.Clientes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;

public class cadastroCliente extends JFrame {

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
					cadastroCliente frame = new cadastroCliente();
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
	public cadastroCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(cadastroCliente.class.getResource("/image/icon-pizza.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 367);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(21, 58, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(21, 117, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(21, 176, 62, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo 'nome' deve ser preenchido!");
					textField.requestFocus();
				} else if(textField_1.getText().isEmpty()) { 
					JOptionPane.showMessageDialog(null, "O campo 'email' deve ser preenchido!");
					textField_1.requestFocus();
				} else if(textField_2.getText().isEmpty()) { 
						JOptionPane.showMessageDialog(null, "O campo 'telefone' deve ser preenchido!");
						textField_2.requestFocus();
				} else {
					Clientes clientes = new Clientes();
					clientes.setCliente(textField.getText());
					clientes.setEmail(textField_1.getText());
					clientes.setTelefone(textField_2.getText());
	
					ClientesDAO clientesDao = new ClientesDAO();
					clientesDao.saveClient(clientes);
			}
			}
		});
		btnNewButton.setBounds(146, 258, 147, 33);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(21, 83, 272, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(21, 142, 272, 23);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(21, 201, 272, 23);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cadastro do Cliente");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(95, 11, 216, 33);
		contentPane.add(lblNewLabel_3);
	}
}
