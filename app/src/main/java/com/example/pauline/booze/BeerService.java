package com.example.pauline.booze;

import android.app.DownloadManager;
import android.content.pm.LauncherApps;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class BeerService {

    public static String key = Constants.KEY;
    public static String abv = Constants.ABV;
    public static String url = Constants.URL;


    public static void findBeers(Callback callback) {

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        urlBuilder.addQueryParameter(Constants.QueryKEY, key).addQueryParameter(Constants.QueryABV, abv);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);
        Log.d(BeerService.class.getSimpleName(), "calling");


    }


    public ArrayList<Beer> processResult(Response response) {
        ArrayList<Beer> beer = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject brewerydbJSON = new JSONObject(jsonData);
                JSONArray dataJson = brewerydbJSON.getJSONArray("data");
                for (int i = 0; i < dataJson.length(); i++) {
                    JSONObject beerJSON = dataJson.getJSONObject(i);
                    String name = beerJSON.getString("name");
                    //String nameDisplay = beerJSON.getString("nameDisplay");
                    String description = beerJSON.getString("description");

                    Beer newBeer = new Beer(name,description);
                    beer.add(newBeer);
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return beer;


    }

}