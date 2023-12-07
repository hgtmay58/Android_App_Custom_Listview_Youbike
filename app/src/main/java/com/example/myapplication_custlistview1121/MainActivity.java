package com.example.myapplication_custlistview1121;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView list;
    LazyAdapter adapter;
    ArrayList<HashMap<String, String>> bList;
    static final String URL = "https://data.ntpc.gov.tw/api/datasets/71CD1490-A2DF-4198-BEF1-318479775E8A/json/preview";
    // parent node
    static final String KEY_ID = "geocode";
    static final String KEY_TITLE = "locationName";
    static final String KEY_lat = "lat";
    static final String KEY_lon = "lon";
    static final String KEY_ARTIST = "value";
    static final String KEY_DURATION = "description";
    static final String KEY_THUMB_URL = "thumb_url";
    static final String KEY_date = "dataTime";
    static final String KEY_addr = "address";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        list=(ListView)findViewById(R.id.list);
        bList = new ArrayList<HashMap<String, String>>();
        JsonParser_yb parser = new JsonParser_yb(this);
        parser.getjsonFromUrl(URL); // getting XML from URL
        // Click event for single list row
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


            }
        });
    }
    //
    //

}
