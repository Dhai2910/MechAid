package com.example.mechanicalproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class About_Us_Activity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<About_Us> aboutUsList;

    AboutAdapter aboutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about_us);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        aboutUsList = new ArrayList<>();

        About_Us a1 = new About_Us("I am Kashish Saini (23BCS049). I helped in app-dev and report preparation",R.drawable.kashish);
        About_Us a2 = new About_Us("I am Kunal Thakur(23BCS053). I designed the app prototype", R.drawable.img_2);
        About_Us a3 = new About_Us("I am Madhav Goyal(23BCS057). I laid the fondation and spark the ideation for the creation of the app", R.drawable.img);

        aboutUsList.add(a1);
        aboutUsList.add(a2);
        aboutUsList.add(a3);

        aboutAdapter = new AboutAdapter(aboutUsList);

        recyclerView.setAdapter(aboutAdapter);


    }
}