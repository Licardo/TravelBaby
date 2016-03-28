package com.miaotu.travelbaby.network;

import android.text.TextUtils;

import com.facebook.stetho.okhttp.StethoInterceptor;
import com.miaotu.travelbaby.BuildConfig;
import com.miaotu.travelbaby.utils.DeviceUtils;
import com.miaotu.travelbaby.utils.ProtocolUtil;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by zenglihao on 15/11/25.
 */
public class NetWorkAgent {
    public static final String TAG = NetWorkAgent.class.getSimpleName();


    public static UrlParamsInterface agent;
    private static OkHttpClient client;


    public static void init() {
        client = new OkHttpClient();
        client.setConnectTimeout(10, TimeUnit.SECONDS);
        client.setReadTimeout(10, TimeUnit.SECONDS);
        client.setWriteTimeout(15, TimeUnit.SECONDS);
        client.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                String deviceid = DeviceUtils.getDeviceInfo();
                Request chainRequest = chain.request();
                HttpUrl httpUrl = chainRequest.httpUrl();
                Request.Builder newRequestBuilder = chainRequest.newBuilder();
                newRequestBuilder.addHeader("deviceid", deviceid.length() > 22 ? deviceid.substring(22) : deviceid);
                String newUrl = httpUrl.toString();
                try {
                    URL url = new URL(newUrl);
                    String userInfo = TextUtils.isEmpty(url.getUserInfo()) ? "" : URLDecoder.decode(url.getUserInfo(), "UTF-8");
                    String path = TextUtils.isEmpty(url.getPath()) ? "" : URLDecoder.decode(url.getPath(), "UTF-8");
                    String query = TextUtils.isEmpty(url.getQuery()) ? "" : URLDecoder.decode(url.getQuery(), "UTF-8");
                    String ref = TextUtils.isEmpty(url.getRef()) ? "" : URLDecoder.decode(url.getRef(), "UTF-8");
                    URI uri = new URI(url.getProtocol(), userInfo, url.getHost(), url.getPort(), path, query, ref);
                    newUrl = uri.toASCIIString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                newRequestBuilder.url(newUrl);
                return chain.proceed(newRequestBuilder.build());
            }
        });

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.interceptors().add(logging);
        if (BuildConfig.DEBUG) {
            client.networkInterceptors().add(new StethoInterceptor());
        }

        Retrofit retrofit = new Retrofit.Builder().baseUrl(ProtocolUtil.SERVER).client(client).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(TravelCallFactory.create()).build();
        agent = retrofit.create(UrlParamsInterface.class);
    }

    public static UrlParamsInterface getApiAgent() {
        return agent;
    }
}
