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

public class AddPointLoad extends AppCompatActivity {
    private EditText distance, magnitude;
    private Button btn;
    private String sDistance, sMagnitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_point_load);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        distance = findViewById(R.id.distance2);
        magnitude = findViewById(R.id.magnitude);
        btn = findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(distance.getText().toString().isEmpty()||magnitude.getText().toString().isEmpty()){
                    Toast.makeText(AddPointLoad.this,
                            "Please input all fields", Toast.LENGTH_LONG).show();

                }else {
                    sDistance = distance.getText().toString();
                    sMagnitude = magnitude.getText().toString();

                    Intent i = new Intent(getApplicationContext(),SolveQuestions.class);
                    i.putExtra("distance",sDistance);
                    i.putExtra("magnitude",sMagnitude);
                    setResult(RESULT_OK, i);
                    finish();
                }
            }
        });
    }
}