package eu.redray.jstr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

import eu.redray.showjokeactivity.ShowJokeActivity;

/**
 * Jstr base activity.
 */
public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.EndpointsAsyncTaskListener {

    private static final String JOKE_KEY = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Launches an async task that will fetch joke from library.
     *
     * @param view that will display the toast
     */
    public void tellJoke(View view) {
        new EndpointsAsyncTask(this).execute();
    }

    /**
     * Displays fetched joke in new Activity.
     *
     * @param result String containing joke received from GCE server
     */
    @Override
    public void onComplete(String result) {
        Intent intent = new Intent(this, ShowJokeActivity.class);
        intent.putExtra(MainActivity.JOKE_KEY, result);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
