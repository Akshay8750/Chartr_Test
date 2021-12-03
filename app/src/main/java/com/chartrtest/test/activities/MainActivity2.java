package com.chartrtest.test.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.chartrtest.test.R;
import com.datadog.android.log.Logger;

public class MainActivity2 extends AppCompatActivity {
    Logger logger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        logger = new Logger.Builder()
                .setNetworkInfoEnabled(true)
                .setLogcatLogsEnabled(true)
                .setDatadogLogsEnabled(true)
                .setBundleWithTraceEnabled(true)
                .setLoggerName("<MainActivity2>")
                .build();
    }

    @Override
    protected void onResume() {
        super.onResume();
        logger.d("Activity 2 (Main Activity 2) started");

    }
}