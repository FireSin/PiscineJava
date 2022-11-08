package edu.school21.chat.models.logic;

import java.util.List;

public class User {
    private long            _id;
    private String          _login;
    private String          _password;
    private List<Chatroom>  _createdRooms;
    private List<Chatroom>  _communicationRooms;

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
}
