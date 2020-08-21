package com.example.contact_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity2 extends AppCompatActivity {

    private EditText EditName, EditPhone;
    private LottieAnimationView lt;
    private Button Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditName = findViewById(R.id.EditName);
        EditPhone = findViewById(R.id.EditPhone);
        Button = findViewById(R.id.Button);
        lt = findViewById(R.id.lt);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database_Helper mydb = new Database_Helper(MainActivity2.this);
                mydb.addBook(EditName.getText().toString(),Integer.parseInt(EditPhone.getText().toString()));
                lt.setVisibility(View.VISIBLE);

            }
        });
    }
}