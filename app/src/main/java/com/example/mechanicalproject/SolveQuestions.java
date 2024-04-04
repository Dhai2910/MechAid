package com.example.mechanicalproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SolveQuestions extends AppCompatActivity {
    Button addPointLoad;
    RecyclerView recyclerView;
    List<Model> modelList;
    Adapter adapter;
    private String distance, magnitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_solve_questions);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addPointLoad = findViewById(R.id.addPointLoad);
        addPointLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddPointLoad.class);
                startActivity(i);
            }
        });
        modelList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(modelList);
        recyclerView.setAdapter(adapter);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                data = getIntent();
                distance = data.getStringExtra("distance");
                magnitude = data.getStringExtra("magnitude");

                modelList.add(new Model("Distance",distance,"Magnitude",magnitude,R.color.option1));
                adapter.notifyDataSetChanged();



            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this,
                        "Cancelled", Toast.LENGTH_SHORT).show();
            }
        }
    }
}