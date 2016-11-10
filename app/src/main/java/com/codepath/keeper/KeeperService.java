package com.codepath.keeper;

import com.codepath.keeper.models.VouchResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DateFormat;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by matthewlent on 11/10/16.
 */

public class KeeperService {
    private static final String API_URL = "http://keeper.duxf8t8yvk.us-west-2.elasticbeanstalk.com";

    public interface Keeper {
        @GET("/userVouches/{userId}")
        Call<VouchResponse> vouchResponse(
                @Path("userId") String userId);
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
