package com.example.sharedpreferencescours;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView=findViewById(R.id.textView);
        SharedPreferences preferences=getSharedPreferences("file",MODE_PRIVATE);
        String firstName=preferences.getString("firstName",null);
        textView.setText(firstName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.annuler:
                SharedPreferences preferences=getSharedPreferences("file",MODE_PRIVATE);
                preferences.edit().clear().commit();
                String firstName=preferences.getString("firstName",null);
                textView.setText(firstName);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
