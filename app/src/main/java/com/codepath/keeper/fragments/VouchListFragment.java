package com.codepath.keeper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.keeper.Adapters.VouchAdapter;
import com.codepath.keeper.R;
import com.codepath.keeper.models.Vouch;
import com.codepath.keeper.models.VouchResponse;
import com.codepath.keeper.services.KeeperService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VouchListFragment extends Fragment {

    @BindView(R.id.rvVouches)
    RecyclerView rvVouches;

    private static final String TEST_USER_ID = "55cbb222b63f760008d002b6";
    private List<Vouch> mVouchList;
    private Unbinder mUnbinder;
    private VouchAdapter mAdapter;

    public VouchListFragment() {
        // Required empty public constructor
    }

    // When binding a fragment in onCreateView, set the views to null in onDestroyView.
    // ButterKnife returns an Unbinder on the initial binding that has an unbind method to do this automatically.
    @Override public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callGetVouchList(TEST_USER_ID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vouch_list, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        mVouchList = new ArrayList<Vouch>();

        mAdapter= new VouchAdapter(getContext(), mVouchList);
        rvVouches.setAdapter(mAdapter);
        rvVouches.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    private void callGetVouchList(String testUserId) {
        KeeperService.Keeper keeper = KeeperService.createInstance();
        Call<VouchResponse> call = keeper.vouchResponse(testUserId);
        call.enqueue(new Callback<VouchResponse>() {
            @Override
            public void onResponse(Call<VouchResponse> call, Response<VouchResponse> response) {
                VouchResponse vouchResponse = response.body();
                mVouchList.addAll(vouchResponse.getVouches());
                mAdapter.notifyItemRangeInserted(0, mVouchList.size());
            }

            @Override
            public void onFailure(Call<VouchResponse> call, Throwable t) {
                Log.d("DEBUG", t.toString());
            }
        });
    }


}
