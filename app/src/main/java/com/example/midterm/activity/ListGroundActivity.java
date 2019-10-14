package com.example.midterm.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midterm.ListGroundAdapter;
import com.example.midterm.R;
import com.example.midterm.models.GroundCampData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ListGroundActivity extends AppCompatActivity {

    List<GroundCampData> campData = new ArrayList<GroundCampData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ground);

        addMenuItemsFromJson();

        RecyclerView recyclerView = findViewById(R.id.ground_list_recycler);
        ListGroundAdapter groundAdapter = new ListGroundAdapter(this, campData,
                new ListGroundAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int item) {
                        Intent inten = new Intent(ListGroundActivity.this, GroundContent.class);
                        startActivity(inten);
                    }
                });
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(groundAdapter);
    }

    private void addMenuItemsFromJson() {
        try {
            String jsonDataString = readJsonDataFromFile();
            JSONArray menuItemsJsonArray = new JSONArray(jsonDataString);

            for (int i = 0; i < menuItemsJsonArray.length(); ++i) {

                JSONObject menuItemObject = menuItemsJsonArray.getJSONObject(i);

                String name = menuItemObject.getString("name");
                String location = menuItemObject.getString("location");
                String ticket = menuItemObject.getString("ticket");
                String desc = menuItemObject.getString("desc");
                String image = menuItemObject.getString("image");

                GroundCampData pojo = new GroundCampData(name, location, ticket,desc,image);
                campData.add(pojo);
            }
        } catch (IOException | JSONException exception) {
            Log.e(ListGroundActivity.class.getName(), "Unable to parse JSON file.", exception);
        }
    }

    private String readJsonDataFromFile() throws IOException {

        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try {
            String jsonDataString = null;
            inputStream = getResources().openRawResource(R.raw.groundcamp);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));
            while ((jsonDataString = bufferedReader.readLine()) != null) {
                builder.append(jsonDataString);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return new String(builder);
    }

}
