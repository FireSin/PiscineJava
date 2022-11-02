package Day_01.ex04;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList{
	
	private TransactionNode	_start;
	private TransactionNode	_end;
	private int				_size;

	TransactionsLinkedList(){
		_start = new TransactionNode(null);
		_end = new TransactionNode(null);
		_size = 0;
		_start._next = _end;
		_end._prev = _start;
	}

	public void addTransaction(Transaction tr){
		TransactionNode newList = new TransactionNode(tr, _end, _end._prev);
		_end._prev._next = newList;
		_end._prev = newList;
		_size++;
	}

	public void deleteTransaction(UUID uuid) throws TransactionNotFoundException{
		TransactionNode tmp = _start._next;
		while (tmp != _end) {
			if (tmp._data.GetUUID().equals(uuid)){
				if (tmp._prev != null){
					tmp._prev._next = tmp._next;
				}
				tmp._next._prev = tmp._prev;
				_size--;
				return;
			}
			tmp = tmp._next;
		}
		throw new TransactionNotFoundException();
	}

	public Transaction[] toArray(){
		Transaction[] arr = new Transaction[_size];
		TransactionNode tmp = _start._next;
		for (int i = 0; i < _size ; i++) {
			arr[i] = tmp._data;
			tmp = tmp._next;
		}
		return arr;
	}

	public int getSize(){return _size;}

	public String toString(){
		TransactionNode tmp = _start._next;
		String st = new String();
		while (tmp != _end){
			st = st.concat(tmp._data.toString());
			tmp = tmp._next;
		}
		return st;
	}
}

class TransactionNode {

    public Transaction      _data;
    public TransactionNode  _next;
    public TransactionNode  _prev;

    public TransactionNode(Transaction tr) {
        _data = tr;
        _next = null;
        _prev = null;
    }

    public TransactionNode(Transaction tr, TransactionNode next, TransactionNode prev) {
        _data = tr;
        _next = next;
        _prev = prev;
    }
}