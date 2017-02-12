package com.vipinkr.recyclerviewdividerexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Vipin K R on 25-01-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    Context context;
    ArrayList<Movie> list;

    public RecyclerViewAdapter(Context context, ArrayList<Movie> list) {
        this.context = context;
        this.list = list;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view= LayoutInflater.from(context).
                inflate(R.layout.recycler_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        Movie m=list.get(position);
        holder.textView.setText(m.getName());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+list.size());
        return list.size();
    }


}
