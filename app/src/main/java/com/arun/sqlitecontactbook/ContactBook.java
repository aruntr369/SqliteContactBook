package com.arun.sqlitecontactbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ContactBook extends AppCompatActivity {

    private ArrayList<ContactModel> contactModelArrayList;
    private DBhandler dBhandler;
    private RVAdapter rvAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_book);

        contactModelArrayList = new ArrayList<>();
        dBhandler = new DBhandler(ContactBook.this);
        contactModelArrayList = dBhandler.readContact();

        rvAdapter = new RVAdapter(contactModelArrayList,ContactBook.this);
        recyclerView = findViewById(R.id.recyclerV);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ContactBook.this,
                RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(rvAdapter);
    }
}