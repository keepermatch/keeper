package com.codepath.keeper.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.codepath.keeper.R;


public class UserContactsFragment extends Fragment {
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
                            ContactsContract.Contacts.PHOTO_URI };
                    // Construct the loader
                    CursorLoader cursorLoader = new CursorLoader(getContext(),
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupCursorAdapter();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Initialize the loader with a special ID and the defined callbacks from above
        getActivity().getSupportLoaderManager().initLoader(CONTACT_LOADER_ID, new Bundle(), contactsLoader);

        View view = inflater.inflate(R.layout.fragment_user_contacts, container, false);

        ListView lvUserContacts = (ListView) view.findViewById(R.id.user_contacts);
        lvUserContacts.setAdapter(cursorAdapter);

        return view;
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
                getContext(), R.layout.item_user_friend,
                null, uiBindFrom, uiBindTo,
                0);
    }

}
