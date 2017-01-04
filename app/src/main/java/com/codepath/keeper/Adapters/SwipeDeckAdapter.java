package com.codepath.keeper.Adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.codepath.keeper.R;
import com.codepath.keeper.fragments.ProfileFragment;
import com.codepath.keeper.models.User;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by matthewlent on 11/22/16.
 */

public class SwipeDeckAdapter extends BaseAdapter {

    private List<User> mUsers;
    private Context mContext;

    public SwipeDeckAdapter(List<User> users, Context context) {
        this.mUsers = users;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mUsers.size();
    }

    @Override
    public Object getItem(int position) {
        return mUsers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            // normally use a viewholder
            v = inflater.inflate(R.layout.swipe_card, parent, false);
        }

        int newId = generateViewId();
        v.findViewById(R.id.profile_card_within_swipe).setId(newId);

        FragmentTransaction ft = ((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction();
        ProfileFragment profileFragment = ProfileFragment.newInstance((User) getItem(position));
        ft.replace(newId, profileFragment);
        ft.commit();

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Layer type: ", Integer.toString(v.getLayerType()));
                Log.i("Hardware Accel type:", Integer.toString(View.LAYER_TYPE_HARDWARE));
            }
        });
        return v;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static int generateViewId() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            for (;;) {
                final int result = sNextGeneratedId.get();
                // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
                int newValue = result + 1;
                if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
                if (sNextGeneratedId.compareAndSet(result, newValue)) {
                    return result;
                }
            }
        } else {
            return View.generateViewId();
        }
    }
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
}
