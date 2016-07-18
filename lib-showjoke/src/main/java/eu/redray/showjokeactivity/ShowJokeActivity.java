package eu.redray.showjokeactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/** Displays joke received in intent extra */
public class ShowJokeActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        // Get string from intent extra and apply it to joke text view
        ((TextView) findViewById(R.id.joke_view)).setText(getIntent().getStringExtra(JOKE_KEY));
    }
}