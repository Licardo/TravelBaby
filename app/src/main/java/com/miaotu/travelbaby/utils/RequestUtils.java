package com.miaotu.travelbaby.utils;

import android.content.Context;
import android.widget.Toast;

import com.lidroid.xutils.exception.HttpException;
//import la.ruru.LoginActivity_;

/**
 * Created by remilia on 2015/9/16.
 */
public class RequestUtils {

    public static void toastFail(Context context,Exception e) {

        if (e instanceof HttpException) {
            Toast.makeText(context, "出错了，请联网后再试", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "出错了，请稍后再试或联系我们", Toast.LENGTH_SHORT).show();
        }
    }

     public static void toastFail(Context context,Throwable e,String s) {

         L.e(s,e);
         if (e instanceof HttpException) {
             Toast.makeText(context, "出错了，请联网后再试", Toast.LENGTH_SHORT).show();
         } else {
             Toast.makeText(context, "出错了，请稍后再试或联系我们", Toast.LENGTH_SHORT).show();
         }
    }




    public static void toast(Context context,String str){
        Toast.makeText(context, str, Toast.LENGTH_LONG).show();
        if(str.equals("没联网")){
//            Intent intent = new Intent(context, LoginActivity_.class);
//            context.startActivity(intent);
        }
    }
}
