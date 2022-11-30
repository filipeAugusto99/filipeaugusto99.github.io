package aplicacao;

import DAO.ProdutosDAO;
import sistema.Produtos;

public class Main {

	public static void main(String[] args) {
		
//		Produtos produto1 = new Produtos();
//		produto1.setNomePedido("Frango");
//		produto1.setDescricao("Frango desfiado coberta com Catupiry");
//		produto1.setValor(27.69);
//		
//		Produtos produto2 = new Produtos();
//		produto2.setNomePedido("Carijó");
//		produto2.setDescricao("Frango desfiado, milho verde, tomate picado, ovos e mussarela");
//		produto2.setValor(36.00);
			
			//Metodo "save"
//		ProdutosDAO produtosDao = new ProdutosDAO();
//		produtosDao.save(produto2);
			
			//Metodo "update"
//		Produtos produto3 = new Produtos();
//		produto3.setNomePedido("Carija");
//		produto3.setDescricao("Frango desfiado, milho verde, tomate picado, ovos e mussarela");
//		produto3.setValor(36.00);
//		produto3.setNumeroPedido(2);
//		
//		ProdutosDAO produtosDao2 = new ProdutosDAO();
//		produtosDao2.update(produto3);
		
			//Metodo "delete"
		//ProdutosDAO produtosDao3 = new ProdutosDAO();
		//produtosDao3.delete(2);
			
			//Metodo de listagem
		ProdutosDAO produtoDao = new ProdutosDAO();
		
		for (Produtos i : produtoDao.getInformacoes()) {
			System.out.println();
			System.out.println("Numero do Pedido: " + i.getNumeroPedido());
			System.out.println("Produto: " + i.getNomePedido());
			System.out.println("Descrição: " + i.getDescricao());
			System.out.println("Valor: " + i.getValor());
		}
	}
}