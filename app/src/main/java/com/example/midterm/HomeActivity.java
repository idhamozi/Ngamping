package com.example.midterm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.midterm.activity.ListGroundActivity;

public class HomeActivity extends AppCompatActivity {

    ImageButton About;
    ImageButton InfoCamp;
    ImageButton Keluar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Keluar = findViewById(R.id.exit);
        InfoCamp = findViewById(R.id.infocamp);
        About = findViewById(R.id.about1);

        Keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(HomeActivity.this)
                .setTitle("KELUAR APLIKASI")
                .setMessage("Anda Yakin Keluar ?")
                .setNegativeButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("NO", null).create().show();
            }
        });
        InfoCamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ListGroundActivity.class);
                startActivity(intent);
            }
        });
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, about.class);
                startActivity(intent);
            }
        });

    }
}
