package Day_01.ex02;

public class UsersArrayList implements UsersList{

	private User[]	_data;
	private int		_sizeData;
	private int		_numUsers;

	UsersArrayList(){
		_data = new User[10];
		_sizeData = 10;
		_numUsers = 0;
	}
	
	public User FindUserById(int id) throws UserNotFoundException{
		for (int i = 0; i < _numUsers; i++) {
			if (_data[i].getIdentifier() == id){
				return _data[i];
			}
		}
		throw new UserNotFoundException();
	};

	public User FindUserByIndex(int index) throws UserNotFoundException{
		if (index < 0 || index >= _numUsers){
			throw new UserNotFoundException();
		}
		return _data[index];
	};

	public void addUser(String name, int balance) {
		if (_numUsers == _sizeData){
			_sizeData *= 2;
			User[] tmp = new User[_sizeData];
			for (int i = 0; i < _numUsers; i++) {
				tmp[i] = _data[i];
			}
			_data = tmp;
		}
		_data[_numUsers] = new User(name, balance);
		_numUsers++;
	}

	public int NumberUsers(){return _numUsers;}
}
