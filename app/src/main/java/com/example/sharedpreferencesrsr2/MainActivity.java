package com.example.sharedpreferencesrsr2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String filename="myfile";
    EditText et;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText) findViewById(R.id.name1);
        tv=(TextView)findViewById(R.id.tv1);
    }

    public void save(View view) {
        String name=et.getText().toString();
        SharedPreferences sp=getSharedPreferences(filename,MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("If",name);
        editor.commit();
        Toast.makeText(this, "Data saved successfuly",
                Toast.LENGTH_SHORT).show();
    }

    public void show(View view) {
        SharedPreferences sp=getSharedPreferences(filename,MODE_PRIVATE);
        String result=sp.getString("If","");
        tv.append(result+"\n");
    }
}
