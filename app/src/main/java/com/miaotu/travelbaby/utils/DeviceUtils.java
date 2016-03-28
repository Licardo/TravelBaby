package com.miaotu.travelbaby.utils;

import android.content.Context;
import android.text.TextUtils;

/**
 * Created by xuchao on 15/9/24.
 */
public class DeviceUtils {

    private static Context mContext;

    public static void init(Context context){
        mContext = context;
    }
    /**
     * Get device information json string for testing device register on umeng.
     *
     * @return deviceInfo json string
     */

    public static String getDeviceInfo() {
        try {
            final android.telephony.TelephonyManager tm = (android.telephony.TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
            String device_id = tm.getDeviceId();
            final android.net.wifi.WifiManager wifi = (android.net.wifi.WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
            final String mac = wifi.getConnectionInfo().getMacAddress();
            if (TextUtils.isEmpty(device_id)) {
                device_id = mac;
            }
            if (TextUtils.isEmpty(device_id)) {
                device_id = android.provider.Settings.Secure.getString(mContext.getContentResolver(),
                        android.provider.Settings.Secure.ANDROID_ID);
            }
            if (TextUtils.isEmpty(device_id)) {
                device_id = "abc";
            }
            return device_id;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return "abc";
    }

}
