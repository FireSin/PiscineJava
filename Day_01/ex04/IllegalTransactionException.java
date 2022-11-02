package Day_01.ex04;

public class IllegalTransactionException extends RuntimeException{
	public String toString() {
		return ("Insufficient funds");
	}
}
