package Day_01.ex05;

import java.util.UUID;

public class TransactionsService {
	
	private UsersList 			_users;
	private TransactionsList	_invalidList;

	TransactionsService(){
		_users = new UsersArrayList();
		_invalidList = new TransactionsLinkedList();
	}

	public void addUser(String name, int balance){
		_users.addUser(name, balance);
	}

	public int getBalance(int id){
		int balance = 0;
		try {
			balance = _users.FindUserById(id).getBalance();
		} catch (UserNotFoundException e) {
			System.err.println(e.toString());
		}
		return balance;
	}

	public void MakeTransaction(int id1, int id2, int amount){
		User u1 = new User();
		User u2 = new User();
		try {
			u1 = _users.FindUserById(id1);
			u2 = _users.FindUserById(id2);
		} catch (UserNotFoundException e) {
			System.err.println(e.toString());
		}
		try {
			new Transaction(u2, u1, -amount).SetUUID(new Transaction(u1, u2, amount).GetUUID());;
		} catch (IllegalTransactionException e) {
			System.err.println(e.toString());
		}
	}

	public Transaction[] getTransactionList(int id){
		Transaction[] tr = null;
		try {
			tr = _users.FindUserById(id).GetTransactionsList().toArray();
		} catch (UserNotFoundException e) {
			System.err.println(e.toString());
		}
		return tr;
	}

	private Transaction findTransaction(Transaction[] lst, UUID uuid) throws TransactionNotFoundException{
		for (int i = 0; i < lst.length; i++) {
			if (lst[i].GetUUID().equals(uuid)){
					return lst[i];
			}
		}
		throw new TransactionNotFoundException();
	}

	public void deleteTransaction(int id, UUID uuid){
		User u1 = new User();
		User u2 = new User();
		try {
			u1 = _users.FindUserById(id);
		} catch (UserNotFoundException e) {
			System.err.println(e.toString());
		}
		try {
			Transaction tr = findTransaction(u1.GetTransactionsList().toArray(), uuid);
			if (tr.GetRecipient().getIdentifier() == id){
				u2 = tr.GetSender();
			} else {
				u2 = tr.GetRecipient();
			}
			u1.GetTransactionsList().deleteTransaction(uuid);
			try {
				_invalidList.addTransaction(findTransaction(u2.GetTransactionsList().toArray(), uuid));
			} catch (TransactionNotFoundException e) {
				return ;
			}

		} catch (TransactionNotFoundException e) {
			System.err.println(e.toString());
		}
		System.out.println("Перевод выполнен");
	}

	public Transaction[] invalidTransactions(){return _invalidList.toArray();}
}
