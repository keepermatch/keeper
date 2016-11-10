package com.codepath.keeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.codepath.keeper.models.User;
import com.codepath.keeper.models.UserDailyMatches;
import com.codepath.keeper.models.Vouch;
import com.codepath.keeper.models.VouchResponse;
import com.crashlytics.android.Crashlytics;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import io.fabric.sdk.android.Fabric;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        // vouch list
        // http://keeper.duxf8t8yvk.us-west-2.elasticbeanstalk.com/userVouches/55cbb222b63f760008d002b6
        KeeperService.Keeper keeper = KeeperService.createInstance();
        Call<VouchResponse> call = keeper.vouchResponse("55cbb222b63f760008d002b6");
        call.enqueue(new Callback<VouchResponse>() {
            @Override
            public void onResponse(Call<VouchResponse> call, Response<VouchResponse> response) {
                VouchResponse vouchResponse = response.body();

                for (Vouch vouch : vouchResponse.vouches) {
                    Log.d("DEBUG", vouch.vouches.get(0).body);
                }
            }

            @Override
            public void onFailure(Call<VouchResponse> call, Throwable t) {
                Log.d("DEBUG", t.toString());
            }
        });


        // user daily matches
        // https://www.dropbox.com/s/jdeo6at5vlxmd8n/userDailyMatches.json?raw=1"
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(
                "https://www.dropbox.com/s/jdeo6at5vlxmd8n/userDailyMatches.json?raw=1",
                new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable t) {
                        Log.d("DEBUG", t.toString());
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String response) {
                        Gson gson = new GsonBuilder().create();
                        UserDailyMatches userDailyMatches = gson.fromJson(response, UserDailyMatches.class);
                        for (User user : userDailyMatches.users) {
                            Log.d("DEBUG", user.firstName);
                        }
                    }
                });

    }





}
