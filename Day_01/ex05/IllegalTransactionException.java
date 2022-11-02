package Day_01.ex05;

public class IllegalTransactionException extends RuntimeException{
	public String toString() {
		return ("Insufficient funds");
	}
}
