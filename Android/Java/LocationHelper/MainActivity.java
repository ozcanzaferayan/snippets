package istanbul.iski.testapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity implements LocationListener{

    public static final int PERMISSIONS_REQUEST_LOCATION = 2;
    private static final int REQUEST_CODE_OPEN_LOCATION = 3;

    public static final long MIN_TIME = 0;
    public static final float MIN_DISTANCE = 0;

    private Button btn;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        attachLocationListener();
                    }
                }
        );
    }

    @SuppressLint("NewApi")
    private void attachLocationListener() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (this.checkSelfPermission(ACCESS_FINE_LOCATION) != PERMISSION_GRANTED &&  this.checkSelfPermission(ACCESS_COARSE_LOCATION) != PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_LOCATION);
            return;
        }
        if (isGpsClosed(this, locationManager)) {
            startActivityForResult(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS), REQUEST_CODE_OPEN_LOCATION);
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME, MIN_DISTANCE, this);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this);
        locationManager.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, MIN_TIME, MIN_DISTANCE, this);
    }

    public static boolean isGpsClosed(Activity activity, LocationManager locationManager) {
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ignored) {
        }

        try {
            network_enabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ignored) {
        }

        return (!gps_enabled && !network_enabled);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PERMISSION_GRANTED) {
                    attachLocationListener();
                }
                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != REQUEST_CODE_OPEN_LOCATION && resultCode != Activity.RESULT_OK) {
            return;
        }
        switch (requestCode) {
            case (REQUEST_CODE_OPEN_LOCATION): {
                attachLocationListener();
                break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location loc) {
        Log.d("MyLocationListener", loc.getProvider() + ", Lat: " + loc.getLatitude() + " Lng: "
                + loc.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

        Log.d("MyLocationListener", "onStatusChanged");
    }

    @Override
    public void onProviderEnabled(String provider) {

        Log.d("MyLocationListener", "onProviderEnabled");
    }

    @Override
    public void onProviderDisabled(String provider) {

        Log.d("MyLocationListener", "onProviderDisabled");
    }
}