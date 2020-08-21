package com.example.contact_list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton floatingbutton;
    private RecyclerView recview;
    private RelativeLayout relative;

    Database_Helper mydb;
    ArrayList<String> contact_name,contact_phone;
    Contact_Adapter contact_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingbutton = findViewById(R.id.floatingbutton);
        recview = findViewById(R.id.recview);
        relative = findViewById(R.id.relative);

        floatingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        recview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if(newState == RecyclerView.SCROLL_STATE_IDLE)
                    floatingbutton.show();
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if(dy>0 || dy<0 && floatingbutton.isShown())
                    floatingbutton.hide();
            }
        });

        mydb = new Database_Helper(MainActivity.this);
        contact_name = new ArrayList<>();
        contact_phone = new ArrayList<>();

        storeDatainArrays();

        contact_adapter = new Contact_Adapter(MainActivity.this,contact_name,contact_phone);
        recview.setAdapter(contact_adapter);
        recview.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }



    void storeDatainArrays()
    {
        Cursor cursor = mydb.readAllData();
        if(cursor.getCount() == 0)
        {
            relative.setVisibility(View.VISIBLE);
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            relative.setVisibility(View.GONE);
            while(cursor.moveToNext())
            {
                contact_name.add(cursor.getString(0));
                contact_phone.add(cursor.getString(1));
            }
        }
    }
}