package Day_01.ex04;

public class UserNotFoundException extends RuntimeException{
	public String toString() {
		return ("User not found!");
	}
}
