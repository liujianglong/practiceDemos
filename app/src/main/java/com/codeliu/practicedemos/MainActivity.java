package com.codeliu.practicedemos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToQRCodeDemo(View view) {
        Intent intent=new Intent(MainActivity.this, QRCodeDemoActivity.class);
        startActivity(intent);
    }
}
