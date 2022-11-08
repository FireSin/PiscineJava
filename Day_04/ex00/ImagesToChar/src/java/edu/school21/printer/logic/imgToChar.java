package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class imgToChar {

    char _color1;
    char _color2;
    String _path;

    public imgToChar(char color1, char color2, String path) {
        _color1 = color1;
        _color2 = color2;
        _path = path;
    }

    public void Convert(){
        try{
            BufferedImage image = ImageIO.read(new File(_path));
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    Color col = new Color(image.getRGB(x, y));
                    if (col.getBlue() == 255 && col.getRed() == 255 && col.getGreen() == 255){
                        System.out.print(_color1);
                    } else if (col.getBlue() == 0 && col.getRed() == 0 && col.getGreen() == 0){
                        System.out.print(_color2);
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Херня с картинкой");
            System.exit(-1);
        }
    }
}
