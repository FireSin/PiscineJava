package Day_01.ex05;

public class TransactionNotFoundException extends RuntimeException{
	public String toString() {
		return ("Transaction not found!");
	}
}
