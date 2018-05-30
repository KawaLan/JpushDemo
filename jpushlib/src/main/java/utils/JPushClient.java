package utils;

import android.app.Notification;
import android.content.Context;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;

/****
 * <pre>
 *  Created:         Kawa on 2017/7/21 14:19.
 *  E-mail:          958129971@qq.com
 *  Desc:
 * </pre>
 ****/
public class JPushClient {
    private static JPushClient mInstance;

    private JPushClient(Context context) {
        init(context);
    }

    public synchronized static final JPushClient getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new JPushClient(context);
        }
        return mInstance;
    }

    /**
     * 初始化
     */
    private void init(Context context) {
        JPushInterface.setDebugMode(true);
        JPushInterface.init(context);
    }

    //注册极光推送
    public void registerJPush(Context context, int sequence, String token) {
        Set<String> tag = new HashSet<String>();
        tag.add(token);
        JPushInterface.setTags(context, sequence, tag);
        JPushInterface.setAlias(context, sequence, token);
    }

    //退出极光推送
    public void logOutJPush(Context context, int sequence) {
        JPushInterface.deleteAlias(context, sequence);
        JPushInterface.cleanTags(context, sequence);
    }

    /**
     * 自定义通知栏样式
     *
     * @param context
     */
    public void setPushNotificationBuilder(Context context, boolean sound, boolean vibrate, boolean lights) {
        BasicPushNotificationBuilder builder = new BasicPushNotificationBuilder(context);
        int notifyValue = Notification.DEFAULT_ALL;
        if (!sound) {//铃声
            notifyValue = notifyValue ^ Notification.DEFAULT_SOUND;
        }
        if (!vibrate) {//震动
            notifyValue = notifyValue ^ Notification.DEFAULT_VIBRATE;
        }
        if (!lights) {//呼吸灯闪烁
            notifyValue = notifyValue ^ Notification.DEFAULT_LIGHTS;
        }
        builder.notificationDefaults = notifyValue;
        JPushInterface.setPushNotificationBuilder(1, builder);
    }
}
