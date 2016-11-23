package com.codepath.keeper.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.codepath.keeper.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by matthewlent on 11/22/16.
 */

public class ProfilePicturesAdapter extends RecyclerView.Adapter<ProfilePicturesAdapter.ViewHolder> {

    private List<String> mProfilePictureUrls;
    private Context mContext;

    public ProfilePicturesAdapter(Context context, List<String> profilePictureUrls) {
        mContext = context;
        mProfilePictureUrls = profilePictureUrls;
    }

    private Context getContext() {
        return mContext;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ProfilePicturesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View profilePictureView = inflater.inflate(R.layout.item_profile_picture, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(profilePictureView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ProfilePicturesAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        String profilePictureUrl = mProfilePictureUrls.get(position);

        // Set item views based on your views and data model
        Picasso.with(getContext()).load(profilePictureUrl).into(viewHolder.ivProfilePicture);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mProfilePictureUrls.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public ImageView ivProfilePicture;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            ivProfilePicture = (ImageView) itemView.findViewById(R.id.ivProfilePicture);

        }
    }
}
