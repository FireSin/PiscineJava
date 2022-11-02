package Day_01.ex02;

public class UserNotFoundException extends RuntimeException{
	public String toString() {
		return ("User not found!");
	}
}
