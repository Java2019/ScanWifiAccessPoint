package com.samples.network.scanwifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class WiFiScanActivity extends AppCompatActivity
        implements CompoundButton.OnCheckedChangeListener, View.OnClickListener{

    private TextView text;
    private CheckBox checkBox;
    private Button button;

    private WifiManager manager;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

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
