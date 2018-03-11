package com.vyankatesh.interestingfacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class QuestFacts extends AppCompatActivity {
    ArrayList<String> categories = new ArrayList<>();
    ArrayAdapter<String> adapter;
    Spinner cat;
    LinearLayout llTrivia, llMath, llDate, llYear;
    String SelectedCat = "trivia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_facts);
        cat = findViewById(R.id.spinnerCat);
        categories.add("Trivia");
        categories.add("Math");
        categories.add("Date");
        categories.add("Year");
        llTrivia = findViewById(R.id.llNumber);
        llDate = findViewById(R.id.llDate);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        cat.setAdapter(adapter);

        cat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        SelectedCat = "trivia";
                        llTrivia.setVisibility(View.VISIBLE);
                        llDate.setVisibility(View.GONE);
                        ((EditText) findViewById(R.id.editTextNumber)).setHint("Number");

                        break;
                    case 1:
                        SelectedCat = "math";
                        llTrivia.setVisibility(View.VISIBLE);
                        llDate.setVisibility(View.GONE);
                        ((EditText) findViewById(R.id.editTextNumber)).setHint("Number");

                        break;
                    case 2:
                        SelectedCat = "date";
                        llTrivia.setVisibility(View.GONE);
                        llDate.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        SelectedCat = "year";
                        llTrivia.setVisibility(View.VISIBLE);
                        llDate.setVisibility(View.GONE);
                        ((EditText) findViewById(R.id.editTextNumber)).setHint("Year");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void onGetFactClicked(View view) {
        String parameter = "";

        if (SelectedCat.equals("trivia") || SelectedCat.equals("math") || SelectedCat.equals("year")) {
            parameter = ((EditText) findViewById(R.id.editTextNumber)).getText().toString() + "/" + SelectedCat;
        }
        if (SelectedCat.equals("date")) {
            parameter = ((EditText) findViewById(R.id.editTextMonth)).getText().toString() + "/" + ((EditText) findViewById(R.id.editTextDay)).getText().toString() + "/" + SelectedCat;
        }

        Intent i = new Intent(this, Facts.class);
        i.putExtra("cat", parameter);
        startActivity(i);
    }
}
