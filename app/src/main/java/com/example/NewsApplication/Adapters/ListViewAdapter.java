package com.example.NewsApplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.NewsApplication.Models.ListViewModel;
import com.example.NewsApplication.Views.R;

import java.util.ArrayList;


public class ListViewAdapter extends BaseAdapter implements View.OnClickListener {
    ArrayList<ListViewModel> list;
    public Context context;
    private LayoutInflater inflater;



    private static class ViewHolder {
        TextView txtName;
        ImageView info;
    }
    public ListViewAdapter( ArrayList<ListViewModel> list, Context context) {
        this.context = context;
        this.list = list;
    }
    @Override
    public void onClick(View v) {

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public ListViewModel getItem(int position) {
        return (ListViewModel) list.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if(inflater == null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {

            convertView = inflater.inflate(R.layout.model, parent, false);

        }
        viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
        viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);
        viewHolder.info.setImageResource(getItem(position).getImage());
        viewHolder.txtName.setText(getItem(position).getSiteName());

        return convertView;
    }

    }

