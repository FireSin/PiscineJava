package edu.school21.classes;

import java.util.StringJoiner;

public class User {
    private String _firstName;
    private String _lastName;
    private Integer _height;

    public User() {
        this._firstName = "Default first name";
        this._lastName = "Default last name";
        this._height = 0;
    }

    public User(String firstName, String _lastName, int _height) {
        this._firstName = firstName;
        this._lastName = _lastName;
        this._height = _height;
    }

    public Integer grow(int value) {
        this._height += value;
        return _height;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class . getSimpleName() + "[", "]")
                .add("firstName='" + _firstName + "'")
                .add("lastName='" + _lastName + "'")
                .add("height=" + _height)
                .toString();
    }
}
