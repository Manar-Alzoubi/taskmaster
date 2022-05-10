package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class taskDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        TextView textTitle = findViewById(R.id.title);

        Intent passedIntent = getIntent();

        String titleRecived = passedIntent.getStringExtra("title");
        String bodyRecived = passedIntent.getStringExtra("body");
        String stateRecived = passedIntent.getStringExtra("state");

        TextView title = findViewById(R.id.title);
        TextView body = findViewById(R.id.body);
        TextView state = findViewById(R.id.state);

        title.setText(titleRecived);
        body.setText(bodyRecived);
        state.setText(stateRecived);

    }

}