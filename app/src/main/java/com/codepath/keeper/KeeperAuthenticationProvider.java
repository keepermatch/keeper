package com.codepath.keeper;

import android.app.Activity;
import android.net.Uri;

import com.codepath.keeper.util.AuthenticationProvider;
import com.layer.sdk.LayerClient;
import com.layer.sdk.exceptions.LayerException;

/**
 * Created by matthewlent on 1/1/17.
 */

public class KeeperAuthenticationProvider implements AuthenticationProvider<KeeperAuthenticationProvider.Credentials> {

    @Override
    public AuthenticationProvider<Credentials> setCredentials(Credentials credentials) {
        return null;
    }

    @Override
    public boolean hasCredentials() {
        return false;
    }

    @Override
    public AuthenticationProvider<Credentials> setCallback(Callback callback) {
        return null;
    }

    @Override
    public boolean routeLogin(LayerClient layerClient, String layerAppId, Activity from) {
        return false;
    }

    @Override
    public void onAuthenticated(LayerClient layerClient, String s) {

    }

    @Override
    public void onDeauthenticated(LayerClient layerClient) {

    }

    @Override
    public void onAuthenticationChallenge(LayerClient layerClient, String s) {

    }

    @Override
    public void onAuthenticationError(LayerClient layerClient, LayerException e) {

    }

    public static class Credentials {
        private final String mLayerAppId;
        private final String mUserName;

        public Credentials(Uri layerAppId, String userName) {
            this(layerAppId == null ? null : layerAppId.getLastPathSegment(), userName);
        }

        public Credentials(String layerAppId, String userName) {
            mLayerAppId = layerAppId == null ? null : (layerAppId.contains("/") ? layerAppId.substring(layerAppId.lastIndexOf("/") + 1) : layerAppId);
            mUserName = userName;
        }

        public String getUserName() {
            return mUserName;
        }

        public String getLayerAppId() {
            return mLayerAppId;
        }
    }
}
