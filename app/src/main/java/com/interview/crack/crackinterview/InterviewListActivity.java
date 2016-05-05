package com.interview.crack.crackinterview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class InterviewListActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        // Defined Array values to show in ListView
        String[] values = new String[] { "Basics Questions", "Activities Questions","Intent Questions", "Services Questions", "Content Provider Questions", "Fragment Questions"};


        // Array Adapter to set the course values
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, android.R.id.text1, values);

        // List View for the Courses Start
        listView = (ListView)findViewById(R.id.listView3);


        // set the adapter to the list view
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                if (0 == itemPosition) {

                    Intent intent = new Intent(getApplicationContext(), InterviewViewActivity.class);
                    intent.putExtra("filename", "file:///android_asset/iq_activities.html");
                    startActivity(intent);

                } else if (1 == itemPosition) {

                    Intent intent = new Intent(getApplicationContext(), InterviewViewActivity.class);
                    intent.putExtra("filename", "file:///android_asset/iq_basics.html");
                    startActivity(intent);

                } else if (2 == itemPosition) {

                    Toast.makeText(getApplicationContext(), "Yet to develope", Toast.LENGTH_LONG).show();
                }


                // ListView Clicked item value
                //String itemValue = (String) listView.getItemAtPosition(position);

                // Show Alert
                // Toast.makeText(getApplicationContext(), "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG).show();

            }

        });

    }

}
