package com.codepath.keeper.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.keeper.R;
import com.codepath.keeper.models.SubVouch;
import com.codepath.keeper.models.Vouch;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by matthewlent on 11/16/16.
 */

public class VouchAdapter extends RecyclerView.Adapter<VouchAdapter.ViewHolder> {

    // instance vars
    public List<Vouch> mVouches;
    private Context mContext;

    // constructor
    public VouchAdapter(Context context, List<Vouch> vouches) {
        mVouches = vouches;
        mContext = context;
    }

    // getters and setters
    private Context getContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View vouchView = inflater.inflate(R.layout.item_sub_vouch, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(vouchView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Vouch vouch = mVouches.get(position);
        SubVouch subVouch = vouch.getSubVouches().get(0);

        TextView tvVouchTitle = holder.tvVouchTitle;
        TextView tvVouchBody = holder.tvVouchBody;
        TextView tvLikeCount = holder.tvLikeCount;
        ImageView ivVoucherPicture = holder.ivVoucherPicture;
        TextView tvVoucherFirstName = holder.tvVoucherFirstName;

        tvVouchTitle.setText(subVouch.getTitle());
        tvVouchBody.setText(subVouch.getBody());
        tvLikeCount.setText(Integer.toString(subVouch.getLikes().size()));
        Picasso.with(getContext()).load(vouch.getPhotoUrl()).into(ivVoucherPicture);
        tvVoucherFirstName.setText(vouch.getVoucherName());
    }

    @Override
    public int getItemCount() {
       return mVouches.size();
    }

    // view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvVouchTitle)
        public TextView tvVouchTitle;
        @BindView(R.id.tvVouchBody)
        public TextView tvVouchBody;
        @BindView(R.id.tvLikeCount)
        public TextView tvLikeCount;
        @BindView(R.id.ivVoucherPicture)
        public ImageView ivVoucherPicture;
        @BindView(R.id.tvVoucherFirstName)
        public TextView tvVoucherFirstName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}