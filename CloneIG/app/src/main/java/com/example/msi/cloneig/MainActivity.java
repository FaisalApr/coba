package com.example.msi.cloneig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private Button myBut, ButKu;
    EditText EtUname,EtPwd;
    dbHandler db;
    SessionManagement mSession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButKu = (Button) findViewById(R.id.btnMasuk);
        EtUname = (EditText) findViewById(R.id.editTextUser);
        EtPwd = (EditText) findViewById(R.id.editTextPass);
        myBut = (Button) findViewById(R.id.btnPindah);
        db = new dbHandler(this);
        mSession = new SessionManagement(this);
        myBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),Register.class);
                startActivity(i);
            }
        });

        if(mSession.isLoggedIn()){
            Intent inte = new Intent(getApplicationContext(),Home.class);
            startActivity(inte);
        }

        ButKu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = EtUname.getText().toString();
                String pwd = EtPwd.getText().toString();

                Boolean ChkLogin = db.cekLogin(uname,pwd);

                if(ChkLogin==true){
                    Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_SHORT).show();
                    Intent inte = new Intent(getApplicationContext(),Home.class);
//                    inte.putExtra("username",uname);
                    mSession.createLoginSession(uname,pwd);

                    startActivity(inte);
                }else{
                    Toast.makeText(getApplicationContext(),"Anda Belum Terdaftar",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
