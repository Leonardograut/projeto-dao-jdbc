package principal;



import model.dao.DaoFactory;
import model.dao.VendedorDao;

import model.entidades.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		
		VendedorDao vendedordao = DaoFactory.createVendedorDao();
		
		
		System.out.println("==== TEST 1: seller findById ====");
		
	    Vendedor vendedor = vendedordao.findById(3);
		
		System.out.println(vendedor);

	}

}
