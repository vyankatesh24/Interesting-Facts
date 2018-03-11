package com.vyankatesh.interestingfacts;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String SelectedCat = "trivia";
    LinearLayout llTrivia, llDate;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public void onGetFactClicked(View view) {
        String parameter = "";

        if (SelectedCat.equals("trivia") || SelectedCat.equals("math") || SelectedCat.equals("year")) {
            parameter = ((EditText) findViewById(R.id.editTextNumber)).getText().toString() + "/" + SelectedCat;
        }
        if (SelectedCat == "date") {
            parameter = ((EditText) findViewById(R.id.editTextMonth)).getText().toString() + "/" + ((EditText) findViewById(R.id.editTextDay)).getText().toString() + "/" + SelectedCat;
        }

        Intent i = new Intent(this, Facts.class);
        i.putExtra("cat", parameter);
        startActivity(i);
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

    public void onTextViewClickTab2(View v) {
        llTrivia = findViewById(R.id.llNumber);
        llDate = findViewById(R.id.llDate);
        TextView textView = (TextView) v;
        int id = textView.getId();
        switch (id) {
            case R.id.tvTrivia1:
                //Trivia
                SelectedCat = "trivia";
                llTrivia.setVisibility(View.VISIBLE);
                llDate.setVisibility(View.GONE);
                ((EditText) findViewById(R.id.editTextNumber)).setHint("Number");
                ((TextView) findViewById(R.id.tvTrivia1)).setTextColor(Color.parseColor("#ffda09"));
                ((TextView) findViewById(R.id.tvMath1)).setTextColor(Color.WHITE);
                ((TextView) findViewById(R.id.tvDate1)).setTextColor(Color.WHITE);
                ((TextView) findViewById(R.id.tvYear1)).setTextColor(Color.WHITE);
                break;
            case R.id.tvMath1:
                SelectedCat = "math";
                llTrivia.setVisibility(View.VISIBLE);
                llDate.setVisibility(View.GONE);
                ((EditText) findViewById(R.id.editTextNumber)).setHint("Number");
                ((TextView) findViewById(R.id.tvTrivia1)).setTextColor(Color.WHITE);
                ((TextView) findViewById(R.id.tvMath1)).setTextColor(Color.parseColor("#ffda09"));
                ((TextView) findViewById(R.id.tvDate1)).setTextColor(Color.WHITE);
                ((TextView) findViewById(R.id.tvYear1)).setTextColor(Color.WHITE);
                break;
            case R.id.tvDate1:
                SelectedCat = "date";
                llTrivia.setVisibility(View.GONE);
                llDate.setVisibility(View.VISIBLE);
                ((TextView) findViewById(R.id.tvTrivia1)).setTextColor(Color.WHITE);
                ((TextView) findViewById(R.id.tvMath1)).setTextColor(Color.WHITE);
                ((TextView) findViewById(R.id.tvDate1)).setTextColor(Color.parseColor("#ffda09"));
                ((TextView) findViewById(R.id.tvYear1)).setTextColor(Color.WHITE);
                break;
            case R.id.tvYear1:
                SelectedCat = "year";
                llTrivia.setVisibility(View.VISIBLE);
                llDate.setVisibility(View.GONE);
                ((EditText) findViewById(R.id.editTextNumber)).setHint("Year");
                ((TextView) findViewById(R.id.tvTrivia1)).setTextColor(Color.WHITE);
                ((TextView) findViewById(R.id.tvMath1)).setTextColor(Color.WHITE);
                ((TextView) findViewById(R.id.tvDate1)).setTextColor(Color.WHITE);
                ((TextView) findViewById(R.id.tvYear1)).setTextColor(Color.parseColor("#ffda09"));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {
            Intent i = new Intent(this, Help.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            switch (position) {
                case 0:

                    return new Tab1();
                case 1:
                    return new Tab2();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Random Facts";
                case 1:
                    return "Quest Facts";
            }
            return null;
        }


    }
}
