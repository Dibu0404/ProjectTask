package com.whizzdreamer.divisha0404.projecttask.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.whizzdreamer.divisha0404.projecttask.Adapter.DetailListAdapter;
import com.whizzdreamer.divisha0404.projecttask.Data.DataClass;
import com.whizzdreamer.divisha0404.projecttask.Decorative.LinePagerIndicatorDecoration;
import com.whizzdreamer.divisha0404.projecttask.R;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView dateTV;
    DataClass storesListProjo;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewInitialized();

        //Current date Display
        //dateTV = findViewById(R.id.current_date_TV);
        String date_n = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(new Date());
        dateTV.setText(date_n);

        //RecyclerView Attach with horizontal
        recyclerView.setHasFixedSize(true);

        //layout manager set
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new LinePagerIndicatorDecoration());

        storesListProjo = new Gson().fromJson(parseJSONData(), DataClass.class);
        adapter = new DetailListAdapter(storesListProjo.getContentList(), this);
        recyclerView.setAdapter(adapter);

    }

    //View Initialized
    private void viewInitialized() {
        dateTV = findViewById(R.id.current_date_TV);
        recyclerView = (RecyclerView) findViewById(R.id.name_list);
    }

    //JSON data Collection Function
    public String parseJSONData() {
        String JSONString = null;
        JSONObject JSONObject = null;
        try {
            InputStream inputStream = getAssets().open("sample.json");
            int sizeOfJSONFile = inputStream.available();
            byte[] bytes = new byte[sizeOfJSONFile];
            inputStream.read(bytes);
            inputStream.close();
            JSONString = new String(bytes, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return JSONString;
    }
}