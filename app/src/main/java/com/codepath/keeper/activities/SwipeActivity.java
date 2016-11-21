package com.codepath.keeper.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.codepath.keeper.R;
import com.codepath.keeper.fragments.ProfileFragment;
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

    private void startSwiping(User user) {
        // Within the activity
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ProfileFragment profileFragment = ProfileFragment.newInstance(user);
        ft.replace(R.id.flProfilePlaceholder, profileFragment);
        ft.commit();
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
                        User currentUser = null;
                        for (User user : userDailyMatchesResponse.getUsers()) {
                            Log.d("DEBUG", user.getFirstName());
                            currentUser = user;
                        }
                        startSwiping(userDailyMatchesResponse.getUsers().get(2));
                    }}
        );

    }
}
