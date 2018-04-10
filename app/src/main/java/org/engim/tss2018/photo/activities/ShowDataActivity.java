package org.engim.tss2018.photo.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import org.engim.tss2018.photo.R;
import org.engim.tss2018.photo.adapters.ShowDataRecycleAdapter;
import org.engim.tss2018.photo.models.Rifornimento;
import java.util.ArrayList;

/**
 * Created by svilupposw on 27/03/18.
 */

public class ShowDataActivity extends AppCompatActivity
{
    private RecyclerView myShowDataList;
    private FloatingActionButton add;
    private Toolbar myToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.show_data);

        myShowDataList = findViewById(R.id.list);
        add = findViewById(R.id.fab);

        myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        ArrayList<Rifornimento> data = new ArrayList<>();

        Rifornimento r = new Rifornimento("Eni",30.0);
        data.add(r);
        data.add(r);
        data.add(r);
        data.add(r);
        data.add(r);
        data.add(r);
        data.add(r);
        data.add(r);

        ShowDataRecycleAdapter adapter = new ShowDataRecycleAdapter(getApplicationContext(),data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myShowDataList.setLayoutManager(linearLayoutManager);

        myShowDataList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.show_data_activity_toolbar_menu, menu);
        return true;
    }
}
