package de.btscharn.ffg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class VehiclesFragment extends Fragment {

    public VehiclesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


           View rootview;
           rootview = inflater.inflate(R.layout.fragment_vehicles, container, false);
           return rootview;
    }
}