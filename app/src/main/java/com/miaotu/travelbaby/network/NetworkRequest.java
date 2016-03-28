package com.miaotu.travelbaby.network;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by zenglihao on 15/11/27.
 */
public class NetworkRequest<T> {


    private Call<T> retrofitCall;
    private Handler handler;
    private boolean isFinish = true;

    public NetworkRequest(Call<T> retrofitCall) {
        this.retrofitCall = retrofitCall;
        handler = new Handler(Looper.getMainLooper());
    }



    public <E> void asynRequest(final NetWorkRequestListner<E> callback) {

        isFinish = false;
        retrofitCall.enqueue(new Callback<T>() {
            @Override
            public void onResponse(final Response<T> response, Retrofit retrofit) {
                Runnable runnable = new Runnable() {
                    public void run() {
                        if(response.code()==200){
                            callback.onSucess((E)response.body());
                        }else {

                        }
                    }
                };
                handler.post(runnable);
            }

            @Override
            public void onFailure(final Throwable t) {
                Runnable runnable = new Runnable() {
                    public void run() {

                        callback.onFailed(1000,"网络错误");

                    }
                };
                handler.post(runnable);
            }
        });
    }

    public void cancel() {
        retrofitCall.cancel();
    }

    public Response<T> request() throws IOException {
        isFinish = false;
        Response<T> response = retrofitCall.execute();
        isFinish = true;
        return response;
    }

    public boolean isFinish() {
        return isFinish;
    }

}
