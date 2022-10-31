import java.util.Scanner;

class Program{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numWeek = 1;
		long statistic = 0;
		while (numWeek <= 18){
			if (!checkString(sc, numWeek)){
				break;
			}
			statistic = minGrade(sc, statistic, numWeek);
			numWeek++;
		}
		printStatistic(statistic);
		sc.close();
	}
	
	static boolean checkString(Scanner sc, int numWeek){
		String s;
		s = sc.next();
		if (s.equals("42")){
			return false;
		}
		if ((!s.equals("Week") && !s.equals("42")) || !sc.hasNextInt()){
			printErr(sc);
		}
		if (numWeek != sc.nextInt()){
			printErr(sc);
		}
		return true;
	}
		
		static long minGrade(Scanner sc, long statistic, int numWeek){
			int grade;
			int minGrade = 9;
			for (int i = 0; i < 5; i++) {
				if (!sc.hasNextInt()){
					printErr(sc);
				}
				grade = sc.nextInt();
				if (grade < 1 || grade > 9){
					printErr(sc);
				}
				if (grade < minGrade){
					minGrade = grade;
				}
			}
			statistic += degree(numWeek) * minGrade;
			return statistic;
		}
	
	static long degree(int num){
		long result = 1;
		for (int i = 1; i < num; i++) {
			result *= 10;
		}
		return result;
	}

	static void printStatistic(long stat){
		for (int i = 1; stat != 0; i++) {
			System.out.print("Week " + i + " ");
			for (long j = 0; j < stat % 10; j++) {
				System.out.print("=");
			}
			System.out.println(">");
			stat /= 10;
		}
	}

	static void printErr(Scanner sc){
		System.err.println("IllegalArgument");
		sc.close();
		System.exit(-1);
	}
}