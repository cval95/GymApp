package com.example.cormac.gym12m;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cormac.gym12m.DBHelper;
import com.example.cormac.gym12m.R;

public class Add_Workouts extends AppCompatActivity {

    private Button btnAdd;
    private EditText edtName;
    private DBHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add__workouts);

        databaseHelper = new DBHelper(this);

        btnAdd = (Button) findViewById(R.id.btnAdd);

        edtName = (EditText) findViewById(R.id.workout_Name);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addWorkout(edtName.getText().toString());
                Toast.makeText(Add_Workouts.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Add_Workouts.this, AddExercises.class);
                startActivity(intent);
            }
        });
    }



    }

