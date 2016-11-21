package com.codepath.keeper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.keeper.Adapters.UserFriendsAdapter;
import com.codepath.keeper.R;
import com.codepath.keeper.models.User;
import com.codepath.keeper.models.UserFriendsResponse;
import com.codepath.keeper.services.KeeperService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserFriendFragment extends Fragment {
    private static final String TEST_USER_ID = "55cbb222b63f760008d002b6";
    ArrayList<User> userFriendsArrayList;
    UserFriendsAdapter userFriendsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //initialize friends
        callGetFriendsList(TEST_USER_ID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        userFriendsArrayList = new ArrayList<>();
        //lookup the recycler view
        View view = inflater.inflate(R.layout.fragment_user_friend, container, false);

        RecyclerView rvUserFriends = (RecyclerView) view.findViewById(R.id.user_friends);
        userFriendsAdapter = new UserFriendsAdapter(getContext(), userFriendsArrayList);
        rvUserFriends.setAdapter(userFriendsAdapter);
        rvUserFriends.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    private void callGetFriendsList(String testUserId) {
        KeeperService.Keeper keeper = KeeperService.createInstance();
        Call<UserFriendsResponse> call = keeper.userFriendsResponse(testUserId);
        call.enqueue(new Callback<UserFriendsResponse>() {
            @Override
            public void onResponse(Call<UserFriendsResponse> call, Response<UserFriendsResponse> response) {
                UserFriendsResponse userFriendsResponse = response.body();

                userFriendsArrayList.addAll(userFriendsResponse.getFriends());
                userFriendsAdapter.notifyDataSetChanged();
                for (User friend : userFriendsResponse.getFriends()) {

                    Log.d("DEBUG", friend.getFirstName());
                }
            }

            @Override
            public void onFailure(Call<UserFriendsResponse> call, Throwable t) {
                Log.d("DEBUG", t.toString());
            }
        });
    }


}
