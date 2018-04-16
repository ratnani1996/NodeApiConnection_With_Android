package com.example.abhij.restapiconnection;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by abhij on 01-04-2018.
 */

public class StudentAsynTask extends AsyncTask<String,Void,Void> {
    @Override
    protected Void doInBackground(String... strings) {

        try{

            String urlString =strings[0];
            URL url =new URL(urlString);

            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();

            String result ="";
            Scanner scanner =new Scanner(inputStream);

            while(scanner.hasNext())
            {
                result=result.concat(scanner.next());
            }

            Log.d("Got String",result);

            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            Log.d("Error",e.getMessage());
        } catch (IOException e) {
            Log.d("Error2",e.getMessage());}




        return null;
    }
}
