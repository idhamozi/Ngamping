package com.example.midterm.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midterm.ListGroundAdapter;
import com.example.midterm.R;
import com.example.midterm.models.GroundCampData;

import java.util.ArrayList;
import java.util.List;

public class ListGroundActivity extends AppCompatActivity {

    List<GroundCampData> campData = new ArrayList<GroundCampData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ground);

        campData.add(new GroundCampData("nama","location","10k"));

        RecyclerView recyclerView = findViewById(R.id.ground_list_recycler);
        ListGroundAdapter groundAdapter = new ListGroundAdapter(this, campData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(groundAdapter);
    }
}
