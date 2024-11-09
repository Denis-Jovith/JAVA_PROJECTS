//Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Base64;


//Creating a class for encryption
public class EncryptionDecryptionApp {

    private JFrame frame;
    private JTextArea textArea;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                EncryptionDecryptionApp window = new EncryptionDecryptionApp();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public EncryptionDecryptionApp() {
        // Initialize the main frame
        frame = new JFrame("Message Encryption And Decryption App");
        frame.setBounds(100, 100, 375, 398);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Create and set up the icon
        ImageIcon icon = new ImageIcon("whobenefitspage.png");
        frame.setIconImage(icon.getImage());

        // Text area for input
        textArea = new JTextArea();
        textArea.setFont(new Font("Roboto", Font.PLAIN, 20));
        textArea.setBounds(10, 50, 355, 100);
        textArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        frame.getContentPane().add(textArea);

        // Label for text area
        JLabel lblText = new JLabel("Enter text for encryption and decryption");
        lblText.setFont(new Font("Calibri", Font.PLAIN, 13));
        lblText.setBounds(10, 10, 350, 20);
        frame.getContentPane().add(lblText);

        // Label for password field
        JLabel lblPassword = new JLabel("Enter secret key for encryption and decryption");
        lblPassword.setFont(new Font("Calibri", Font.PLAIN, 13));
        lblPassword.setBounds(10, 170, 350, 20);
        frame.getContentPane().add(lblPassword);

        // Password field
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 25));
        passwordField.setBounds(10, 200, 350, 40);
        frame.getContentPane().add(passwordField);

        // Encrypt button
        JButton btnEncrypt = new JButton("ENCRYPT");
        btnEncrypt.setBackground(new Color(237, 56, 51));
        btnEncrypt.setForeground(Color.WHITE);
        btnEncrypt.setBounds(10, 250, 150, 40);
        btnEncrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                encrypt();
            }
        });
        frame.getContentPane().add(btnEncrypt);

        // Decrypt button
        JButton btnDecrypt = new JButton("DECRYPT");
        btnDecrypt.setBackground(new Color(0, 189, 86));
        btnDecrypt.setForeground(Color.WHITE);
        btnDecrypt.setBounds(200, 250, 150, 40);
        btnDecrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                decrypt();
            }
        });
        frame.getContentPane().add(btnDecrypt);

        // Reset button
        JButton btnReset = new JButton("RESET");
        btnReset.setBackground(new Color(16, 137, 255));
        btnReset.setForeground(Color.WHITE);
        btnReset.setBounds(10, 300, 340, 40);
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
        frame.getContentPane().add(btnReset);
    }

    private void encrypt() {
        String password = new String(passwordField.getPassword());

        if (password.equals("1234")) {
            JFrame encryptFrame = new JFrame("Encryption");
            encryptFrame.setBounds(100, 100, 400, 200);
            encryptFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            encryptFrame.getContentPane().setLayout(null);
            encryptFrame.getContentPane().setBackground(new Color(237, 56, 51));

            JTextArea encryptedTextArea = new JTextArea();
            encryptedTextArea.setFont(new Font("Roboto", Font.PLAIN, 10));
            encryptedTextArea.setBounds(10, 40, 380, 150);
            encryptedTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            encryptFrame.getContentPane().add(encryptedTextArea);

            String message = textArea.getText();
            try {
                byte[] encodedMessage = Base64.getEncoder().encode(message.getBytes("ASCII"));
                String encryptedMessage = new String(encodedMessage, "ASCII");
                encryptedTextArea.setText(encryptedMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }

            encryptFrame.setVisible(true);
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Input Password", "Encryption Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid Password", "Encryption Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void decrypt() {
        String password = new String(passwordField.getPassword());

        if (password.equals("1234")) {
            JFrame decryptFrame = new JFrame("Decryption");
            decryptFrame.setBounds(100, 100, 400, 200);
            decryptFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            decryptFrame.getContentPane().setLayout(null);
            decryptFrame.getContentPane().setBackground(new Color(0, 189, 86));

            JTextArea decryptedTextArea = new JTextArea();
            decryptedTextArea.setFont(new Font("Roboto", Font.PLAIN, 10));
            decryptedTextArea.setBounds(10, 40, 380, 150);
            decryptedTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            decryptFrame.getContentPane().add(decryptedTextArea);

            String message = textArea.getText();
            try {
                byte[] decodedMessage = Base64.getDecoder().decode(message.getBytes("ASCII"));
                String decryptedMessage = new String(decodedMessage, "ASCII");
                decryptedTextArea.setText(decryptedMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }

            decryptFrame.setVisible(true);
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Input Password", "Decryption Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid Password", "Decryption Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void reset() {
        passwordField.setText("");
        textArea.setText("");
    }
}
