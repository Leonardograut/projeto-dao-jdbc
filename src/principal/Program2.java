package principal;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartamentoDao;
import model.entidades.Departamento;

public class Program2 {

	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);
		
		
		DepartamentoDao departamentoDao = DaoFactory.createDepartmentDao();
		
		
		System.out.println("=== TEST 1: findById =======");
		
		Departamento dep = departamentoDao.findById(2);
		System.out.println(dep);
		
		
		
		System.out.println("\n=== TEST 2: findAll =======");
		List<Departamento>list =departamentoDao.findAll();
		for(Departamento d :list) {
			System.out.println(d);
		}

		
		System.out.println("\n=== TEST 3: insert =======");
		Departamento novoDepartamento = new Departamento(null, "Musica");
		departamentoDao.insert(novoDepartamento);
		System.out.println("Inserido como id"+novoDepartamento.getId());
		
		
		
		
		System.out.println("\n=== TEST 4: update =======");
		Departamento deep = departamentoDao.findById(1);
		deep.setName("ELETRO");
		departamentoDao.update(deep);
		System.out.println("Update Completo");
		
		
		System.out.println("\n=== TEST 4: delete =======");
		System.out.println("Entre com id para deletar");
		int id = sc.nextInt();
		departamentoDao.deleteById(id);
		System.out.println("Delete foi um sucesso");
	}
	
	  
	
	
}
