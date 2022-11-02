package Day_01.ex00;

public class Program {
	public static void main(String[] args) {
		User us;
		us = new User ("asd", 500);
		User us2 = new User ("asd2", 0);
		System.out.println(us.toString());
		System.out.println("---------------------");
		System.out.println(us2.toString());
		System.out.println("---------------------");
		Transaction tr = new Transaction(us, us2, -500);
		System.out.println(tr.toString());
		System.out.println("---------------------");
		System.out.println(us.toString());
		System.out.println("---------------------");
		System.out.println(us2.toString());
	}
}
