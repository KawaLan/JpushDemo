package com.kawa.jpushdemo;

import android.app.Application;

import utils.JPushClient;

/****
 * <pre>
 *  Project_Name:    JpushDemo
 *  Copyright:       Copyright  2012-2018 G-emall Technology Co.,Ltd
 *  Created:         Kawa on 2018/5/30 15:02.
 *  E-mail:          zhenlin.liang@g-emall.com
 *  Desc:            
 * </pre> 
 ****/
public class JpushContent extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        JPushClient.getInstance(this);
    }
}
