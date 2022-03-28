package com.arun.sqlitecontactbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText tname, tnumber ,temail;
    Button add;
    FloatingActionButton showw;
    DBhandler dBhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        DBhandler dBhandler = new DBhandler(MainActivity.this);

        add.setOnClickListener(view -> {
            String name = tname.getText().toString();
            String number = tnumber.getText().toString();
            String email = temail.getText().toString();

            if (name.isEmpty() && number.isEmpty() && email.isEmpty() ){
                Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
            return;
            }

            dBhandler.addContact(name,number,email);
            Toast.makeText(MainActivity.this, "Contact has been added.", Toast.LENGTH_SHORT).show();
            tname.setText("");
            tnumber.setText("");
            temail.setText("");

        });

        showw.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,ContactBook.class));
        });
    }


    private void initViews(){
        tname =(TextInputEditText) findViewById(R.id.tvName);
        tnumber =(TextInputEditText) findViewById(R.id.tvNo);
        temail =(TextInputEditText) findViewById(R.id.tvEmail);
        add =(Button) findViewById(R.id.btnAdd);
        showw = (FloatingActionButton) findViewById(R.id.floatingActionButton);
    }
}