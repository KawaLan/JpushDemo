package com.kawa.jpushdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

/****
 * <pre>
 *  Created:         Kawa on 2017/7/21 14:19.
 *  E-mail:          958129971@qq.com
 *  Desc:         接收极光推送的广播
 * </pre>
 ****/
public class JPushBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Log.e("tag",">>>>>>>有接收到数据<<<<<<<");
        //打开消息
        if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            if (bundle.getString(JPushInterface.EXTRA_EXTRA) != null) {
               //TODO 处理推送过来的数据
                Log.e("tag",">>>>>>>"+bundle.getString(JPushInterface.EXTRA_EXTRA));
            }
        }
        //有推送消息进来
        else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
            //TODO 处理推送过来的数据
            Log.e("tag",">>>>>>>"+bundle.getString(JPushInterface.EXTRA_EXTRA));
        }
    }
}