package principal;

import java.util.Date;

import model.entidades.Departamento;
import model.entidades.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		Departamento obj = new Departamento(1,"Livros");
		
		Vendedor vendedor = new Vendedor(28, "leonardo", "leo@gmail.com", new Date(), 3000.0);
		
		System.out.println(obj);
		
		System.out.println(vendedor);

	}

}
