package com.example.firebasestorage;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter{

    private Activity context;
    private List<UserDetails> userDetailsList;

    public CustomAdapter( Activity context,List<UserDetails> userDetailsList) {
        super(context,R.layout.sample_layout);
        this.context = context;
        this.userDetailsList = userDetailsList;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample_layout,null,true);
        UserDetails userDetails = userDetailsList.get(position);

        TextView t1= view.findViewById(R.id.t1);
        TextView t2= view.findViewById(R.id.t2);
        TextView t3= view.findViewById(R.id.t3);
        TextView t4= view.findViewById(R.id.t4);

        t1.setText(userDetails.getUserName());
        t2.setText(userDetails.getUserName());
        t3.setText(userDetails.getUserCollage());
        t4.setText(userDetails.getUserNumber());
        return view;
    }
}
