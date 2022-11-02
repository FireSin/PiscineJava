package Day_01.ex05;

public class UserNotFoundException extends RuntimeException{
	public String toString() {
		return ("User not found!");
	}
}
