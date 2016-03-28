package com.miaotu.travelbaby.network;


import android.support.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

//import la.ruru.model.ShoppingCartItemInfo;

/**
 * Created by zenglihao on 15/11/27.
 */
public class GetShoppingCartListRequest extends AbstractRequest<JsonElement> {
    private static final String PARAM0_KEY = "loginkey";

    private ViewHandler viewHandler;


    @Nullable
    @Override
    protected NetworkRequest getRequest() {
        return NetWorkAgent.getApiAgent().queryShoppingCartRequet(getParams());


    }


    public GetShoppingCartListRequest(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
    }

    @Override
    public void onSucess(JsonElement result) {
        if (result instanceof JsonObject) {
            JsonObject jsonObject = (JsonObject) result;
            String code = jsonObject.get("code").getAsString();
            if (!code.equals("1")) {
                String err = jsonObject.get("errmsg").getAsString();
                int errorCode = jsonObject.get("errcode").getAsInt();
                viewHandler.getShoppingCartListFailed(errorCode, err);
            } else {
//                ArrayList shoppingCartItems = new ArrayList<ShoppingCartItemInfo>();
                JsonArray resultJson = jsonObject.get("result").getAsJsonArray();
                for (int i = 0; i < resultJson.size(); i++) {
//                    ShoppingCartItemInfo cartItems = new ShoppingCartItemInfo();
//                    JsonObject resultJsonObject = resultJson.get(i).getAsJsonObject();
//                    cartItems.setShoppingCarID(resultJsonObject.get("shoppingCarID").getAsInt());
//                    cartItems.setGoodsPackID(resultJsonObject.get("goodsPackID").getAsInt());
//                    cartItems.setGoodsPackNum(resultJsonObject.get("sl").getAsInt());
//                    cartItems.setUserGUID(resultJsonObject.get("userGUID").getAsString());
//                    cartItems.setGoodsID(resultJsonObject.get("goodsID").getAsInt());
//                    cartItems.setGoodsPackName(resultJsonObject.get("goodsPackName").getAsString());
//
//                    cartItems.setTotalPrice(resultJsonObject.get("totalPrice").getAsString());
//                    cartItems.setDjPrice(resultJsonObject.get("djPrice").getAsString());
//                    cartItems.setFmpic(resultJsonObject.get("fmpic").getAsString());
//                    cartItems.setGoodsPackDetail(resultJsonObject.get("goodsPackDetail").getAsString());
//                    cartItems.setPlaces(resultJsonObject.get("Places").getAsInt());
////                        cartItems.setErveyOnePlaces(resultJsonObject.getInt("erveyOnePlaces"));
//                    cartItems.setYydsl(resultJsonObject.get("yydsl").getAsInt());
//                    cartItems.setKcMsg(resultJsonObject.get("kcMsg").getAsString());
//                    cartItems.setFhTime(resultJsonObject.get("fhTime").getAsInt());
//                    cartItems.setCouponMoney("0");
//                    cartItems.setCouponName("请选择该商品可以使用的优惠券");
//                    shoppingCartItems.add(cartItems);
                }

//                viewHandler.getShoppingCartListSuccess(shoppingCartItems);
            }
        }
    }

    public interface ViewHandler {
//        void getShoppingCartListSuccess(ArrayList<ShoppingCartItemInfo> shoppingCartItems);

        void getShoppingCartListFailed(int errorCode, String errorMessage);
    }

    @Override
    public void onFailed(int code, String message) {

    }

    public GetShoppingCartListRequest setMapPramas(String loginkey, String appid, String time) {
        clearParams();
        putParam(PARAM0_KEY, loginkey);
        return this;

    }

}
