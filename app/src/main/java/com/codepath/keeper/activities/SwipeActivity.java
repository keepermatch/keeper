package com.codepath.keeper.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.codepath.keeper.R;
import com.codepath.keeper.models.User;
import com.codepath.keeper.models.UserDailyMatchesResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class SwipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);
        callGetUserDailyMatches();
    }


    // see https://www.dropbox.com/s/jdeo6at5vlxmd8n/userDailyMatches.json?raw=1"
    private void callGetUserDailyMatches() {
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
                        UserDailyMatchesResponse userDailyMatchesResponse = gson.fromJson(response, UserDailyMatchesResponse.class);
                        for (User user : userDailyMatchesResponse.getUsers()) {
                            //TODO: kcunha here is how you parse through user matches
                            Log.d("DEBUG", user.getFirstName());
                        }
                    }}
        );

    }
}
