package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository{

    DataSource _ds;

    ProductsRepositoryJdbcImpl(DataSource ds){
        _ds = ds;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product";
        try{
            PreparedStatement ps = _ds.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                products.add(new Product(rs.getLong(1), rs.getString(2), rs.getDouble(3)));
            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        String query = "SELECT * FROM product WHERE id=" + id;
        try{
            PreparedStatement ps = _ds.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
               return Optional.of(new Product(rs.getLong(1), rs.getString(2), rs.getDouble(3)));
            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return Optional.empty();
    }

    @Override
    public void update(Product product) {
        String query = "UPDATE product SET name=?, price=? WHERE id=?";
        try {
            PreparedStatement ps = _ds.getConnection().prepareStatement(query);
            ps.setString(1, product.get_name());
            ps.setDouble(2, product.get_price());
            ps.setLong(3, product.get_id());
            ps.execute();

        } catch (SQLException e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void save(Product product) {
        String query = "INSERT INTO product(name, price) VALUES (?, ?)";
        try {
            PreparedStatement ps = _ds.getConnection().prepareStatement(query);
            ps.setString(1, product.get_name());
            ps.setDouble(2, product.get_price());
            ps.execute();
        } catch (SQLException e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM product WHERE id=" + id;
        try {
            PreparedStatement ps = _ds.getConnection().prepareStatement(query);
            ps.execute();
        } catch (SQLException e){
            System.out.println(e.toString());
        }
    }
}
