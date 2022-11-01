import java.util.Scanner;

class Program{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		int lenghtText = text.length();
		createMas(text.length(), text.toCharArray(), new int[lenghtText], new char[lenghtText]);
		sc.close();	
	}

	static void createMas(int lenghtText, char[] chText, int[] sumCh, char[] mas){
		int lenghtMas = 0;
		int numCh = 0;
		int maxNum = 0;
		for (int i = 0; i < lenghtText; i++) {
			numCh = inMas(chText[i], mas, lenghtMas);
			if (numCh != -1){
				sumCh[numCh]++;
				if (maxNum < sumCh[numCh]){
					maxNum = sumCh[numCh];
				}
			}
			else{
				mas[lenghtMas] = chText[i];
				sumCh[lenghtMas] = 1;
				lenghtMas++;
			}
		}
		printResult(mas, sumCh, lenghtMas);
	}

	static void printResult(char[] mas, int[]sumCh, int lenghtMas){
		int[][] printNum = findTen(sumCh, lenghtMas);
		if (lenghtMas > 10){
			lenghtMas = 10;
		}
		System.out.println();
		for (int i = 100; i >= 0; i -= 10) {
			for (int j = 0; j < lenghtMas; j++) {
				if(printNum[j][1] * 100 / printNum[0][1] >= i && printNum[j][1] * 100 / printNum[0][1] < i + 10){
					System.out.print(printNum[j][1] + "\t");
				}
				else if(printNum[j][1] * 100 / printNum[0][1] > i){
					System.out.print("#\t");
				}
			};
			System.out.println();
		}
		for (int i = 0; i < lenghtMas; i++) {
			System.out.print(mas[printNum[i][0]] + "\t");
		}
	}

	static int[][] findTen(int[] sumCh, int lenghtMas){
		int[][] printNum = new int[10][2];
		int	nextMax;
		for (int i = 0; i < 10 && i < lenghtMas; i++) {
			nextMax = findNextMax(sumCh, lenghtMas);
			printNum[i][0] = nextMax;
			printNum[i][1] = sumCh[nextMax];
			sumCh[nextMax] = 0;
		}
		return printNum;
	}

	static int findNextMax(int[] sumCh, int lenghtMas){
		int maxi = 0;
		int maxNum = 0;
		for (int i = 0; i < lenghtMas; i++) {
			if (maxNum <= sumCh[i]){
				maxi = i;
				maxNum = sumCh[i];
			}
		}
		return maxi;
	}

	static int inMas(char c, char[] mas, int lenghtMas){
		for (int i = 0; i < lenghtMas; i++) {
			if (c == mas[i]){
				return i;
			}
		}
		return -1;
	}
}

// AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDWEWWKFKKDKKDSKAKLSLDKSKALLLLLLLLLLRTRTETWTWWWWWWWWWWOOOOOOO42