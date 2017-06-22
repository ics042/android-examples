package com.tsun.framework.json.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.tsun.framework.R;

public class JsonActivity extends Activity implements View.OnClickListener {

    Button btnGetJson;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        btnGetJson = (Button) findViewById(R.id.btn_get_json);
        btnGetJson.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
