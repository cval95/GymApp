package com.example.cormac.gym12m;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText e1,e2;
    Button b1;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        db = new DBHelper(this);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText3);
        b1 = (Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean checkemailPass = db.emailpassword(email,password);
                if (checkemailPass==true){
                    Toast.makeText(getApplicationContext(),"Successfully Login",Toast.LENGTH_SHORT).show();
                    Intent iMenu = new Intent(Login.this, MainMenu.class);
                    startActivity(iMenu);
                } else{
                    Toast.makeText(getApplicationContext(),"Wrong email or password", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
