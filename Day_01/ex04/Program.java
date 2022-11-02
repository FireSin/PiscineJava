package Day_01.ex04;

public class Program {
	public static void main(String[] args) {
		TransactionsService a = new TransactionsService();
        a.addUser("Boba", 100);
        a.addUser("Biba", 150);
        System.out.println(a.getBalance(1));
        System.out.println(a.getBalance(2));
        a.MakeTransaction(1, 2, 10);
        System.out.println(a.getBalance(1));
        System.out.println(a.getBalance(2));
        Transaction[] tr =  a.getTransactionList(1);
        for (int i = 0; i < tr.length; i++) {
            System.out.println(tr[i].toString());
        }
        Transaction[] tr2 =  a.getTransactionList(2);
        for (int i = 0; i < tr2.length; i++) {
            System.out.println(tr2[i].toString());
        }
        a.deleteTransaction(1, tr[0].GetUUID());
        System.out.println("------------------------------------");
        Transaction[] inv = a.invalidTransactions();
        for (int i = 0; i < inv.length; i++) {
            System.out.println(inv[i]);
        }
    }
}
