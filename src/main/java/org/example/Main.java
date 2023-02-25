package org.example;

import model.entities.Product;
import model.repositories.DAO.DAOFactory;
import model.repositories.DAO.DAOProduct;
import model.repositories.DB.DBConnector;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection c = null;

        while (sc != null) {
            System.out.println("Welcome to the market management!");
            System.out.println("Created by: Luiz Breno 2023");
            System.out.println("Digite um comando: ");
            String command = sc.nextLine();

            switch (command) {
                case "add":
                    System.out.println();
                    System.out.print("How many products? ");
                    int products = sc.nextInt();
                    for (int i = 1; i <= products; i++) {
                        System.out.println("Enter the data of product " + i);
                        sc.nextLine();
                        System.out.println("Name: ");
                        String name = sc.nextLine();
                        System.out.println("Sector: ");
                        String sector = sc.nextLine();
                        System.out.println("Quantity: ");
                        int quantity = sc.nextInt();
                        System.out.println("Price: ");
                        double price = sc.nextDouble();

                        try {
                            c = DBConnector.connect();
                            Product p = new Product(name, sector, quantity, price);
                            DAOProduct dp = DAOFactory.newDAOProduct(c);
                            dp.insert(p);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            DBConnector.disconnect();
                        }
                    }
                    break;

                case "remove":
                    System.out.println("delete");
                    System.out.println("Enter the id of products that will be deleted: ");
                    int id = sc.nextInt();
                    try {
                        c = DBConnector.connect();
                        DAOProduct dp = DAOFactory.newDAOProduct(c);
                        dp.remove(id);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        DBConnector.disconnect();
                    }

                    break;

                case "update":
                    System.out.println("update");
                    System.out.println("Enter the id of product: ");
                    int idProduct = sc.nextInt();
                    System.out.println("Enter the quantity of product that will updated: ");
                    int quantity = sc.nextInt();
                    try{
                       c = DBConnector.connect();
                       DAOProduct dp = DAOFactory.newDAOProduct(c);
                       dp.updateQuantity(quantity,idProduct);
                    }catch(Exception e){
                        e.getMessage();
                    }finally{
                        DBConnector.disconnect();
                    }
                    break;

                case "find":
                    System.out.println("find");
                    break;

                default:
                    System.out.println("error");
                    break;
            }
        }
        sc.close();
    }
}