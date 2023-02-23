package model.repositories.DB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Properties;

public class DBConnector {

    private static Connection c = null;
    public static Connection connect(){
        if(c == null) {
            try {
                Properties p = loadValues();
                String DBurl = loadValues().getProperty("dburl");
                c = DriverManager.getConnection(DBurl, p);
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return c;
    }

    public static void disconnect(){
        if(c != null){
            try{
                c.close();
            }catch (Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static Properties loadValues() {
        try (FileInputStream is = new FileInputStream("DB.values")){
            Properties p = new Properties();
            p.load(is);
            return p;
        }catch (Exception e){
           throw new RuntimeException(e.getMessage());
        }
    }

    public static void closeStatement(Statement s){
        if(s != null){
            try{
                s.close();
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
