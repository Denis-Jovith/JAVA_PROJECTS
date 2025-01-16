import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyAndSellApp {

    private Inventory inventory;
    private Transaction transaction;
    private JFrame frame;
    private JTextField itemNameField, quantityField;

    public BuyAndSellApp() {
        inventory = new Inventory();
        transaction = new Transaction(inventory);
        frame = new JFrame("Buy and Sell App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        itemNameField = new JTextField(15);
        quantityField = new JTextField(5);

        JLabel itemNameLabel = new JLabel("Item Name:");
        JLabel quantityLabel = new JLabel("Quantity:");

        JButton purchaseButton = new JButton("Purchase Item");
        JButton sellButton = new JButton("Sell Item");
        JButton viewInventoryButton = new JButton("View Inventory");

        frame.add(itemNameLabel);
        frame.add(itemNameField);
        frame.add(quantityLabel);
        frame.add(quantityField);
        frame.add(purchaseButton);
        frame.add(sellButton);
        frame.add(viewInventoryButton);

        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                purchaseItem();
            }
        });

        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sellItem();
            }
        });

        viewInventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewInventory();
            }
        });

        frame.setVisible(true);
    }

    private void purchaseItem() {
        String itemName = itemNameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());

        if (transaction.purchaseItem(itemName, quantity)) {
            JOptionPane.showMessageDialog(frame, "Purchase successful!");
        } else {
            JOptionPane.showMessageDialog(frame, "Purchase failed. Check item stock.");
        }
    }

    private void sellItem() {
        String itemName = itemNameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());

        transaction.sellItem(itemName, quantity);
        JOptionPane.showMessageDialog(frame, "Item sold successfully!");
    }

    private void viewInventory() {
        StringBuilder inventoryList = new StringBuilder("Inventory:\n");

        for (Item item : inventory.getItems()) {
            inventoryList.append(item.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(frame, inventoryList.toString());
    }

    public static void main(String[] args) {
        BuyAndSellApp app = new BuyAndSellApp();

        // Add some items to the inventory for testing
        app.inventory.addItem(new Item("Laptop", 1000.0, 10));
        app.inventory.addItem(new Item("Smartphone", 500.0, 15));
        app.inventory.addItem(new Item("Headphones", 50.0, 30));
    }
}
