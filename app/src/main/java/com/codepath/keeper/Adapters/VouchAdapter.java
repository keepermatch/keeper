package com.codepath.keeper.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codepath.keeper.R;
import com.codepath.keeper.models.Vouch;

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
        View vouchView = inflater.inflate(R.layout.item_vouch, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(vouchView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Vouch vouch = mVouches.get(position);

        TextView tvVoucherName = holder.tvVoucherName;

        tvVoucherName.setText(vouch.getVoucherName());
    }

    @Override
    public int getItemCount() {
       return mVouches.size();
    }

    // view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvVoucherName)
        public TextView tvVoucherName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}