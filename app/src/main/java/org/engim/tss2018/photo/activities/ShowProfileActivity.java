package org.engim.tss2018.photo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.engim.tss2018.photo.R;

/**
 * Created by svilupposw on 20/03/18.
 */

public class ShowProfileActivity extends AppCompatActivity
{
    private ImageView profilePhoto;

    private TextView nameText;

    private TextView emailText;

    private TextView bioText;

    private TextView phoneText;

    private Toolbar myToolbar;

    static final int PICK_CONTACT_REQUEST = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // SET VIEW
        setContentView(R.layout.show_profile_activity);

        // TOOLBAR
        myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        // VIEW CREATION
        profilePhoto = findViewById(R.id.profileImage);
        nameText = findViewById(R.id.nameText);
        emailText = findViewById(R.id.emailText);
        bioText = findViewById(R.id.bioText);
        phoneText = findViewById(R.id.phoneText);

        // VIEW SET

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        int id = item.getItemId();

        if(id == R.id.action_edit)
        {
            Intent intent = new Intent(getApplicationContext(), EditProfileActivity.class);
            startActivityForResult(intent, PICK_CONTACT_REQUEST);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_CONTACT_REQUEST)
        {
            if (resultCode == 1)
            {
                nameText.setText(data.getStringExtra("name"));
                emailText.setText(data.getStringExtra("email"));
                bioText.setText(data.getStringExtra("bio"));
                phoneText.setText(data.getStringExtra("phone"));
            }
        }
    }
}