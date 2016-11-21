package com.codepath.keeper.services;

import com.codepath.keeper.models.LoginRequest;
import com.codepath.keeper.models.MatchMakersResponse;
import com.codepath.keeper.models.UpdateUserRequest;
import com.codepath.keeper.models.User;
import com.codepath.keeper.models.UserFriendsResponse;
import com.codepath.keeper.models.VouchResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DateFormat;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by matthewlent on 11/10/16.
 */

public class KeeperService {

    private static final String LOCAL_API_URL = "http://10.0.2.2:5000";
    private static final String API_URL = "http://keeper.duxf8t8yvk.us-west-2.elasticbeanstalk.com";

    public interface Keeper {
        @GET("/userVouches/{userId}")
        Call<VouchResponse> vouchResponse(
                @Path("userId") String userId);

        @GET("/userFriends/{userId}/yes")
        Call<UserFriendsResponse> userFriendsResponse(
                @Path("userId") String userId);

        @GET("/matchmakers/{userId}")
        Call<MatchMakersResponse> matchMakersResponse(
                @Path("userId") String userId);

        @POST("/facebook_login")
        Call<User> login(
                @Body LoginRequest loginRequest);

        @PUT("/facebook_login")
        Call<User> updateUser(
                @Body UpdateUserRequest updateUserRequest);

    }

    public static Keeper createInstance() {
        Gson gson = new GsonBuilder()
                .setDateFormat(DateFormat.LONG)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        Keeper keeper = retrofit.create(Keeper.class);
        return keeper;
    }


}
