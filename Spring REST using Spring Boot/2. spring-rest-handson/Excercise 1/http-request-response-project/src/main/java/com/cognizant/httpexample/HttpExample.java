
package com.cognizant.httpexample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            System.out.println("Request Method: " + con.getRequestMethod());
            System.out.println("Request URL: " + url);
            System.out.println("Response Code: " + con.getResponseCode());
            System.out.println("Response Message: " + con.getResponseMessage());
            System.out.println("Content-Type: " + con.getContentType());

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            System.out.println("Response Body:");
            System.out.println(content.toString());

            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
