package com.vyankatesh.interestingfacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by vyankatesh on 29/10/17.
 */

public class Tab2 extends Fragment {


    LinearLayout llTrivia, llDate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.layout_tab2, container, false);


        llTrivia = rootView.findViewById(R.id.llNumber);
        llDate = rootView.findViewById(R.id.llDate);


      /*  cat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:MainActivity.SelectedCat="trivia";
                        llTrivia.setVisibility(View.VISIBLE);
                        llDate.setVisibility(View.GONE);
                        ((EditText)rootView.findViewById(R.id.editTextNumber)).setHint("Number");

                        break;
                    case 1:MainActivity.SelectedCat="math";
                        llTrivia.setVisibility(View.VISIBLE);
                        llDate.setVisibility(View.GONE);
                        ((EditText)rootView.findViewById(R.id.editTextNumber)).setHint("Number");

                        break;
                    case 2:MainActivity.SelectedCat="date";
                        llTrivia.setVisibility(View.GONE);
                        llDate.setVisibility(View.VISIBLE);
                        break;
                    case 3:MainActivity.SelectedCat="year";
                        llTrivia.setVisibility(View.VISIBLE);
                        llDate.setVisibility(View.GONE);
                        ((EditText)rootView.findViewById(R.id.editTextNumber)).setHint("Year");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
        return rootView;
    }
}

