package com.example.mechanicalproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    TextView textView;

    private RecyclerView recyclerView;

    private List<menu> menuItems;

    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.textView);
        recyclerView = findViewById(R.id.recyclerView);
        menuItems = new ArrayList<>();

        menu m1 = new menu("Solve Questions",R.color.option1,R.drawable.img_2);
        menu m2 = new menu("Feedback",R.color.option2,R.drawable.feedback);
        menu m3 = new menu("About Us",R.color.option3,R.drawable.img_4);

        menuItems.add(m1);
        menuItems.add(m2);
        menuItems.add(m3);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        customAdapter = new CustomAdapter(menuItems);
        recyclerView.setAdapter(customAdapter);

        customAdapter.setClickListener(this);

    }

    @Override
    public void onClick(View v, int pos) {
        if(pos == 0){
            Intent i = new Intent(this, SolveQuestions2.class);
            startActivity(i);
        }

        if(pos == 1){
            Uri feedback = Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLScjDvTUKAQSQr0g8Sljtg3Hw90rP-gej6iZ-BuFO7R_rLnZBg/viewform?usp=sf_link");
            Intent i = new Intent(Intent.ACTION_VIEW, feedback);
            startActivity(i);
        }

        if(pos == 2){
            Intent i = new Intent(this, About_Us_Activity.class);
            startActivity(i);
        }
    }

}