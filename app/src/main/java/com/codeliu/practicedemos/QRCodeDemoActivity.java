package com.codeliu.practicedemos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.xys.libzxing.zxing.encoding.EncodingUtils;

/**
 * Created by liu77 on 16-12-21.
 */
public class QRCodeDemoActivity extends Activity {

    private TextView mTvResult;
    private EditText mEtContent;
    private CheckBox mCbLogo;
    private ImageView mIvQRCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        mTvResult = (TextView) findViewById(R.id.tv_scan_result);
        mEtContent = (EditText) findViewById(R.id.et_input);
        mCbLogo = (CheckBox) findViewById(R.id.cb_logo);
        mIvQRCode = (ImageView) findViewById(R.id.iv_qrcode);
    }

    public void onStartScanClick(View view) {
        startActivityForResult(new Intent(this, CaptureActivity.class), 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            mTvResult.setText("result: " + result);
        }
    }

    public void onGenerateQRCodeClick(View view) {
        String content = mEtContent.getText().toString();
        if (TextUtils.isEmpty(content)) {
            Toast.makeText(this, "content should not be empty",
                    Toast.LENGTH_SHORT).show();
        } else {
            Bitmap logo = mCbLogo.isChecked() ?
                    BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher) :
                    null;
            Bitmap bitmap = EncodingUtils.createQRCode(content, 500, 500, logo);
            mIvQRCode.setImageBitmap(bitmap);
        }
    }


}
