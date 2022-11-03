import java.io.*;
import java.util.*;

public class Program {

    private static final String pathDict = "/home/artur/Desktop/PiscineJava/Day_02/ex01/files/dictionary.txt";


    public static void main(String[] args) {
        if (args.length != 2){
            System.err.println("Нужны названия 2 файлов");
            System.exit(-1);
        }
        List<String> fileA = getWords(args[0]);
        List<String> fileB = getWords(args[1]);
        TreeSet<String> dict = new TreeSet<>();
        dict.addAll(fileA);
        dict.addAll(fileB);
        dictionaryToFile(dict);
        List<Integer> occurrenceA = getOccurrence(dict, fileA);
        List<Integer> occurrenceB = getOccurrence(dict, fileB);
        int numerator = getNumerator(occurrenceA, occurrenceB);
        double denominator = getDenominator(occurrenceA, occurrenceB);
        double similarity = (double)((int)((numerator / denominator) * 100)) / 100;
        System.out.println("Similarity = " + similarity);
    }

    public static int getNumerator(List<Integer> a, List<Integer> b) {
        int num = 0;
        for (int i = 0; i < a.size(); i++) {
            num += a.get(i) * b.get(i);
        }
        return num;
    }

    public static double getDenominator(List<Integer> a, List<Integer> b) {
        double pow2A = 0;
        for (Integer x : a)
            pow2A += x * x;
        double pow2B = 0;
        for (Integer x : b)
            pow2B += x * x;
        return Math.sqrt(pow2A) * Math.sqrt(pow2B);
    }
    private static List<Integer> getOccurrence(TreeSet<String> dict, List<String> file) {
        List<Integer> occ = new ArrayList<>(dict.size());
        int i = 0;
        int counter = 0;
        for (String wordDict : dict) {
            for (String word : file) {
                if (wordDict.equals(word))
                    counter++;
            }
            occ.add(i, counter);
            i++;
            counter = 0;
        }
        return occ;
    }


    public static void dictionaryToFile(TreeSet<String> dict) {
        try {
            FileWriter file = new FileWriter(pathDict);
            BufferedWriter writer = new BufferedWriter(file);
            for (String word : dict) {
                writer.write(word + " ");
            }
            writer.close();
        } catch (NullPointerException e) {
            System.err.println("Не смог создать файл словаря");
            System.exit(-1);
        } catch (IOException e) {
            System.err.println("Не смог записать в файл словаря");
            System.exit(-1);
        }
    }

    public static List<String> getWords(String path){
        File file = new File(path);
        if (file.length() / (1024 * 1024) > 10){
            System.err.println("Файл слишком большой, предел 10мб");
            System.exit(-1);
        }
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e){
            System.err.println("Какой то из файлов не найден");
            System.exit(-1);
        }
        Scanner sc = new Scanner(fr);
        List<String> list = new ArrayList<>();
        String[] line;
        while (sc.hasNextLine()){
            line = sc.nextLine().split(" ");
            list.addAll(Arrays.asList(line));
        }
        try {
            fr.close();
        } catch (IOException e) {
            System.err.println("Какой то из файлов не смог закрыться");
            System.exit(-1);
        }
        return list;
    }
}