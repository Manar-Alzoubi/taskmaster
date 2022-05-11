package com.example.taskmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView username;

    List<Task> taskList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addTaskBtn = findViewById(R.id.addTask);
        addTaskBtn.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext() ,addTask.class));
        });
        initialiseData();
        List<Task> task = AppDatabase.getInstance(this).taskDao().getAll();

        // get the recycler view object
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // create an adapter
        CustomRecyclerViewAdapter customRecyclerViewAdapter = new CustomRecyclerViewAdapter(taskList);
//        CustomRecyclerViewAdapter customRecyclerViewAdapter = new CustomRecyclerViewAdapter(task, new CustomRecyclerViewAdapter.CustomClickListener() {
//            @Override
//            public void onTaskItemClicked(int position) {
//                Intent taskDetailActivity = new Intent(getApplicationContext() , taskDetails.class);
//                taskDetailActivity.putExtra("id" ,  task.get(position).getId().toString());
//                startActivity(taskDetailActivity);
//            }
//        });

        // set adapter on recycler view
        recyclerView.setAdapter(customRecyclerViewAdapter);

        // set other important properties
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // set click listener

//        username = findViewById(R.id.username);
//        Button pray = findViewById(R.id.button4);
//        pray.setOnClickListener(view -> {
//            Intent prayActivity = new Intent(this , taskDetails.class);
//            prayActivity.putExtra("title" , pray.getText().toString());
//            startActivity(prayActivity);
//        });
//
//        Button read = findViewById(R.id.button5);
//        read.setOnClickListener(view -> {
//            Intent readActivity = new Intent(this , taskDetails.class);
//            readActivity.putExtra("title" , read.getText().toString());
//            startActivity(readActivity);
//        });
//
//        Button sleep = findViewById(R.id.button3);
//        sleep.setOnClickListener(view -> {
//            Intent sleepActivity = new Intent(this , taskDetails.class);
//            sleepActivity.putExtra("title" , sleep.getText().toString());
//            startActivity(sleepActivity);
//        });

    }
    private void initialiseData() {
        taskList.add(new Task("Task 1" , "Do your homeWork" , "new"));
        taskList.add(new Task("Task 2" , "Go shopping" , "assigned"));
        taskList.add(new Task("Task 3" , "visit friend" , "in progress"));
        taskList.add(new Task("Task 4" , "stay with childs" , "complete"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                navigateToSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void navigateToSettings() {
        Intent settingsIntent = new Intent(this, settingsActivity.class);
        startActivity(settingsIntent);
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: called");
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume: called - The App is VISIBLE");
//                setUserName();
        super.onResume();

    }

    @Override
    protected void onPause() {
        Log.i(TAG, "onPause: called");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop: called");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy: called");
        super.onDestroy();
    }

//    private void setUserName() {
//        // get text out of shared preference
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//
//        // set text on text view User Name
//        username.setText(sharedPreferences.getString(settingsActivity.UserName, "no username"));
//
//    }
}