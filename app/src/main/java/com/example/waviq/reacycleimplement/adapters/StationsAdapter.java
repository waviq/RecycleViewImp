package com.example.waviq.reacycleimplement.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.waviq.reacycleimplement.R;
import com.example.waviq.reacycleimplement.activities.MainActivity;
import com.example.waviq.reacycleimplement.holders.StationViewHolder;
import com.example.waviq.reacycleimplement.models.Station;

import java.util.ArrayList;

/**
 * Created by waviq on 20/11/2016.
 */

public class StationsAdapter extends RecyclerView.Adapter<StationViewHolder>{

    private ArrayList<Station>stations;

    public StationsAdapter(ArrayList<Station> stations) {
        this.stations = stations;
    }

    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View stationCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_station, parent, false);

        return new StationViewHolder(stationCard);
    }

    @Override
    public void onBindViewHolder(StationViewHolder holder, final int position) {
        final Station station = stations.get(position);
        holder.updateUI(station);

        //detail klik radio image
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //load the detail screen
                MainActivity.getMainActivity().loadDetailScreen(station);
            }
        });


    }

    @Override
    public int getItemCount() {
        return stations.size();
    }
}
