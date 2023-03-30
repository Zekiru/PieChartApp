package com.example.piechartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle tasks = getIntent().getExtras();

        // Create the object of TextView and PieChart class
        TextView tvR, tvPython, tvCPP, tvJava, taskName1, taskName2, taskName3, taskName4, pietaskName1,pietaskName2,pietaskName3,pietaskName4;
        PieChart pieChart;

        // Link those objects with their respective
        // id's that we have given in .XML file
        tvR = findViewById(R.id.tvR);
        tvPython = findViewById(R.id.tvPython);
        tvCPP = findViewById(R.id.tvCPP);
        tvJava = findViewById(R.id.tvJava);
        pieChart = findViewById(R.id.piechart);

        taskName1 = findViewById(R.id.tn1);
        taskName2= findViewById(R.id.tn2);
        taskName3 = findViewById(R.id.tn3);
        taskName4= findViewById(R.id.tn4);

        pietaskName1 = findViewById(R.id.pn1);
        pietaskName2= findViewById(R.id.pn2);
        pietaskName3 = findViewById(R.id.pn3);
        pietaskName4= findViewById(R.id.pn4);


        //variable
        taskName1.setText(tasks.getString("Task1"));
        taskName2.setText(tasks.getString("Task2"));
        taskName3.setText(tasks.getString("Task3"));
        taskName4.setText(tasks.getString("Task4"));

        pietaskName1.setText(tasks.getString("Task1"));
        pietaskName2.setText(tasks.getString("Task2"));
        pietaskName3.setText(tasks.getString("Task3"));
        pietaskName4.setText(tasks.getString("Task4"));





        // Set the percentage of language used
        tvR.setText(Integer.toString(tasks.getInt("Perc1")));
        tvPython.setText(Integer.toString(tasks.getInt("Perc2")));
        tvCPP.setText(Integer.toString(tasks.getInt("Perc3")));
        tvJava.setText(Integer.toString(tasks.getInt("Perc4")));

        // Set the data and color to the pie chart
        pieChart.addPieSlice(
                new PieModel(
                        tasks.getString("Task1"),
                        Integer.parseInt(tvR.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        tasks.getString("Task2"),
                        Integer.parseInt(tvPython.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        tasks.getString("Task3"),
                        Integer.parseInt(tvCPP.getText().toString()),
                        Color.parseColor("#EF5350")));
        pieChart.addPieSlice(
                new PieModel(
                        tasks.getString("Task4"),
                        Integer.parseInt(tvJava.getText().toString()),
                        Color.parseColor("#29B6F6")));

        pieChart.startAnimation();
    }
}