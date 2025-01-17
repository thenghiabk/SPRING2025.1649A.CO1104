package E00_SimpleBankingSystem;

import java.util.Scanner;

public class SimpleBankingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double balance = Double.parseDouble( scanner.nextLine() );

        double[] transactions = new double[5];  // Array to store transactions
        int transactionIndex = 0; // Index for storing transactions

        int choice; // Variable to store user's choice

        do {
            System.out.println("\nBanking Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transaction History");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt( scanner.nextLine() ) ;

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = Double.parseDouble( scanner.nextLine() );
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        transactions[transactionIndex] = depositAmount;
                        transactionIndex = transactionIndex + 1;
                        System.out.println("Updated balance: " + balance);
                    } else {
                        System.out.println("Invalid deposit amount. Please enter a positive number.");
                    }
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = Double.parseDouble( scanner.nextLine() );
                    if (withdrawalAmount > 0 && withdrawalAmount <= balance) {
                        balance -= withdrawalAmount;
                        transactions[transactionIndex] = -withdrawalAmount; // Negative for withdrawals
                        transactionIndex = transactionIndex + 1;
                        System.out.println("Updated balance: " + balance);

                    } else if(withdrawalAmount <= 0){
                        System.out.println("Invalid withdrawal amount. Please enter a positive number.");
                    }
                    else
                    {
                        System.out.println("Insufficient funds.");
                    }
                    break;

                case 3:
                    System.out.println("Transaction History:");
                    for(int i = 0; i < transactions.length; i++) {
                        System.out.println((transactions[i] >= 0 ? "+" : "") + transactions[i]); // Show +/-
                    }

                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}