package Day_01.ex03;

import java.util.UUID;

public class Program {
	public static void main(String[] args) {
		User        alex = new User("Alex", 1000);
        User        boba = new User("Boba", 500);
        User        mike = new User("Mike", 2000);
        User        gala = new User("Gala", 800);
        User        sara = new User("Sara", 1500);

        System.out.println(alex.toString());
        System.out.println(boba.toString());
        System.out.println(mike.toString());
        System.out.println(gala.toString());
        System.out.println(sara.toString());

		System.out.println("\n");

        Transaction transaction_1 = new Transaction(alex, boba, -30);
        Transaction transaction_2 = new Transaction(boba, mike, 130);
        Transaction transaction_3 = new Transaction(gala, sara, -300);
        Transaction transaction_4 = new Transaction(mike, alex, -400);
        Transaction transaction_5 = new Transaction(boba, mike, 700);

        System.out.println(alex.toString());
		System.out.println(boba.toString());
		System.out.println(mike.toString());
		System.out.println(gala.toString());
		System.out.println(sara.toString());

		System.out.println("\n");

        System.out.println(transaction_1.toString());
        System.out.println(transaction_2.toString());
        System.out.println(transaction_3.toString());
        System.out.println(transaction_4.toString());
        System.out.println(transaction_5.toString());

		System.out.println("\n");

        System.out.println(alex.GetTransactionsList().toString());
		System.out.println("\n\n");
        System.out.println(boba.GetTransactionsList().toString());

		System.out.println("\n");

        Transaction[]	transactionArray;
        transactionArray = alex.GetTransactionsList().toArray();
        System.out.println(transactionArray[1].toString());
        System.out.println("transactionArray.length = " + transactionArray.length);

        alex.GetTransactionsList().deleteTransaction(transactionArray[1].GetUUID());

        transactionArray = alex.GetTransactionsList().toArray();
        System.out.println("transactionArray.length = " + transactionArray.length);

		System.out.println("\n");

        try {
            alex.GetTransactionsList().deleteTransaction(UUID.randomUUID());
        } catch (TransactionNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
