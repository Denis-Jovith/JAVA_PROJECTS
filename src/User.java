import javax.swing.*;

public class User {
    private String userId;
    private String pin;
    private double balance;

    public User(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void checkBalance() {
        JOptionPane.showMessageDialog(null, "Your balance is: " + balance);
    }

    public void depositMoney() {
        String amountStr = JOptionPane.showInputDialog("Enter amount to deposit:");
        try {
            double amount = Double.parseDouble(amountStr);
            if (amount > 0) {
                balance += amount;
                JOptionPane.showMessageDialog(null, "Deposit successful! New balance: " + balance);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid amount. Deposit failed.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input.");
        }
    }

    public void withdrawMoney() {
        String amountStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
        try {
            double amount = Double.parseDouble(amountStr);
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                JOptionPane.showMessageDialog(null, "Withdrawal successful! Remaining balance: " + balance);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid amount or insufficient funds.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input.");
        }
    }
}
