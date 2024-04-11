package com.alurachallenge.currencyconverter.apirequest;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConnection {
    private String urlStr;
    private String result;

    public void ApiConnect (String target, String base, double amount) {
        final String apiKey = System.getenv("API_KEY");
        this.urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey +
                "/pair/" + base + "/" +
                target + "/" + amount + "/";

        try {
            URL url = new URL(urlStr);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            // Accessing object
            this.result = jsonobj.get("conversion_result").getAsString();
        } catch (IOException e) {
        throw new RuntimeException(e.getMessage());
    }
        System.out.println("El resultado de su conversión es: " + result);
    }

    public void ApiConnected (String choose, double amount) {
        final String apiKey = System.getenv("API_KEY");
        this.urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey +
                "/pair/" + choose + "/" + amount + "/";

        try {
            URL url = new URL(urlStr);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            // Accessing object
            this.result = jsonobj.get("conversion_result").getAsString();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("El resultado de su conversión es: " + result);
    }
}
