package com.example.android.passdatabetweenactivitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();

        if(extras != null) {
            TextView tv = findViewById(R.id.text_view);
            String s = extras.getString("EditTextContent");
            int num = extras.getInt("Number");
            tv.setText(s + "\n" + num);
        }

        Button go_back = findViewById(R.id.back_button);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnText", "Returning from Second Activity");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
