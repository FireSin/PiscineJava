package edu.school21.chat.models.logic;

import java.util.Date;

public class Message {
    private long        _id;
    private User        _author;
    private Chatroom    _room;
    private String      _text;
    private String      _time;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public User get_author() {
        return _author;
    }

    public void set_author(User _author) {
        this._author = _author;
    }

    public Chatroom get_room() {
        return _room;
    }

    public void set_room(Chatroom _room) {
        this._room = _room;
    }

    public String get_text() {
        return _text;
    }

    public void set_text(String _text) {
        this._text = _text;
    }

    public String get_time() {
        return _time;
    }

    public void set_time(String _time) {
        this._time = _time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "_author=" + _author +
                ", _room=" + _room +
                ", _text='" + _text + '\'' +
                ", _time='" + _time + '\'' +
                '}';
    }
}
