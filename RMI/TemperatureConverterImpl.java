import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// The actual implementation of the remote interface.
// Extends UnicastRemoteObject so it can receive remote calls over the network.
public class TemperatureConverterImpl extends UnicastRemoteObject implements TemperatureConverter {

    // Constructor must declare RemoteException (required by UnicastRemoteObject)
    protected TemperatureConverterImpl() throws RemoteException {
        super();
    }

    @Override
    public double celsiusToFahrenheit(double celsius) throws RemoteException {
        return (celsius * 9.0 / 5.0) + 32;
    }

    @Override
    public double fahrenheitToCelsius(double fahrenheit) throws RemoteException {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
}
