package com.example.ramprasad.e1_weatherapp1.task;

import com.example.ramprasad.e1_weatherapp1.MainActivity;
import com.example.ramprasad.e1_weatherapp1.interfaces.TaskCommunicator;
import com.example.ramprasad.e1_weatherapp1.parse.Info;
import com.example.ramprasad.e1_weatherapp1.parse.ParseHelper;

import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;

/**
 * Created by Ramprasad on 1/17/2015.
 */
public class WeatherTask extends android.os.AsyncTask<String, Void, Info> {

    private TaskCommunicator taskC;

    public WeatherTask(TaskCommunicator taskcommunicator) {
    }


    //Run in the background thread
    @Override
    protected Info doInBackground(String... urls) {


        try {
            URL url = new URL(urls[0]);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setChunkedStreamingMode(15000);

            conn.setRequestMethod("GET");
            conn.connect();

            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String data = null;
            String rawJson = "";

            while((data = reader.readLine()) != null)
                rawJson += data +"\n";

            Info info = ParseHelper.getParsedData(rawJson);
            return info;





        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }


        return null;

    }


    @Override
    public void onPostExecute(Info info){
        taskC.getWeatherData(info);

}

}

