import java.util.Scanner;

class Program{

	public static void main(String[] args) {
		int n = 0;
		int countCoffee = 0;
		Scanner sc = new Scanner(System.in);
		while (n != 42) {
			n = sc.nextInt();
			if (n != 42){
				if (!isSimpleSum(n)){
					continue;
				}
				countCoffee++;
			}
		}
		sc.close();
		System.out.println("Count of coffee - request - " + countCoffee);
	}

	static boolean isSimpleSum(int i){
		int n = 0;
		while (i != 0) {
			n += i % 10;
			i /= 10;
		}
		if (n < 2){
			return false;
		}
		if (n % 2 == 0 && n != 2){
			return false;
		} 
		for(int j = 3; j * j <= n; j += 2) {
			if(n % j == 0){
				return false;
			}
		}
		return true;
	}
}