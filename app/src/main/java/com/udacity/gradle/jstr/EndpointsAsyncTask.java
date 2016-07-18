package com.udacity.gradle.jstr;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import eu.redray.jstr.backend.jokesApi.JokesApi;
import eu.redray.showjokeactivity.ShowJokeActivity;

/**
 * Created by frano on 18/07/2016.
 */

class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static JokesApi JokesApiService = null;
    private Context context;

    private static final String JOKE_KEY = "joke";

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (JokesApiService == null) {  // Only do this once
            JokesApi.Builder builder = new JokesApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jstr-1376.appspot.com/_ah/api/");
            // end options for devappserver

            JokesApiService = builder.build();
        }

        context = params[0].first;
        //String name = params[0].second;

        try {
            return JokesApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, ShowJokeActivity.class);
        intent.putExtra(EndpointsAsyncTask.JOKE_KEY, result);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
