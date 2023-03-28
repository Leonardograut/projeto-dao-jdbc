package principal;



import java.util.List;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		
		VendedorDao vendedordao = DaoFactory.createVendedorDao();
		
		
		System.out.println("==== TEST 1: seller findById ====");
		
	    Vendedor vendedor = vendedordao.findById(3);
		
		System.out.println(vendedor);
		
		
		
		System.out.println("==== TEST 2: seller findByDepartment ====");
		
		Departamento departamento = new Departamento(2,null);
					
		List<Vendedor>list =vendedordao.findByDepartamento(departamento);

		for (Vendedor obj : list) {
			System.out.println(obj);
		}
		
		
		
		System.out.println("==== TEST 3: seller findByDepartment ====");
		 	
		
	    list =vendedordao.findAll();

		for (Vendedor obj : list) {
			System.out.println(obj);
		}
		
		
	}

}
