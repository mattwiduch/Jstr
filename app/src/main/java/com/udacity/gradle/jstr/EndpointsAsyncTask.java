package com.udacity.gradle.jstr;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import eu.redray.jstr.backend.jokesApi.JokesApi;

/**
 * Async Task that retrieves joke String from GCE server.
 */

class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static JokesApi mJokesApiService = null;

    private EndpointsAsyncTaskListener mListener = null;

    EndpointsAsyncTask(EndpointsAsyncTaskListener listener) {
        mListener = listener;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (mJokesApiService == null) {  // Only do this once
            JokesApi.Builder builder = new JokesApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jstr-1376.appspot.com/_ah/api/");
            // end options for devappserver

            mJokesApiService = builder.build();
        }

        try {
            return mJokesApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public EndpointsAsyncTask setListener(EndpointsAsyncTaskListener listener) {
        this.mListener = listener;
        return this;
    }

    @Override
    protected void onPostExecute(String result) {
        if (this.mListener != null)
            this.mListener.onComplete(result);
    }

    interface EndpointsAsyncTaskListener {
        /** Performs desired action specified by class implementing this listener.
         *
         * @param result String containing joke received from GCE server
         * */
        void onComplete(String result);
    }
}
