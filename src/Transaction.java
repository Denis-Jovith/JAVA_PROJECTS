public class Transaction {

    private Inventory inventory;

    public Transaction(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean purchaseItem(String itemName, int quantity) {
        Item item = inventory.getItem(itemName);
        if (item != null && item.getQuantity() >= quantity) {
            item.decreaseQuantity(quantity);
            System.out.println("Purchased " + quantity + " " + itemName + "(s) for $" + (item.getPrice() * quantity));
            return true;
        } else {
            System.out.println("Sorry, not enough stock for " + itemName);
            return false;
        }
    }

    public void sellItem(String itemName, int quantity) {
        Item item = inventory.getItem(itemName);
        if (item != null) {
            item.increaseQuantity(quantity);
            System.out.println("Sold " + quantity + " " + itemName + "(s)");
        } else {
            System.out.println("Item not found.");
        }
    }
}
