package de.btscharn.ffg;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import de.btscharn.ffg.data.ListItem;
import de.btscharn.ffg.data.CustomListAdapter;
import de.btscharn.ffg.data.JSONAdapter;

public class VehiclesFragment extends Fragment {

    public View rootview;
    public ListView listView;

    //define file which contains the displayed Strings
    public static String data = "data_vehicles.json";

    public static String getData() {
        return data;
    }

    public VehiclesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        rootview = inflater.inflate(R.layout.fragment_vehicles, container, false);

        getList();

        return rootview;

    }

    /**
     * Creates ItemList with data from JSON file
     */
    public void getList() {
        listView = (ListView) rootview.findViewById(R.id.vehicles_list);
        JSONAdapter jAdapter = new JSONAdapter();
        try {
            jAdapter.getListStrings(listView, getActivity(), data, getContext());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

/*
    public void getVehicleStrings() throws JSONException {

        JSONAdapter jAdapter = new JSONAdapter();

        ArrayList<ListItem> arrayOfVehicles;
        arrayOfVehicles = jAdapter.getArrayFromString(data, getContext());
        CustomListAdapter adapter = new CustomListAdapter(getActivity(), arrayOfVehicles);
        ListView listView = (ListView) rootview.findViewById(R.id.vehicle_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListItem listitem = (ListItem) parent.getAdapter().getItem(position);
                openItem(view, listitem);
            }
        });
    }
*/

    /**
     * Calls VehicleDetailActivity and handles related data
     * @param view no idea why
     * @param listitem
     *
    public void openItem(View view, ListItem listitem){

        String title = listitem.getTitle();
        String description = listitem.getDescription();
        String url = listitem.getURL();
        String fulltext = listitem.getFulltext();

        // Erstelle einen neuen Intent und weise ihm eine Actvity zu
        Intent intent = new Intent(getContext(), VehicleDetailActivity.class);

        //Werte an DetailActivity übergeben
        intent.putExtra("Title", title);
        intent.putExtra("Description", description);
        intent.putExtra("URL", url);
        intent.putExtra("FullText", fulltext);

        // Starte Activity
        getContext().startActivity(intent);

    }
    */
}