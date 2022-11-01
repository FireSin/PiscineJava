class Program{
	public static void main(String[] args) {
		int n = 479598;
		System.out.println((n % 10) + (n / 10 % 10) + (n / 100 % 10) + (n / 1000 % 10) + (n / 10000 % 10) + (n / 100000 % 10));
	}
}