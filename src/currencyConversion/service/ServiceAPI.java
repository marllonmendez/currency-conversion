package currencyConversion.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import currencyConversion.model.CurrencyModel;
import currencyConversion.record.CurencyRecord;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class ServiceAPI {
    public ServiceAPI(String baseValue, String targetValue, double value) {

        final String key = "a0747b852bb53b9aad9000b2";

        URI url = URI.create("https://v6.exchangerate-api.com/v6/" + key + "/pair/" + baseValue + "/" + targetValue);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            CurencyRecord curencyRecord = gson.fromJson(json, CurencyRecord.class);

            CurrencyModel currencyModel = new CurrencyModel();
            currencyModel.coin(curencyRecord, value);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }
}


