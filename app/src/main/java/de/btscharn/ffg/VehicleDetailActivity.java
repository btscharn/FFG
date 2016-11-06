package de.btscharn.ffg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class VehicleDetailActivity extends AppCompatActivity {

    String title;
    String url;
    String description;
    String fulltext;
    int imageid;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }



        Intent i = getIntent();

        title = i.getStringExtra("Title");
        description = i.getStringExtra("Description");
        url = i.getStringExtra("URL");
        fulltext = i.getStringExtra("FullText");
        imageid = i.getIntExtra("ImageID", R.drawable.leiter_gross_placeholder);

        TextView content = (TextView) findViewById(R.id.text_detail_content);
        content.setText(fulltext);

        setTitle(title);

        //System.out.println(url);
        titleImage(imageid);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //

            Intent intent = new Intent(this, MainActivity.class);
            //Cosnign values to an DetailActivity übergeben
            intent.putExtra("goback", "from_vehicle_detail");
            NavUtils.navigateUpTo(this, intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * TODO: Replace placeholder image
     */
    public void titleImage(int imageid) {
        img = (ImageView) findViewById(R.id.image_vehicle_detail_appbar);
        img.setImageResource(imageid);
    }
}
