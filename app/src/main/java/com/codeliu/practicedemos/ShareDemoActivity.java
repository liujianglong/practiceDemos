package com.codeliu.practicedemos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

/**
 * Created by liu77 on 16-12-22.
 */

public class ShareDemoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
    }

    public void shareText(View view){
        String title =getString(R.string.app_name);
        String subject="Share Text";
        String content="Hello World!";

        Intent intent =new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, content);

        if (!TextUtils.isEmpty(title)){//自定义title
            startActivity(Intent.createChooser(intent, title));
        }else {//系统默认title
            startActivity(intent);
        }
    }

    public void shareImage(View view){

    }

    public void shareTextWithImage(View view){
        String title =getString(R.string.app_name);
        String subject="Share Text";
        String content="Hello World!";


    }
}
