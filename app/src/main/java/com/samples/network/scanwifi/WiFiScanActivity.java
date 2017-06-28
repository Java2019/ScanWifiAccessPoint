package com.samples.network.scanwifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

public class WiFiScanActivity extends AppCompatActivity
        implements CompoundButton.OnCheckedChangeListener, View.OnClickListener{

    private TextView text;
    private CheckBox checkBox;
    private Button button;

    private WifiManager manager;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                    WifiManager.WIFI_STATE_UNKNOWN);
            switch (wifiState){
                case WifiManager.WIFI_STATE_ENABLING:
                    text.setText("Wi-fi state enabling");
                    break;
                case WifiManager.WIFI_STATE_ENABLED:
                    text.setText("Wi-fi state enabled");
                    break;
                case WifiManager.WIFI_STATE_DISABLING:
                    text.setText("Wi-fi state disabling");
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    text.setText("Wi-fi state disabled");
                    break;
                case WifiManager.WIFI_STATE_UNKNOWN:
                    text.setText("Wi-fi state unknown");
                    break;
            }
        }
    };

    private BroadcastReceiver scanReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            List<ScanResult> results = manager.getScanResults();
            text.setText("Scan result: " + results.size() + " points");
            // Выводим результаты сканирования на экран
            for (ScanResult result : results) {
                text.append("\nSS ID:\t" + result.SSID);
                text.append("\n\tLevel:\t" + result.level + " dBm");
                text.append("\n\tFrequency:\t" + result.frequency + " MHz");
                text.append("\n\tCapabilities:\t" + result.capabilities);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fi_scan);

        text = (TextView)findViewById(R.id.text);
        checkBox =  (CheckBox)findViewById(R.id.checkbox);
        button = (Button)findViewById(R.id.bStart);

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }
}
