package Day_01.ex03;

import java.util.UUID;

public interface TransactionsList {
	public void addTransaction(Transaction tr);
	public void deleteTransaction(UUID uuid) throws TransactionNotFoundException;
	public Transaction[] toArray();
}
