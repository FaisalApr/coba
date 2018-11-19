package com.example.msi.cloneig;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class detailProfil extends Activity {
    ImageButton ButHome , Butpruf;
    Button ButEdit;
    SessionManagement mSession;
    HashMap<String,String> nama;
    TextView txtNama;
    GridView gvLay;
    String[] a={""};
    dbHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail_profil);
        gvLay = (GridView) findViewById(R.id.griedview);
        gvLay.setAdapter(new ImageAdapter(this));
        gvLay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(detailProfil.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mSession = new SessionManagement(this);
        txtNama = (TextView) findViewById(R.id.TxtBismillah);
        nama = mSession.getUserInformation();
        txtNama.setText(""+nama.get(SessionManagement.KEY_EMAIL));

        ButHome = (ImageButton) findViewById(R.id.btnHum);
        Butpruf = (ImageButton) findViewById(R.id.btnPro);
        ButHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intt = new Intent(getApplicationContext(),Home.class);
                startActivity(intt);
            }
        });
        Butpruf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),detailProfil.class);
                startActivity(i);
            }
        });
        ButEdit = (Button) findViewById(R.id.coba);
        ButEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSession.logoutUser();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
