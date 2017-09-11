package com.jakubbadysiak.weatherapplication;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jakubbadysiak.weatherapplication.Client.ForecastWeatherClient;
import com.jakubbadysiak.weatherapplication.Client.WeatherClient;
import com.jakubbadysiak.weatherapplication.Common.Common;
import com.jakubbadysiak.weatherapplication.Helper.Helper;
import com.jakubbadysiak.weatherapplication.Model.OpenWeatherMap;
import com.jakubbadysiak.weatherapplication.Model.WeatherForFiveDays;
import com.jakubbadysiak.weatherapplication.Service.WeatherApiService;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;

import static java.lang.System.exit;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private static int SPLASH_TIME_OUT = 4000;
    private boolean isChecked;
    private ViewFlipper viewFlipper;
    private TextView txtCity, txtLastUpdate, txtDescription, txtHumidity, txtCelsius;
    private ImageView imageView;

    private TextView txtCelsius1, txtDate1, txtCity1, txtCelsius2, txtDate2, txtCelsius3, txtDate3, txtCelsius4, txtDate4;
    private TextView txtCelsius5, txtDate5, txtCelsius6, txtDate6, txtCelsius7, txtDate7, txtCelsius8, txtDate8;
    private TextView txtCelsius9, txtDate9, txtCelsius10, txtDate10, txtCelsius11, txtDate11, txtCelsius12, txtDate12;
    private TextView txtCelsius13, txtDate13, txtCelsius14, txtDate14, txtCelsius15, txtDate15, txtCelsius16, txtDate16;
    private TextView txtCelsius17, txtDate17, txtCelsius18, txtDate18, txtCelsius19, txtDate19, txtCelsius20, txtDate20;
    private TextView txtCelsius21, txtDate21, txtCelsius22, txtDate22, txtCelsius23, txtDate23, txtCelsius24, txtDate24;
    private TextView txtCelsius25, txtDate25, txtCelsius26, txtDate26, txtCelsius27, txtDate27, txtCelsius28, txtDate28;
    private TextView txtCelsius29, txtDate29, txtCelsius30, txtDate30, txtCelsius31, txtDate31, txtCelsius32, txtDate32;
    private TextView txtCelsius33, txtDate33, txtCelsius34, txtDate34;

    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8;
    private ImageView imageView9, imageView10, imageView11, imageView12, imageView13, imageView14, imageView15, imageView16;
    private ImageView imageView17, imageView18, imageView19, imageView20, imageView21, imageView22, imageView23, imageView24;
    private ImageView imageView25, imageView26, imageView27, imageView28, imageView29, imageView30, imageView31, imageView32;
    private ImageView imageView33, imageView34;

    private LocationManager locationManager;
    private String provider;
    private static double lat, lng;
    private OpenWeatherMap openWeatherMap = new OpenWeatherMap();
    private WeatherForFiveDays weatherForFiveDays = new WeatherForFiveDays();
    private WeatherApiService weatherApiService;
    private ForecastWeatherClient forecastWeatherApiService;
    private String baseApi = "http://10.0.2.2:8080";

    private float lastX;
    private int MY_PERMISSION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        txtCity = (TextView) findViewById(R.id.txtCity);
        txtLastUpdate = (TextView) findViewById(R.id.txtLastUpdate);
        txtDescription = (TextView) findViewById(R.id.txtDescription);
        txtHumidity = (TextView) findViewById(R.id.txtHumidity);
        txtCelsius = (TextView) findViewById(R.id.txtCelsius);
        imageView = (ImageView) findViewById(R.id.imageView);
        txtCity1 = (TextView) findViewById(R.id.txtCity1);

        txtCelsius1 = (TextView) findViewById(R.id.txtCelsius1);
        txtDate1 = (TextView) findViewById(R.id.txtDate1);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        txtCelsius2 = (TextView) findViewById(R.id.txtCelsius2);
        txtDate2 = (TextView) findViewById(R.id.txtDate2);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        txtCelsius3 = (TextView) findViewById(R.id.txtCelsius3);
        txtDate3 = (TextView) findViewById(R.id.txtDate3);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        txtCelsius4 = (TextView) findViewById(R.id.txtCelsius4);
        txtDate4 = (TextView) findViewById(R.id.txtDate4);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        txtCelsius5 = (TextView) findViewById(R.id.txtCelsius5);
        txtDate5 = (TextView) findViewById(R.id.txtDate5);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        txtCelsius6 = (TextView) findViewById(R.id.txtCelsius6);
        txtDate6 = (TextView) findViewById(R.id.txtDate6);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        txtCelsius7 = (TextView) findViewById(R.id.txtCelsius7);
        txtDate7 = (TextView) findViewById(R.id.txtDate7);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        txtCelsius8 = (TextView) findViewById(R.id.txtCelsius8);
        txtDate8 = (TextView) findViewById(R.id.txtDate8);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
        txtCelsius9 = (TextView) findViewById(R.id.txtCelsius9);
        txtDate9 = (TextView) findViewById(R.id.txtDate9);
        imageView9 = (ImageView) findViewById(R.id.imageView9);
        txtCelsius10 = (TextView) findViewById(R.id.txtCelsius10);
        txtDate10 = (TextView) findViewById(R.id.txtDate10);
        imageView10 = (ImageView) findViewById(R.id.imageView10);
        txtCelsius11 = (TextView) findViewById(R.id.txtCelsius11);
        txtDate11 = (TextView) findViewById(R.id.txtDate11);
        imageView11 = (ImageView) findViewById(R.id.imageView11);
        txtCelsius12 = (TextView) findViewById(R.id.txtCelsius12);
        txtDate12 = (TextView) findViewById(R.id.txtDate12);
        imageView12 = (ImageView) findViewById(R.id.imageView12);
        txtCelsius13 = (TextView) findViewById(R.id.txtCelsius13);
        txtDate13 = (TextView) findViewById(R.id.txtDate13);
        imageView13 = (ImageView) findViewById(R.id.imageView13);
        txtCelsius14 = (TextView) findViewById(R.id.txtCelsius14);
        txtDate14 = (TextView) findViewById(R.id.txtDate14);
        imageView14 = (ImageView) findViewById(R.id.imageView14);
        txtCelsius15 = (TextView) findViewById(R.id.txtCelsius15);
        txtDate15 = (TextView) findViewById(R.id.txtDate15);
        imageView15 = (ImageView) findViewById(R.id.imageView15);
        txtCelsius16 = (TextView) findViewById(R.id.txtCelsius16);
        txtDate16 = (TextView) findViewById(R.id.txtDate16);
        imageView16 = (ImageView) findViewById(R.id.imageView16);
        txtCelsius17 = (TextView) findViewById(R.id.txtCelsius17);
        txtDate17 = (TextView) findViewById(R.id.txtDate17);
        imageView17 = (ImageView) findViewById(R.id.imageView17);
        txtCelsius18 = (TextView) findViewById(R.id.txtCelsius18);
        txtDate18 = (TextView) findViewById(R.id.txtDate18);
        imageView18 = (ImageView) findViewById(R.id.imageView18);
        txtCelsius19 = (TextView) findViewById(R.id.txtCelsius19);
        txtDate19 = (TextView) findViewById(R.id.txtDate19);
        imageView19 = (ImageView) findViewById(R.id.imageView19);
        txtCelsius20 = (TextView) findViewById(R.id.txtCelsius20);
        txtDate20 = (TextView) findViewById(R.id.txtDate20);
        imageView20 = (ImageView) findViewById(R.id.imageView20);

        txtCelsius21 = (TextView) findViewById(R.id.txtCelsius21);
        txtDate21 = (TextView) findViewById(R.id.txtDate21);
        imageView21 = (ImageView) findViewById(R.id.imageView21);
        txtCelsius22 = (TextView) findViewById(R.id.txtCelsius22);
        txtDate22 = (TextView) findViewById(R.id.txtDate22);
        imageView22 = (ImageView) findViewById(R.id.imageView22);
        txtCelsius23 = (TextView) findViewById(R.id.txtCelsius23);
        txtDate23 = (TextView) findViewById(R.id.txtDate23);
        imageView23 = (ImageView) findViewById(R.id.imageView23);
        txtCelsius24 = (TextView) findViewById(R.id.txtCelsius24);
        txtDate24 = (TextView) findViewById(R.id.txtDate24);
        imageView24 = (ImageView) findViewById(R.id.imageView24);
        txtCelsius25 = (TextView) findViewById(R.id.txtCelsius25);
        txtDate25 = (TextView) findViewById(R.id.txtDate25);
        imageView25 = (ImageView) findViewById(R.id.imageView25);
        txtCelsius26 = (TextView) findViewById(R.id.txtCelsius26);
        txtDate26 = (TextView) findViewById(R.id.txtDate26);
        imageView26 = (ImageView) findViewById(R.id.imageView26);
        txtCelsius27 = (TextView) findViewById(R.id.txtCelsius27);
        txtDate27 = (TextView) findViewById(R.id.txtDate27);
        imageView27 = (ImageView) findViewById(R.id.imageView27);
        txtCelsius28 = (TextView) findViewById(R.id.txtCelsius28);
        txtDate28 = (TextView) findViewById(R.id.txtDate28);
        imageView28 = (ImageView) findViewById(R.id.imageView28);
        txtCelsius29 = (TextView) findViewById(R.id.txtCelsius29);
        txtDate29 = (TextView) findViewById(R.id.txtDate29);
        imageView29 = (ImageView) findViewById(R.id.imageView29);

        txtCelsius30 = (TextView) findViewById(R.id.txtCelsius30);
        txtDate30 = (TextView) findViewById(R.id.txtDate30);
        imageView30 = (ImageView) findViewById(R.id.imageView30);
        txtCelsius31 = (TextView) findViewById(R.id.txtCelsius31);
        txtDate31 = (TextView) findViewById(R.id.txtDate31);
        imageView31 = (ImageView) findViewById(R.id.imageView31);
        txtCelsius32 = (TextView) findViewById(R.id.txtCelsius32);
        txtDate32 = (TextView) findViewById(R.id.txtDate32);
        imageView32 = (ImageView) findViewById(R.id.imageView32);
        txtCelsius33 = (TextView) findViewById(R.id.txtCelsius33);
        txtDate33 = (TextView) findViewById(R.id.txtDate33);
        imageView33 = (ImageView) findViewById(R.id.imageView33);
        txtCelsius34 = (TextView) findViewById(R.id.txtCelsius34);
        txtDate34 = (TextView) findViewById(R.id.txtDate34);
        imageView34 = (ImageView) findViewById(R.id.imageView34);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        provider = locationManager.getBestProvider(new Criteria(), false);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    Manifest.permission.INTERNET,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, MY_PERMISSION);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent touchevent) {

        switch (touchevent.getAction()) {

            case MotionEvent.ACTION_DOWN:
                lastX = touchevent.getX();
                break;
            case MotionEvent.ACTION_UP:
                float currentX = touchevent.getX();

                if (lastX < currentX) {
                    if (viewFlipper.getDisplayedChild() == 0)
                        break;

                    viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
                    viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);
                    viewFlipper.showPrevious();
                }

                if (lastX > currentX) {

                    if (viewFlipper.getDisplayedChild() == 2)
                        break;

                    viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);
                    viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);
                    viewFlipper.showNext();
                }
                break;
        }

        return false;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem checkable = menu.findItem(R.id.geolocation);
        checkable.setChecked(isChecked);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.geolocation:
                isChecked = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                item.setChecked(isChecked);
                break;

            case R.id.updateLocation:
                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(getApplicationContext(),"Update your location", Toast.LENGTH_SHORT).show();
                        WeatherClient weatherClient = new WeatherClient(baseApi);
                        ForecastWeatherClient forecastWeatherClient = new ForecastWeatherClient(baseApi);
                        weatherApiService = weatherClient.getApiService();
                        //forecastWeatherApiService = forecastWeatherClient.getApiService();
                        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                        provider = locationManager.getBestProvider(new Criteria(), false);

                        //noinspection MissingPermission
                        Location location = locationManager.getLastKnownLocation(provider);

                        if (location == null) {
                            Log.e("TAG", "No found location");
                            return false;
                        }
                        onLocationChanged(location);
                        return true;
                    }
                });
                break;

            case R.id.exit:
                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        exit(1);
                        return true;
                    }
                });
                break;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    Manifest.permission.INTERNET,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, MY_PERMISSION);
        }
        locationManager.requestLocationUpdates(provider, 400, 1, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        lat = location.getLatitude();
        lng = location.getLongitude();

        new GetWeather().execute(Common.apiRequest(String.valueOf(lat), String.valueOf(lng)));
        new GetForecast().execute(Common.apiRequestForecast(String.valueOf(lat), String.valueOf(lng)));
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    private class GetWeather extends AsyncTask<String, Void, String> {

        ProgressDialog pd = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd.setTitle("Please wait...");
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String stream = null;
            String urlString = strings[0];

            Helper http = new Helper();
            stream = http.getHttpData(urlString);
            return stream;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s.contains("Error: Not found city")) {
                pd.dismiss();
                return;
            }
            Gson gson = new Gson();
            Type mType = new TypeToken<OpenWeatherMap>() {
            }.getType();
            openWeatherMap = gson.fromJson(s, mType);
            pd.dismiss();

            txtCity.setText(String.format("%s,%s", openWeatherMap.getName(), openWeatherMap.getSys().getCountry()));
            txtLastUpdate.setText(String.format("Last Updated: %s", Common.getDateNow()));
            txtDescription.setText(String.format("%s", openWeatherMap.getWeather().get(0).getDescription()));
            txtHumidity.setText(String.format("Humidity: %d%%", openWeatherMap.getMain().getHumidity()));
            txtCelsius.setText(String.format("%.2f °C", openWeatherMap.getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(openWeatherMap.getWeather().get(0).getIcon())).into(imageView);
        }
    }

    private class GetForecast extends AsyncTask<String, Void, String> {

        ProgressDialog pd = new ProgressDialog(MainActivity.this);

        @Override
        protected String doInBackground(String... strings) {
            String stream = null;
            String urlString = strings[0];

            Helper http = new Helper();
            stream = http.getHttpData(urlString);
            return stream;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s.contains("Error: Not found city")) {
                return;
            }
            Gson gson = new Gson();
            Type mType = new TypeToken<WeatherForFiveDays>() {}.getType();
            weatherForFiveDays = gson.fromJson(s, mType);
            pd.dismiss();

            txtCity1.setText(String.format("Forecast weather for %s in the coming days", weatherForFiveDays.getCity().getName()));
            txtDate1.setText(String.format("%s", weatherForFiveDays.getList().get(0).getDt_txt()));
            txtCelsius1.setText(String.format("%.2f °C", weatherForFiveDays.getList().get(0).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(0).getWeather().get(0).getIcon())).into(imageView1);

            txtDate2.setText(String.format("%s",weatherForFiveDays.getList().get(1).getDt_txt()));
            txtCelsius2.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(1).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(1).getWeather().get(0).getIcon())).into(imageView2);

            txtDate3.setText(String.format("%s",weatherForFiveDays.getList().get(2).getDt_txt()));
            txtCelsius3.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(2).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(2).getWeather().get(0).getIcon())).into(imageView3);

            txtDate4.setText(String.format("%s",weatherForFiveDays.getList().get(3).getDt_txt()));
            txtCelsius4.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(3).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(3).getWeather().get(0).getIcon())).into(imageView4);

            txtDate5.setText(String.format("%s", weatherForFiveDays.getList().get(4).getDt_txt()));
            txtCelsius5.setText(String.format("%.2f °C", weatherForFiveDays.getList().get(4).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(4).getWeather().get(0).getIcon())).into(imageView5);

            txtDate6.setText(String.format("%s",weatherForFiveDays.getList().get(5).getDt_txt()));
            txtCelsius6.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(5).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(5).getWeather().get(0).getIcon())).into(imageView6);

            txtDate7.setText(String.format("%s",weatherForFiveDays.getList().get(6).getDt_txt()));
            txtCelsius7.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(6).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(6).getWeather().get(0).getIcon())).into(imageView7);

            txtDate8.setText(String.format("%s",weatherForFiveDays.getList().get(7).getDt_txt()));
            txtCelsius8.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(7).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(7).getWeather().get(0).getIcon())).into(imageView8);

            txtDate9.setText(String.format("%s", weatherForFiveDays.getList().get(8).getDt_txt()));
            txtCelsius9.setText(String.format("%.2f °C", weatherForFiveDays.getList().get(8).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(8).getWeather().get(0).getIcon())).into(imageView9);

            txtDate10.setText(String.format("%s", weatherForFiveDays.getList().get(9).getDt_txt()));
            txtCelsius10.setText(String.format("%.2f °C", weatherForFiveDays.getList().get(9).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(9).getWeather().get(0).getIcon())).into(imageView10);

            txtDate11.setText(String.format("%s", weatherForFiveDays.getList().get(10).getDt_txt()));
            txtCelsius11.setText(String.format("%.2f °C", weatherForFiveDays.getList().get(10).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(10).getWeather().get(0).getIcon())).into(imageView11);

            txtDate12.setText(String.format("%s",weatherForFiveDays.getList().get(11).getDt_txt()));
            txtCelsius12.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(11).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(11).getWeather().get(0).getIcon())).into(imageView12);

            txtDate13.setText(String.format("%s",weatherForFiveDays.getList().get(12).getDt_txt()));
            txtCelsius13.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(12).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(12).getWeather().get(0).getIcon())).into(imageView13);

            txtDate14.setText(String.format("%s",weatherForFiveDays.getList().get(13).getDt_txt()));
            txtCelsius14.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(13).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(13).getWeather().get(0).getIcon())).into(imageView14);

            txtDate15.setText(String.format("%s", weatherForFiveDays.getList().get(14).getDt_txt()));
            txtCelsius15.setText(String.format("%.2f °C", weatherForFiveDays.getList().get(14).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(14).getWeather().get(0).getIcon())).into(imageView15);

            txtDate16.setText(String.format("%s",weatherForFiveDays.getList().get(15).getDt_txt()));
            txtCelsius16.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(15).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(15).getWeather().get(0).getIcon())).into(imageView16);

            txtDate17.setText(String.format("%s",weatherForFiveDays.getList().get(16).getDt_txt()));
            txtCelsius17.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(16).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(16).getWeather().get(0).getIcon())).into(imageView17);

            txtDate18.setText(String.format("%s",weatherForFiveDays.getList().get(17).getDt_txt()));
            txtCelsius18.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(17).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(17).getWeather().get(0).getIcon())).into(imageView18);

            txtDate19.setText(String.format("%s", weatherForFiveDays.getList().get(18).getDt_txt()));
            txtCelsius19.setText(String.format("%.2f °C", weatherForFiveDays.getList().get(18).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(18).getWeather().get(0).getIcon())).into(imageView19);

            txtDate20.setText(String.format("%s", weatherForFiveDays.getList().get(19).getDt_txt()));
            txtCelsius20.setText(String.format("%.2f °C", weatherForFiveDays.getList().get(19).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(19).getWeather().get(0).getIcon())).into(imageView20);

            txtDate21.setText(String.format("%s", weatherForFiveDays.getList().get(20).getDt_txt()));
            txtCelsius21.setText(String.format("%.2f °C", weatherForFiveDays.getList().get(20).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(20).getWeather().get(0).getIcon())).into(imageView21);

            txtDate22.setText(String.format("%s",weatherForFiveDays.getList().get(21).getDt_txt()));
            txtCelsius22.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(21).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(21).getWeather().get(0).getIcon())).into(imageView22);

            txtDate23.setText(String.format("%s",weatherForFiveDays.getList().get(22).getDt_txt()));
            txtCelsius23.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(22).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(22).getWeather().get(0).getIcon())).into(imageView23);

            txtDate24.setText(String.format("%s",weatherForFiveDays.getList().get(23).getDt_txt()));
            txtCelsius24.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(23).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(23).getWeather().get(0).getIcon())).into(imageView24);

            txtDate25.setText(String.format("%s", weatherForFiveDays.getList().get(24).getDt_txt()));
            txtCelsius25.setText(String.format("%.2f °C", weatherForFiveDays.getList().get(24).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(24).getWeather().get(0).getIcon())).into(imageView25);

            txtDate26.setText(String.format("%s",weatherForFiveDays.getList().get(25).getDt_txt()));
            txtCelsius26.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(25).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(25).getWeather().get(0).getIcon())).into(imageView26);

            txtDate27.setText(String.format("%s",weatherForFiveDays.getList().get(26).getDt_txt()));
            txtCelsius27.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(26).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(26).getWeather().get(0).getIcon())).into(imageView27);

            txtDate28.setText(String.format("%s",weatherForFiveDays.getList().get(27).getDt_txt()));
            txtCelsius28.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(27).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(27).getWeather().get(0).getIcon())).into(imageView28);

            txtDate29.setText(String.format("%s", weatherForFiveDays.getList().get(28).getDt_txt()));
            txtCelsius29.setText(String.format("%.2f °C", weatherForFiveDays.getList().get(28).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(28).getWeather().get(0).getIcon())).into(imageView29);

            txtDate30.setText(String.format("%s", weatherForFiveDays.getList().get(29).getDt_txt()));
            txtCelsius30.setText(String.format("%.2f °C", weatherForFiveDays.getList().get(29).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(29).getWeather().get(0).getIcon())).into(imageView30);

            txtDate31.setText(String.format("%s", weatherForFiveDays.getList().get(30).getDt_txt()));
            txtCelsius31.setText(String.format("%.2f °C", weatherForFiveDays.getList().get(30).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(30).getWeather().get(0).getIcon())).into(imageView31);

            txtDate32.setText(String.format("%s",weatherForFiveDays.getList().get(31).getDt_txt()));
            txtCelsius32.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(31).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(31).getWeather().get(0).getIcon())).into(imageView32);

            txtDate33.setText(String.format("%s",weatherForFiveDays.getList().get(32).getDt_txt()));
            txtCelsius33.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(32).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(32).getWeather().get(0).getIcon())).into(imageView33);

            txtDate34.setText(String.format("%s",weatherForFiveDays.getList().get(33).getDt_txt()));
            txtCelsius34.setText(String.format("%.2f °C",weatherForFiveDays.getList().get(33).getMain().getTemp()));
            Picasso.with(MainActivity.this).load(Common.getImage(weatherForFiveDays.getList().get(33).getWeather().get(0).getIcon())).into(imageView34);

        }
    }
}
