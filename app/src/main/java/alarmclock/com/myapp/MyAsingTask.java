package alarmclock.com.myapp;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyAsingTask extends AsyncTask<String,Void,String>{

    private OkHttpClient client = new OkHttpClient();

    @Override
    protected String doInBackground(String... strings) {
        Request request = new Request.Builder()
                .url(strings[0]+strings[1])
                .get()
                .addHeader("x-rapidapi-host", "lingua-robot.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "b83d0c440amshf5b0c99c46ea382p149ba4jsn19901b7115ba")
                .build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
