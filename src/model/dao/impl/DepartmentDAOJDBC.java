package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class DepartmentDAOJDBC implements DepartmentDAO{

    private Connection conn;

    public DepartmentDAOJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO department "
                    + "(Name) "
                    + "VALUES "
                    + "(?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());
            
            int rowsAffected = st.executeUpdate();
            if(rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new SQLException("Unexpected error! No rows affected!");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
        }
        
    }

    @Override
    public void update(Department obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Department findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Department> findAll() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
