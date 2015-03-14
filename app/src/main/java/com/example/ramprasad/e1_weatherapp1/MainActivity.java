package com.example.ramprasad.e1_weatherapp1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ramprasad.e1_weatherapp1.common.WConstants;
import com.example.ramprasad.e1_weatherapp1.interfaces.TaskCommunicator;
import com.example.ramprasad.e1_weatherapp1.parse.Info;
import com.example.ramprasad.e1_weatherapp1.task.WeatherTask;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity implements TaskCommunicator {
    private EditText stateET, cityET;
    private Button submitBtn;
    private TextView resultview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Load UI
        setContentView(R.layout.activity_main);
        cityET = (EditText)findViewById(R.id.cityET);
        stateET = (EditText)findViewById(R.id.stateET);

        resultview = (TextView)findViewById(R.id.resultTv);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = cityET.getText().toString();
                String statename = stateET.getText().toString();

                String url = WConstants.URL_HEAD + statename + "/" +cityName + WConstants.URL_TAIL;

                String[] urls = {url};


                WeatherTask task = new WeatherTask(MainActivity.this);
                task.execute(urls);

            }
        });

    }


    @Override
    public void getWeatherData(Info info) {

        String tempC = info.getCurrent_observation().getTemp_c();
        String tempF = info.getCurrent_observation().getTemp_f();

        resultview.setText("Weather Data: Temp in c = "+tempC+" and in F = "+tempF);




    }
}

