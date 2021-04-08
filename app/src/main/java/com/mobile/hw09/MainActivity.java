package com.mobile.hw09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adapterMainSubjects;
    ListView myMainListView;
    Context context;
    SingleItem selectedNewsItem;
    String [][] myUrlCaptionMenu = {
            {"https://feeds.npr.org/510289/podcast.xml", "Business"},
    {"https://feeds.npr.org/344098539/podcast.xml", "Comedy"},
    {"https://feeds.npr.org/510308/podcast.xml", "Science"},
    {"https://feeds.npr.org/510298/podcast.xml", "Technology"},
    {"https://feeds.npr.org/510306/podcast.xml", "Music"},
    {"https://feeds.npr.org/510354/podcast.xml", "Kid & family"},
    {"https://feeds.npr.org/510309/podcast.xml", "Society & culture"}
    };

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dantri_btn = findViewById(R.id.dantri_btn),
                thanhnien_btn = findViewById(R.id.thanhnien_btn),
                vnexpress_btn = findViewById(R.id.vnexpress_btn);
        dantri_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "TODO: Get Dan Tri news", Toast.LENGTH_SHORT).show();
            }
        });
        thanhnien_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "TODO: Get Thanh Nien news", Toast.LENGTH_SHORT).show();
            }
        });
        vnexpress_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "TODO: Get VNEXPRESS news", Toast.LENGTH_SHORT).show();
            }
        });
    }
}