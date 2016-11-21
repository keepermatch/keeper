package com.codepath.keeper.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.codepath.keeper.R;
import com.codepath.keeper.fragments.VouchListFragment;
import com.codepath.keeper.models.Vouch;

import java.util.ArrayList;
import java.util.List;

public class VouchListActivity extends AppCompatActivity {

    List<Vouch> vouches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vouch_list);

        vouches = new ArrayList<Vouch>();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        VouchListFragment vouchListFragment = VouchListFragment.newInstance(vouches);
        vouchListFragment.callGetVouchesReceivedList(MainActivity.TEST_USER_ID);
        ft.replace(R.id.flVouchesReceived, vouchListFragment);
        ft.commit();
    }



}
