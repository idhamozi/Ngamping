package com.example.midterm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.midterm.activity.ListGroundActivity;

public class HomeActivity extends AppCompatActivity {

    Button About;
    Button InfoCamp;
    Button Keluar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Keluar = findViewById(R.id.exit);
        InfoCamp = findViewById(R.id.infocamp);

        Keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                builder.setTitle("KELUAR APLIKASI");
                builder.setMessage("Anda Yakin Keluar ?");
                builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).create().show();
                builder.setPositiveButton("NO", null).create().show();
            }
        });
        InfoCamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ListGroundActivity.class);
                startActivity(intent);
            }
        });

    }
}
