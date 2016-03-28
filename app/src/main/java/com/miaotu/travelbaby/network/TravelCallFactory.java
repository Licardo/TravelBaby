package com.miaotu.travelbaby.network;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

import retrofit.Call;
import retrofit.CallAdapter;
import retrofit.Retrofit;

/**
 * Created by zenglihao on 15/11/27.
 */
public class TravelCallFactory implements CallAdapter.Factory{


    public static TravelCallFactory create() {
        return new TravelCallFactory();
    }

    private TravelCallFactory() {
    }

    private CallAdapter<NetworkRequest<?>> getCallAdapter(Type returnType) {
        Type observableType = getSingleParameterUpperBound((ParameterizedType) returnType);
        return new TravelCallAdapter(observableType);
    }

    @Override
    public CallAdapter<?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        boolean isRuruCall = "class com.miaotu.travelbaby.network.NetworkRequest".equals(((ParameterizedType) returnType).getRawType().toString());
        if (!isRuruCall) {
            return null;
        }
        CallAdapter<NetworkRequest<?>> callAdapter = getCallAdapter(returnType);
        return callAdapter;
    }

    static final class TravelCallAdapter implements CallAdapter<NetworkRequest<?>> {
        private final Type responseType;

        TravelCallAdapter(Type responseType) {
            this.responseType = responseType;
        }

        @Override
        public Type responseType() {
            return responseType;
        }

        @Override
        public <R> NetworkRequest<R> adapt(Call<R> call) {
            return new NetworkRequest<R>(call);
        }
    }

    public static Type getSingleParameterUpperBound(ParameterizedType type) {
        Type[] types = type.getActualTypeArguments();
        if (types.length != 1) {
            throw new IllegalArgumentException(
                    "Expected one type argument but got: " + Arrays.toString(types));
        }
        Type paramType = types[0];
        if (paramType instanceof WildcardType) {
            return ((WildcardType) paramType).getUpperBounds()[0];
        }
        return paramType;
    }

}
