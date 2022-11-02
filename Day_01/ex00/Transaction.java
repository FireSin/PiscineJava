package Day_01.ex00;

import java.util.UUID;

public class Transaction {
	private enum Category{DEBIT, CREDIT};

	private	UUID		_uuid;
	private User		_recipient;
	private User		_sender;
	private Category	_transferCategory;
	private int			_transferAmount;

	public Transaction(User sender, User recipient, int amount){
		_transferAmount = amount;
		if (amount < 0){
			_transferCategory = Category.CREDIT;
			_recipient = recipient;
			_sender = sender;
		}
		else{
			_transferCategory = Category.DEBIT;
			_recipient = sender;
			_sender = recipient;
		}
		if (_sender.getBalance() + amount >= 0){
			_sender.setBalance(_sender.getBalance() + amount);
			_recipient.setBalance(_recipient.getBalance() - amount);
		}
		_uuid = UUID.randomUUID();
	}

	public String GetUUID(){return _uuid.toString();}

	public void SetUUID(String uuid){_uuid = UUID.fromString(uuid);}

	public User GetRecipient(){return _recipient;}
	
	public void SetRecipien(User recipient){_recipient = recipient;}

	public User GetSender(){return _sender;}
	
	public void SetSender(User sender){_sender = sender;}

	public Category GetCategory(){return _transferCategory;}
	
	public void SetCategory(Category transferCategory){_transferCategory = transferCategory;}

	public int GetTransferAmount(){return _transferAmount;}
	
	public void SetTransferAmount(int transferAmount){_transferAmount = transferAmount;}

	public String toString(){
		return "Transaction:\nUUID: " + _uuid + 
			"\nResipient:{ " + _recipient + 
			"}\nSender:{ " + _sender + 
			"}\nTransfer category: " + _transferCategory + 
			"\nAmount: " + _transferAmount;
	}
}
