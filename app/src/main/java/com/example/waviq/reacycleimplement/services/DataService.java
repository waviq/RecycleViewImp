package com.example.waviq.reacycleimplement.services;

import com.example.waviq.reacycleimplement.models.Station;

import java.util.ArrayList;

/**
 * Created by waviq on 21/11/2016.
 */
public class DataService {
    private static DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {
    }

    /*Add data dan image yang nantinya akan ditampilkan di recycleview*/
    public ArrayList<Station>getFeaturedStations(){
        //download featured stations from the Internet
        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight plant(Tunes for Travel)","flightplanmusic"));
        list.add(new Station("Two-Whee' (Biking playlist)","bicyclemusic"));
        list.add(new Station("Kids jams(Music for childred)","kidsmusic"));

        return list;
    }

    public ArrayList<Station>getRecentsStations(){
        ArrayList<Station> list = new ArrayList<>();
        return list;
    }

    public ArrayList<Station>getPartyStations(){
        ArrayList<Station> list = new ArrayList<>();
        return list;
    }
}
