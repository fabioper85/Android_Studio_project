package org.engim.tss2018.photo.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.engim.tss2018.photo.R;

/**
 * Created by svilupposw on 20/03/18.
 */

public class EditProfileActivity extends AppCompatActivity
{
    private static final String PREFS = "My preferences";
    private EditText nameEdit;
    private EditText emailEdit;
    private EditText bioEdit;
    private EditText phoneEdit;
    private Button photoButton;
    private Button saveButton;

    private String name;
    private String email;
    private String bio;
    private String phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        SharedPreferences sp = getSharedPreferences(PREFS, MODE_PRIVATE);
        name = sp.getString("name", " ");
        email = sp.getString("email", " ");
        bio = sp.getString("bio", " ");
        phone = sp.getString("phone", " ");

        setContentView(R.layout.edit_profile_activity);

        nameEdit = findViewById(R.id.editName);
        emailEdit = findViewById(R.id.editEmail);
        bioEdit = findViewById(R.id.editBio);
        phoneEdit = findViewById(R.id.editPhone);
        photoButton = findViewById(R.id.savePhotoButton);
        saveButton = findViewById(R.id.saveDataButton);

        if(savedInstanceState != null)
        {
            name = savedInstanceState.getString("name");
            email = savedInstanceState.getString("email");
            bio = savedInstanceState.getString("bio");
            phone = savedInstanceState.getString("phone");

            nameEdit.setText(name);
            emailEdit.setText(email);
            bioEdit.setText(bio);
            phoneEdit.setText(phone);
        }

        setListeners();
    }

    private void setListeners()
    {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name", nameEdit.getText().toString());
                intent.putExtra("email", emailEdit.getText().toString());
                intent.putExtra("bio", bioEdit.getText().toString());
                intent.putExtra("phone", phoneEdit.getText().toString());
                setResult(1, intent);
                finish();
            }
        });

        nameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                name = editable.toString();
            }
        });

        emailEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                email = editable.toString();
            }
        });

        bioEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                bio = editable.toString();
            }
        });

        phoneEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                phone = editable.toString();
            }
        });

        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snapPhoto();
            }
        });
    }

    private void snapPhoto()
    {

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("name", name);
        outState.putString("email", email);
        outState.putString("bio", bio);
        outState.putString("phone", phone);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sp= getSharedPreferences(PREFS, MODE_PRIVATE);
        SharedPreferences.Editor e=sp.edit();
        e.putString("name", name);
        e.putString("email", email);
        e.putString("bio", bio);
        e.putString("phone", phone);
        e.commit();

    }
}
