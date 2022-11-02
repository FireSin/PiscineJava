package Day_01.ex05;

import java.util.UUID;

public class Transaction {
	private enum Category{DEBIT, CREDIT};

	private	UUID		_uuid;
	private User		_recipient;
	private User		_sender;
	private Category	_transferCategory;
	private int			_transferAmount;

	public Transaction(User sender, User recipient, int amount) throws IllegalTransactionException{
		_transferAmount = amount;
		_uuid = UUID.randomUUID();
		_recipient = recipient;
		_sender = sender;
		if (amount < 0){
			_transferCategory = Category.CREDIT;
			if (_recipient.getBalance() + amount < 0){
				throw new IllegalTransactionException();
			}
			// _sender.setBalance(_sender.getBalance() - amount);
			// _recipient.setBalance(_recipient.getBalance() + amount);
			// _sender.GetTransactionsList().addTransaction(this);
			// _recipient.GetTransactionsList().addTransaction(this);
		}
		else{
			_transferCategory = Category.DEBIT;
			if (_sender.getBalance() - amount < 0){
				throw new IllegalTransactionException();
			}
			// _sender.setBalance(_sender.getBalance() - amount);
			// _recipient.setBalance(_recipient.getBalance() + amount);
			// _sender.GetTransactionsList().addTransaction(this);
			// _recipient.GetTransactionsList().addTransaction(this);
		}
		_sender.setBalance(_sender.getBalance() - amount);
		_sender.GetTransactionsList().addTransaction(this);
	}

	public UUID GetUUID(){return _uuid;}

	public void SetUUID(String uuid){_uuid = UUID.fromString(uuid);}

	public void SetUUID(UUID uuid){_uuid = uuid;}

	public User GetRecipient(){return _recipient;}
	
	public void SetRecipien(User recipient){_recipient = recipient;}

	public User GetSender(){return _sender;}
	
	public void SetSender(User sender){_sender = sender;}

	public Category GetCategory(){return _transferCategory;}
	
	public void SetCategory(Category transferCategory){_transferCategory = transferCategory;}

	public int GetTransferAmount(){return _transferAmount;}
	
	public void SetTransferAmount(int transferAmount){_transferAmount = transferAmount;}

	public String toString(){
		return "Transaction:\nUUID: " + GetUUID() + 
			"\nResipient:{ " + _recipient + 
			"}\nSender:{ " + _sender + 
			"}\nTransfer category: " + _transferCategory + 
			"\nAmount: " + _transferAmount + "\n";
	}
}
