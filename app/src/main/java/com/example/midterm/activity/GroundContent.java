package com.example.midterm.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.midterm.MainActivity;
import com.example.midterm.R;
import com.squareup.picasso.Picasso;

public class GroundContent extends AppCompatActivity {

    TextView name;
    TextView informasi;
    TextView ticket;
    TextView lokasi;
    ImageView gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ground_content);

        name = findViewById(R.id.nama_tempat);
        informasi = findViewById(R.id.desc);
        ticket = findViewById(R.id.ticket_tempat);
        lokasi = findViewById(R.id.lokasi_tempat);
        gambar = findViewById(R.id.gambar_tempat);

        Picasso.with(getApplicationContext()).
                load(getIntent().getStringExtra("image")).fit().into(gambar);

        name.setText(getIntent().getStringExtra("nama"));
        informasi.setText(getIntent().getStringExtra("desc"));
        ticket.setText(getIntent().getStringExtra("ticket"));
        lokasi.setText(getIntent().getStringExtra("location"));

    }
}
