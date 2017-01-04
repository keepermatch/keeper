package com.codepath.keeper.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.codepath.keeper.Adapters.SwipeDeckAdapter;
import com.codepath.keeper.R;
import com.codepath.keeper.fragments.FiltersFragment;
import com.codepath.keeper.models.User;
import com.codepath.keeper.models.UserDailyMatchesResponse;
import com.daprlabs.aaron.swipedeck.SwipeDeck;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;

public class SwipeActivity extends AppCompatActivity {

    private FiltersFragment mFiltersFragment;
    private SwipeDeck cardStack;
    private ArrayList<User> potentialMatches;
    private SwipeDeckAdapter adapter;
    private User mUserMatchmakee;
    @BindView(R.id.tvMatchmakeeName) TextView tvMatchmakeeName;
    @BindView(R.id.ivMatchmakeePhoto) ImageView ivMatchmakeePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);
        mUserMatchmakee = (User) getIntent().getSerializableExtra(User.CURRENT_USER);
        ButterKnife.bind(this);

        // display bottom bar
        tvMatchmakeeName.setText("Swiping for " + mUserMatchmakee.getFirstName());
        Picasso.with(this).load(mUserMatchmakee.getProfilePicture()).into(ivMatchmakeePhoto);

        // set up cards
        callGetUserDailyMatches();
        cardStack = (SwipeDeck) findViewById(R.id.swipe_deck);
        potentialMatches = new ArrayList<>();
        adapter = new SwipeDeckAdapter(potentialMatches, this);
        if(cardStack != null){
            cardStack.setAdapter(adapter);
        }
        cardStack.setLeftImage(R.drawable.sadoverlay);
        cardStack.setCallback(new SwipeDeck.SwipeDeckCallback() {
            @Override
            public void cardSwipedLeft(long positionInAdapter) {
                Log.i("MainActivity", "card was swiped left, position in adapter: " + positionInAdapter);
                User user = (User) adapter.getItem((int) positionInAdapter);
                Toast.makeText(getApplicationContext(), "Swipe left on " + user.getObjectId().getId(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void cardSwipedRight(long positionInAdapter) {
                Log.i("MainActivity", "card was swiped right, position in adapter: " + positionInAdapter);
                User user = (User) adapter.getItem((int) positionInAdapter);
                Toast.makeText(getApplicationContext(), "Swipe right on " + user.getObjectId().getId(), Toast.LENGTH_SHORT).show();
            }
        });
        cardStack.setLeftImage(R.id.left_image);
        cardStack.setRightImage(R.id.right_image);

        // set up button click events
        Button btn = (Button) findViewById(R.id.btnSwipeLeft);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardStack.swipeTopCardLeft(180);
            }
        });

        Button btn2 = (Button) findViewById(R.id.btnSwipeRight);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardStack.swipeTopCardRight(180);
            }
        });

        Button btn3 = (Button) findViewById(R.id.btnSwipeKeep);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int positionInAdapter = cardStack.getAdapterIndex();
                User user = (User) adapter.getItem((int) positionInAdapter);
                Toast.makeText(getApplicationContext(), "Keep on " + user.getObjectId().getId(), Toast.LENGTH_SHORT).show();

            }
        });

    }

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
                            Log.d("DEBUG", "User id: " + user.getObjectId().getId());
                            potentialMatches.add(user);
                            adapter.notifyDataSetChanged();
                        }
                    }}
        );

    }

    public void onClickLetsSwipe(View view) {
        //TODO api call
        Toast.makeText(this, "chagned filters", Toast.LENGTH_SHORT).show();

        mFiltersFragment.dismiss();
    }

    public void onClickAdjustFilters(View view) {
        FragmentManager fm = getSupportFragmentManager();
        mFiltersFragment = FiltersFragment.newInstance();
        mFiltersFragment.show(fm, "fragment_filters");

    }
}
