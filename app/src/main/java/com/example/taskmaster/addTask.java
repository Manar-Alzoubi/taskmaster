package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class addTask extends AppCompatActivity {

    private EditText title;
    private EditText description;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Button addTask = findViewById(R.id.button);
        addTask.setOnClickListener(v -> {
            title = findViewById(R.id.edit_title);
            description = findViewById(R.id.edit_description);
            spinner = findViewById(R.id.spinner);

            Task task = new Task(title.getText().toString() , description.getText().toString() ,spinner.getSelectedItem().toString());
            Long addNewTask = AppDatabase.getInstance(getApplicationContext()).taskDao().insertNewTask(task);
            startActivity(new Intent(getApplicationContext() , MainActivity.class));
        });
    }
}