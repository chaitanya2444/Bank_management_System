package BankManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankManager manager = new BankManager();
        BankAccount currentAccount = null;

        while (true) {
            System.out.println("\n\tWelcome to Kalyan Bank");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Fixed Deposit");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    long accNo = sc.nextLong();
                    System.out.print("Enter your name: ");
                    sc.nextLine();  // consume newline
                    String name = sc.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initBalance = sc.nextDouble();
                    currentAccount = manager.createAccount(accNo, name, initBalance);
                    break;

                case 2:
                    currentAccount = getValidAccount(manager, sc);
                    if (currentAccount != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        currentAccount.deposit(depositAmount);
                    }
                    break;

                case 3:
                    currentAccount = getValidAccount(manager, sc);
                    if (currentAccount != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        currentAccount.withDraw(withdrawAmount);
                    }
                    break;

                case 4:
                    currentAccount = getValidAccount(manager, sc);
                    if (currentAccount != null) {
                        System.out.print("Enter amount to FD: ");
                        double fdAmount = sc.nextDouble();
                        currentAccount.createFD(fdAmount);
                    }
                    break;

                case 5:
                    currentAccount = getValidAccount(manager, sc);
                    if (currentAccount != null) {
                        System.out.println("Available balance: ₹" + currentAccount.getBalance());
                        System.out.println("FD balance: ₹" + currentAccount.getFdAmount());
                    }
                    break;

                case 6:
                    System.out.println("Thank you for banking with us!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static BankAccount getValidAccount(BankManager manager, Scanner sc) {
        System.out.print("Enter your account number: ");
        long accNo = sc.nextLong();
        BankAccount account = manager.getAccount(accNo);
        if (account == null) {
            System.out.println("Account not found!");
            return null;
        }
        return account;
    }
}
