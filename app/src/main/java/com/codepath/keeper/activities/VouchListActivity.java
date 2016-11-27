package com.codepath.keeper.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.codepath.keeper.R;
import com.codepath.keeper.fragments.VouchListFragment;
import com.codepath.keeper.models.User;
import com.codepath.keeper.models.Vouch;

import java.util.ArrayList;
import java.util.List;

public class VouchListActivity extends AppCompatActivity {

    List<Vouch> vouches;
    User mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vouch_list);

        mCurrentUser = (User) getIntent().getSerializableExtra(User.CURRENT_USER);

        vouches = new ArrayList<Vouch>();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        VouchListFragment vouchListFragment = VouchListFragment.newInstance(vouches);
        vouchListFragment.callGetVouchesReceivedList(mCurrentUser.getObjectId().getId());
        ft.replace(R.id.flVouchesReceived, vouchListFragment);
        ft.commit();
    }



}
