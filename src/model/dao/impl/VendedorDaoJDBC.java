package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class VendedorDaoJDBC  implements VendedorDao{

	
	private Connection coon;
	
	public VendedorDaoJDBC(Connection coon ) {
		this.coon = coon;
		
	}
	
	@Override
	public void insert(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = coon.prepareStatement(
					"SELECT seller.*,department.Name as DepName " 
					+ "FROM seller INNER JOIN department " 
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				
				Departamento dep = instantiateDepartmento(rs);
				Vendedor obj = instatiateVendedor(rs,dep);
				return obj;
				
				
			}
			return null;
		}
		
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	private Vendedor instatiateVendedor(ResultSet rs, Departamento dep) throws SQLException {
		
		Vendedor obj = new Vendedor();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setSalarioBase(rs.getDouble("BaseSalary"));
		obj.setDataNascimento(rs.getDate("BirthDate"));
		obj.setDepartemento(dep);
		return obj;
		
		
		
	}

	private Departamento instantiateDepartmento(ResultSet rs) throws SQLException {
		
		Departamento dep =new Departamento();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	
	}

	@Override
	public List<Vendedor> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = coon.prepareStatement(
					"SELECT seller.*,department.Name as DepName " 
					+"FROM seller INNER JOIN department " 
					+ "ON seller.DepartmentId = department.Id "
					
					+ "ORDER BY Name "	);
			
			
			rs = st.executeQuery();
			
			List<Vendedor> list = new ArrayList<>();
			
			Map<Integer,Departamento>map = new HashMap<>();
			
			
			while (rs.next()) {
				
				Departamento dep = map.get(rs.getInt("DepartmentId"));
				
				if (dep == null) {
					dep = instantiateDepartmento(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				
				
				
				Vendedor obj = instatiateVendedor(rs,dep);
				list.add(obj);
				
				
			}
			return list;
		}
		
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		} 
		
		
		
		
	}

	
	
	
	
	
	
	@Override
	public List<Vendedor> findByDepartamento(Departamento departamento) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = coon.prepareStatement(
					"SELECT seller.*,department.Name as DepName " 
					+"FROM seller INNER JOIN department " 
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name "	);
			
			st.setInt(1, departamento.getId());
			rs = st.executeQuery();
			
			List<Vendedor> list = new ArrayList<>();
			
			Map<Integer,Departamento>map = new HashMap<>();
			
			
			while (rs.next()) {
				
				Departamento dep = map.get(rs.getInt("DepartmentId"));
				
				if (dep == null) {
					dep = instantiateDepartmento(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				
				
				
				Vendedor obj = instatiateVendedor(rs,dep);
				list.add(obj);
				
				
			}
			return list;
		}
		
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		} 
		
	}

	
	
}
