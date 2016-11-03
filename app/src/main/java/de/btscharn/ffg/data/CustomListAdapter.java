package de.btscharn.ffg.data;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import de.btscharn.ffg.VehicleDetailActivity;
import de.btscharn.ffg.R;

/**
 * TODO: Finish class for use in this app
 *
 * Sets Strings for List of Vehicles and Devices and starts to related DetailActivity
 */
public class CustomListAdapter extends ArrayAdapter<ListItem> {

    public CustomListAdapter(Context context, ArrayList<ListItem> lists) {
        super(context, 0, lists);
    }

    /**
     * TODO: Set OnClickListener not on TextView but on item_list or so
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ListItem list = getItem(position);
        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent, false);

        }

        final TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tvDescription = (TextView) convertView.findViewById(R.id.tv_description);

        tvName.setText(list.title);
        tvDescription.setText(list.description);

        tvName.setTag(list);
 //       tvName.setOnClickListener(new View.OnClickListener(){
 //           public void onClick(View view){
 //               openitem(view);
//
 //           }
  //      });

        tvDescription.setTag(list);
 //       tvDescription.setOnClickListener(new View.OnClickListener(){
 //           public void onClick(View view){
 //               openitem(view);
 //           }
 //       });

        //should accept clicks at whole item_list, however does not
        //convertView.setTag(list);
        //convertView.setOnClickListener(new View.OnClickListener(){
 //       itemList.setOnClickListener(new View.OnClickListener(){
 //           public void onClick(View view){
 //               openitem(view);
 //           }
 //       });

        return convertView;

    }

    public void openitem(View view){


        ListItem list = (ListItem) view.getTag();

        // Erstelle einen neuen Intent und weise ihm eine Actvity zu
        Intent intent = new Intent(getContext(), VehicleDetailActivity.class);

        //Werte an DetailActivity übergeben
        intent.putExtra("Title", list.title);
        intent.putExtra("Description", list.description);
        intent.putExtra("URL", list.url);
        intent.putExtra("FullText", list.fulltext);

        // Starte Activity
        getContext().startActivity(intent);

    }



}
