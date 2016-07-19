package eu.redray.jstr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import eu.redray.showjokeactivity.ShowJokeActivity;

/**
 * Jstr base activity.
 */
public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.EndpointsAsyncTaskListener {

    private static final String JOKE_KEY = "joke";

    private InterstitialAd mInterstitialAd;
    private MenuItem miProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup interstitial ad
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        requestNewInterstitial();
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                new EndpointsAsyncTask(MainActivity.this).execute();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        miProgressBar = menu.findItem(R.id.item_progress_bar);
        return true;
    }

    /**
     * Launches an async task that will fetch joke from library.
     *
     * @param view that will display the toast
     */
    public void tellJoke(View view) {
        miProgressBar.setVisible(true);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    /**
     * Displays fetched joke in new Activity.
     *
     * @param result String containing joke received from GCE server
     */
    @Override
    public void onComplete(String result) {
        if (result.startsWith("timeout") || result.startsWith("404")) {
            miProgressBar.setVisible(false);
            Toast.makeText(this, "Couldn't connect to server", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, ShowJokeActivity.class);
            intent.putExtra(MainActivity.JOKE_KEY, result);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            miProgressBar.setVisible(false);
            startActivity(intent);
        }
    }

    /**
     * Requests new interstitial ad
     */
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
}
