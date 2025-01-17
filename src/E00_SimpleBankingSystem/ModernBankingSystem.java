package E00_SimpleBankingSystem;

import java.util.Scanner;

public class ModernBankingSystem {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        Customer[] customers = new Customer[10];

        // mock data
        customers[0] = new Customer( "John", "ACCT101", 1000 );
        customers[1] = new Customer( "David", "ACCT102", 2000 );

        int customerIndex = 2;

        double[] transactions = new double[5];  // Array to store transactions
        int transactionIndex = 0; // Index for storing transactions

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
                    System.out.print("Enter customer's account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = Double.parseDouble( scanner.nextLine() );

                    customers[customerIndex] = new Customer(name, "ACCT"+accountNumber, balance);
                    customerIndex++;

                    break;

                case 2: // Display all customers
                    for ( int i = 0; i < customerIndex ; i++ ) {
                        System.out.println(customers[i]);
                        //System.out.println(customers[i].toString());
                    }
                    break;

                case 3: // Deposit
                    System.out.print("Enter customer's account number: ");
                    String accountNumberDeposit = scanner.nextLine();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = Double.parseDouble( scanner.nextLine() );
                    boolean isDeposited = false; // variable to check if deposit was successful
                    for (int i = 0; i < customerIndex; i++) {
                        if (customers[i].getAccountNumber().equals( accountNumberDeposit.toUpperCase() )){
                            customers[i].deposit( depositAmount );
                            isDeposited = true; // set isDeposited to true if deposit was successful
                        }
                    }

                    // if deposit was not successful, display error message
                    if(!isDeposited) { // similar to "isDeposited == false"
                        System.out.println( "Customer not found. Please try again." );
                    }

                    break;

                case 4: // Withdraw
                    System.out.print("Enter customer's account number: ");
                    String accountNumberWithdraw = scanner.nextLine();
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = Double.parseDouble( scanner.nextLine() );
                    boolean isWithdrawn = false; // variable to check if withdraw was successful
                    for (int i = 0; i < customerIndex; i++) {
                        if (customers[i].getAccountNumber().equals( accountNumberWithdraw.toUpperCase() )){
                            customers[i].withdraw( withdrawAmount );
                            isWithdrawn = true; // set isWithdrawn to true if withdraw was successful
                        }
                    }

                    // if withdraw was not successful, display error message
                    if(!isWithdrawn) { // similar to "isWithdrawn == false"
                        System.out.println( "Customer not found. Please try again." );
                    }

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

    public void deposit (double amount){
        if (amount < 0){ // data validation
            System.out.println("Deposit amount cannot be negative. Please try again!");
        }else {
            this.balance += amount;
            System.out.println("Deposit successful!");
        }
    }

    public void withdraw (double amount){
        if (amount < 0 || amount > balance){ // data validation
            System.out.println("Withdraw amount cannot be negative or greater than balance. Please try again!");
        }else {
            this.balance -= amount;
            System.out.println("Withdraw successful!");
        }
    }
}
