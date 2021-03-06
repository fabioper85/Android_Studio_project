package org.engim.tss2018.photo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.engim.tss2018.photo.R;

/**
 * Created by svilupposw on 27/03/18.
 */

public class AddRifornimentoActivity extends AppCompatActivity
{
    private TextView nomeBenzinaioEdit;
    private TextView importoEdit;
    private Button saveRifornimento;
    private String nomeBenzinaio;
    private String importo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_rifornimento_activity);

        nomeBenzinaioEdit = findViewById(R.id.addRifornimentoNome);
        importoEdit = findViewById(R.id.addRifornimentoImporto);
        saveRifornimento = findViewById(R.id.addRifornimentoBtn);

        setListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.show_data_activity_toolbar_menu, menu);
        return true;
    }

    private void setListener()
    {
        saveRifornimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("nomeBenzinaio", nomeBenzinaio);
                intent.putExtra("importo", importo);
                setResult(1, intent);
                finish();
            }
        });

        nomeBenzinaioEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                nomeBenzinaio = editable.toString();
            }
        });

        importoEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                importo = editable.toString();
            }
        });
    }
}
