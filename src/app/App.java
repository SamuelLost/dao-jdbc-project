package app;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
        
        SellerDAO sellerDao = DAOFactory.createSellerDAO();

        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
    }
}
