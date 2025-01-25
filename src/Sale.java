
public class Sale {
    private Worker worker;
    private String fuelType;
    private double litersSold;
    private double totalPrice;

    public Sale(Worker worker, String fuelType, double litersSold, double totalPrice) {
        this.worker = worker;
        this.fuelType = fuelType;
        this.litersSold = litersSold;
        this.totalPrice = totalPrice;
    }

    public Worker getWorker() {
        return worker;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getLitersSold() {
        return litersSold;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Worker: " + worker.getName() + ", Fuel: " + fuelType + ", Liters: " + litersSold + ", Total Price: " + totalPrice;
    }
}
