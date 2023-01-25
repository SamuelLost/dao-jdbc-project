package app;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class App2 {
    public static void main(String[] args) {

        DepartmentDAO departmentDao = DAOFactory.createDepartmentDAO();

        System.out.println("=== TEST 1: findById =======");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);

        System.out.println("\n=== TEST 2: findAll =======");
        departmentDao.findAll().forEach(System.out::println);

        System.out.println("\n=== TEST 3: insert =======");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println("\n=== TEST 4: update =======");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update completed");

        System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter id for delete test: ");
		departmentDao.deleteById(8);
		System.out.println("Delete completed");
    }
}
