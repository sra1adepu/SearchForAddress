package com.example.srinath_pc.searchadderss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class CustomListAdapter extends BaseAdapter{
    Context context;
    ArrayList<ListPojo> listPojos;

    public CustomListAdapter(MainActivity mainActivity, ArrayList<ListPojo> listarray) {
        context=mainActivity;
        listPojos=listarray;
    }

    @Override
    public int getCount() {
        return listPojos.size();
    }

    @Override
    public Object getItem(int i) {
        return listPojos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }



    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listadadapter, viewGroup, false);
        }

        // get current item to be displayed
        ListPojo currentItem = (ListPojo) getItem(i);

        // get the TextView for item name and item description
        TextView textViewItemName = (TextView) convertView.findViewById(R.id.location);
        TextView textViewItemDescription = (TextView) convertView.findViewById(R.id.latlang);

        //sets the text for item name and item description from the current item object
        textViewItemName.setText(currentItem.getAddress());
        textViewItemDescription.setText(currentItem.getLatitude()+","+currentItem.getLognitude());

        // returns the view for the current row
        return convertView;
    }
    }

