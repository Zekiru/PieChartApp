package com.example.piechartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText Task1 = findViewById(R.id.Task1);
        EditText Task2 = findViewById(R.id.Task2);
        EditText Task3 = findViewById(R.id.Task3);
        EditText Task4 = findViewById(R.id.Task4);
        EditText Perc1 = findViewById(R.id.Perc1);
        EditText Perc2 = findViewById(R.id.Perc2);
        EditText Perc3 = findViewById(R.id.Perc3);
        EditText Perc4 = findViewById(R.id.Perc4);
        Button submit = findViewById(R.id.submitButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(Task1.getText()) || TextUtils.isEmpty(Task2.getText()) || TextUtils.isEmpty(Task3.getText()) || TextUtils.isEmpty(Task4.getText()) || TextUtils.isEmpty(Perc1.getText()) || TextUtils.isEmpty(Perc2.getText()) || TextUtils.isEmpty(Perc3.getText()) || TextUtils.isEmpty(Perc4.getText()) ) {
                    Alert("Please fill out all the fields.");
                    return;
                }

                if (Integer.parseInt(Perc1.getText().toString()) + Integer.parseInt(Perc2.getText().toString()) + Integer.parseInt(Perc3.getText().toString()) + Integer.parseInt(Perc4.getText().toString()) != 100) {
                    Alert("All Percentages must sum up to 100%.");
                    return;
                }

                Intent next = new Intent(MainActivity.this, MainActivity2.class);
                Bundle tasks = new Bundle();
                tasks.putString("Task1", Task1.getText().toString());
                tasks.putString("Task2", Task2.getText().toString());
                tasks.putString("Task3", Task3.getText().toString());
                tasks.putString("Task4", Task4.getText().toString());
                tasks.putInt("Perc1",  Integer.parseInt(Perc1.getText().toString()));
                tasks.putInt("Perc2",  Integer.parseInt(Perc2.getText().toString()));
                tasks.putInt("Perc3",  Integer.parseInt(Perc3.getText().toString()));
                tasks.putInt("Perc4",  Integer.parseInt(Perc4.getText().toString()));
                next.putExtras(tasks);
                startActivity(next);
            }
        });


    }

    private void Alert(String dialog) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(dialog);
        builder.setCancelable(true);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}