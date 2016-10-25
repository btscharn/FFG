package de.btscharn.ffg;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
     //   implements MainFragment.OnClickButtonListener {

    // Erstelle einen Zähler für GoBack mit dem Wert 0
    public int gobackcound = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab =getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "F*** off, I'm not ready", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        openStartFragment();
        gobackcound = 0;
    }

    @Override
    public void onBackPressed() {

        /* Zähler wird geprüft, wenn größer 0, dann wird zurückgegangen und
        * den Zähler um 1 reduziert. Sobald Zähler bei 0 angekommen ist, wird
        * die App beendet
        * */

        if (gobackcound > 0){
            gobackcound = gobackcound - 1;
            super.onBackPressed();
        }else{
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            openSettingsFragment();
        }
        if (id == R.id.action_about) {
            openAboutFragment();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Fragment Callers
     */

    /**
     * Open startup fragment. If Return from VehicleDetailActivity, open VehiclesFragment
     */
    public void openStartFragment() {
        try {
            Intent i = getIntent();
            String check_intent = i.getStringExtra("goback");
            String check_intent_string = "from_vehicles";

            if(check_intent.equals(check_intent_string)){
                openVehiclesFragment();
            }else{
                openMainFragment();
            }
        } catch( Exception e){
            openMainFragment();
        }

    }

    public void openMainFragment() {
        setTitle(R.string.main_fragment_title);
        gobackcound = gobackcound + 1;
        MainFragment mainFragment = new MainFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(
                R.id.content_main,
                mainFragment,
                mainFragment.getTag()
                ).addToBackStack(null)
                .commit();
    }

    public void openVehiclesFragment() {
        setTitle(R.string.vehicles_fragment_title);
        gobackcound = gobackcound + 1;
        VehiclesFragment vehiclesFragment = new VehiclesFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(
                R.id.content_main,
                vehiclesFragment,
                vehiclesFragment.getTag()
                ).addToBackStack(null)
                .commit();
    }

    public void openDevicesFragment() {
        setTitle(R.string.devices_fragment_title);
        gobackcound = gobackcound + 1;
        DevicesFragment devicesFragment = new DevicesFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(
                R.id.content_main,
                devicesFragment,
                devicesFragment.getTag()
        ).addToBackStack(null)
                .commit();
    }

    public void openAboutFragment() {
        setTitle(R.string.about_fragment_title);
        gobackcound = gobackcound + 1;
        AboutFragment aboutFragment = new AboutFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(
                R.id.content_main,
                aboutFragment,
                aboutFragment.getTag()
        ).addToBackStack(null)
                .commit();
    }

    public void openSettingsFragment() {
        setTitle(R.string.settings_fragment_title);
        gobackcound = gobackcound + 1;
        SettingsFragment settingsFragment = new SettingsFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(
                R.id.content_main,
                settingsFragment,
                settingsFragment.getTag()
        ).addToBackStack(null)
                .commit();
    }

    public void openVehicleDetailActivity() {
        Intent intent = new Intent(this, VehicleDetailActivity.class);
        startActivity(intent);
    }

/** uncomment implements...  on class beginning
    public void onClickButton(int button) {
        switch(button) {
            case 1: openVehiclesFragment();
                break;
            case 2: openDevicesFragment();
                break;
            default: break;
        }
    }
*/
    public void onClickVehicles(View v) {
        openVehiclesFragment();
    }

    public void onClickDevices(View v) {
        openDevicesFragment();
    }

    public void onChooseVehicle(View v) {
        openVehicleDetailActivity();
    }


}
