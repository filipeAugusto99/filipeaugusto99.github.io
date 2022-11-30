package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import conexao.Conexao;
import sistema.Produtos;

public class ProdutosDAO {
	
	public void save (Produtos pedidos) {
		
		String sql = "INSERT INTO pedidos (nomePedido, descricao, valorR$) values (?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = (Connection) Conexao.createConnectionToMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, pedidos.getNomePedido());
			pstm.setString(2, pedidos.getDescricao());
			pstm.setDouble(3, pedidos.getValor());

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update (Produtos pedidos) {
		
		String sql = "UPDATE pedidos SET nomePedido = ?, descricao = ?, valorR$ = ?" + "WHERE numeroPedido = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
	
		try {
			conn = (Connection) Conexao.createConnectionToMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, pedidos.getNomePedido());
			pstm.setString(2, pedidos.getDescricao());
			pstm.setDouble(3, pedidos.getValor());
			pstm.setInt(4, pedidos.getNumeroPedido());
			
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
		
		String sql = "DELETE FROM pedidos WHERE numeroPedido = ?";
		
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
	
	public List<Produtos> getInformacoes() {
		
		String sql = "SELECT * FROM pedidos";
		
		List<Produtos> informacoes = new ArrayList<Produtos>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
	
		try {
			conn = (Connection) Conexao.createConnectionToMySql();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Produtos listagem = new Produtos();
				listagem.setNumeroPedido(rset.getInt("numeroPedido"));
				listagem.setNomePedido(rset.getString("nomePedido"));
				listagem.setDescricao(rset.getString("descricao"));
				listagem.setValor(rset.getDouble("valorR$"));

				
				informacoes.add(listagem);
			} 
		}catch (Exception e) {
			e.printStackTrace ();
		}finally {
			
			try {
				if (rset!= null) {
					rset.close();
				}
				
				if (pstm!=null) {
					pstm.close();
				}
				
				if (conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace ();
			}
			
		}
		return informacoes;
	}
	
}
