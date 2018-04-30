package com.example.cormac.gym12m;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * Created by Cormac on 18/04/2018.
 */

public class AddExercises extends AppCompatActivity {

    private EditText edtId, edtName, edtSet, edtWeight, edtReps;
    private Button btnAdd;
    private ListView lvEx;
    private DBHelper databaseHelper;
    private SimpleCursorAdapter simpleCursorAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_exercises);


        databaseHelper = new DBHelper(this);

        lvEx = (ListView) findViewById(R.id.ex_list);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        edtId = (EditText) findViewById(R.id.ex_id);
        edtName = (EditText) findViewById(R.id.ex_Name);
        edtWeight = (EditText) findViewById(R.id.ex_Weight);
        edtSet = (EditText) findViewById(R.id.ex_Set);
        edtReps = (EditText) findViewById(R.id.ex_Reps);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addExercise(Long.parseLong(edtId.getText().toString()), edtName.getText().toString(),edtSet.getText().toString(), edtWeight.getText().toString(),edtReps.getText().toString());
                edtName.setText("");
                edtSet.setText("");
                edtWeight.setText("");
                edtReps.setText("");
                Toast.makeText(AddExercises.this,"Stored Successfully!", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
