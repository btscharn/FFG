package de.btscharn.ffg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.R.attr.button;

public class MainFragment extends Fragment {
    OnClickButtonListener mCallback;

    public MainFragment() {
        // Required empty public constructor
    }

    //handle number of button
    public interface OnClickButtonListener {
        public void onClickButton(int button);
    }

    public void onAttach(MainActivity mainActivity) {
        super.onAttach(mainActivity);

        //make sure that the container activity has implemented the callback interface
        try {
            mCallback = (OnClickButtonListener) mainActivity;
        } catch (ClassCastException e) {
            throw new ClassCastException(mainActivity.toString()
                    + "must implement OnClickButtonListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview;
        rootview = inflater.inflate(R.layout.fragment_main, container, false);
        return rootview;
    }

    //Listen button actions, handle button number
    public void onClickVehicles(View v) {
        mCallback.onClickButton(1);
    }

    public void onClickDevices(View v) {
        mCallback.onClickButton(2);
    }


}