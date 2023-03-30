package model.dao;

import db.DB;
import model.dao.impl.VendedorDaoJDBC;
import model.dao.impl.DepartamentDaoJDBC;

public class DaoFactory {

	public static VendedorDao createVendedorDao() {
		return new VendedorDaoJDBC(DB.getConnection());	
	}
	
	public static DepartamentoDao createDepartmentDao() {
		return new DepartamentDaoJDBC(DB.getConnection());
	}
}
