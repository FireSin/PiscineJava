package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private long            _id;
    private String          _login;
    private String          _password;
    private List<Chatroom>  _createdRooms;
    private List<Chatroom>  _communicationRooms;

    public User(long _id, String _login, String _password, List<Chatroom> _createdRooms, List<Chatroom> _communicationRooms) {
        this._id = _id;
        this._login = _login;
        this._password = _password;
        this._createdRooms = _createdRooms;
        this._communicationRooms = _communicationRooms;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_login() {
        return _login;
    }

    public void set_login(String _login) {
        this._login = _login;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public List<Chatroom> get_createdRooms() {
        return _createdRooms;
    }

    public void set_createdRooms(List<Chatroom> _createdRooms) {
        this._createdRooms = _createdRooms;
    }

    public List<Chatroom> get_communicationRooms() {
        return _communicationRooms;
    }

    public void set_communicationRooms(List<Chatroom> _communicationRooms) {
        this._communicationRooms = _communicationRooms;
    }

    @Override
    public String toString() {
        return "User{" +
                "_id=" + _id +
                ", _login='" + _login + '\'' +
                ", _createdRooms=" + _createdRooms +
                ", _communicationRooms=" + _communicationRooms +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return get_id() == user.get_id() && get_login().equals(user.get_login()) && get_password().equals(user.get_password()) && Objects.equals(get_createdRooms(), user.get_createdRooms()) && Objects.equals(get_communicationRooms(), user.get_communicationRooms());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), get_login(), get_password(), get_createdRooms(), get_communicationRooms());
    }
}
