package com.codepath.keeper;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.codepath.keeper.activities.MainActivity;
import com.codepath.keeper.models.GenerateTokenRequest;
import com.codepath.keeper.models.GenerateTokenResponse;
import com.codepath.keeper.services.KeeperService;
import com.layer.atlas.util.picasso.requesthandlers.MessagePartRequestHandler;
import com.layer.sdk.LayerClient;
import com.layer.sdk.exceptions.LayerException;
import com.layer.sdk.listeners.LayerAuthenticationListener;
import com.layer.sdk.listeners.LayerConnectionListener;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import retrofit2.Call;


/**
 * Created by matthewlent on 1/1/17.
 */

public class KeeperApplication extends MultiDexApplication {
    // Called when the application is starting, before any other application objects have been created.
    // Overriding this method is totally optional!

    private static LayerClient sLayerClient;
    private static Application sInstance;
    private static String sLayerAppId = "layer:///apps/production/b914337c-4b55-11e5-a6e9-9190690d2327";
    private static Picasso sPicasso;

    public static LayerClient getLayerClient() {
        return sLayerClient;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        MultiDex.install(newBase);
        super.attachBaseContext(newBase);
    }

    public static Picasso getPicasso() {
        if (sPicasso == null) {
            // Picasso with custom RequestHandler for loading from Layer MessageParts.
            sPicasso = new Picasso.Builder(sInstance)
                    .addRequestHandler(new MessagePartRequestHandler(getLayerClient()))
                    .build();
        }
        return sPicasso;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Required initialization logic here!
        // Allow the LayerClient to track app state
        LayerClient.applicationCreated(this);
        sInstance = this;


        sLayerClient = LayerClient.newInstance(this, sLayerAppId);

        LayerConnectionListener layerConnectionListener = new LayerConnectionListener() {
            @Override
            public void onConnectionConnected(LayerClient layerClient) {
                layerClient.authenticate();
            }

            @Override
            public void onConnectionDisconnected(LayerClient layerClient) {

            }

            @Override
            public void onConnectionError(LayerClient layerClient, LayerException e) {

            }
        };

        LayerAuthenticationListener layerAuthenticationListener = new LayerAuthenticationListener() {
            @Override
            public void onAuthenticated(LayerClient layerClient, String s) {
                System.out.println("Layer Authentication successful");
            }

            @Override
            public void onDeauthenticated(LayerClient layerClient) {

            }

            @Override
            public void onAuthenticationChallenge(final LayerClient layerClient, final String nonce) {



                Runnable taskToRun = new Runnable() {
                    @Override
                    public void run() {
                        // The code to execute when the runnable is processed by a thread
                        String userId = MainActivity.TEST_USER_ID;

                        String eit = generateToken(sLayerAppId, userId, nonce);

                        layerClient.answerAuthenticationChallenge(eit);
                    }
                };
                Thread thread = new Thread(taskToRun);
                thread.start();

            }

            @Override
            public void onAuthenticationError(LayerClient layerClient, LayerException e) {
                System.out.println("There was an error authenticating to layer: " + e);

            }
        };


        sLayerClient.registerConnectionListener(layerConnectionListener);
        sLayerClient.registerAuthenticationListener(layerAuthenticationListener);

    }

    public static void loginToLayer() {
        if (!sLayerClient.isConnected()) {
            sLayerClient.connect();
        }
    }

    private String generateToken(String appId, String userId, String nonce) {
        KeeperService.Keeper keeper = KeeperService.createInstance();
        GenerateTokenRequest generateTokenRequest = new GenerateTokenRequest();
        generateTokenRequest.setAppId(appId);
        generateTokenRequest.setNonce(nonce);
        generateTokenRequest.setUserId(userId);
        Call<GenerateTokenResponse> call = keeper.generateToken(generateTokenRequest);
        try {
            return call.execute().body().getToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Application getInstance() {
        return sInstance;
    }


    // Called by the system when the device configuration changes while your component is running.
    // Overriding this method is totally optional!
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    // This is called when the overall system is running low on memory,
    // and would like actively running processes to tighten their belts.
    // Overriding this method is totally optional!
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
