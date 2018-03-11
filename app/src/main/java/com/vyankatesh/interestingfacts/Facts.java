package com.vyankatesh.interestingfacts;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class Facts extends AppCompatActivity {

    String cat;
    LinearLayout linearLayout;
    Random r;
    private Dialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts);
        cat = getIntent().getStringExtra("cat");
        new GetResponseAsync(this).execute();
        r = new Random();
        String title = (cat.substring(cat.lastIndexOf('/') + 1)).toUpperCase() + " FACTS";
        setTitle(title);

        linearLayout = findViewById(R.id.llFacts);


    }

    public void onNextClick(View v) {
        new GetResponseAsync(this).execute();
    }


    class GetResponseAsync extends AsyncTask {
        StringBuilder sb = new StringBuilder();
        Context context;


        public GetResponseAsync(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            loadingDialog = ProgressDialog.show(context, "Please wait", "Loading...");
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Object[] params) {
            String link = "http://numbersapi.com/" + cat + "/";
            try {
                URL url = new URL(link);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoOutput(false);
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                // Read Server Response
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    break;
                }
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Object o) {
            TextView tv = findViewById(R.id.textView);
            tv.setText(sb.toString());
            tv.setTextColor(Color.WHITE);
            linearLayout.setBackgroundColor(Color.rgb(r.nextInt(200), r.nextInt(200), r.nextInt(200)));

            loadingDialog.dismiss();

            super.onPostExecute(o);
        }
    }
}

