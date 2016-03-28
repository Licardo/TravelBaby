package com.miaotu.travelbaby.network;

import android.support.annotation.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


/**
 * Created by zenglihao on 15/10/10.
 */
public abstract class AbstractRequest<T> implements NetWorkRequestListner<T> {
    private NetworkRequest request;
    private Map<String, Object> params = new TreeMap<>();

    public Map<String, Object> getParams() {
        return params;
    }

    protected final void putParam(String key, Object value) {
        if (value instanceof Collection) {
            int i=0;
            for (Iterator iterator = ((Collection) value).iterator(); iterator.hasNext();) {
                params.put(key + "["+i+"]", iterator.next());
                i++;
            }
        }else{
            params.put(key, value);
        }
    }

    protected final void clearParams() {
        params.clear();
    }

    @Nullable
    protected abstract NetworkRequest getRequest();

    public final void cancelCurrent() {
        if (request != null) {
//            request.cancel();
        }
    }

//    public final boolean isCurrentFinished() {
//        return request == null ? true : request.isFinish();
//    }


    public final void fire() {
        request = getRequest();
        if (request != null) {
            request.asynRequest(this);
        }
    }
}
