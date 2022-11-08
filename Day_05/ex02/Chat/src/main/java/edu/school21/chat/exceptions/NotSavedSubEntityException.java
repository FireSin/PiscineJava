package edu.school21.chat.exceptions;

public class NotSavedSubEntityException extends RuntimeException{
    public String toString(){
        return ("User or Chatroom does not exist");
    }
}
