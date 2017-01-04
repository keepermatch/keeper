package com.codepath.keeper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.codepath.keeper.KeeperApplication;
import com.codepath.keeper.R;
import com.codepath.keeper.models.User;
import com.layer.atlas.AtlasConversationsRecyclerView;
import com.layer.atlas.adapters.AtlasConversationsAdapter;
import com.layer.atlas.messagetypes.location.LocationCellFactory;
import com.layer.atlas.messagetypes.singlepartimage.SinglePartImageCellFactory;
import com.layer.atlas.messagetypes.text.TextCellFactory;
import com.layer.atlas.messagetypes.threepartimage.ThreePartImageCellFactory;
import com.layer.sdk.LayerClient;
import com.layer.sdk.messaging.Conversation;
import com.squareup.picasso.Picasso;

public class SingleMenuActivity extends AppCompatActivity {

    User mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_menu);
        mCurrentUser = (User) getIntent().getSerializableExtra(User.CURRENT_USER);

        LayerClient layerClient = KeeperApplication.getLayerClient();

        Picasso picasso = KeeperApplication.getPicasso();

        AtlasConversationsRecyclerView conversationsList = ((AtlasConversationsRecyclerView) findViewById(R.id.conversations_list))
                .init(layerClient, picasso)
                .setOnConversationClickListener(new AtlasConversationsAdapter.OnConversationClickListener() {
                    public void onConversationClick(AtlasConversationsAdapter adapter, Conversation conversation) {
                        Intent intent = new Intent(SingleMenuActivity.this, ConversationActivity.class);
                        intent.putExtra(ConversationActivity.LAYER_CONVERSATION_KEY, conversation.getId());
                        startActivity(intent);
                    }

                    public boolean onConversationLongClick(AtlasConversationsAdapter adapter, Conversation conversation) {
                        return false;
                    }
                })


                .addCellFactories(new TextCellFactory(),
                        new ThreePartImageCellFactory(layerClient, picasso),
                        new LocationCellFactory(picasso),
                        new SinglePartImageCellFactory(layerClient, picasso));
    }

    public void onSwitchToMatchmakerModeClick(View view) {
        Intent i = new Intent(this, SwipeActivity.class);
        i.putExtra(User.CURRENT_USER, mCurrentUser);
        startActivity(i);
    }

    public void onSingleSettingsClick(View view) {
        Intent i = new Intent(this, SettingsActivity.class);
        i.putExtra(User.CURRENT_USER, mCurrentUser);
        startActivity(i);
    }

    public void onSingleVouchingForMeClick(View view) {
        Intent i = new Intent(this, VouchListActivity.class);
        i.putExtra(User.CURRENT_USER, mCurrentUser);
        startActivity(i);
    }

    public void onSingleSwipingForMeClick(View view) {
        Intent i = new Intent(this, MatchmakerActivity.class);
        i.putExtra(User.CURRENT_USER, mCurrentUser);
        startActivity(i);
    }

    public void onEditProfileClick(View view) {
        Intent i = new Intent(this, EditProfileActivity.class);
        i.putExtra(User.CURRENT_USER, mCurrentUser);
        startActivity(i);
    }

}