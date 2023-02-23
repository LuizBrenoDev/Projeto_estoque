package model.repositories.DAO;

import model.entities.Product;
import model.repositories.DB.DBConnector;

import java.sql.*;

public class DAOProductJDBC implements DAOProduct{

    private Connection c = null;

    public DAOProductJDBC(){
    }
    public DAOProductJDBC(Connection c){
        this.c = c;
    }
    @Override
    public void insert(Product p) {
        PreparedStatement ps = null;
        try{
            ps = c.prepareStatement(
                    "insert into products " +
                            "(name,sector,quantity,price) " +
                            "values " +
                            "(?,?,?,?) "
            );
            ps.setString(1,p.getName());
            ps.setString(2,p.getSector());
            ps.setInt(3,p.getQuantity());
            ps.setDouble(4,p.getPrice());

            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println(rows);
            }else{
                System.out.println("ERROR:Unexpected error occurred");
            }

        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }finally{
            DBConnector.closeStatement(ps);
        }
    }

    @Override
    public void update(Product p) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void find(Integer id) {

    }

    @Override
    public void products() {

    }
}
