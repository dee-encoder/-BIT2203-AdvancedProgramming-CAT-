java.net.URL doesn't have a built-in method to split query parameters into key-value pairs, so the code manually splits the query string on &, then splits each pair on = (limited to 2 parts, in case a value itself contains =).
getPort() returns -1 if no port was explicitly specified in the URL — this example has 8443, so it will print that.
getRef() is the method that retrieves the fragment (the part after #).
