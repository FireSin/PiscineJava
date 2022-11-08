package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {

    private long            _id;
    private String          _name;
    private User            _owner;
    private List<Message>   _messages;

    public Chatroom(long _id, String _name, User _owner, List<Message> _messages) {
        this._id = _id;
        this._name = _name;
        this._owner = _owner;
        this._messages = _messages;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chatroom)) return false;
        Chatroom chatroom = (Chatroom) o;
        return get_id() == chatroom.get_id() && get_name().equals(chatroom.get_name()) && get_owner().equals(chatroom.get_owner()) && get_messages().equals(chatroom.get_messages());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), get_name(), get_owner(), get_messages());
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "_id=" + _id +
                ", _name='" + _name + '\'' +
                ", _owner=" + _owner +
                ", _messages=" + _messages +
                '}';
    }
}
