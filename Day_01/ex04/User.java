package Day_01.ex04;

public class User {
	private String				_name;
	private int					_identifier;
	private	int					_balance;
	private TransactionsList	_transactions;

	public User(){}

	public User(String name, int balance){
		_name = name;
		if (balance < 0){
			_balance = 0;
		}
		else{
			_balance = balance;
		}
		_identifier = UserIdsGenerator.getInstance().generateId();
		_transactions = new TransactionsLinkedList();
	}

	public void setName(String name){_name = name;}

	public String getName(){return _name;}

	public void setIdentifier(int identifier){_identifier = identifier;}

	public int getIdentifier(){return _identifier;}

	public void setBalance(int balance){
		_balance = balance;
	}

	public int getBalance(){return _balance;}

	public TransactionsList GetTransactionsList(){return _transactions;}

	public String toString(){
		return "Name: " + _name + 
			"   Identifier: " + _identifier;
	}
}
