package com.example.pauline.booze;

import android.content.pm.LauncherApps;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.pauline.booze.BeerService.url;

/**
 * Created by pauline on 4/5/17.
 */

public class SearchService {

    public static void searchBeer(String input, Callback callback){
        OkHttpClient client1 = new OkHttpClient();
        HttpUrl.Builder urlBuild = HttpUrl.parse(url).newBuilder();
        urlBuild.addQueryParameter(Constants.QueryQ,input).addQueryParameter(Constants.QueryTYPE,Constants.TYPE).addQueryParameter(Constants.QueryKEY,Constants.KEY);
        String url = urlBuild.build().toString();
        Request request1 = new Request.Builder().url(url).build();
        Call call1 = client1.newCall(request1);
        call1.enqueue(callback);

    }

    public ArrayList<Beer> processSearchResult(Response response) {
        ArrayList<Beer> beer = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject brewerydbJSON = new JSONObject(jsonData);
                JSONArray dataJson = brewerydbJSON.getJSONArray("data");
                for (int i = 0; i < dataJson.length(); i++) {
                    JSONObject beerJSON = dataJson.getJSONObject(i);
                    String name = beerJSON.getString("name");

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
