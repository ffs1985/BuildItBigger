package com.ffs1985.myjokelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private TextView jokeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("joke");
            jokeTv = findViewById(R.id.tvJoke);
            jokeTv.setText(value);
        }
    }
}
