package app;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class App2 {
    public static void main(String[] args) {

        DepartmentDAO departmentDao = DAOFactory.createDepartmentDAO();

        System.out.println("\n=== TEST 3: insert =======");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());
    }
}
