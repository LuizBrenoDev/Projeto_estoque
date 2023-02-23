package model.repositories.DAO;

import model.entities.Product;

import java.util.List;

public interface DAOProduct {

    void insert(Product p);
    void update(Product p);
    void remove(Integer id);
    void find(Integer id);
    void products();
}
