package com.secure.earlyinit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView t = new TextView(this);
        t.setText("App loaded. Early init ran in logs.");
        t.setTextSize(18);
        setContentView(t);
    }
}
