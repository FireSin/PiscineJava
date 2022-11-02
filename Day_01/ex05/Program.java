package Day_01.ex05;

public class Program {
	public static void main(String[] args) {
        if (args[0].equals("--profile=dev")){
            Menu menu = new Menu(true);
            menu.start();
        } else if (args[0].equals("--profile=std")){
            Menu menu = new Menu(false);
            menu.start();
        } else {
            System.out.println("Неправильный аргумент. Либо --profile=dev , либо --profile=std");
        }
    }
}
