package BankManagementSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            BankManager manager = new BankManager();
            BankAccount currentAccount = null;

            while (true) {
                System.out.println("\n\tWelcome to chaitanya Bank");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Fixed Deposit");
                System.out.println("5. Check Balance");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = getValidChoice(sc);

                switch (choice) {
                    case 1:
                        System.out.print("Enter account number: ");
                        long accNo = sc.nextLong();
                        sc.nextLine();  // consume newline
                        System.out.print("Enter your name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter initial balance: ");
                        double initBalance = getValidBalance(sc);
                        if (manager.getAccount(accNo) != null) {
                            System.out.println("Account already exists!");
                        } else if (initBalance < 1000) {
                            System.out.println("Minimum balance should be 1000!");
                        } else {
                            currentAccount = manager.createAccount(accNo, name, initBalance);
                        }
                        break;

                    case 2:
                        currentAccount = getValidAccount(manager, sc);
                        if (currentAccount != null) {
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = getValidAmount(sc);
                            if (depositAmount > 0) {
                                currentAccount.deposit(depositAmount);
                            } else {
                                System.out.println("Invalid deposit amount!");
                            }
                        }
                        break;

                    case 3:
                        currentAccount = getValidAccount(manager, sc);
                        if (currentAccount != null) {
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = getValidAmount(sc);
                            if (withdrawAmount > 0 && currentAccount.getBalance() >= withdrawAmount) {
                                currentAccount.withDraw(withdrawAmount);
                            } else {
                                System.out.println("Insufficient balance or invalid amount!");
                            }
                        }
                        break;

                    case 4:
                        currentAccount = getValidAccount(manager, sc);
                        if (currentAccount != null) {
                            System.out.print("Enter amount to FD: ");
                            double fdAmount = getValidAmount(sc);
                            if (fdAmount > 0) {
                                currentAccount.createFD(fdAmount);
                            } else {
                                System.out.println("Invalid FD amount!");
                            }
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
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

    private static BankAccount getValidAccount(BankManager manager, Scanner sc) {
        System.out.print("Enter your account number: ");
        long accNo = sc.nextLong();
        sc.nextLine();  // consume newline
        BankAccount account = manager.getAccount(accNo);
        if (account == null) {
            System.out.println("Account not found!");
            return null;
        }
        return account;
    }

    private static int getValidChoice(Scanner sc) {
        while (true) {
            try {
                int choice = sc.nextInt();
                sc.nextLine();  // consume newline
                if (choice >= 1 && choice <= 6) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Try again.");
                sc.nextLine();  // clear invalid input
            }
        }
    }

    private static double getValidAmount(Scanner sc) {
        while (true) {
            try {
                double amount = sc.nextDouble();
                sc.nextLine();  // consume newline
                if (amount > 0) {
                    return amount;
                } else {
                    System.out.println("Invalid amount. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Try again.");
                sc.nextLine();  // clear invalid input
            }
        }
    }

    private static double getValidBalance(Scanner sc) {
        while (true) {
            try {
                double balance = sc.nextDouble();
                sc.nextLine();  // consume newline
                if (balance >= 1000) {
                    return balance;
                } else {
                    System.out.println("Minimum balance should be 1000. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Try again.");
                sc.nextLine();  // clear invalid input
            }
        }
    }
}