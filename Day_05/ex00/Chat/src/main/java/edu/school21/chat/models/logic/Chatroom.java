package edu.school21.chat.models.logic;

import java.util.List;

public class Chatroom {

    private long            _id;
    private String          _name;
    private User            _owner;
    private List<Message>   _messages;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public User get_owner() {
        return _owner;
    }

    public void set_owner(User _owner) {
        this._owner = _owner;
    }

    public List<Message> get_messages() {
        return _messages;
    }

    public void set_messages(List<Message> _messages) {
        this._messages = _messages;
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "_name='" + _name + '\'' +
                ", _owner=" + _owner +
                '}';
    }
}
