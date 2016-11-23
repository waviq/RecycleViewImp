package com.example.waviq.reacycleimplement.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.waviq.reacycleimplement.R;
import com.example.waviq.reacycleimplement.fragments.DetailsFragment;
import com.example.waviq.reacycleimplement.fragments.MainFragment;
import com.example.waviq.reacycleimplement.models.Station;

public class MainActivity extends AppCompatActivity {

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    public static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }


    private static MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.setMainActivity(this);

        FragmentManager fm = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment)fm.findFragmentById(R.id.frameUatama);

        if (mainFragment == null){
            mainFragment = MainFragment.newInstance("serah","bebas");
            fm.beginTransaction().add(R.id.frameUatama, mainFragment).commit();
        }
    }

    /*
    * Method untuk load det
    * */
    public void loadDetailScreen(Station selectedStation){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameUatama, new DetailsFragment())
                .addToBackStack(null)
                .commit();
    }
}
