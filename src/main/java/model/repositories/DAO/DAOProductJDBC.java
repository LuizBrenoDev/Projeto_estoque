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
    public void updateQuantity(Integer quantity, Integer id) {
        PreparedStatement ps = null;
        try{
           ps = c.prepareStatement(
                  "update products " +
                          "set quantity = quantity - ? " +
                          "where " +
                          "idProduct = ?"
           );
           ps.setInt(1,quantity);
           ps.setInt(2,id);

           int rows = ps.executeUpdate();

           if(rows > 0){
               System.out.println(rows);
           }else{
           System.out.println("Unexpected error occurred");
           }
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }finally{
            DBConnector.closeStatement(ps);
        }
    }

    @Override
    public void increasePrice(Double amount, Integer id) {

        PreparedStatement ps = null;
        try{
            ps = c.prepareStatement(
                    "update products " +
                            "set price = price + ? " +
                            "where " +
                            "IdProduct = ?"
            );
            ps.setDouble(1,amount);
            ps.setInt(2,id);

            int rows = ps.executeUpdate();

            if(rows > 0){
                System.out.println(rows);
            }else{
                System.out.println("Unexpected error occurred");
            }
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }finally{
            DBConnector.closeStatement(ps);
        }
    }

    @Override
    public void decreasePrice(Double amount, Integer id) {
        PreparedStatement ps = null;
        try{
            ps = c.prepareStatement(
                    "update products " +
                            "set price = price - ? " +
                            "where " +
                            "IdProduct = ?"
            );
            ps.setDouble(1,amount);
            ps.setInt(2,id);

            int rows = ps.executeUpdate();

            if(rows > 0){
                System.out.println(rows);
            }else{
                System.out.println("Unexpected error occurred");
            }

        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }finally{
            DBConnector.closeStatement(ps);
        }
    }


    @Override
    public void remove(Integer id) {
        PreparedStatement ps = null;
        try{
            ps = c.prepareStatement(
                    "delete from products " +
                            "where idProduct  = ?"
            );

            ps.setInt(1,id);

            int rows  = ps.executeUpdate();

            if(rows > 0){
                System.out.println(rows);
            }else{
                System.out.println("ERROR");
            }
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }finally{
            DBConnector.closeStatement(ps);
        }
    }

    @Override
    public void find(Integer id) {

    }

    @Override
    public void products() {

    }
}
