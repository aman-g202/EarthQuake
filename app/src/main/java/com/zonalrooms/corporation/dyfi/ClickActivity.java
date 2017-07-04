package com.zonalrooms.corporation.dyfi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by DELL on 6/11/2017.
 */

public class ClickActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String people = intent.getStringExtra("people");
        String value = intent.getStringExtra("value");
        String link = intent.getStringExtra("url");
        //Toast.makeText(this,link,Toast.LENGTH_LONG).show();

        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(title);

        TextView tsunamiTextView = (TextView) findViewById(R.id.number_of_people);
        tsunamiTextView.setText(getString(R.string.num_people_felt_it, people));

        TextView magnitudeTextView = (TextView) findViewById(R.id.perceived_magnitude);
        magnitudeTextView.setText(value);

        TextView url = (TextView) findViewById(R.id.link);
        url.setText(link);
        url.setMovementMethod(LinkMovementMethod.getInstance());

    }

}
