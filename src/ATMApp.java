import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMApp {
    private Bank bank;
    private User currentUser;
    private JTextField userIdField;
    private JPasswordField pinField;

    public ATMApp() {
        bank = new Bank();
    }

    public void start() {
        JFrame frame = new JFrame("ATM Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel userIdLabel = new JLabel("User ID:");
        userIdField = new JTextField(20);
        JLabel pinLabel = new JLabel("PIN:");
        pinField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        frame.add(userIdLabel);
        frame.add(userIdField);
        frame.add(pinLabel);
        frame.add(pinField);
        frame.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticateUser();
            }
        });

        frame.setVisible(true);
    }

    private void authenticateUser() {
        String userId = userIdField.getText();
        String pin = new String(pinField.getPassword());

        currentUser = bank.validateUser(userId, pin);
        if (currentUser != null) {
            showATMMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
        }
    }

    private void showATMMenu() {
        JFrame atmFrame = new JFrame("ATM Menu");
        atmFrame.setSize(300, 200);
        atmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        atmFrame.setLayout(new FlowLayout());

        JButton checkBalanceButton = new JButton("Check Balance");
        JButton depositButton = new JButton("Deposit Money");
        JButton withdrawButton = new JButton("Withdraw Money");
        JButton exitButton = new JButton("Exit");

        atmFrame.add(checkBalanceButton);
        atmFrame.add(depositButton);
        atmFrame.add(withdrawButton);
        atmFrame.add(exitButton);

        checkBalanceButton.addActionListener(e -> currentUser.checkBalance());
        depositButton.addActionListener(e -> currentUser.depositMoney());
        withdrawButton.addActionListener(e -> currentUser.withdrawMoney());
        exitButton.addActionListener(e -> atmFrame.dispose());

        atmFrame.setVisible(true);
    }

    public static void main(String[] args) {
        ATMApp atmApp = new ATMApp();
        atmApp.start();
    }
}
