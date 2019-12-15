package com.example.midterm.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.midterm.MainActivity;
import com.example.midterm.MapsActivity;
import com.example.midterm.R;
import com.squareup.picasso.Picasso;

public class GroundContent extends AppCompatActivity implements View.OnClickListener {

    TextView name;
    TextView informasi;
    TextView ticket;
    TextView lokasi;
    ImageView gambar;
    Button view_map;

    String nama;
    Double lat,lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ground_content);

        name = findViewById(R.id.nama_tempat);
        informasi = findViewById(R.id.desc);
        ticket = findViewById(R.id.ticket_tempat);
        lokasi = findViewById(R.id.lokasi_tempat);
        gambar = findViewById(R.id.gambar_tempat);
        view_map = findViewById(R.id.view_map);

        Picasso.with(getApplicationContext()).
                load(getIntent().getStringExtra("image")).fit().into(gambar);

        name.setText(getIntent().getStringExtra("nama"));
        informasi.setText(getIntent().getStringExtra("desc"));
        ticket.setText(getIntent().getStringExtra("ticket"));
        lokasi.setText(getIntent().getStringExtra("location"));
        nama = getIntent().getStringExtra("nama");
        lat = getIntent().getDoubleExtra("lat",0);
        lng =getIntent().getDoubleExtra("lng",0);

        view_map.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("nama",nama);
        intent.putExtra("lat",lat);
        intent.putExtra("lng",lng);
        startActivity(intent);
    }
}
