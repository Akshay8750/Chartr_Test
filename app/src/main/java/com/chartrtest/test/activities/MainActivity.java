package com.chartrtest.test.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.chartrtest.test.R;
import com.datadog.android.Datadog;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.core.configuration.Credentials;
import com.datadog.android.log.Logger;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumMonitor;

public class MainActivity extends AppCompatActivity {
    Logger logger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Configuration configuration = new Configuration.Builder(true, true, true, true).build();
        Credentials credentials = new Credentials("pub08a144ccb82b8e91288c91a758f2d4b1",
                "Environment",
                "APP_VARIANT_NAME", "1e386fef-adb5-4dbe-992d-aa51dbc1f1d9", "");
        Datadog.initialize(this, credentials, configuration, TrackingConsent.GRANTED);
        RumMonitor monitor = new RumMonitor.Builder().build();
        GlobalRum.registerIfAbsent(monitor);
        logger = new Logger.Builder()
                .setNetworkInfoEnabled(true)
                .setLogcatLogsEnabled(true)
                .setDatadogLogsEnabled(true)
                .setBundleWithTraceEnabled(true)
                .setLoggerName("MainActivity1")
                .build();

    }

    public void moveToSecondScreen(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity2.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        logger.d("Activity 1 (Main Activity) started");

    }
}