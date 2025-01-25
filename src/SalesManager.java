
import java.util.ArrayList;
import java.util.List;

public class SalesManager {
    private List<Sale> sales;

    public SalesManager() {
        sales = new ArrayList<>();
    }

    // Record a sale
    public void recordSale(Worker worker, String fuelType, double litersSold, double pricePerLiter) {
        double totalPrice = litersSold * pricePerLiter;
        Sale sale = new Sale(worker, fuelType, litersSold, totalPrice);
        sales.add(sale);
        System.out.println("Sale recorded: " + sale);
    }

    // View sales
    public void viewSales() {
        if (sales.isEmpty()) {
            System.out.println("No sales recorded.");
        } else {
            sales.forEach(sale -> System.out.println(sale));
        }
    }

    // Total liters sold
    public double totalLitersSold() {
        return sales.stream().mapToDouble(Sale::getLitersSold).sum();
    }
}
