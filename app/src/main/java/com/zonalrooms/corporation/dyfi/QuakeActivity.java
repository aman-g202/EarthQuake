package com.zonalrooms.corporation.dyfi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 6/11/2017.
 */

public class QuakeActivity extends AppCompatActivity {
    private List<Earthquake> earthquakeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecycleAdapter mAdapter;
    ProgressDialog progressBar;

    /** URL for earthquake data from the USGS dataset */
    private static final String USG_REQUEST_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=1&limit=300";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Backgroundthreade threade  = new Backgroundthreade();
        threade.execute(USG_REQUEST_URL);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new RecycleAdapter(earthquakeList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecycleTouch(getApplicationContext(), recyclerView, new RecycleTouch.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Earthquake earth = earthquakeList.get(position);
                Intent intent = new Intent(QuakeActivity.this, ClickActivity.class);
                intent.putExtra("title", earth.getTitle());
                intent.putExtra("people", earth.getPeople());
                intent.putExtra("value", earth.getValue());
                intent.putExtra("url", earth.getUrl());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }
    private class Backgroundthreade extends AsyncTask<String, Void, List<Earthquake>> {

        @Override
        protected void onPreExecute() {
            progressBar = new ProgressDialog(QuakeActivity.this);
            progressBar.setCancelable(true);
            progressBar.setMessage("Fetching Data Kindly Wait ...");
            progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressBar.setProgress(0);
            progressBar.setMax(100);
            progressBar.show();
            //super.onPreExecute();
        }

        @Override
        protected List<Earthquake> doInBackground(String... params) {
            List<Earthquake> earthquake =  Utils_ex.fetchEarthquakeData(params[0]);
            return earthquake;
        }

        @Override
        protected void onPostExecute(List<Earthquake> earthquakes) {
            progressBar.dismiss();
            earthquakeList.addAll(earthquakes);
            mAdapter.notifyDataSetChanged();
        }
    }
}
