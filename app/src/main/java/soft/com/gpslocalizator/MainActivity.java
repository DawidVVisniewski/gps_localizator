package soft.com.gpslocalizator;

import android.os.Bundle;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;

public class MainActivity  extends Activity implements LatitudeLongitudeUpdate{

    private GPSManager gps;
    private EditText et1, et2;

    private void refresh() {
        gps = new GPSManager(MainActivity.this);
        if(gps.canGetLocation()){
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            et1.setText(String.valueOf(latitude));
            et2.setText(String.valueOf(longitude));
        }else{
            gps.showSettingsAlert();
        }
    }

    public void forceRefresh(View view) {
        refresh();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.latitudeedit);
        et2 = (EditText)findViewById(R.id.longitudeedit);

        refresh();
    }

    @Override
    public void update(double latitude, double longitude) {
        et1.setText(String.valueOf(latitude));
        et2.setText(String.valueOf(longitude));
    }
}

