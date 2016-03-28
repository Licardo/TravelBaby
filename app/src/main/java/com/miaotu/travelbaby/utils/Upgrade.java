package com.miaotu.travelbaby.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import la.ruru.ui.MainApplication;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiao
 * Date: 13-9-28
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
public class Upgrade {



    private static final int DOWNLOAD = 1;
    private static final int DOWNLOAD_FINISH = 2;
    private static final int CONNECT_FAILED = 0;
    private static final int CONNECT_SUCCESS = 1;
    HashMap<String, String> mHashMap;

    private int progress;
    private boolean cancelUpdate = false;
    private Context mContext;
    private boolean showTips = false;
    private ProgressBar mProgress;

    private Dialog mDownloadDialog;


    public Upgrade(Context context, boolean showTips) {
        this.mContext = context;
        this.showTips = showTips;

    }


    /**
     * 检查更新
     */
    public void checkUpdate() {
        if (!ConfigUtil.isNetworkConnected(mContext)) {
            if (showTips) {
                Toast.makeText(mContext, "没有联网！", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, ProtocolUtil.versionXmlPath, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> objectResponseInfo) {
                Log.d(MainApplication.Tag, objectResponseInfo.toString());
                String xml = objectResponseInfo.result;
                Log.d(MainApplication.Tag, xml);
                try {
                    mHashMap = parseXmlString(xml);
                    Log.d(MainApplication.Tag, mHashMap.toString());
                    Message msg = new Message();
                    msg.what = CONNECT_SUCCESS;
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    L.e(e.getMessage(),e);
                    Message msg = new Message();
                    msg.what = CONNECT_FAILED;
                    handler.sendMessage(msg);
                }

            }

            @Override
            public void onFailure(HttpException e, String s) {

                Log.e(MainApplication.Tag, s, e);
                Toast.makeText(mContext, "访问服务器失败！", Toast.LENGTH_SHORT).show();
            }
        });

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(ConfigUtil.versionXmlPath);
                    HttpURLConnection conn = (HttpURLConnection) url
                            .openConnection();
                    conn.setConnectTimeout(2000);
                    InputStream inStream = conn.getInputStream();
                    mHashMap = parseXml(inStream);
                    Log.d(this.getClass().getName(), mHashMap.toString());
                    Message msg = new Message();
                    msg.what = CONNECT_SUCCESS;
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    L.e(e.getMessage(),e);
                    Message msg = new Message();
                    msg.what = CONNECT_FAILED;
                    handler.sendMessage(msg);
                }
            }
        }).run();*/
    }

    private HashMap<String, String> parseXml(InputStream inStream)
            throws Exception {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        // 实例化一个文档构建器工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // 通过文档构建器工厂获取一个文档构建器
        DocumentBuilder builder = factory.newDocumentBuilder();
        // 通过文档通过文档构建器构建一个文档实例
        Document document = builder.parse(inStream);
        // 获取XML文件根节点
        Element root = document.getDocumentElement();
        // 获得所有子节点
        NodeList childNodes = root.getChildNodes();
        for (int j = 0; j < childNodes.getLength(); j++) {
            // 遍历子节点
            Node childNode = (Node) childNodes.item(j);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) childNode;
                // 版本号
                if ("version".equals(childElement.getNodeName())) {
                    hashMap.put("version", childElement.getFirstChild()
                            .getNodeValue());
                }
                // 软件名称
                else if (("name".equals(childElement.getNodeName()))) {
                    hashMap.put("name", childElement.getFirstChild()
                            .getNodeValue());
                }
                // 下载地址
                else if (("url".equals(childElement.getNodeName()))) {
                    hashMap.put("url", childElement.getFirstChild()
                            .getNodeValue());
                }
            }
        }
        return hashMap;
    }

    private HashMap<String, String> parseXmlString(String xml)
            throws Exception {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        // 实例化一个文档构建器工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // 通过文档构建器工厂获取一个文档构建器
        DocumentBuilder builder = factory.newDocumentBuilder();
        // 通过文档通过文档构建器构建一个文档实例

        Document document = builder.parse( new ByteArrayInputStream(xml.getBytes("UTF-8")));
        // 获取XML文件根节点
        Element root = document.getDocumentElement();
        // 获得所有子节点
        NodeList childNodes = root.getChildNodes();
        for (int j = 0; j < childNodes.getLength(); j++) {
            // 遍历子节点
            Node childNode = (Node) childNodes.item(j);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) childNode;
                // 版本号
                if ("version".equals(childElement.getNodeName())) {
                    hashMap.put("version", childElement.getFirstChild()
                            .getNodeValue());
                }
                // 软件名称
                else if (("name".equals(childElement.getNodeName()))) {
                    hashMap.put("name", childElement.getFirstChild()
                            .getNodeValue());
                }
                // 下载地址
                else if (("url".equals(childElement.getNodeName()))) {
                    hashMap.put("url", childElement.getFirstChild()
                            .getNodeValue());
                }
            }
        }
        return hashMap;
    }


    /**
     * 访问服务器更新XML
     */
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case CONNECT_FAILED:
                    if (showTips) {
                        Toast.makeText(mContext, "访问服务器失败！", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case CONNECT_SUCCESS:
                    if (null != mHashMap) {
                        int serviceCode = Integer.valueOf(mHashMap.get("version"));
                        if (serviceCode > getVersionCode(mContext)) {
                            showNoticeDialog();
                        } else {
                            if (showTips) {
                                Toast.makeText(mContext, "您当前已经是最新版本！", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    break;
            }
        }
    };

    /**
     * 获取程序版本号
     */
    private int getVersionCode(Context context) {
        int versionCode = 0;
        try {
            versionCode = context.getPackageManager().getPackageInfo(
                    mContext.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 是否更新提示窗口
     */
    private void showNoticeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("软件更新");
        builder.setMessage("检测到新版本，是否更新？");
        builder.setPositiveButton("更新",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        Uri uri = Uri.parse(mHashMap.get("url"));
                        Log.d(this.getClass().getName(), mHashMap.get("url"));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        mContext.startActivity(intent);
                    }
                });

        builder.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        Dialog noticeDialog = builder.create();
        noticeDialog.show();
    }


}
