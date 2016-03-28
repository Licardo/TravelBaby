package com.miaotu.travelbaby.network;

/**
 * Created by zenglihao on 15/11/13.
 */
public interface NetWorkRequestListner<T> {
    void onSucess(T result);
    void onFailed(int code, String message);
}
