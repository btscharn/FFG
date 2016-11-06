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

import de.btscharn.ffg.VehiclesFragment;
import de.btscharn.ffg.DevicesFragment;
import de.btscharn.ffg.VehicleDetailActivity;

/**
 * Created by Benedikt on 03.11.2016.
 */

/**
 * Collects data from JSON file and sets up ListView
 */
public class JSONAdapter {

    private CustomListAdapter adapter;

    private ArrayList<ListItem> listItem;

    private Context context1;

    public Context getContext1() {
        return context1;
    }

    public void getListStrings(ListView listView, Activity activity, String data, Context context) throws JSONException {

        context1 = context;

         /* TODO: Change to specific ListItem in all classes
                    if(data == VehiclesFragment.getData()) {
                        ArrayList<ListItemVehicles> listItem;
                    }
                    if(data == DevicesFragment.getData()) {
                       ArrayList<ListItemDevices> listItem;
                   }
        */
        listItem = getArrayFromString(data, context);
        adapter = new CustomListAdapter(context, listItem);
        listView.setAdapter(adapter);

        //Make List clickable
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListItem listitem = (ListItem) parent.getAdapter().getItem(position);
                openItem(view, listitem, getContext1());
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
            int imageid = getImageID(context, obj.getString("Image"));
            listitems.add(new ListItem(title, description, url, fulltext, imageid));
            if(data == VehiclesFragment.getData()) {
                String radio = obj.getString("Radio");
     //           listitems.add(new ListItem(title, radio, description, url, fulltext, imageid));
            }
            if(data == DevicesFragment.getData()) {
                int on1_11 = obj.getInt("1-11");
                int on1_44 = obj.getInt("1-44");
                int on1_30 = obj.getInt("1-30");
                int on1_22 = obj.getInt("1-22");
                int on1_45 = obj.getInt("1-45");
                int on1_64 = obj.getInt("1-64");
                int on1_78 = obj.getInt("1-78");
     //           listitems.add(new ListItem(title, description, url, fulltext, on1_11, on1_22, on1_30, on1_44, on1_45, on1_64, on1_78));
            }
        }
        return listitems;
    }

    public static int getImageID(Context context, String imageName) {
        int imageid;
        if(imageName.equals("") || imageName == null) {
            imageName = "leiter_gross_placeholder"; //placeholder
        }
        imageid = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        return imageid;
    }

    /**
     * Load JSON file which is given
     * @return JSON file as String
     */
    public String loadJSONFromAsset(String jsonfile, Context context) {
        String json;
        try {
            InputStream is = context.getAssets().open(jsonfile);
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
        int imageid = listitem.getImageid();

        // Erstelle einen neuen Intent und weise ihm eine Actvity zu
        Intent intent = new Intent(context, VehicleDetailActivity.class);

        //Werte an DetailActivity übergeben
        intent.putExtra("Title", title);
        intent.putExtra("Description", description);
        intent.putExtra("URL", url);
        intent.putExtra("FullText", fulltext);
        intent.putExtra("ImageID", imageid);

        // Starte Activity
        context.startActivity(intent);

    }
}
