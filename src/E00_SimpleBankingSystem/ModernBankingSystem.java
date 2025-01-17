package E00_SimpleBankingSystem;

import java.util.Scanner;

public class ModernBankingSystem {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        Customer[] customers = new Customer[10];
        int customerIndex = 0;

        int choice; // Variable to store user's choice

        do {
            System.out.println("\nBanking Menu:");
            System.out.println("1. Create new customer");
            System.out.println("2. Display all customers");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt( scanner.nextLine() ) ;

            switch (choice) {
                case 1: // Create new customer
                    System.out.print("Enter customer's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer's DOB: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = Double.parseDouble( scanner.nextLine() );

                    customers[customerIndex] = new Customer(name, "ACCT"+accountNumber, balance);
                    customerIndex++;

                    break;

                case 2: // Display all customers
                    for ( int i = 0; i < customerIndex ; i++ ) {
                        System.out.println(customers[i]);
                    }
                    break;

                case 3: // Deposit
                    break;

                case 4: // Withdraw

                    break;

                case 5: // Transaction History
                    break;

                case 6: // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);
    }
}

class Customer {
    // attributes
    private String name;
    private String accountNumber;
    private double balance;

    // constructors
    public Customer(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        setBalance( balance );
    }

    // methods
    private void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    private void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber(){
        return this.accountNumber;
    }
    public double getBalance () {
        return balance;
    }
    private void setBalance ( double balance ) {
        if (balance < 0){
            balance = 0;
        }
        this.balance = balance;
    }

    @Override
    public String toString () {
        return "Customer {" +
                "name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
