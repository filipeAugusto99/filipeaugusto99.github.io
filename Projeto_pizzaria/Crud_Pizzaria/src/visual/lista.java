package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conexao.Conexao;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class lista extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lista frame = new lista();
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
	public lista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(lista.class.getResource("/image/icon-pizza.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 320);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 22, 322, 178);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Pedido", "Produto", "Descrição", "Valor"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Listar");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = Conexao.createConnectionToMySql();
					String sql = "SELECT * FROM pedidos";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					modelo.setNumRows(0);
					
					while (rs.next()) {
						modelo.addRow(new Object[] {rs.getInt("numeroPedido"), rs.getString("nomePedido"), rs.getString("descricao"), rs.getDouble("valorR$")});
					}
				} catch(Exception e1) {
					e1.printStackTrace();
				} 
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setBounds(166, 224, 113, 35);
		contentPane.add(btnNewButton);
	}
}
