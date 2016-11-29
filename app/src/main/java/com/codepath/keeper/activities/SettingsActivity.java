package com.codepath.keeper.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.codepath.keeper.R;
import com.codepath.keeper.models.UpdateUserRequest;
import com.codepath.keeper.models.User;
import com.facebook.login.LoginManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsActivity extends AppCompatActivity {

    @BindView(R.id.btnChangeStatus) Button btnChangeStatus;
    User mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mCurrentUser = (User) getIntent().getSerializableExtra(User.CURRENT_USER);
        ButterKnife.bind(this);
        updateChangeStatusButtonText();
    }

    private void updateChangeStatusButtonText() {
        if (mCurrentUser.isSingle()) {
            btnChangeStatus.setText("Change status to Not Single");
        } else {
            btnChangeStatus.setText("Change status to Single");
        }
    }

    public void onLogoutClick(View view) {
        LoginManager.getInstance().logOut();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    public void onPrivacyPolicyClick(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.findkeeper.co"));
        if (browserIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(browserIntent);
        }
    }

    public void onChangeStatusClick(View view) {
        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
        Toast.makeText(this, "Posting new user data to Keeper API", Toast.LENGTH_SHORT).show();
        //TODO call api
        mCurrentUser.setSingle(!mCurrentUser.isSingle());
        updateChangeStatusButtonText();
    }
}
