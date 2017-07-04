package com.zonalrooms.corporation.dyfi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by DELL on 6/11/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    private List<Earthquake> eartquakeList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.earth_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    public RecycleAdapter(List<Earthquake> earthquakeList) {
        this.eartquakeList = earthquakeList;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Earthquake earthquake = eartquakeList.get(position);
        holder.title.setText(earthquake.getTitle());
        holder.people.setText(earthquake.getPeople());
        holder.value.setText(earthquake.getValue());
    }

    @Override
    public int getItemCount() {
        return eartquakeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, value, people;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            people = (TextView) view.findViewById(R.id.people);
            value = (TextView) view.findViewById(R.id.value);
        }
    }
}
