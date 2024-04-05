package com.example.mechanicalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Results extends AppCompatActivity {
    float[][] loads;
    int a ;
    float b;

    LineChart lineChart, lineChart2;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_results);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        loads = (float[][]) intent.getSerializableExtra("loads");
        b = intent.getFloatExtra("length",0);
        a = intent.getIntExtra("number",0);

        float[] sfd = SFD(loads,a,b);
        float[] bmd = BMD(loads,a,b);


        lineChart = findViewById(R.id.lineChart);
        lineChart.getAxisRight().setDrawLabels(false);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisLineColor(R.color.black);
        xAxis.setTextColor(R.color.white);
        xAxis.setAxisLineWidth(1f);

        YAxis yAxis = lineChart.getAxisLeft();
        yAxis.setAxisLineColor(R.color.black);
        yAxis.setTextColor(R.color.white);
        yAxis.setAxisLineWidth(1f);

        List<Entry> entries = new ArrayList<>();
        if(loads[0][0] == b){
            for(int i = 0; i<sfd.length; i++) {
                if(i == 0){
                    entries.add(new Entry(0,sfd[i]));
                    entries.add(new Entry(loads[a-1][0],sfd[i]));
                }else {
                    entries.add(new Entry(loads[a-i][0],sfd[i]));
                    entries.add(new Entry(loads[a-i-1][0],sfd[i]));
                }

            }
        }else {
            for(int i = 0; i<sfd.length; i++) {
                if(i == 0){
                    entries.add(new Entry(0,sfd[i]));
                    entries.add(new Entry(loads[a-1][0],sfd[i]));
                }else {
                    entries.add(new Entry(loads[a-i][0],sfd[i]));
                    entries.add(new Entry(loads[a-i-1][0],sfd[i]));
                }

            }
            entries.add(new Entry(loads[0][0],0));
            entries.add(new Entry(b,0));
        }
        LineDataSet lineDataSet = new LineDataSet(entries,"sfd");

        LineData lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);
        lineChart.invalidate();

        lineChart2 = findViewById(R.id.lineChart2);
        lineChart2.getAxisRight().setDrawLabels(false);

        XAxis xAxis2 = lineChart.getXAxis();
        xAxis2.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis2.setAxisLineColor(R.color.black);
        xAxis2.setTextColor(R.color.white);
        xAxis2.setAxisLineWidth(1f);

        YAxis yAxis2 = lineChart.getAxisLeft();
        yAxis2.setAxisLineColor(R.color.black);

        yAxis2.setAxisLineWidth(1f);
        List<Entry> entries1 = new ArrayList<>();
        if(loads[0][0] == b) {
            entries1.add(new Entry(0,bmd[0]));
            for (int i = 0; i < bmd.length-1; i++) {
                entries1.add(new Entry(loads[a-i-1][0], bmd[i+1]));
            }

        }else {
            entries1.add(new Entry(0,bmd[0]));
            for (int i = 0; i < bmd.length-1; i++) {
                entries1.add(new Entry(loads[a-i-1][0], bmd[i+1]));
            }
            entries1.add(new Entry(b,0));
            entries1.add(new Entry((float) loads[0][0], 0));
        }
        LineDataSet lineDataSet2 = new LineDataSet(entries1,"bmd");

        LineData lineData2 = new LineData(lineDataSet2);
        lineChart2.setData(lineData2);
        lineChart2.invalidate();

    }
    public static float[] SFD(float[][] loads, int a, float b) {


        float sfd[] = new float[a];

        float sum = 0;

            for (int i = 0; i < a; i++) {
                sum = sum + loads[i][1];
                sfd[i] = sum;
            }

        for (int i = 0;i<(sfd.length)/2;i++){
            float temp = sfd[i];
            sfd[i] = sfd[sfd.length-i-1];
            sfd[sfd.length-i-1] = temp;
        }

        return sfd;
    }

    // BMD
    public static float[] BMD(float[][] loads, int a, float b) {
        float[] bmd = new float[a + 1];
        for (int i = 0; i < a; i++) {
            float bendingM = 0;
            for (int j = 0; j < a; j++) {
                if (loads[i][0] <= loads[j][0]) {
                    bendingM = bendingM - (loads[j][0] - loads[i][0]) * loads[j][1];
                }
                bmd[i] = bendingM;
            }

        }
        if (loads[a - 1][0] != 0) {
            float bmd2 = 0;
            for (int i = 0; i < a; i++) {
                bmd2 = bmd2 - (loads[i][0] * loads[i][1]);
            }
            bmd[a] = bmd2;
        }
        for (int i = 0;i<(bmd.length)/2;i++){
            float temp = bmd[i];
            bmd[i] = bmd[bmd.length-i-1];
            bmd[bmd.length-i-1] = temp;
        }

        return bmd;
    }
}