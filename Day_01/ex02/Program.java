package Day_01.ex02;

public class Program {
	public static void main(String[] args) {
		UsersArrayList al = new UsersArrayList();
		al.addUser("u1", 500);
		al.addUser("u2", 0);
		al.addUser("u3", 100);
		System.out.println(al.FindUserByIndex(1).toString());
	}
}
