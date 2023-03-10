package model.repositories.DAO;

import model.entities.Product;

import java.util.List;

public interface DAOProduct {

    void insert(Product p);
    void updateQuantity(Integer quantity,Integer id);
    void increasePrice(Double amount,Integer id);
    void decreasePrice(Double amount,Integer id);
    void remove(Integer id);
    void find(Integer id);
    void products();
}
