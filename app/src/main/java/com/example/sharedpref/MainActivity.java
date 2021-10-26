package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Ename;
    Button SaveBtn;
    SharedPreferences sharedPreferences;



    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ename = findViewById(R.id.Ename);
        SaveBtn=findViewById(R.id.SaveBtn);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);


        String name=sharedPreferences.getString(KEY_NAME,null);

        if(name != null){
            Intent intent=new Intent(MainActivity.this,ViewActivity.class);
            startActivity(intent);
        }

        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(KEY_NAME,Ename.getText().toString());
                editor.apply();
                Intent intent=new Intent(MainActivity.this,ViewActivity.class);
                startActivity(intent);



            }
        });

    }
}