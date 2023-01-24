package app;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
        
        SellerDAO sellerDao = DAOFactory.createSellerDAO();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        sellerDao.findByDepartment(department).forEach(System.out::println);

        System.out.println("\n=== TEST 3: seller findAll ===");
        sellerDao.findAll().forEach(System.out::println);

        // System.out.println("\n=== TEST 4: seller insert ===");
        // Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new java.util.Date(), 4000.0, department);
        // sellerDao.insert(newSeller);
        // System.out.println("Inserted! New id = " + newSeller.getId());
        // sellerDao.findAll().forEach(System.out::println);

        System.out.println("\n=== TEST 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed");
        
    }
}
