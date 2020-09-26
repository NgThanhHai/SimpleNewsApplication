package com.example.NewsApplication.Views.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.NewsApplication.Models.ListViewModel;
import com.example.NewsApplication.Adapters.ListViewAdapter;
import com.example.NewsApplication.Views.ListNewsViews;
import com.example.NewsApplication.Views.R;

import java.util.ArrayList;


public class RecruitmentFragment extends Fragment {


    public RecruitmentFragment() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recruitment, container, false);
        ListView listSite = (ListView) v.findViewById(R.id.listSite);

        ListViewAdapter adapterGame = new ListViewAdapter(getList(), this.getActivity());

        listSite.setAdapter(adapterGame);
        listSite.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), ListNewsViews.class);
                intent.putExtra("link", getList().get(i).getLink());
                startActivity(intent);
            }
        });
        return v;

    }
    public ArrayList<ListViewModel> getList()
    {
        ArrayList<ListViewModel> list = new ArrayList<>();
        return list;
    }
    @Override
    public String toString() {
        return "RECRUITMENT";
    }

}