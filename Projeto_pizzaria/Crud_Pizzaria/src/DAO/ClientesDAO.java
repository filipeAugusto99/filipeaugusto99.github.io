package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexao.Conexao;
import sistema.Clientes;
import sistema.Produtos;

public class ClientesDAO {
	
	public void saveClient (Clientes clientes) {
		
		String sql = "INSERT INTO clientes (cliente, email, telefone) values (?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, clientes.getCliente());
			pstm.setString(2, clientes.getEmail());
			pstm.setString(3, clientes.getTelefone());
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update (Clientes clientes) {
		
		String sql = "UPDATE pedidos SET cliente = ?, email = ?, telefone = ?" + "WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
	
		try {
			conn = (Connection) Conexao.createConnectionToMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, clientes.getCliente());
			pstm.setString(2, clientes.getEmail());
			pstm.setString(3, clientes.getTelefone());
		
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			
				if (pstm != null) {
					pstm.close();
				} 
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete (int id) {
		
		String sql = "DELETE FROM clientes WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = (Connection) Conexao.createConnectionToMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
