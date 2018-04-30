package com.example.cormac.gym12m;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Cormac on 29/04/2018.
 */

public class MainMenu extends AppCompatActivity {

    private Button btnStart;
    private Button btnGetW;
    private Button btnGetEx;
    private Button btnPic;
    private Button btnEx;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnGetW = (Button) findViewById(R.id.btnGetW);
        btnGetEx = (Button) findViewById(R.id.btnGetEx);
        btnPic = (Button) findViewById(R.id.btnPic);
        btnEx = (Button) findViewById(R.id.btnEx);


          }



    public void onClickEX(View view) {
        Intent intentS = new Intent(MainMenu.this, ExerciseList.class );
        startActivity(intentS);
    }


    public void onClickPic(View view) {
        Intent intentS = new Intent(MainMenu.this, Camera.class );
        startActivity(intentS);
    }

    public void onClickW(View view) {
        Intent intentS = new Intent(MainMenu.this, GetAllWorkoutsActivity.class );
        startActivity(intentS);
    }

    public void onClickE(View view) {
        Intent intentEx = new Intent(MainMenu.this, GetAllExercisesActivity.class );
        startActivity(intentEx);
    }

    public void onClickStart(View view) {
        Intent intentS = new Intent(MainMenu.this, Add_Workouts.class );
        startActivity(intentS);
    }
}
