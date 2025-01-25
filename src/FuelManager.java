import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class FuelManager {
    private Map<String, Double> fuelPrices;

    public FuelManager() {
        fuelPrices = new HashMap<>();
    }

    // Set the price for a specific fuel type
    public void setFuelPrice(String fuelType, double price) {
        fuelPrices.put(fuelType, price);
    }

    // Get the price of a specific fuel type
    public double getFuelPrice(String fuelType) {
        return fuelPrices.getOrDefault(fuelType, 0.0);
    }

    // Get all fuel types
    public List<String> getFuelTypes() {
        Set<String> fuelTypesSet = fuelPrices.keySet();  // Get the keys (fuel types)
        return new ArrayList<>(fuelTypesSet);  // Convert the Set to a List
    }

    // Get all fuel prices (return the map of fuel types and their prices)
    public Map<String, Double> getFuelPrices() {
        return fuelPrices;
    }
}
