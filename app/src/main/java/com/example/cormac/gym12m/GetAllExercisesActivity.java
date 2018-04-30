package com.example.cormac.gym12m;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class GetAllExercisesActivity extends AppCompatActivity {


    private ListView listView;
    private ArrayList<Exercise> exerciseArrayList;
    private ExerciseAdapter exerciseAdapter;
    private DBHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_exercises);



        listView = (ListView) findViewById(R.id.lv2);

        databaseHelper = new DBHelper(this);

        exerciseArrayList = databaseHelper.getAllExercise();

        exerciseAdapter = new ExerciseAdapter(this,exerciseArrayList);
        listView.setAdapter(exerciseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GetAllExercisesActivity.this,AddExercises.class);
                intent.putExtra("user", exerciseArrayList.get(position));
                startActivity(intent);
            }
        });


    }
    }
