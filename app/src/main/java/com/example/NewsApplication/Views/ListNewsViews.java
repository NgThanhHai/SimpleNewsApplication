package com.example.NewsApplication.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.NewsApplication.ViewModels.ReceivingXML.readRSS;

import java.util.ArrayList;

public class ListNewsViews extends AppCompatActivity {
    ListView listView;
    public static ArrayList<String> listTitle;
    public static ArrayList<String> listLink;
    public static ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_news_list_view);
        listTitle = new ArrayList<>();
        listLink = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listTitle);
        listView.setAdapter(adapter);
        Intent receiveIntent = getIntent();
        String link = receiveIntent.getStringExtra("link");
        new readRSS().execute(link);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent sendIntent = new Intent(ListNewsViews.this, NewsViews.class);
                sendIntent.putExtra("newsLink", listLink.get(i));
                startActivity(sendIntent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}