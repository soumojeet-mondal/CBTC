import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Main {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public Main(String ownerName, double initialBalance) {
        this.accountNumber = generateAccountNumber();
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited into account " + accountNumber);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn from account " + accountNumber);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    private String generateAccountNumber() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }
}

class Bank {
    private List<Main> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void createAccount(String ownerName, double initialBalance) {
        Main account = new Main(ownerName, initialBalance);
        accounts.add(account);
        System.out.println("Account created successfully. Account Number: " + account.getAccountNumber());
    }

    public Main findAccount(String accountNumber) {
        for (Main account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void deposit(String accountNumber, double amount) {
        Main account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        Main account = findAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found");
        }
    }

    public double getBalance(String accountNumber) {
        Main account = findAccount(accountNumber);
        if (account != null) {
            return account.getBalance();
        } else {
            System.out.println("Account not found");
            return -1; // Or throw an exception
        }
    }
}

class BankY {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Example usage
        bank.createAccount("John Doe", 1000);
        bank.createAccount("Jane Smith", 500);

        bank.deposit("1234567890", 200);
        bank.withdraw("1234567890", 150);

        double balance = bank.getBalance("1234567890");
        System.out.println("Current balance: " + balance);
    }
}

