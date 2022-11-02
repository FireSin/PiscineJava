package Day_01.ex03;

public class TransactionNotFoundException extends RuntimeException{
	public String toString() {
		return ("Transaction not found!");
	}
}
