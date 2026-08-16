# RMI Temperature Converter

## Description
A Java **Remote Method Invocation (RMI)** demo application. A client calls methods on a remote object hosted by a server — across separate JVMs — to convert temperatures between Celsius and Fahrenheit.

## Files
- `TemperatureConverter.java` — Remote interface extending `java.rmi.Remote`, declaring the callable methods
- `TemperatureConverterImpl.java` — Server-side implementation, extends `UnicastRemoteObject` to support remote calls
- `RMIServer.java` — Starts an RMI registry and binds the remote object under the name `"TemperatureConverter"`
- `RMIClient.java` — Looks up the remote object via the registry and invokes its methods remotely

## How RMI Works Here
1. `RMIServer` creates the registry and binds `TemperatureConverterImpl` to the name `"TemperatureConverter"`.
2. `RMIClient` looks up that name in the registry and receives a stub (proxy) for the remote object.
3. The client calls `celsiusToFahrenheit(25.0)` on the stub as if it were a local method — RMI handles sending the request to the server and returning the result.

## How to Run
No external libraries required — RMI is built into standard Java.

1. Compile: javac TemperatureConverter.java TemperatureConverterImpl.java RMIServer.java RMIClient.java
2. Start the server (keep it running in its own terminal): java RMIServer
3. In a separate terminal (same folder), run the client: java RMIClient

## Expected Output:
25.0°C converted to Fahrenheit is: 77.0°F
77.0°F converted back to Celsius is: 25.0°C
