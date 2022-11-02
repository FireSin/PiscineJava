package Day_00.ex01;

import java.util.Scanner;

class Program{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int step = 1;
		if (n < 2){
			sc.close();
			System.err.println("IllegalArgument");
			System.exit(-1);
		}
		if (n % 2 == 0 && n != 2){
			System.out.println("false " + step);
			sc.close();
			System.exit(1);
		} 
		for(int i = 3; i * i <= n; i += 2, step ++) {
			if(n % i == 0){
				System.out.println("false " + step);
				sc.close();
				System.exit(1);
			}
		}
		sc.close();
		System.out.println("true " + step);
		System.exit(0);
	}
}