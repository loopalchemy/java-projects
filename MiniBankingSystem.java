import java.util.*;

class BankAccount {
    private String accountName;
    private double balance;
    private List<String> transactions;

    public BankAccount(String name) {
        this.accountName = name;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited $" + amount);
        System.out.println("Successfully deposited $" + amount);
    }

    public void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            transactions.add("Withdrew $" + amount);
            System.out.println("Successfully withdrew $" + amount);
        }
    }

    public void checkBalance() {
        System.out.println(accountName + ", your current balance is $" + balance);
    }

    public void showTransactions() {
        if(transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction history for " + accountName + ":");
            for(String t : transactions) {
                System.out.println("- " + t);
            }
        }
    }

    public String getAccountName() {
        return accountName;
    }
}

public class MiniBankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BankAccount> accounts = new HashMap<>();

        while(true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Create account");
            System.out.println("2. Access account");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            int mainChoice = sc.nextInt();
            sc.nextLine(); // consume newline

            if(mainChoice == 1) {
                System.out.print("Enter new account name: ");
                String name = sc.nextLine();
                if(accounts.containsKey(name)) {
                    System.out.println("Account already exists!");
                } else {
                    accounts.put(name, new BankAccount(name));
                    System.out.println("Account created successfully.");
                }
            } else if(mainChoice == 2) {
                System.out.print("Enter account name: ");
                String name = sc.nextLine();
                BankAccount account = accounts.get(name);
                if(account == null) {
                    System.out.println("Account not found!");
                    continue;
                }

                while(true) {
                    System.out.println("\nAccount Menu for " + name + ":");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Check balance");
                    System.out.println("4. Transaction history");
                    System.out.println("5. Back to main menu");

                    System.out.print("Your choice: ");
                    int choice = sc.nextInt();

                    switch(choice) {
                        case 1:
                            System.out.print("Enter amount to deposit: ");
                            double dep = sc.nextDouble();
                            account.deposit(dep);
                            break;
                        case 2:
                            System.out.print("Enter amount to withdraw: ");
                            double wd = sc.nextDouble();
                            account.withdraw(wd);
                            break;
                        case 3:
                            account.checkBalance();
                            break;
                        case 4:
                            account.showTransactions();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Invalid choice! Try again.");
                    }

                    if(choice == 5) break;
                }
            } else if(mainChoice == 3) {
                System.out.println("Goodbye!");
                sc.close();
                System.exit(0);
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
