package Day_01.ex05;

public interface UsersList {

	public void addUser(String name, int balance);

	public User FindUserById(int id) throws UserNotFoundException;

	public User FindUserByIndex(int index) throws UserNotFoundException;

	public int	NumberUsers();
}
