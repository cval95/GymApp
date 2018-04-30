package com.example.cormac.gym12m;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Cormac on 18/04/2018.
 */

public class GetAllWorkoutsActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Workout> workoutArrayList;
    private WorkoutAdapter workoutAdapter;
    private DBHelper databaseHelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_get_all_workouts);

        listView = (ListView) findViewById(R.id.lv);

        databaseHelper = new DBHelper(this);

        workoutArrayList = databaseHelper.getAllWokouts();

        workoutAdapter = new WorkoutAdapter(this,workoutArrayList);
        listView.setAdapter(workoutAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GetAllWorkoutsActivity.this,AddExercises.class);
                intent.putExtra("workout_name", workoutArrayList.get(position));
                startActivity(intent);
            }
        });


    }
}
