package com.example.waviq.reacycleimplement.fragments;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.waviq.reacycleimplement.R;
import com.example.waviq.reacycleimplement.adapters.StationsAdapter;
import com.example.waviq.reacycleimplement.services.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StationsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_STATION_TYPE = "station_type";


    public static final int STATION_TYPE_FEATURED = 0;
    public static final int STATION_TYPE_RECENT = 0;
    public static final int STATION_TYPE_PARTY = 0;

    private int stationType;


    public StationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param stationType the radio stations Type
     * @return A new instance of fragment StationsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StationsFragment newInstance(int stationType) {

        StationsFragment fragment = new StationsFragment();

        //saved bundle
        Bundle args = new Bundle();
        args.putInt(ARG_STATION_TYPE, stationType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stationType = getArguments().getInt(ARG_STATION_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_stations, container, false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recycler_stations);
        recyclerView.setHasFixedSize(true);

        StationsAdapter adapter;

        if (stationType == STATION_TYPE_FEATURED) {
            adapter = new StationsAdapter(DataService.getInstance().getFeaturedStations());
        } else if (stationType == STATION_TYPE_RECENT) {
            adapter = new StationsAdapter(DataService.getInstance().getRecentsStations());
        } else {
            adapter = new StationsAdapter(DataService.getInstance().getPartyStations());
        }

        //set agar tampilan lebihr rapi
        recyclerView.addItemDecoration(new HorizontalSpaceItemDecorator(30));

        //set di adapter class
        recyclerView.setAdapter(adapter);

        //set agar reyclerview punya linearlayout dg orientation horizontal
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        return v;
    }

}

/*
    class ini digunakan untuk membuat agar RecycleView yang ditampilkan lebih rapi,
    ada space jarak antar recycleViewnya

 */
class HorizontalSpaceItemDecorator extends RecyclerView.ItemDecoration {

    private final int spacer;

    public HorizontalSpaceItemDecorator(int spacer) {
        this.spacer = spacer;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        //biar viewnya reccyleView eclipse
        outRect.right = spacer;

    }
}
