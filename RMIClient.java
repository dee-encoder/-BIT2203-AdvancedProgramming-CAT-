import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

    public static void main(String[] args) {
        try {
            // Locate the RMI registry running on localhost, port 1099
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Loookup the remote object by the name the server registered it under
            TemperatureConverter converter = (TemperatureConverter) registry.lookup("TemperatureConverter");

            // Call the remote method
            double celsius = 25.0;
            double fahrenheit = converter.celsiusToFahrenheit(celsius);

            System.out.println(celsius + "°C converted to Fahrenheit is: " + fahrenheit + "°F");

            // demonstrate the reverse conversion too
            double backToCelsius = converter.fahrenheitToCelsius(fahrenheit);
            System.out.println(fahrenheit + "°F converted back to Celsius is: " + backToCelsius + "°C");

        } catch (Exception e) {
            System.out.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}