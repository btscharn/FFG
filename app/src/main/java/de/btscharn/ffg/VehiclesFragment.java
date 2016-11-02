package de.btscharn.ffg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import de.btscharn.ffg.data.ListItem;
import de.btscharn.ffg.data.CustomListAdapter;

public class VehiclesFragment extends Fragment {

    private String in;
    public View rootview;

    public VehiclesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


           rootview = inflater.inflate(R.layout.fragment_vehicles, container, false);

        try {
            getVehicleStrings();
        } catch (JSONException e) {
            e.printStackTrace();
        }

           return rootview;

    }

    public void getVehicleStrings() throws JSONException {

        MainActivity activity = new MainActivity();

        ArrayList<ListItem> arrayOfVehicles;
        arrayOfVehicles = getArrayFromString();
        CustomListAdapter adapter = new CustomListAdapter(getActivity(), arrayOfVehicles);
        ListView listView = (ListView) rootview.findViewById(R.id.vehicle_list);
        listView.setAdapter(adapter);


    }

    /**
     * Extract values from JSON file loaded inloadJSONFromAsset()
     * @return values of file as Strings
     * @throws JSONException
     */

    public ArrayList<ListItem> getArrayFromString() throws JSONException {
        ArrayList<ListItem> listitems = new ArrayList<>();

        JSONArray jsonarray = new JSONArray(loadJSONFromAsset());
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject obj = jsonarray.getJSONObject(i);

            String title = obj.getString("Title");
            String description = obj.getString("Description");
            String url = obj.getString("URL");
            String fulltext = obj.getString("FullText");
            listitems.add(new ListItem(title, description, url, fulltext));
        }
        return listitems;
    }

    /**
     * Load JSON file data_vehicles.json
     * @return JSON file as String
     */
    public String loadJSONFromAsset() {
        String json;
        String json_file = "data_vehicles.json";
        try {

            InputStream is = getContext().getAssets().open(json_file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}