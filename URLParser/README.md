
## URLParser.java

## Description
A Java program that demonstrates parsing a URL and extracting its individual components using the `java.net.URL` class.

## URL Used
https://api.techstore.com:8443/products/category/electronics?sort=price&limit=20#reviews

## Components Extracted
- Protocol
- Host
- Port
- Path
- Query parameters (as key-value pairs)
- Fragment

## How to Run
1.Build program in jgrasp
2. Run in jgrasp

## Explanation:
java.net.URL doesn't have a built-in method to split query parameters into key-value pairs, so the code manually splits the query string on &, then splits each pair on = (limited to 2 parts, in case a value itself contains =).
getPort() returns -1 if no port was explicitly specified in the URL — this example has 8443, so it will print that.
getRef() is the method that retrieves the fragment (the part after #).
