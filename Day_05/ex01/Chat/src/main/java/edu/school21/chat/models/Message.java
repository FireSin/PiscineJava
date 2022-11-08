package edu.school21.chat.models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Message {
    private long        _id;
    private User        _author;
    private Chatroom    _room;
    private String      _text;
    private Date         _time;

    public Message(long _id, User _author, Chatroom _room, String _text, Date _time) {
        this._id = _id;
        this._author = _author;
        this._room = _room;
        this._text = _text;
        this._time = _time;
    }

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

    public Date get_time() {
        return _time;
    }

    public void set_time(Date _time) {
        this._time = _time;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return get_id() == message.get_id() && get_author().equals(message.get_author()) && get_room().equals(message.get_room()) && get_text().equals(message.get_text()) && get_time().equals(message.get_time());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), get_author(), get_room(), get_text(), get_time());
    }

    @Override
    public String toString() {
        return "Message{\n" +
                "_id=" + _id +
                "\n_author=" + _author +
                "\n_room=" + _room +
                "\n_text='" + _text + '\'' +
                "\n_time=" + new SimpleDateFormat().format(_time) +
                "\n}";
    }
}
