package com.codepath.keeper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.codepath.keeper.R;

public class MatchmakingMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    public void onClickVouchList(View view) {
        Intent i = new Intent(this, VouchListActivity.class);
        startActivity(i);
    }


    public void onVouchForAFriendClick(View view) {
        Intent intent = new Intent(this,VouchForAFriend.class);
        startActivity(intent);
    }
}
