package principal;



import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		
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
		
		
		
		System.out.println("==== TEST 3: seller findAll ====");
		 	
		
	    list =vendedordao.findAll();

		for (Vendedor obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("==== TEST 4: Vendedor insert ====");
		Vendedor newVendedor = new Vendedor(null, "Leonardo", "leos@gmail.com", new Date(), 4000.0,departamento);
		vendedordao.insert(newVendedor);
		System.out.println("Insert! New id = :"+newVendedor.getId());
		
		
		
		System.out.println("==== TEST 5: Vendedor update ====");
		vendedor =vendedordao.findById(1);
		vendedor.setEmail("MariaDB@gmail.com");
		vendedordao.update(vendedor);
		System.out.println("Update Completo");
		
		
		
		System.out.println("==== TEST 6: Vendedor delete ====");
		System.out.println("Insira o id para excluir o teste");
		int id = sc.nextInt();
		vendedordao.deleteById(id);
		System.out.println("Deletado Com Sucesso");
		
		sc.close();
		
		
	}

}
