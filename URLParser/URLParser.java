import java.net.URL;
import java.net.MalformedURLException;

public class URLParser {

    public static void main(String[] args) {
        String urlString = "https://api.techstore.com:8443/products/category/electronics?sort=price&limit=20#reviews";

        try {
            URL url = new URL(urlString);

            System.out.println("Original URL: " + urlString);
            System.out.println("----------------------------------------");

            System.out.println("Protocol: " + url.getProtocol());

            System.out.println("Host: " + url.getHost());

            int port = url.getPort();
            System.out.println("Port: " + (port == -1 ? "Default (-1, none specified)" : port));

            System.out.println("Path: " + url.getPath());

            String query = url.getQuery();
            System.out.println("Query String: " + query);
            System.out.println("Query Parameters:");
            if (query != null) {
                String[] pairs = query.split("&");
                for (String pair : pairs) {
                    String[] keyValue = pair.split("=", 2);
                    String key = keyValue[0];
                    String value = keyValue.length > 1 ? keyValue[1] : "";
                    System.out.println("   " + key + " = " + value);
                }
            } else {
                System.out.println("   (none)");
            }

            System.out.println("Fragment: " + url.getRef());

        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        }
    }
}
