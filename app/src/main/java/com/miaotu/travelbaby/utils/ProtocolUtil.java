package com.miaotu.travelbaby.utils;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import la.ruru.ui.MainApplication;

/**
 * Created by pro on 15-9-1.
 */
public class ProtocolUtil {
    public static String const_appid = "mAPP01";
    public static String const_encsub = "FFamdsdfwrer21aafVV";
    //amdsdfwrer21aaf  //FFamdsdfwrer21aafVV

    public static final String SERVER = "http://api.ruru.la/";
    //http://testapi.ruru.la/

  //  http://api.ruru.la/


    public static final String GETORDERPAYINFO_URL = SERVER + "order.ashx?action=getOrderPayInfo";
    public static final String SERVER_BASECITYLIST = SERVER + "basic.ashx?action=getprovinceCityList";


    public static final String SERVER_DICINFOLIST = SERVER + "basic.ashx?action=getDicInfoList";
    public static final String SERVER_GOODSLIST = SERVER + "goods.ashx?action=getGoodsPageList";
    public static final String SERVER_SEARCHGOODS = SERVER + "goods.ashx?action=searchGoodsPageList";
    public static final String SERVER_SEARCHOTHERUGOODS = SERVER + "goods.ashx?action=searchGoodsPageList";
    public static final String SERVER_GOODSFOLLOWLIST = SERVER + "goods.ashx?action=getGoodsFollowPageList";
    public static final String SERVER_GOODSINFO = SERVER + "goods.ashx?action=getGoodsInfo";
    public static final String SERVER_GOODSIFFOLLOWGOODS = SERVER + "goods.ashx?action=ifFollowGoods";
    public static final String SERVER_GOODSADDFOLLOW = SERVER + "goods.ashx?action=addgoodsFollow";
    public static final String SERVER_GOODSDELFOLLOW = SERVER + "goods.ashx?action=delgoodsFollow";
    public static final String SERVER_GOODSADDTIP = SERVER + "goods.ashx?action=addgoodsTip";
    public static final String SERVER_GOODSCOMMENTLIST = SERVER + "goods.ashx?action=getCommentPageList";
    public static final String SERVER_GOODSADDCOMMENT = SERVER + "goods.ashx?action=addComment";

    public static final String SERVER_GOODSPACKLIST = SERVER + "goods.ashx?action=getgoodsPackList";
    public static final String SERVER_GOODSPACKINFO = SERVER + "goods.ashx?action=getgoodsPackInfo";

    public static final String SERVER_BANNERLIST = SERVER + "basic.ashx?action=getbannerInfoList";
    public static final String SERVER_ANNOUNCEMENT = SERVER + "basic.ashx?action=getAnnouncementInfo";


    public static final String SERVER_PERSONALLOGIN = SERVER + "personal.ashx?action=login";
    public static final String SERVER_PERSONALIFLOGIN = SERVER + "personal.ashx?action=iflogin";
    public static final String SERVER_PERSONALUSERINFO = SERVER + "personal.ashx?action=getUserInfo";

    public static final String SERVER_PERSONALGETADDRESS = SERVER + "personal.ashx?action=getAddress";
    public static final String SERVER_ORDERADDORDER = SERVER + "order.ashx?action=addOrder";
    public static final String SERVER_ORDERORDERLIST = SERVER + "order.ashx?action=getOrderPageList";
    public static final String SERVER_ORDERUPDATEADDR = SERVER + "order.ashx?action=updateOrderAddress";
    public static final String SERVER_ORDERSUREORDERSH = SERVER + "order.ashx?action=sureOrderSH";
    public static final String SERVER_ORDERDELORDER = SERVER + "order.ashx?action=delOrder";
    public static final String SERVER_ORDERTKAPPLY = SERVER + "order.ashx?action=tkApply";


    public static final String SERVER_PERSONALSENDCODE = SERVER + "personal.ashx?action=sendCode";
    public static final String SERVER_PERSONALCREATEUSER = SERVER + "personal.ashx?action=createUser";
    public static final String SERVER_PERSONALRESET = SERVER + "personal.ashx?action=resetPwd";
    public static final String SERVER_PERSONALUPDATEPWD = SERVER + "personal.ashx?action=updatePwd";
    public static final String SERVER_PERSONALUPUSEPHOTO = SERVER + "personal.ashx?action=upUsePhoto";

    public static final String SERVER_PERSONALOTHERUINFO = SERVER + "personal.ashx?action=getOtherUserInfo";
    public static final String SERVER_PERSONALDELADDRESS = SERVER + "personal.ashx?action=delAddress";

    public static final String SERVER_PERSONALADDADDRESS = SERVER + "personal.ashx?action=addAddress";
    public static final String SERVER_PERSONALUPDATEADDRESS = SERVER + "personal.ashx?action=updateAddress";
    public static final String SERVER_PERSONALDEFAULTADDRESS = SERVER + "personal.ashx?action=defaultAddress";

    public static final String SERVER_SXMSGSXLINKMAN = SERVER + "sxMessage.ashx?action=getSXLinkMan";
    public static final String SERVER_SXMSGBACKWARDMSG = SERVER + "sxMessage.ashx?action=getBackwardMsgList";
    public static final String SERVER_SXMSGSENDMSG = SERVER + "sxMessage.ashx?action=sendMsg";
    public static final String SERVER_SXMSGFORWARDMSG = SERVER + "sxMessage.ashx?action=getForwardMsgList";
    public static final String SERVER_SXMSGLASTMSGLIST = SERVER + "sxMessage.ashx?action=getLastMsgList";


    public static final String SERVER_PERSONALIFHAVEPHONE = SERVER + "personal.ashx?action=ifHavePhone";


    public static final String versionXmlPath = "http://www.xxx.com/upgrade/version-demo.xml"; // 服务器更新xml存放地址


    public static final String CanOrNotAddShopping_URL = SERVER + "shoppingCar.ashx?action=ifadd";
    public static final String AddShoppingGoods_URL = SERVER + "shoppingCar.ashx?action=addshoppingCar";
    public static final String QueryShoppingCart_URL = SERVER + "shoppingCar.ashx?action=getshoppingCarList";
    public static final String AddShoppingCartItem_URL = SERVER + "shoppingCar.ashx?action=updateshoppingCar";
    public static final String DeleteShoppingCartItem_URL = SERVER + "shoppingCar.ashx?action=deleteshoppingCar";
    public static final String IfByMore_URL = SERVER + "order.ashx?action=ifbyMore";
    public static final String Obtain_Coupon_List_URL = SERVER + "userCoupon.ashx?action=getCouponListWithgoodsPackID";
    public static final String Convert_Coupon_URL= SERVER + "userCoupon.ashx?action=getCoupon";
    public static final String Convert_All_Coupon_URL= SERVER + "userCoupon.ashx?action=getCouponList";
    public static final String Create_Order_URL= SERVER + "order.ashx?action=addOrderMore";
    public static final String Get_Shopping_Items_Num_URL= SERVER + "shoppingCar.ashx?action=getShoppingCarGoodsNum";
    public static final String Del_Order_With_VirNo_URL= SERVER + "order.ashx?action=delOrderWithvorderNu";
    public static final String Get_Order_List_VirNo_URL= SERVER + "order.ashx?action=getOrderPageListByvorderNu";
    public static final String Get_Order_Info_VirNo_URL= SERVER + "order.ashx?action=getOrderPayInfoWithvorderNu";
    public static final String Update_Order_Adrr_With_VirNo_URL= SERVER + "order.ashx?action=updateOrderAddressWithvorderNu";






    public static String genSign(Map<String, Object> map) {
        String result = "";

        //这里将map.entrySet()转换成list
        List<Map.Entry<String, Object>> list = new ArrayList<Map.Entry<String, Object>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<String, Object>>() {
            //升序排序
            public int compare(Map.Entry<String, Object> o1,
                               Map.Entry<String, Object> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }

        });

//        for(Map.Entry<String,String> mapping:list){
//            System.out.println(mapping.getKey()+":"+mapping.getValue());
//        }

        for (Map.Entry<String, Object> mapping : list) {
            String newval = (String)mapping.getValue();
            result = result + newval;
        }
        result = result + const_encsub;
        L.d(result);
        result = Util.MD5(result);
        return result;
    }

    /**
     * 传入 除appid,time,loginkey,sign 之外的其它参数
     *
     * @param map
     * @return
     */
    public static RequestParams fetch_wraper(Map<String, Object> map) {
        String time = MainApplication.getCurrentSecs();
        map.put("appid", const_appid);
        map.put("time", time);
        map.put("sign", genSign(map));


        L.d("--------------------");
        final RequestParams param = new RequestParams();
        for (String key : map.keySet()) {
            String newval =(String) map.get(key);

            param.addBodyParameter(key, newval);
            L.d(key + " " + newval);
        }
        L.d("--------------------");

        String loginKey = MainApplication.getLoginkey();
        String deviceid = DeviceUtils.getDeviceInfo();
        param.addHeader("loginkey", loginKey);
        param.addHeader("deviceid", deviceid.length() > 22 ? deviceid.substring(22) : deviceid);
        param.addHeader("time", time);
        param.addHeader("sign", Util.MD5(deviceid + loginKey + time + const_encsub).toLowerCase());

        L.d("--", param.toString());
        return param;
    }

    public static void fetch_dictinfolist(RequestCallBack callBack) {
        HttpUtils httpUtils = new HttpUtils();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dictionaryType", "");
        map.put("loginkey", "");
        RequestParams param = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_DICINFOLIST, param, callBack);
        L.d(SERVER_DICINFOLIST);

    }


    public static void fetch_basiccitylist(RequestCallBack callBack, String loginkey, int fatherID) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("fatherInfoID", String.valueOf(fatherID));
        RequestParams param = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_BASECITYLIST, param, callBack);
        L.d(SERVER_BASECITYLIST);
    }


    public static void fetch_bannerlist(RequestCallBack callBack) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", "");
        map.put("bannerUse", String.valueOf(1));
        RequestParams param = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_BANNERLIST, param, callBack);
        L.d(SERVER_BANNERLIST);
    }


    /**
     * @param callBack
     * @param infType  31：卖家认证协议
     *                 32：常见疑问
     *                 33：平台协议
     *                 34：预售规则条款
     *                 35：用户服务条款
     *                 36：关于我们
     *                 37：联系我们
     */
    public static void fetch_announcement(RequestCallBack callBack, String loginkey, int infType) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("infType", String.valueOf(infType));
        RequestParams param = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_ANNOUNCEMENT, param, callBack);
        L.d(SERVER_ANNOUNCEMENT);
    }


    public static void fetch_goodslist(RequestCallBack callBack, int pageSize, int pageNumber) {
        HttpUtils httpUtils = new HttpUtils();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", "");
        map.put("pageSize", String.valueOf(pageSize));
        map.put("goPage", String.valueOf(pageNumber));
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_GOODSLIST, param, callBack);
        L.d(SERVER_GOODSLIST);
    }

    public static void fetch_searchgoods(RequestCallBack callBack, int pageSize, int goPage, String keyword, String LabelIDs, String userGUID) {
        HttpUtils httpUtils = new HttpUtils();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", "");
        map.put("pageSize", String.valueOf(pageSize));
        map.put("goPage", String.valueOf(goPage));
        map.put("keyword", keyword);
        map.put("LabelIDs", LabelIDs);
        map.put("userGUID", userGUID);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_SEARCHGOODS, param, callBack);
        L.d(SERVER_SEARCHGOODS);
    }


    public static void fetch_goodsfollowlist(RequestCallBack callBack, String loginkey, int pageSize, int pageNumber) {
        HttpUtils httpUtils = new HttpUtils();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("pageSize", String.valueOf(pageSize));
        map.put("goPage", String.valueOf(pageNumber));
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_GOODSFOLLOWLIST, param, callBack);
        L.d(SERVER_GOODSFOLLOWLIST);
    }


    public static void fetch_goodsinfo(RequestCallBack callBack, String loginkey, String goodsID) {
        HttpUtils httpUtils = new HttpUtils();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("goodsID", goodsID);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_GOODSINFO, param, callBack);
        L.d(SERVER_GOODSINFO);
    }

    public static void fetch_goodsiffollowed(RequestCallBack callBack, String loginkey, String goodsID) {
        HttpUtils httpUtils = new HttpUtils();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("goodsID", goodsID);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_GOODSIFFOLLOWGOODS, param, callBack);
        L.d(SERVER_GOODSIFFOLLOWGOODS);
    }


    public static void fetch_goodsaddfollow(RequestCallBack callBack, String loginkey, String goodsID) {
        HttpUtils httpUtils = new HttpUtils();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("goodsID", goodsID);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_GOODSADDFOLLOW, param, callBack);
        L.d(SERVER_GOODSADDFOLLOW);
    }


    public static void fetch_goodsdelfollow(RequestCallBack callBack, String loginkey, String goodsID) {
        HttpUtils httpUtils = new HttpUtils();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("goodsID", goodsID);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_GOODSDELFOLLOW, param, callBack);
        L.d(SERVER_GOODSDELFOLLOW);
    }

    public static void fetch_goodsaddtip(RequestCallBack callBack, String loginkey, String goodsID, String tipEX) {
        HttpUtils httpUtils = new HttpUtils();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("goodsID", goodsID);
        map.put("tipEX", tipEX);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_GOODSADDTIP, param, callBack);
        L.d(SERVER_GOODSADDTIP);
    }

    public static void fetch_goodscommentlist(RequestCallBack callBack, String loginkey, String goodsID, int pageSize, int goPage) {
        HttpUtils httpUtils = new HttpUtils();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("goodsID", goodsID);
        map.put("pageSize", String.valueOf(pageSize));
        map.put("goPage", String.valueOf(goPage));
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_GOODSCOMMENTLIST, param, callBack);
        L.d(SERVER_GOODSCOMMENTLIST);
    }

    public static void fetch_goodsaddcomment(RequestCallBack callBack, String loginkey, String goodsID, String comment, String commentInfoID) {
        HttpUtils httpUtils = new HttpUtils();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("goodsID", goodsID);
        map.put("comment", comment);
        map.put("commentInfoID", commentInfoID);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_GOODSADDCOMMENT, param, callBack);
        L.d(SERVER_GOODSADDCOMMENT);
    }

    public static void fetch_goodspacklist(RequestCallBack callBack, String loginkey, String goodsID) {
        HttpUtils httpUtils = new HttpUtils();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("goodsID", goodsID);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_GOODSPACKLIST, param, callBack);
        L.d(SERVER_GOODSPACKLIST);
    }

    public static void fetch_goodspackinfo(RequestCallBack callBack, String loginkey, String goodsID, String goodsPackID) {
        HttpUtils httpUtils = new HttpUtils();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("goodsID", goodsID);
        map.put("goodsPackID", goodsPackID);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_GOODSPACKINFO, param, callBack);
        L.d(SERVER_GOODSPACKINFO);
    }


    public static void fetch_personallogin(RequestCallBack callBack, String areacode, String phone, String pwd) {
        HttpUtils httpUtils = new HttpUtils();

        String deviceid = DeviceUtils.getDeviceInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", "");
        map.put("areacode", areacode);
        map.put("phone", phone);
        map.put("pwd", pwd);
        map.put("deviceid", deviceid.length() > 22 ? deviceid.substring(22) : deviceid);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_PERSONALLOGIN, param, callBack);
        L.d(SERVER_PERSONALLOGIN);
    }

    public static void fetch_personaliflogin(RequestCallBack callBack, String loginkey) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_PERSONALIFLOGIN, param, callBack);
        L.d(SERVER_PERSONALIFLOGIN);
    }

    public static void fetch_personaluserinfo(RequestCallBack callBack, String loginkey) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        RequestParams param = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_PERSONALUSERINFO, param, callBack);
        L.d(SERVER_PERSONALUSERINFO);
    }

    public static void fetch_personalgetaddress(RequestCallBack callBack, String loginkey) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        RequestParams param = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_PERSONALGETADDRESS, param, callBack);
        L.d(SERVER_PERSONALGETADDRESS);
    }

    public static void fetch_orderaddorder(RequestCallBack callBack, String loginkey, String goodsPackID, String addressID) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("goodsPackID", goodsPackID);
        map.put("addressID", addressID);
        RequestParams param = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_ORDERADDORDER, param, callBack);
        L.d(SERVER_ORDERADDORDER);
    }


    public static void fetch_orderorderlist(RequestCallBack callBack, String loginkey, String orderState, String orderNo,
                                            String kdFormNu, String orderNr, String ffNr, int pageSize, int goPage) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("orderState", orderState);
        map.put("orderNo", orderNo);
        map.put("kdFormNu", kdFormNu);
        map.put("orderNr", orderNr);
        map.put("ffNr", ffNr);
        map.put("pageSize", String.valueOf(pageSize));
        map.put("goPage", String.valueOf(goPage));

        RequestParams param = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_ORDERORDERLIST, param, callBack);
        L.d(SERVER_ORDERORDERLIST);
    }


    public static void fetch_orderoupdateaddr(RequestCallBack callBack, String loginkey, String orderID, String addressID) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("orderID", orderID);
        map.put("addressID", addressID);

        RequestParams param = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_ORDERUPDATEADDR, param, callBack);
        L.d(SERVER_ORDERUPDATEADDR);
    }


    public static void fetch_ordersureordersh(RequestCallBack callBack, String loginkey, String orderID) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("orderID", orderID);

        RequestParams param = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_ORDERSUREORDERSH, param, callBack);
        L.d(SERVER_ORDERSUREORDERSH);
    }

    public static void fetch_orderdelorder(RequestCallBack callBack, String loginkey, String orderID) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("orderID", orderID);

        RequestParams param = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_ORDERDELORDER, param, callBack);
        L.d(SERVER_ORDERDELORDER);
    }


    public static void fetch_ordertkapply(RequestCallBack callBack, String loginkey, String orderID, String skAccount, String skName, String applyEx) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("orderID", orderID);
        map.put("skAccount", skAccount);
        map.put("skName", skName);
        map.put("applyEx", applyEx);

        RequestParams param = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_ORDERTKAPPLY, param, callBack);
        L.d(SERVER_ORDERTKAPPLY);
    }


    public static void fetch_personalifhavephone(RequestCallBack callBack, String areacode, String phone) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", "");
        map.put("areacode", areacode);
        map.put("phone", phone);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_PERSONALIFHAVEPHONE, param, callBack);
        L.d(SERVER_PERSONALIFHAVEPHONE);
    }

    /**
     * @param callBack
     * @param areacode
     * @param phone
     * @param useType  1：用户注册、2：重置密码、3：修改密码
     */
    public static void fetch_personalsendcode(RequestCallBack callBack, String areacode, String phone, String useType) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", "");
        map.put("areacode", areacode);
        map.put("phone", phone);
        map.put("useType", useType);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_PERSONALSENDCODE, param, callBack);
        L.d(SERVER_PERSONALSENDCODE);
    }

    public static void fetch_personalcreateuser(RequestCallBack callBack, String username, String areacode, String phone, String pwd, String msgkey, String verificationcode) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", "");
        map.put("username", username);
        map.put("areacode", areacode);
        map.put("phone", phone);
        map.put("pwd", pwd);
        map.put("msgkey", msgkey);
        map.put("verificationcode", verificationcode);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_PERSONALCREATEUSER, param, callBack);
        L.d(SERVER_PERSONALCREATEUSER);
    }


    public static void fetch_personalreset(RequestCallBack callBack, String msgkey, String verificationcode, String areacode, String phone, String newpwd) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", "");
        map.put("msgkey", msgkey);
        map.put("verificationcode", verificationcode);
        map.put("areacode", areacode);
        map.put("phone", phone);
        map.put("newpwd", newpwd);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_PERSONALRESET, param, callBack);
        L.d(SERVER_PERSONALRESET);
    }

    public static void fetch_personalupdatepwd(RequestCallBack callBack, String loginkey, String msgkey, String verificationcode, String newpwd) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("msgkey", msgkey);
        map.put("verificationcode", verificationcode);
        map.put("newpwd", newpwd);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_PERSONALUPDATEPWD, param, callBack);
        L.d(SERVER_PERSONALUPDATEPWD);
    }

    public static void fetch_personalupuserphoto(RequestCallBack callBack, String loginkey, String picBase64) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("picdata", picBase64);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_PERSONALUPUSEPHOTO, param, callBack);
        L.d(SERVER_PERSONALUPUSEPHOTO);
    }


    public static void fetch_personaotheruinfo(RequestCallBack callBack, String loginkey, String userGUID) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("userGUID", userGUID);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_PERSONALOTHERUINFO, param, callBack);
        L.d(SERVER_PERSONALOTHERUINFO);
    }

    public static void fetch_personaldeladdress(RequestCallBack callBack, String loginkey, String addressID) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("addressID", addressID);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_PERSONALDELADDRESS, param, callBack);
        L.d(SERVER_PERSONALDELADDRESS);
    }


    public static void fetch_personaladdaddress(RequestCallBack callBack, String loginkey,
                                                String consigneeName, String consigneePhone, String postalCode, String consigneeProvince, String consigneeCity, String consigneeAddress) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("consigneeName", consigneeName);
        map.put("consigneePhone", consigneePhone);
        map.put("postalCode", postalCode);
        map.put("consigneeProvince", consigneeProvince);
        map.put("consigneeCity", consigneeCity);
        map.put("consigneeAddress", consigneeAddress);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_PERSONALADDADDRESS, param, callBack);
        L.d(SERVER_PERSONALADDADDRESS);
    }


    public static void fetch_personalupdateaddress(RequestCallBack callBack, String loginkey,
                                                   String consigneeName, String consigneePhone, String postalCode, String addressID, String consigneeProvince, String consigneeCity, String consigneeAddress) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("consigneeName", consigneeName);
        map.put("consigneePhone", consigneePhone);
        map.put("postalCode", postalCode);
        map.put("addressID", addressID);
        map.put("consigneeProvince", consigneeProvince);
        map.put("consigneeCity", consigneeCity);
        map.put("consigneeAddress", consigneeAddress);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_PERSONALUPDATEADDRESS, param, callBack);
        L.d(SERVER_PERSONALUPDATEADDRESS);
    }


    public static void fetch_personaldefaultaddress(RequestCallBack callBack, String loginkey, String addressID) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("addressID", addressID);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_PERSONALDEFAULTADDRESS, param, callBack);
        L.d(SERVER_PERSONALDEFAULTADDRESS);
    }


    public static void fetch_sxmsglastmsglist(RequestCallBack callBack, String loginkey, String LinkManUserGUID, String needRowCount) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("LinkManUserGUID", LinkManUserGUID);
        map.put("needRowCount", needRowCount);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_SXMSGLASTMSGLIST, param, callBack);
        L.d(SERVER_SXMSGLASTMSGLIST);
    }

    public static void fetch_sxmsglinkman(RequestCallBack callBack, String loginkey, int pageSize, int goPage) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("pageSize", String.valueOf(pageSize));
        map.put("goPage", String.valueOf(goPage));
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_SXMSGSXLINKMAN, param, callBack);
        L.d(SERVER_SXMSGSXLINKMAN);
    }

    public static void fetch_sxmsgbackwardmsg(RequestCallBack callBack, String loginkey, String LinkManUserGUID, int sitMessageID, int needRowCount) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("LinkManUserGUID", LinkManUserGUID);
        map.put("sitMessageID", String.valueOf(sitMessageID));
        map.put("needRowCount", String.valueOf(needRowCount));
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_SXMSGBACKWARDMSG, param, callBack);
        L.d(SERVER_SXMSGBACKWARDMSG);
    }

    public static void fetch_sxmsgsendmsg(RequestCallBack callBack, String loginkey, String receiveUserGUID, String nr) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("receiveUserGUID", receiveUserGUID);
        map.put("nr", nr);
        RequestParams param = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, SERVER_SXMSGSENDMSG, param, callBack);
        L.d(SERVER_SXMSGSENDMSG);
    }


    public static void payOrder(RequestCallBack callBack,String loginkey, int orderID, int djorwk) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("orderID", String.valueOf(orderID));
        map.put("djorwk", String.valueOf(djorwk));
        RequestParams params = fetch_wraper(map);

        httpUtils.send(HttpRequest.HttpMethod.POST, ProtocolUtil.GETORDERPAYINFO_URL, params, callBack);
        L.d(GETORDERPAYINFO_URL);
    }


    public static void canOrNotAddShopping(RequestCallBack callBack,String loginkey, String goodsPackID ) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("goodsPackID", goodsPackID);
        RequestParams params = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, ProtocolUtil.CanOrNotAddShopping_URL, params, callBack);
        L.d(CanOrNotAddShopping_URL);
    }


    public static void addShoppingRequet(RequestCallBack callBack,String loginkey, String goodsPackID,String goodsNum ) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("goodsPackID", goodsPackID);
        map.put("sl", goodsNum);
        RequestParams params = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, ProtocolUtil.AddShoppingGoods_URL, params, callBack);
        L.d(AddShoppingGoods_URL);
    }
//查询购物车列表
    public static void queryShoppingCartRequet(RequestCallBack callBack,String loginkey ) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        RequestParams params = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, ProtocolUtil.QueryShoppingCart_URL, params, callBack);
        L.d(QueryShoppingCart_URL);
    }

    public static void addShoppingCartItem(RequestCallBack callBack,String loginkey,String goodsPackID,String sl  ) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("goodsPackID", goodsPackID);
        map.put("sl", sl);
        RequestParams params = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, ProtocolUtil.AddShoppingCartItem_URL, params, callBack);
        L.d(AddShoppingCartItem_URL);
    }
    public static void deleteShoppingCartItem(RequestCallBack callBack,String loginkey,String goodsPackID  ) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("goodsPackID", goodsPackID);
        RequestParams params = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, ProtocolUtil.DeleteShoppingCartItem_URL, params, callBack);
        L.d(DeleteShoppingCartItem_URL);
    }
    public static void IfByMore(RequestCallBack callBack,String loginkey,String dataInfo  ) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("datainfo", dataInfo);
        RequestParams params = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, ProtocolUtil.IfByMore_URL, params, callBack);
        L.d(IfByMore_URL);
    }

    public static void obtainCouponList(RequestCallBack callBack,String loginkey,String goodPackId  ) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("goodsPackID", goodPackId);
        RequestParams params = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, ProtocolUtil.Obtain_Coupon_List_URL, params, callBack);
        L.d(Obtain_Coupon_List_URL);
    }

    public static void convertCoupon(RequestCallBack callBack,String loginkey,String getCode) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("getCode", getCode);
        RequestParams params = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, ProtocolUtil.Convert_Coupon_URL, params, callBack);
        L.d(Convert_Coupon_URL);
    }


    public static void convertAllCoupon(RequestCallBack callBack,String loginkey,String pageSize,String goPage ) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("couponUseRange", "-1");
        map.put("couponState", "-1");
        map.put("pageSize", pageSize);
        map.put("goPage", goPage);
        RequestParams params = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, ProtocolUtil.Convert_All_Coupon_URL, params, callBack);
        L.d(Convert_All_Coupon_URL);
    }


    public static void createOrder(RequestCallBack callBack,String loginkey,String dataInfo,String addressID ) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("datainfo", dataInfo);
        map.put("addressID", addressID);
        RequestParams params = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, ProtocolUtil.Create_Order_URL, params, callBack);
        L.d(Create_Order_URL);
    }


    public static void getShoppingNum(RequestCallBack callBack,String loginkey ) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        RequestParams params = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST, ProtocolUtil.Get_Shopping_Items_Num_URL, params, callBack);
        L.d(Get_Shopping_Items_Num_URL);
    }


    public static void delOrderWithvorderNu(RequestCallBack callBack,String loginkey,String vorderNu ) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("vorderNu", vorderNu);
        RequestParams params = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST,ProtocolUtil.Del_Order_With_VirNo_URL, params, callBack);
        L.d(Del_Order_With_VirNo_URL);
    }


    public static void getOderListWithvorderNu(RequestCallBack callBack,String loginkey,String vorderNu ) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("vorderNu", vorderNu);
        RequestParams params = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST,ProtocolUtil.Get_Order_List_VirNo_URL, params, callBack);
        L.d(Get_Order_List_VirNo_URL);
    }


    public static void getOrderPayInfoWithvorderNu(RequestCallBack callBack,String loginkey,String vorderNu ) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("vorderNu", vorderNu);
        RequestParams params = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST,ProtocolUtil.Get_Order_Info_VirNo_URL, params, callBack);
        L.d(Get_Order_Info_VirNo_URL);
    }


    public static void updateOrderAddressWithvorderNu(RequestCallBack callBack,String loginkey,String vorderNu ,String addrId) {
        HttpUtils httpUtils = new HttpUtils();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginkey", loginkey);
        map.put("vorderNu", vorderNu);
        map.put("addressID", addrId);
        RequestParams params = fetch_wraper(map);
        httpUtils.send(HttpRequest.HttpMethod.POST,ProtocolUtil.Update_Order_Adrr_With_VirNo_URL, params, callBack);
        L.d(Update_Order_Adrr_With_VirNo_URL);
    }

}
