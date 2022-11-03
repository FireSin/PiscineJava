import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Program {

    private static final String pathSignature = "/home/artur/Desktop/PiscineJava/Day_02/ex00/files/signature.txt";
    private static final String pathResult = "/home/artur/Desktop/PiscineJava/Day_02/ex00/files/result.txt";
    public static void main(String[] args){
        Map<String, String> signature = addMap(pathSignature);
        Scanner sc = new Scanner(System.in);
        String inStr;
        System.out.print("-> ");
        while (!(inStr = sc.nextLine()).equals("42")){
            try {
                findSignature(signature, convertFile2Hex(inStr).toString());
            } catch (Exception e){
                System.out.print("-> ");
                continue;
            }
            System.out.print("-> ");
        }
        sc.close();
    }

    public static StringBuilder convertFile2Hex(String path) throws IOException {
        InputStream is = null;
        try {
            is = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            System.out.println("Нет такого файла или каталога");
        }
        int bytesCounter = 0;
        int value = 0;
        int i = 128;
        StringBuilder sbHex = new StringBuilder();
        StringBuilder sbResult = new StringBuilder();
        while ((value = is.read()) != -1 && i-- > 0) {
            sbHex.append(String.format("%02X", value));
            if (bytesCounter == 15) {
                sbResult.append(sbHex).append("\n");
                sbHex.setLength(0);
                bytesCounter = 0;
            } else {
                bytesCounter++;
            }
        }
        if (bytesCounter != 0) {
            for (; bytesCounter < 16; bytesCounter++) {
                sbHex.append("   ");
            }
            sbResult.append(sbHex).append("\n");
        }
        is.close();
        return sbResult;
    }

    public static Map<String, String> addMap(String path){
        Map<String, String> map = new HashMap<>();
        FileInputStream fileInputStream;
        try{
            fileInputStream = new FileInputStream(path);
            Scanner newScanner = new Scanner(fileInputStream);

            while (newScanner.hasNextLine()){
                String line = newScanner.nextLine();
                String[] lineArray = line.split(", ");
                map.put(lineArray[0], lineArray[1].replaceAll("\\s+", ""));
            }
            newScanner.close();
            fileInputStream.close();
        } catch (Exception error){
            System.err.println("Отсутствует файл сигнатур");
            System.exit(-1);
        }
        return map;
    }

    public static void findSignature(Map<String, String> signature, String hex) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(pathResult, true);
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка создания файла результатов");
            System.exit(-1);
        }
        for (Map.Entry<String, String> fileSignature : signature.entrySet()) {
            if (hex.contains(fileSignature.getValue())) {
                try {
                    fileOutputStream.write(fileSignature.getKey().getBytes());
                    fileOutputStream.write("\n".getBytes());
                } catch (IOException e) {
                    System.err.println("Ошибка записи файла результатов");
                    System.exit(-1);
                }
                System.out.println("PROCESSED");
                return;
            }
        }
    }

}