package com.codepath.keeper.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.codepath.keeper.R;
import com.codepath.keeper.models.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by michaelsova on 11/20/16.
 */

public class MatchmakersAdapter extends RecyclerView.Adapter<MatchmakersAdapter.ViewHolder> {

    private List<User> matchMakers;
    // Store the context for easy access
    private Context mContext;

    // Pass in the contact array into the constructor
    public MatchmakersAdapter(Context context, List<User> mtchMakers) {
        matchMakers = mtchMakers;
        mContext = context;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        @BindView(R.id.profile_image)
        public ImageView ivProfileImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public MatchmakersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_matchmaker, parent, false);

        // Return a new holder instance
        MatchmakersAdapter.ViewHolder viewHolder = new MatchmakersAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(MatchmakersAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        final User friend = matchMakers.get(position);
        // Set item views based on your views and data model
        viewHolder.ivProfileImage.setImageResource(0);
        Picasso.with(getContext()).load(friend.getProfilePicture()).transform(new RoundedCornersTransformation(50, 50)).into(viewHolder.ivProfileImage);

        viewHolder.ivProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = friend.getFirstName();
                Toast.makeText(getContext(), name, Toast.LENGTH_LONG).show();
            }
        });
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return matchMakers.size();
    }

}
