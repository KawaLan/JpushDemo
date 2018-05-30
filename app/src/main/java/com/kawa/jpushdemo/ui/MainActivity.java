package com.kawa.jpushdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kawa.jpushdemo.R;

import utils.JPushClient;

/****
 * <pre>
 *  Created:         Kawa on 2017/7/21 14:19.
 *  E-mail:          958129971@qq.com
 *  Desc:
 * </pre>
 ****/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JPushClient.getInstance(this).registerJPush(this,11,"kawa103");
    }

}
