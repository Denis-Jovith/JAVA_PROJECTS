
public class FuelTransaction {
    private String fuelType;
    private double amountLiters;
    private double totalCost;
    private String workerName;

    public FuelTransaction(String fuelType, double amountLiters, double totalCost, String workerName) {
        this.fuelType = fuelType;
        this.amountLiters = amountLiters;
        this.totalCost = totalCost;
        this.workerName = workerName;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getAmountLiters() {
        return amountLiters;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getWorkerName() {
        return workerName;
    }

    @Override
    public String toString() {
        return "Fuel Type: " + fuelType + ", Liters Sold: " + amountLiters + ", Total Cost: " + totalCost + ", Worker: " + workerName;
    }
}
