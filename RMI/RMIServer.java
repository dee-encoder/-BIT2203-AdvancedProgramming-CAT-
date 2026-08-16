import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;

public class RMIServer {

    public static void main(String[] args) {
        try {
            // Start the RMI registry programmatically on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Create an instance of the remote object implementation
            TemperatureConverterImpl converter = new TemperatureConverterImpl();

            // Bind the remote object to a name in the registry
            registry.rebind("TemperatureConverter", converter);

            System.out.println("TemperatureConverter Server is running and bound to registry...");
            System.out.println("Waiting for client requests.");

        } catch (Exception e) {
            System.out.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
