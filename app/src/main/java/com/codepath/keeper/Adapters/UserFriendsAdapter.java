package com.codepath.keeper.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.codepath.keeper.R;
import com.codepath.keeper.models.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;


/**
 * Created by michaelsova on 11/13/16.
 */

public class UserFriendsAdapter extends RecyclerView.Adapter<UserFriendsAdapter.ViewHolder> {

    private List<User> userFriends;
    // Store the context for easy access
    private Context mContext;

    // Pass in the contact array into the constructor
    public UserFriendsAdapter(Context context, List<User> usrFriends) {
        userFriends = usrFriends;
        mContext = context;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        @BindView(R.id.contact_name)
        public TextView tvContactName;

        @BindView(R.id.add_friend)
        public Button btAddFriend;

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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_user_friend, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // Get the data model based on position
        final User friend = userFriends.get(position);

        // Set item views based on your views and data model
        viewHolder.tvContactName.setText(friend.getFirstName());
        viewHolder.btAddFriend.setText("add friend");
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
        return userFriends.size();
    }

}
