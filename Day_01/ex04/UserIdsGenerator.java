package Day_01.ex04;

public class UserIdsGenerator {
	private static UserIdsGenerator instance;
	private static int id;

	private UserIdsGenerator(){};

	public static UserIdsGenerator getInstance(){
		if(instance == null){
			instance = new UserIdsGenerator();
			id = 0;
		}
		return instance;
	}

	public int generateId(){return ++id;}
}
