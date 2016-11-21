package com.codepath.keeper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.keeper.Adapters.MatchmakersAdapter;
import com.codepath.keeper.R;
import com.codepath.keeper.models.MatchMakersResponse;
import com.codepath.keeper.models.User;
import com.codepath.keeper.services.KeeperService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by michaelsova on 11/20/16.
 */

public class MatchmakerFragment extends Fragment{
    private static final String TEST_USER_ID = "55cbb222b63f760008d002b6";
    ArrayList<User> matchmakersArrayList;
    MatchmakersAdapter matchmakerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //initialize friends
        callGetMatchMakers(TEST_USER_ID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        matchmakersArrayList = new ArrayList<>();
        //lookup the recycler view
        View view = inflater.inflate(R.layout.fragment_matchmaker, container, false);

        RecyclerView rvMatchmakers = (RecyclerView) view.findViewById(R.id.matchmakers);
        matchmakerAdapter = new MatchmakersAdapter(getContext(), matchmakersArrayList);
        rvMatchmakers.setAdapter(matchmakerAdapter);
        rvMatchmakers.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));

        return view;
    }

    private void callGetMatchMakers(String testUserId) {
        KeeperService.Keeper keeper = KeeperService.createInstance();
        Call<MatchMakersResponse> call = keeper.matchMakersResponse(testUserId);
        call.enqueue(new Callback<MatchMakersResponse>() {
            @Override
            public void onResponse(Call<MatchMakersResponse> call, Response<MatchMakersResponse> response) {
                MatchMakersResponse matchMakersResponse = response.body();
                Log.d("DEBUG", "string" + matchMakersResponse.toString());
                matchmakersArrayList.addAll(matchMakersResponse.getMatchMakers());
                matchmakerAdapter.notifyDataSetChanged();
                for (User friend : matchMakersResponse.getMatchMakers()) {

                    Log.d("DEBUG", friend.getFirstName());
                }
            }

            @Override
            public void onFailure(Call<MatchMakersResponse> call, Throwable t) {
                Log.d("DEBUG", t.toString());

            }

        });
    }
}
