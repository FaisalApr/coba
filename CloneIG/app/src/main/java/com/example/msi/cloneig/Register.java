package com.example.msi.cloneig;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private Button myButton,Btnsave ;
    dbHandler db;
    EditText emailEt , namaEt, usernameEt, passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myButton = (Button) findViewById(R.id.btnMove);
        Btnsave = (Button) findViewById(R.id.btnRegister);
        emailEt = (EditText) findViewById(R.id.email);
        namaEt = (EditText) findViewById(R.id.editTextNama);
        usernameEt = (EditText) findViewById(R.id.editTextUsername);
        passwordEt = (EditText) findViewById(R.id.editTextPassword);
        db = new dbHandler(this);

        Btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailStr = emailEt.getText().toString();
                String nameStr = namaEt.getText().toString();
                String usernameStr = usernameEt.getText().toString();
                String passwordStr = passwordEt.getText().toString();
                SQLiteDatabase dbS = db.getWritableDatabase();
//                db.addRecord(new userModel(emailStr, nameStr, usernameStr, passwordStr));
                dbS.execSQL("insert into user(email,nama,username,password) values('"
                        +emailStr+"','"+nameStr+"','"+usernameStr+"','"+passwordStr+"')");


                Intent I = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(I);
                Toast.makeText(getApplicationContext(),"sukses",Toast.LENGTH_SHORT).show();
            }
        });

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }
}
