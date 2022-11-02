package Day_01.ex02;

public interface UsersList {

	void addUser(String name, int balance);

	User FindUserById(int id) throws UserNotFoundException;

	User FindUserByIndex(int index) throws UserNotFoundException;

	int	NumberUsers();
}
