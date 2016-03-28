package com.miaotu.travelbaby.network;

import com.google.gson.JsonElement;

import java.util.Map;

import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by zenglihao on 15/11/13.
 */
public interface UrlParamsInterface {
    @FormUrlEncoded
    @POST("shoppingCar.ashx?action=getshoppingCarList")
    NetworkRequest<JsonElement> queryShoppingCartRequet(@FieldMap Map<String, Object> params);


}
