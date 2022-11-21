package edu.school21.models;

import java.util.Objects;

public class Product {

    private Long _id;
    private String _name;
    private double _price;

    public Product() {
    }

    public Product(Long _id, String _name, double _price) {
        this._id = _id;
        this._name = _name;
        this._price = _price;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public double get_price() {
        return _price;
    }

    public void set_price(double _price) {
        this._price = _price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return _id == product._id && Double.compare(product._price, _price) == 0 && Objects.equals(_name, product._name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _name, _price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "_id=" + _id +
                ", _name='" + _name + '\'' +
                ", _price=" + _price +
                '}';
    }
}
