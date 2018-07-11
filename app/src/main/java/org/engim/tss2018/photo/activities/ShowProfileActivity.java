package org.engim.tss2018.photo.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
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

    private DrawerLayout mDrawerLayout;

    static final int PICK_CONTACT_REQUEST = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // SET VIEW
        setContentView(R.layout.show_profile_activity);

        // TOOLBAR
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if(myToolbar != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        }

        // VIEW CREATION
        profilePhoto = findViewById(R.id.profileImage);
        nameText = findViewById(R.id.nameText);
        emailText = findViewById(R.id.emailText);
        bioText = findViewById(R.id.bioText);
        phoneText = findViewById(R.id.phoneText);
        mDrawerLayout = findViewById(R.id.drawer_layout);

        // VIEW SET

        // NAV MENU
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    // set item as selected to persist highlight
                    int id = menuItem.getItemId();

                    switch(id)
                    {
                        case R.id.nav_rifornimenti:
                            Intent intentRif = new Intent(getApplicationContext(), ShowDataActivity.class);
                            startActivity(intentRif);
                            break;

                        case R.id.nav_profilo:
                            Intent intentProfile = new Intent(getApplicationContext(), ShowProfileActivity.class);
                            startActivity(intentProfile);
                            break;
                    }

                    menuItem.setChecked(true);
                    // close drawer when item is tapped
                    mDrawerLayout.closeDrawers();

                    // Add code here to update the UI based on the item selected
                    // For example, swap UI fragments here

                    return true;
                }
            });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
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
        else if (id == android.R.id.home) {
           mDrawerLayout.openDrawer(GravityCompat.START) ;
           return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
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
