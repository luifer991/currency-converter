import com.alurachallenge.currencyconverter.apirequest.ApiConnection;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        byte option = 0;

        while (option !=9) {
            System.out.println(Content.MENU);
            option = scanner.nextByte();
            String choose = "";
            switch (option) {
                case 1:
                    choose = "USD/COP";
                    break;
                case 2:
                    choose = "COP/USD";
                    break;
                case 3:
                    choose = "GBP/COP";
                    break;
                case 4:
                    choose = "COP/GBP";
                    break;
                case 5:
                    choose = "EUR/USD";
                    break;
                case 6:
                    choose = "USD/EUR";
                    break;
                case 7:
                    System.out.println("Elije la moneda que deseas convertir");
                    String targetCurrency = scanner.next().toUpperCase();

                    System.out.println("Elije la moneda a la que deseas cambiar");
                    String baseCurrency = scanner.next().toUpperCase();

                    System.out.println("Elije un monto");
                    double amount = scanner.nextDouble();
                    ApiConnection apiConnection = new ApiConnection();
                    apiConnection.ApiConnect(baseCurrency,targetCurrency,amount);
                    break;
                default:
                    break;
            }

            System.out.println("Elije el monto que desea convertir");
            double amount = scanner.nextDouble();

            ApiConnection apiConnection = new ApiConnection();
            apiConnection.ApiConnected(choose, amount);

        }

    }
}
