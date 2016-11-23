package com.example.waviq.reacycleimplement.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.waviq.reacycleimplement.R;
import com.example.waviq.reacycleimplement.models.Station;

/**
 * Created by waviq on 20/11/2016.
 */

public class StationViewHolder extends RecyclerView.ViewHolder {

    private ImageView mainImage;
    private TextView titleTextView;

    public StationViewHolder(View itemView) {
        super(itemView);

        this.mainImage = (ImageView)itemView.findViewById(R.id.main_image);
        this.titleTextView = (TextView)itemView.findViewById(R.id.main_text);

    }

    public void updateUI(Station station){
        String url = station.getImgUrl();
        int resource = mainImage.getResources().getIdentifier(url, null,mainImage.getContext().getPackageName());
        mainImage.setImageResource(resource);

        titleTextView.setText(station.getStationTitle());

    }
}
