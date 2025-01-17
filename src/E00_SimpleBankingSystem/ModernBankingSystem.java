package E00_SimpleBankingSystem;

public class ModernBankingSystem {
    public static void main ( String[] args ) {
        Customer customer1 = new Customer("John", "ACCT1234", 1000);
        Customer customer2 = new Customer("David", "ACCT1235", 5000);
        Customer customer3 = new Customer("Lucy", "ACCT1236", -50);

        System.out.println(customer1.getName() + " has a balance of $" + customer1.getBalance());
        System.out.println(customer2.getName() + " has a balance of $" + customer2.getBalance());
        System.out.println(customer3.getName() + " has a balance of $" + customer3.getBalance());
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
}
