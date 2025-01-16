import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterApp {

    private JFrame frame;
    private JTextField inputField;
    private JTextField outputField;
    private JComboBox<String> inputUnitCombo;
    private JComboBox<String> outputUnitCombo;

    public TemperatureConverterApp() {
        frame = new JFrame("Temperature Converter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        inputField = new JTextField(10);
        outputField = new JTextField(10);
        outputField.setEditable(false);

        JLabel inputLabel = new JLabel("Enter Temperature:");
        JLabel outputLabel = new JLabel("Converted Temperature:");

        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};

        inputUnitCombo = new JComboBox<>(units);
        outputUnitCombo = new JComboBox<>(units);

        JButton convertButton = new JButton("Convert");

        frame.add(inputLabel);
        frame.add(inputField);
        frame.add(new JLabel("From Unit:"));
        frame.add(inputUnitCombo);
        frame.add(outputLabel);
        frame.add(outputField);
        frame.add(new JLabel("To Unit:"));
        frame.add(outputUnitCombo);
        frame.add(convertButton);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });

        frame.setVisible(true);
    }

    private void convertTemperature() {
        try {
            double inputValue = Double.parseDouble(inputField.getText());
            String inputUnit = (String) inputUnitCombo.getSelectedItem();
            String outputUnit = (String) outputUnitCombo.getSelectedItem();

            double result = 0.0;

            if (inputUnit.equals("Celsius")) {
                if (outputUnit.equals("Fahrenheit")) {
                    result = TemperatureConverter.celsiusToFahrenheit(inputValue);
                } else if (outputUnit.equals("Kelvin")) {
                    result = TemperatureConverter.celsiusToKelvin(inputValue);
                } else {
                    result = inputValue;
                }
            } else if (inputUnit.equals("Fahrenheit")) {
                if (outputUnit.equals("Celsius")) {
                    result = TemperatureConverter.fahrenheitToCelsius(inputValue);
                } else if (outputUnit.equals("Kelvin")) {
                    result = TemperatureConverter.fahrenheitToKelvin(inputValue);
                } else {
                    result = inputValue;
                }
            } else if (inputUnit.equals("Kelvin")) {
                if (outputUnit.equals("Celsius")) {
                    result = TemperatureConverter.kelvinToCelsius(inputValue);
                } else if (outputUnit.equals("Fahrenheit")) {
                    result = TemperatureConverter.kelvinToFahrenheit(inputValue);
                } else {
                    result = inputValue;
                }
            }

            outputField.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        new TemperatureConverterApp();
    }
}
