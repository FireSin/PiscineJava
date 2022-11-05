package edu.school21.printer.app;

import edu.school21.printer.logic.imgToChar;

public class Program {
    public static void main(String[] args) throws Exception{
        if (args.length != 3 || args[0].length() > 1 || args[1].length() > 1){
            throw new Exception("Должно быть 3 параметра: буква, буква, полный путь к картинке");
        }
        imgToChar img = new imgToChar(args[0].charAt(0), args[1].charAt(0), args[2]);
        img.Convert();
    }
}
