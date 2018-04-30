package com.example.cormac.gym12m;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    DBHelper db;
    EditText e1, e2, e3;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DBHelper(this);

        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.pass);
        e3=(EditText)findViewById(R.id.cpass);
        b1=(Button)findViewById(R.id.register);
        b2=(Button)findViewById(R.id.button3);


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);

            }
        });




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();

                if (s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else{
                    if (s2.equals(s3)){
                        Boolean checkemail = db.checkEmail(s1);
                        if (checkemail==true){
                            Boolean insert = db.insert(s1,s2);
                            if (insert==true){
                                Toast.makeText(getApplicationContext(),"Registered Successfully", Toast.LENGTH_SHORT).show();

                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Email Already Exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(),"Password do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}
