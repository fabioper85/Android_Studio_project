package org.engim.tss2018.photo.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.google.gson.Gson;

import org.engim.tss2018.photo.R;
import org.engim.tss2018.photo.adapters.ShowDataRecycleAdapter;
import org.engim.tss2018.photo.models.Rifornimento;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by svilupposw on 27/03/18.
 */

public class ShowDataActivity extends AppCompatActivity
{
    private static final String PREFS = "ShowDataActivity_preferences";
    private RecyclerView myShowDataList;
    private FloatingActionButton add;
    private Toolbar myToolbar;
    private final static int PICK_CONTACT_REQUEST = 1;
    private static ArrayList<Rifornimento> rifornimenti;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.show_data);

        myShowDataList = findViewById(R.id.list);
        add = findViewById(R.id.fab);

        myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        rifornimenti = new ArrayList<>();

        ShowDataRecycleAdapter adapter = new ShowDataRecycleAdapter(getApplicationContext(),rifornimenti);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myShowDataList.setLayoutManager(linearLayoutManager);

        myShowDataList.setAdapter(adapter);
        setListener();
    }

    private void setListener()
    {
        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), AddRifornimentoActivity.class);
                startActivityForResult(intent, PICK_CONTACT_REQUEST);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //return super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.show_data_activity_toolbar_menu, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_CONTACT_REQUEST) {
            if (resultCode == 1) {
                Rifornimento r = new Rifornimento(data.getStringExtra("nomeBenzinaio"), Float.parseFloat(data.getStringExtra("importo")));
                rifornimenti.add(r);

                SharedPreferences sp = getSharedPreferences(PREFS, MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();

                Gson gson = new Gson();
                String jsonText = gson.toJson(rifornimenti);
                e.putString("key", jsonText);
                e.apply();
                e.commit();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
