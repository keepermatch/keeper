package com.codepath.keeper.activities;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.codepath.keeper.Adapters.UserFriendsAdapter;
import com.codepath.keeper.R;
import com.codepath.keeper.models.User;
import com.codepath.keeper.models.UserFriendsResponse;
import com.codepath.keeper.services.KeeperService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VouchForAFriend extends AppCompatActivity {

    private static final String TEST_USER_ID = "55cbb222b63f760008d002b6";
    ArrayList<User> userFriendsArrayList;
    UserFriendsAdapter userFriendsAdapter;

    public static final int CONTACT_LOADER_ID = 78; // From docs: A unique identifier for this loader. Can be whatever you want.

    private SimpleCursorAdapter cursorAdapter;

    // Defines the asynchronous callback for the contacts data loader
    private LoaderManager.LoaderCallbacks<Cursor> contactsLoader =
            new LoaderManager.LoaderCallbacks<Cursor>() {
                // Create and return the actual cursor loader for the contacts data
                @Override
                public Loader<Cursor> onCreateLoader(int id, Bundle args) {
                    // Define the columns to retrieve
                    String[] projectionFields = new String[] { ContactsContract.Contacts._ID,
                            ContactsContract.Contacts.DISPLAY_NAME,
                            ContactsC   ontract.Contacts.PHOTO_URI };
                    // Construct the loader
                    CursorLoader cursorLoader = new CursorLoader(VouchForAFriend.this,
                            ContactsContract.Contacts.CONTENT_URI, // URI
                            projectionFields, // projection fields
                            null, // the selection criteria
                            null, // the selection args
                            null // the sort order
                    );
                    // Return the loader for use
                    return cursorLoader;
                }


                @Override
                public void onLoadFinished(android.support.v4.content.Loader<Cursor> loader, Cursor data) {
                    cursorAdapter.swapCursor(data);

                }

                @Override
                public void onLoaderReset(android.support.v4.content.Loader<Cursor> loader) {
                    cursorAdapter.swapCursor(null);
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vouch_for_afriend);
        setupCursorAdapter();

        // Initialize the loader with a special ID and the defined callbacks from above
        getSupportLoaderManager().initLoader(CONTACT_LOADER_ID, new Bundle(), contactsLoader);


        userFriendsArrayList = new ArrayList<>();
        //lookup the recycler view
        RecyclerView rvUserFriends = (RecyclerView) findViewById(R.id.user_friends);
        userFriendsAdapter = new UserFriendsAdapter(this, userFriendsArrayList);
        rvUserFriends.setAdapter(userFriendsAdapter);
        rvUserFriends.setLayoutManager(new LinearLayoutManager(this));

        //lookup the recycler view
        ListView lvUserContacts = (ListView) findViewById(R.id.user_contacts);
        lvUserContacts.setAdapter(cursorAdapter);

        //initialize friends
        callGetFriendsList(TEST_USER_ID);
    }

    private void callGetFriendsList(String testUserId) {
        KeeperService.Keeper keeper = KeeperService.createInstance();
        Call<UserFriendsResponse> call = keeper.userFriendsResponse(testUserId);
        call.enqueue(new Callback<UserFriendsResponse>() {
            @Override
            public void onResponse(Call<UserFriendsResponse> call, Response<UserFriendsResponse> response) {
                UserFriendsResponse userFriendsResponse = response.body();

                userFriendsArrayList.addAll(userFriendsResponse.getFriends());
                userFriendsAdapter.notifyDataSetChanged();
                for (User friend : userFriendsResponse.getFriends()) {

                    Log.d("DEBUG", friend.getFirstName());
                }
            }

            @Override
            public void onFailure(Call<UserFriendsResponse> call, Throwable t) {
                Log.d("DEBUG", t.toString());
            }
        });
    }

    // Create simple cursor adapter to connect the cursor dataset we load with a ListView
    private void setupCursorAdapter() {
        // Column data from cursor to bind views from
        String[] uiBindFrom = { ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.PHOTO_URI };
        // View IDs which will have the respective column data inserted
        int[] uiBindTo = { R.id.contact_name, R.id.profile_image};
        // Create the simple cursor adapter to use for our list
        // specifying the template to inflate (item_contact),
        cursorAdapter = new SimpleCursorAdapter(
                this, R.layout.item_user_friend,
                null, uiBindFrom, uiBindTo,
                0);
    }

}
