package com.example.rachel.turnonwifi;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends Activity {
    private Handler handler;
    private Runnable runnable;
//    private int interval = 30000;
    private int interval = 1800000; // 30 minutes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createTask();
    }

    private void createTask(){
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//                boolean wifiEnabled = wifiManager.isWifiEnabled();
//                Log.d("Handlers", "WiFi: " + wifiEnabled);
                wifiManager.setWifiEnabled(true);
                handler.postDelayed(runnable, interval);
            }
        };
        handler.post(runnable);
    }
}
