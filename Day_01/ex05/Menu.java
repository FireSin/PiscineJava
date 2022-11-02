package Day_01.ex05;

import java.util.Scanner;
import java.util.UUID;

public class Menu {
    private TransactionsService trService;
    private boolean dev;

    Menu(boolean mode) {
        dev = mode;
        trService = new TransactionsService();
    }

    public void start() {
        int input;
        Scanner scanner = new Scanner(System.in);
        if (dev) {
            while (true) {
                System.out.print("1. Добавить пользователя\n" +
                        "2. Посмотреть баланс пользователей\n" +
                        "3. Осуществить перевод\n" +
                        "4. Посмотреть все переводы конкретного пользователя\n" +
                        "5. DEV - удалить перевод по ID\n" +
                        "6. DEV - проверить корректность переводов\n" +
                        "7. Звершить выполнение\n" +
                        "-> ");
                input = scanner.nextInt();
                switch (input) {
                    case (1):
                        System.out.print("Введите имя и баланс пользователя\n" + "-> ");
                        try {
                            trService.addUser(scanner.next(), scanner.nextInt());
                        } catch (Exception ex) {
                            System.out.println("Неверно введены данные");
                        }
                        break;
                    case (2):
                        System.out.print("Введите id пользователя\n -> ");
                        System.out.println("Баланс: " + trService.getBalance(scanner.nextInt()));
                        break;
                    case (3):
                        System.out.print("Введите id-отправителя, id-получателя и сумму перевода\n" + "-> ");
                        try {
                            trService.MakeTransaction(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                        } catch (Exception ex) {
                            System.out.println("Невозможно провести платеж");
                        }
                        break;
                    case (4):
                        System.out.print("Введите id пользователя\n -> ");
                        try {
                            Transaction[] tr = trService.getTransactionList(scanner.nextInt());
                            for (int i = 0; i < tr.length; i++) {
                                System.out.println(tr[i].toString());
                            }
                        } catch (Exception ex) {
                            System.out.println("Неверно введены данные");
                        }
                        break;
                    case (5):
                        System.out.print("Введите id пользователя и UUID перевода\n -> ");
                        try {
                            trService.deleteTransaction(scanner.nextInt(), UUID.fromString(scanner.next()));
                        } catch (Exception ex) {
                            System.out.println("Неверно введены данные");
                        }
                        break;
                    case (6):
                        System.out.print("Результаты проверки\n -> ");
                        try {
                                Transaction[] tr = trService.invalidTransactions();
                                for (int i = 0; i < tr.length; i++) {
                                    System.out.println(tr[i].toString());
                                }
                        } catch (Exception ex) {
                            System.out.println("Ошибка");
                        }
                        break;
                    case (7):
                        scanner.close();
                        System.exit(0);
                }
                System.out.println("------------------------------------------------");
            }
        } else {
            while (true) {
                System.out.println("1. Добавить пользователя\n" +
                        "2. Посмотреть баланс пользователей\n" +
                        "3. Осуществить перевод\n" +
                        "4. Посмотреть все переводы конкретного пользователя\n" +
                        "5. Звершить выполнение\n" +
                        "-> ");
                input = scanner.nextInt();
                switch (input) {
                    case (1):
                        System.out.print("Введите имя и баланс пользователя\n" + "-> ");
                        try {
                            trService.addUser(scanner.next(), scanner.nextInt());
                        } catch (Exception ex) {
                            System.out.println("Неверно введены данные");
                        }
                        break;
                    case (2):
                        System.out.print("Введите id пользователя\n -> ");
                        trService.getBalance(scanner.nextInt());
                        break;
                    case (3):
                        System.out.print("Введите id-отправителя, id-получателя и сумму перевода\n" + "-> ");
                        try {
                            trService.MakeTransaction(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                            System.out.println("Перевод осуществлен");
                        } catch (Exception ex) {
                            System.out.println("Невозможно провести платеж");
                        }
                        break;
                    case (4):
                        System.out.print("Введите id пользователя\n -> ");
                        try {
                            Transaction[] tr = trService.getTransactionList(scanner.nextInt());
                            for (int i = 0; i < tr.length; i++) {
                                System.out.println(tr[i].toString());
                            }
                        } catch (Exception ex) {
                            System.out.println("Неверно введены данные");
                        }
                        break;
                    case (5):
                        scanner.close();
                        System.exit(0);
                }
                System.out.println("------------------------------------------------");
            }
        }
    }
}
