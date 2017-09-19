package com.craiovadata.ancatest;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Handler handler;
    Runnable runnable;
    int unghi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ToggleButton b = (ToggleButton) findViewById(R.id.toggleButton);
        textView = (TextView) findViewById(R.id.textView);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                unghi= unghi+20;
                textView.setText("unghi = " + unghi);
                textView.setRotation(unghi );

                handler.postDelayed(runnable, 1000);

                if (unghi >= 360)
                    handler.removeCallbacks(runnable);
            }
        };


        b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bifat) {
                if (bifat) {
                    handler.removeCallbacks(runnable);
                    handler.post(runnable);
                } else {
                    handler.removeCallbacks(runnable);
                }
            }
        });

    }

}
