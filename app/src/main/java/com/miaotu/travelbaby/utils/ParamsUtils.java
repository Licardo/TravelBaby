package com.miaotu.travelbaby.utils;

import com.lidroid.xutils.http.RequestParams;

import org.apache.http.NameValuePair;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by remilia on 2015/9/15.
 */
public class ParamsUtils {

    public static Map<String,Object> paramsToMap(RequestParams params){
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        try {
            Field field = params.getClass().getDeclaredField("bodyParams");
            field.setAccessible(true);
            pairs = (List<NameValuePair>) field.get(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String,Object> map = new HashMap<String, Object>();
        for(NameValuePair pair : pairs){
            map.put(pair.getName(),pair.getValue());
        }
        return map;
    }

}
