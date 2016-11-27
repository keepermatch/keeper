package com.codepath.keeper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.codepath.keeper.R;
import com.codepath.keeper.models.LoginRequest;
import com.codepath.keeper.models.User;
import com.codepath.keeper.services.KeeperService;
import com.crashlytics.android.Crashlytics;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import io.fabric.sdk.android.Fabric;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TEST_USER_ID = "55cbb222b63f760008d002b6";
    private TextView info;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private AccessTokenTracker mAccessTokenTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        mAccessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken newAccessToken) {
                updateWithToken(newAccessToken);
            }
        };
        updateWithToken(AccessToken.getCurrentAccessToken());

        setContentView(R.layout.activity_main);
        info = (TextView)findViewById(R.id.info);
        loginButton = (LoginButton)findViewById(R.id.login_button);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getApplicationContext(), "Logged into FB", Toast.LENGTH_SHORT).show();
                LoginRequest loginRequest = new LoginRequest();
                loginRequest.setAccessToken(loginResult.getAccessToken().getToken());
                loginToKeeper(loginRequest);
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException e) {
            }
        });

    }

    private void updateWithToken(final AccessToken currentAccessToken) {

        int SPLASH_TIME_OUT = 5000;

        if (currentAccessToken != null) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    //loginButton.setVisibility(View.GONE);
                    LoginRequest lr = new LoginRequest();
                    lr.setAccessToken(currentAccessToken.getToken().toString());
                    loginToKeeper(lr);

                }
            }, SPLASH_TIME_OUT);
        } else {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                   loginButton.setVisibility(View.VISIBLE);
                }
            }, SPLASH_TIME_OUT);
        }
    }



    private void loginToKeeper(LoginRequest loginRequest) {
        Toast.makeText(this, "Logging in to keeper", Toast.LENGTH_SHORT).show();
        KeeperService.Keeper keeper = KeeperService.createInstance();
        Call<User> call = keeper.login(loginRequest);
        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.raw().code() != 200) {
                    loginButton.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Issue logging into keeper", Toast.LENGTH_SHORT).show();

                } else {
                    loginButton.setVisibility(View.GONE);
                    User user = response.body();
                    Toast.makeText(getApplicationContext(), "Welcome, " + user.getFirstName(), Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(getApplicationContext(), MatchmakingMenuActivity.class);
                    i.putExtra(User.CURRENT_USER, user);
                    startActivity(i);
                }
           }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                loginButton.setVisibility(View.VISIBLE);
                Log.d("DEBUG", t.toString());

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }



}
