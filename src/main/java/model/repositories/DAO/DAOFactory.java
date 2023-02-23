package model.repositories.DAO;

import java.sql.Connection;

public class DAOFactory {

    public static DAOProduct newDAOProduct(Connection c){
        return new DAOProductJDBC(c);
    }
}
