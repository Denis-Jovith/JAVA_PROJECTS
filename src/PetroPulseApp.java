import java.util.ArrayList;
import java.util.List;

public class PetroPulseApp {
    // Managers for workers and fuel
    private static WorkerManager workerManager = new WorkerManager();
    private static FuelManager fuelManager = new FuelManager();

    // List to store fuel transactions
    public static List<FuelTransaction> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        // Set initial fuel prices
        fuelManager.setFuelPrice("Petrol", 1.5);
        fuelManager.setFuelPrice("Diesel", 1.3);

        // Launch the GUI
        new PetroPulseGUI(workerManager, fuelManager);
    }
}
