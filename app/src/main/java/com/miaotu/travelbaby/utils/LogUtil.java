package com.miaotu.travelbaby.utils;

import android.util.Log;

public class LogUtil {
	public static boolean CANPRINT = true;

	public static void v(String log) {
		if (CANPRINT) {
			Log.v("YueLanLog", log);
		}
	}

	public static void e(Exception e) {
		if (CANPRINT) {
			e.printStackTrace();
		}
	}
}
