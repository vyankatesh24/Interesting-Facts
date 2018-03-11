package com.vyankatesh.interestingfacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class RandomFacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_facts);

    }

    public void onTextViewClick(View view) {
        TextView textView = (TextView) view;
        int id = textView.getId();
        Intent i = new Intent(this, Facts.class);
        switch (id) {
            case R.id.tvTrivia:
                //Trivia
                i.putExtra("cat", "random/trivia");
                startActivity(i);
                break;
            case R.id.tvMath:
                i.putExtra("cat", "random/math");
                startActivity(i);
                break;
            case R.id.tvDate:
                i.putExtra("cat", "random/date");
                startActivity(i);
                break;
            case R.id.tvYear:
                i.putExtra("cat", "random/year");
                startActivity(i);
                break;

        }
    }
}
