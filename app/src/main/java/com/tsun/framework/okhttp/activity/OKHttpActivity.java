package com.tsun.framework.okhttp.activity;


import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tsun.framework.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttpActivity extends Activity implements View.OnClickListener {

    private static final int GET = 1;
    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL = 2;
    private Button btnGetPost;
    private Button btnUtils;
    private Button btnUtilsDownload;
    private ProgressBar pbDownload;
    private TextView tvResult;
    private OkHttpClient client = new OkHttpClient();

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case GET:
                    tvResult.setText((String)msg.obj);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        btnGetPost = (Button)findViewById(R.id.btn_get_post);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnUtils = (Button) findViewById(R.id.btn_get_post_utils);
        btnUtilsDownload = (Button) findViewById(R.id.btn_utils_download);
        pbDownload = (ProgressBar) findViewById(R.id.pb_download);

        btnGetPost.setOnClickListener(this);
        btnUtils.setOnClickListener(this);
        btnUtilsDownload.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get_post:
                getData();
                break;
            case R.id.btn_get_post_utils:
                getDataByUtils();
                break;
            case R.id.btn_utils_download:
                getPermission();
                break;
        }
    }

    private String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    private void getData()
    {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    String result = get("http://api.m.mtime.cn/PageSubArea/TrailerList.api");
                    Message msg = Message.obtain();
                    msg.what = GET;
                    msg.obj = result;
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void getDataByUtils () {
        String url = "http://www.csdn.net/";
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback()
                {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        tvResult.setText(response);
                    }

                });
    }

    private void download() {

        String url = "http://github.com/hongyangAndroid/okhttputils/archive/master.zip";
        OkHttpUtils//
                .get()//
                .url(url)//
                .build()//
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), "master.zip")//
                {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(File response, int id) {
                        Log.e("Download", "successfully");
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {
                        pbDownload.setProgress((int)(100 * progress));
                    }
                });
    }
    private void getPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    download();
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
