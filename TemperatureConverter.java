import java.rmi.Remote;
import java.rmi.RemoteException;

// The remote interface — declares methods that can be called remotely.
// Must extend java.rmi.Remote, and every method must declare RemoteException.
public interface TemperatureConverter extends Remote {

    double celsiusToFahrenheit(double celsius) throws RemoteException;

    double fahrenheitToCelsius(double fahrenheit) throws RemoteException;
}