import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PetroPulseGUI {
    private JFrame frame;
    private WorkerManager workerManager;
    private FuelManager fuelManager;
    private BufferedImage backgroundImage;

    public PetroPulseGUI(WorkerManager workerManager, FuelManager fuelManager) {
        this.workerManager = workerManager;
        this.fuelManager = fuelManager;
        frame = new JFrame("Gas Filling Station Inventory System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Load the background image from src folder
        try {
            backgroundImage = ImageIO.read(new File("src/gas.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add a custom JPanel to the frame with background
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        frame.setContentPane(backgroundPanel);
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));

        // Create the buttons for the actions
        JButton manageWorkersButton = new JButton("Manage Workers");
        JButton manageFuelPricesButton = new JButton("Manage Fuel Prices");
        JButton recordTransactionButton = new JButton("Record Fuel Transaction");
        JButton viewFuelTransactionsButton = new JButton("View Fuel Transactions");
        JButton viewWorkersButton = new JButton("View Workers");
        JButton viewFuelPricesButton = new JButton("View Fuel Prices");
        JButton exitButton = new JButton("Exit");

        // Adding action listeners to each button
        manageWorkersButton.addActionListener(e -> manageWorkers());
        manageFuelPricesButton.addActionListener(e -> manageFuelPrices());
        recordTransactionButton.addActionListener(e -> recordTransaction());
        viewFuelTransactionsButton.addActionListener(e -> viewFuelTransactions());
        viewWorkersButton.addActionListener(e -> viewWorkers());
        viewFuelPricesButton.addActionListener(e -> viewFuelPrices());
        exitButton.addActionListener(e -> System.exit(0));

        // Set the buttons' alignment to center
        manageWorkersButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        manageFuelPricesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        recordTransactionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewFuelTransactionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewWorkersButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewFuelPricesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add the buttons to the frame
        backgroundPanel.add(manageWorkersButton);
        backgroundPanel.add(Box.createVerticalStrut(10)); // Add space between buttons
        backgroundPanel.add(manageFuelPricesButton);
        backgroundPanel.add(Box.createVerticalStrut(10)); // Add space between buttons
        backgroundPanel.add(recordTransactionButton);
        backgroundPanel.add(Box.createVerticalStrut(10)); // Add space between buttons
        backgroundPanel.add(viewFuelTransactionsButton);
        backgroundPanel.add(Box.createVerticalStrut(10)); // Add space between buttons
        backgroundPanel.add(viewWorkersButton);
        backgroundPanel.add(Box.createVerticalStrut(10)); // Add space between buttons
        backgroundPanel.add(viewFuelPricesButton);
        backgroundPanel.add(Box.createVerticalStrut(10)); // Add space between buttons
        backgroundPanel.add(exitButton);

        // Set the frame to center the content and make it visible
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    // Custom JPanel to handle background image painting
    private class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    private void manageWorkers() {
        String[] options = {"Add Worker", "Remove Worker", "Cancel"};
        int choice = JOptionPane.showOptionDialog(frame, "Select an action:", "Manage Workers",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            addWorker();
        } else if (choice == 1) {
            removeWorker();
        }
    }

    private void addWorker() {
        String name = JOptionPane.showInputDialog(frame, "Enter worker name:");
        String role = JOptionPane.showInputDialog(frame, "Enter worker role:");
        double salary = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter worker salary:"));
        Worker worker = new Worker(name, role, salary);
        workerManager.addWorker(worker);
        JOptionPane.showMessageDialog(frame, "Worker added successfully.");
    }

    private void removeWorker() {
        String name = JOptionPane.showInputDialog(frame, "Enter worker name to remove:");
        workerManager.removeWorker(name);
        JOptionPane.showMessageDialog(frame, "Worker removed successfully.");
    }

    private void viewWorkers() {
        List<Worker> workers = workerManager.getWorkers();
        if (workers.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No workers available.");
        } else {
            StringBuilder workersList = new StringBuilder("Workers List:\n");
            for (Worker worker : workers) {
                workersList.append(worker).append("\n");
            }
            JOptionPane.showMessageDialog(frame, workersList.toString());
        }
    }

    private void viewFuelPrices() {
        StringBuilder fuelPricesList = new StringBuilder("Current Fuel Prices:\n");
        for (String fuelType : fuelManager.getFuelTypes()) {
            double price = fuelManager.getFuelPrice(fuelType);
            fuelPricesList.append(fuelType).append(": ").append(price).append(" per liter\n");
        }
        JOptionPane.showMessageDialog(frame, fuelPricesList.toString());
    }

    private void viewFuelTransactions() {
        StringBuilder transactionsList = new StringBuilder("Fuel Transactions:\n");
        for (FuelTransaction transaction : PetroPulseApp.transactionHistory) {
            transactionsList.append(transaction).append("\n");
        }
        JOptionPane.showMessageDialog(frame, transactionsList.toString());
    }

    private void manageFuelPrices() {
        String fuelType = JOptionPane.showInputDialog(frame, "Enter fuel type (e.g., Petrol, Diesel):");
        double price = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter price per liter:"));
        fuelManager.setFuelPrice(fuelType, price);
        JOptionPane.showMessageDialog(frame, "Fuel price updated successfully.");
    }

    private void recordTransaction() {
        String fuelType = JOptionPane.showInputDialog(frame, "Enter fuel type (e.g., Petrol, Diesel):");
        double liters = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter number of liters sold:"));
        double pricePerLiter = fuelManager.getFuelPrice(fuelType);
        double totalCost = liters * pricePerLiter;
        String workerName = JOptionPane.showInputDialog(frame, "Enter worker name who sold the fuel:");

        FuelTransaction transaction = new FuelTransaction(fuelType, liters, totalCost, workerName);
        PetroPulseApp.transactionHistory.add(transaction); // Add to transaction history
        JOptionPane.showMessageDialog(frame, "Transaction recorded: " + transaction);
    }
}
