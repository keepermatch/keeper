package com.codepath.keeper.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewlent on 11/10/16.
 */

public class VouchResponse {

    public List<Vouch> vouches;

    public VouchResponse() {
        vouches = new ArrayList<Vouch>();
    }

    public static VouchResponse parseJson(String response) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        Gson gson = new GsonBuilder().create();
        VouchResponse vouchResponse = gson.fromJson(response, VouchResponse.class);
        return vouchResponse;
    }


}
