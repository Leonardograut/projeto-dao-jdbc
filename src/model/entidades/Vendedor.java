package model.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Vendedor implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String name;
	private String email;
	private Date dataNascimento;
	private Double salarioBase;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartemento() {
		return departemento;
	}

	public void setDepartemento(Departamento departemento) {
		this.departemento = departemento;
	}


	//relacionamento de entidades 1 pra  1
	private Departamento departemento;
	
	
	public Vendedor() {
		
	}
	
	public Vendedor(Integer id, String name, String email, Date dataNascimento,Double salarioBase) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.salarioBase = salarioBase;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", name=" + name + ", email=" + email + ", dataNascimento=" + dataNascimento
				+ ", salarioBase=" + salarioBase + ", departemento=" + departemento + "]";
	}
	
	
	
}
