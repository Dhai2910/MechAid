package com.example.mechanicalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SolveQuestions2 extends AppCompatActivity {
    EditText length, distance, magnitude;
    Button addPointLoad, proceedResult;

    RecyclerView recyclerView;
    List<Model> modelList;
    Adapter adapter;
    float[][] loads;
    int a;
    float b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_solve_questions2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        length = findViewById(R.id.editText);
        distance = findViewById(R.id.distance);
        magnitude = findViewById(R.id.mag);
        addPointLoad = findViewById(R.id.addPointLoad);
        proceedResult = findViewById(R.id.button);

        recyclerView = findViewById(R.id.recyclerView2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        modelList = new ArrayList<>();
        adapter = new Adapter(modelList);
        recyclerView.setAdapter(adapter);


        addPointLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sDistance = distance.getText().toString();
                String sMagnitude = magnitude.getText().toString();

                if (sDistance.isEmpty() || sMagnitude.isEmpty()) {
                    Toast.makeText(SolveQuestions2.this,
                            "Please fill all fields", Toast.LENGTH_LONG).show();
                } else {
                    modelList.add(new Model("Distance", sDistance, "Magnitude", sMagnitude, R.color.option1));
                    adapter.notifyItemInserted(modelList.size() - 1);
                    distance.setText("");
                    magnitude.setText("");
                }
            }
        });


        proceedResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sLength = length.getText().toString();

                if (modelList.isEmpty() || sLength.isEmpty()) {
                    Toast.makeText(SolveQuestions2.this,
                            "Please fill all the fields", Toast.LENGTH_LONG).show();
                } else {
                    a = modelList.size();
                    b = Float.parseFloat(sLength);
                    loads = new float[a][2];
                    for (int i = 0; i < a; i++) {
                        Model model = modelList.get(i);
                        String distance = model.getDistanceCount();
                        loads[i][0] = Float.parseFloat(distance);
                        String magnitude = model.getMagnitudeCount();
                        loads[i][1] = Float.parseFloat(magnitude);
                    }
                    // Sorting 2D array by the distance
                    for (int i = 0; i < a - 1; i++) {
                        for (int j = 0; j < a - i - 1; j++) {
                            if (loads[j][0] < loads[j + 1][0]) {
                                float temp = loads[j][0];
                                loads[j][0] = loads[j + 1][0];
                                loads[j + 1][0] = temp;
                                // Sorting forces with distances
                                float temp2 = loads[j][1];
                                loads[j][1] = loads[j + 1][1];
                                loads[j + 1][1] = temp2;

                            }
                        }
                    }

                    Intent intent = new Intent(getApplicationContext(), Results.class);
                    intent.putExtra("loads", loads);
                    intent.putExtra("number", a);
                    intent.putExtra("length", b);
                    startActivity(intent);
                }
            }
        });

    }
}