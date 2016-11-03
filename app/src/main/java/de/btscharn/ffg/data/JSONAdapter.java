package de.btscharn.ffg.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import de.btscharn.ffg.MainActivity;
import de.btscharn.ffg.R;
import de.btscharn.ffg.VehicleDetailActivity;

import static java.security.AccessController.getContext;

/**
 * Created by Benedikt on 03.11.2016.
 */

public class JSONAdapter {

    CustomListAdapter adapter;

    public void getListStrings(ListView listView, Activity activity, String data,final Context context) throws JSONException {

        ArrayList<ListItem> listItem;
        listItem = getArrayFromString(data, context);
        adapter = new CustomListAdapter(activity, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListItem listitem = (ListItem) parent.getAdapter().getItem(position);
                openItem(view, listitem, context);
            }
        });
    }

    /**
     * Extract values from JSON file loaded inloadJSONFromAsset()
     * @return values of file as Strings
     * @throws JSONException
     */
    public ArrayList<ListItem> getArrayFromString(String data, Context context) throws JSONException {
        ArrayList<ListItem> listitems = new ArrayList<>();

        JSONArray jsonarray = new JSONArray(loadJSONFromAsset(data, context));
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
     * Load JSON file which is given
     * @return JSON file as String
     */
    public String loadJSONFromAsset(String json_file, Context context) {
        String json;
        try {
            InputStream is = context.getAssets().open(json_file);
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

    /**
     * Calls VehicleDetailActivity and handles related data
     * @param view no idea why
     * @param listitem
     */
    public void openItem(View view, ListItem listitem, Context context){

        String title = listitem.getTitle();
        String description = listitem.getDescription();
        String url = listitem.getURL();
        String fulltext = listitem.getFulltext();

        // Erstelle einen neuen Intent und weise ihm eine Actvity zu
        Intent intent = new Intent(context, VehicleDetailActivity.class);

        //Werte an DetailActivity übergeben
        intent.putExtra("Title", title);
        intent.putExtra("Description", description);
        intent.putExtra("URL", url);
        intent.putExtra("FullText", fulltext);

        // Starte Activity
        context.startActivity(intent);

    }
}
