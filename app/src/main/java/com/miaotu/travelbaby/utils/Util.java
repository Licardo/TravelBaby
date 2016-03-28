package com.miaotu.travelbaby.utils;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.net.Uri;

import android.content.Context;
import android.text.TextUtils;

import org.apache.http.util.EncodingUtils;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 13-10-30
 * Time: 下午2:53
 * To change this template use File | Settings | File Templates.
 */
public class Util {
    /**
     * will trim the string
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        if (null == s)
            return true;
        if (s.length() == 0)
            return true;
        if (s.trim().length() == 0)
            return true;
        return false;
    }

    // 校验Tag Alias 只能是数字,英文字母和中文
    public static boolean isValidTagAndAlias(String s) {
        Pattern p = Pattern.compile("^[\u4E00-\u9FA50-9a-zA-Z_-]{0,}$");
        Matcher m = p.matcher(s);
        return m.matches();
    }


    public static String numToNumCH(int num) {
        String numCh = "";
        if (num == 1) {
            numCh = "一";
        } else if (num == 2) {
            numCh = "二";
        } else if (num == 3) {
            numCh = "三";
        } else if (num == 4) {
            numCh = "四";
        }
        return numCh;
    }


    public static boolean isGB2312(String str) {
        char[] chars = str.toCharArray();
        boolean isGB2312 = false;
        for (int i = 0; i < chars.length; i++) {
            byte[] bytes = ("" + chars[i]).getBytes();
            if (bytes.length == 2) {
                int[] ints = new int[2];
                ints[0] = bytes[0] & 0xff;
                ints[1] = bytes[1] & 0xff;
                if (ints[0] >= 0x81 && ints[0] <= 0xFE && ints[1] >= 0x40 && ints[1] <= 0xFE) {
                    isGB2312 = true;
                    break;
                }
            }
        }
        return isGB2312;
    }

    public static boolean isGB2312_byRegex(String value) {
        boolean result = false;
        boolean isGB2312 = false;
        for (int i = 0; i < value.length(); i++) {
            String sub = value.substring(i, i + 1);
            isGB2312 = Pattern.matches("[\u4E00-\u9FA5]", sub);
            if (isGB2312) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void makeDir(String DIR_NAME) {
        File dir = new File(DIR_NAME);
        if (!dir.exists()) {
            dir.mkdirs();
        } else {
            //	dir.delete();
        }
    }

    /**
     * 复制单个文件
     *
     * @param srcFileName  待复制的文件名
     * @param destFileName 目标文件名
     * @param overlay      如果目标文件存在，是否覆盖
     * @return 如果复制成功返回true，否则返回false
     */
    public static boolean copyFile(String srcFileName, String destFileName,
                                   boolean overlay) {
        File srcFile = new File(srcFileName);

        // 判断源文件是否存在
        if (!srcFile.exists()) {

            return false;
        } else if (!srcFile.isFile()) {

            return false;
        }

        // 判断目标文件是否存在
        File destFile = new File(destFileName);
        if (destFile.exists()) {
            // 如果目标文件存在并允许覆盖
            if (overlay) {
                // 删除已经存在的目标文件，无论目标文件是目录还是单个文件
                new File(destFileName).delete();
            }
        } else {
            // 如果目标文件所在目录不存在，则创建目录
            if (!destFile.getParentFile().exists()) {
                // 目标文件所在目录不存在
                if (!destFile.getParentFile().mkdirs()) {
                    // 复制文件失败：创建目标文件所在目录失败
                    return false;
                }
            }
        }

        // 复制文件
        int byteread = 0; // 读取的字节数
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(srcFile);
            out = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];

            while ((byteread = in.read(buffer)) != -1) {
                out.write(buffer, 0, byteread);
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        } finally {
            try {
                if (out != null)
                    out.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 复制整个目录的内容
     *
     * @param srcDirName  待复制目录的目录名
     * @param destDirName 目标目录名
     * @param overlay     如果目标目录存在，是否覆盖
     * @return 如果复制成功返回true，否则返回false
     */
    public static boolean copyDirectory(String srcDirName, String destDirName,
                                        boolean overlay) {
        // 判断源目录是否存在
        File srcDir = new File(srcDirName);
        if (!srcDir.exists()) {
            return false;
        } else if (!srcDir.isDirectory()) {

            return false;
        }

        // 如果目标目录名不是以文件分隔符结尾，则加上文件分隔符
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        File destDir = new File(destDirName);
        // 如果目标文件夹存在
        if (destDir.exists()) {
            // 如果允许覆盖则删除已存在的目标目录
            if (overlay) {
                new File(destDirName).delete();
            } else {

                return false;
            }
        } else {
            // 创建目的目录
            System.out.println("目的目录不存在，准备创建。。。");
            if (!destDir.mkdirs()) {
                System.out.println("复制目录失败：创建目的目录失败！");
                return false;
            }
        }

        boolean flag = true;
        File[] files = srcDir.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 复制文件
            if (files[i].isFile()) {
                flag = copyFile(files[i].getAbsolutePath(),
                        destDirName + files[i].getName(), overlay);
                if (!flag)
                    break;
            } else if (files[i].isDirectory()) {
                flag = copyDirectory(files[i].getAbsolutePath(),
                        destDirName + files[i].getName(), overlay);
                if (!flag)
                    break;
            }
        }
        if (!flag) {

            return false;
        } else {
            return true;
        }
    }

    /**
     * @param path
     * @param fileList 注意的是并不是所有的文件夹都可以进行读取的，权限问题
     */

    public static void getFileList(File path, ArrayList<String> fileList) {
        //如果是文件夹的话
        if (path.exists()) {
            if (path.isDirectory()) {
                //返回文件夹中有的数据
                File[] files = path.listFiles();
                //先判断下有没有权限，如果没有权限的话，就不执行了
                if (null == files)
                    return;

                for (int i = 0; i < files.length; i++) {
                    getFileList(files[i], fileList);
                }
            }
            //如果是文件的话直接加入
            else {

                //进行文件的处理
                String filePath = path.getAbsolutePath();
                //文件名
                String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
                //添加
                fileList.add(fileName);
            }
        }
    }


    public static boolean checkEmail(String email) {

        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(email);
        return m.find();
    }

    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPhone(String phone) {
        if (phone.length() >= 11) {
            return isNumeric(phone);
        } else {
            return false;
        }
    }

    //浮点型判断
    public static boolean isDecimal(String str) {
        if (str == null || "".equals(str))
            return false;
        Pattern pattern = Pattern.compile("[0-9]*(\\.?)[0-9]*");
        return pattern.matcher(str).matches();
    }

    //整型判断
    public static boolean isInteger(String str) {
        if (str == null)
            return false;
        Pattern pattern = Pattern.compile("[0-9]+");
        return pattern.matcher(str).matches();
    }


    public static boolean checkQQ(String val) {

        boolean result = false;
        if (val.length() < 6 || val.length() > 25) {
            result = false;
            return result;
        }
        result = isNumber(val);
        return result;
    }

    public static boolean isNumber(String args) {

        return args.matches("-?\\d+\\.?\\d*");

    }

    public static boolean isIp(String s) {
        String regex0 = "(2[0-4]\\d)" + "|(25[0-5])";
        String regex1 = "1\\d{2}";
        String regex2 = "[1-9]\\d";
        String regex3 = "\\d";
        String regex = "(" + regex0 + ")|(" + regex1 + ")|(" + regex2 + ")|(" + regex3 + ")";
        regex = "(" + regex + ").(" + regex + ").(" + regex + ").(" + regex + ")";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        return m.matches();
    }


    public static String replaceBlank(String source) {
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(source);
        return m.replaceAll("");
    }

    /**
     * 递归删除文件和文件夹
     *
     * @param file 要删除的根目录
     */
    public static void RecursionDeleteFile(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] childFile = file.listFiles();
            if (childFile == null || childFile.length == 0) {
                file.delete();
                return;
            }
            for (File f : childFile) {
                RecursionDeleteFile(f);
            }
            file.delete();
        }
    }

    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) { // 判断文件是否存在
            if (file.isFile()) { // 判断是否是文件
                file.delete(); // delete()方法 你应该知道 是删除的意思;
            }
        }
    }

    public static boolean writeStrigToFile(String res, String filePath) {
        deleteFile(filePath);
        Boolean result = false;
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(res);
            bw.close();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        }
        return result;
    }

    //读文件
    public static String readSDFile(String fileName) {
        String res = "";
        File file = new File(fileName);
        if (!file.exists()) {
            return res;
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            int length = fis.available();

            byte[] buffer = new byte[length];
            fis.read(buffer);

            res = EncodingUtils.getString(buffer, "UTF-8");

            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }


    public static String inputStream2String(InputStream in) throws IOException {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        int n;
        while ((n = in.read(b)) != -1) {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }

    public static String inputStream2StringEx(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i = -1;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        return baos.toString();
    }


    public static byte[] InputStreamToByte(InputStream is) throws IOException {
        ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
        int ch;
        while ((ch = is.read()) != -1) {
            bytestream.write(ch);
        }
        byte imgdata[] = bytestream.toByteArray();
        bytestream.close();
        return imgdata;
    }


    /**
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    public final static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertEncrypt(String inStr) {

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * Takes the raw bytes from the digest and formats them correct.
     *
     * @param bytes the raw bytes from the digest.
     * @return the formatted bytes.
     */

    private static String getFormattedText(byte[] bytes) {

        int len = bytes.length;

        StringBuilder buf = new StringBuilder(len * 2);

        // 把密文转换成十六进制的字符串形式

        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);

            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);

        }

        return buf.toString();

    }


    public static String encodeSHA1(String str) {
        if (str == null) {
            return null;
        }

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static String toRmb(double v) {
        NumberFormat nf = new DecimalFormat("￥0.00");

        String str = nf.format(v);

        return str;
    }

    public static void sortParam() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("d", "ddddd");
        map.put("b", "bbbbb");
        map.put("a", "aaaaa");
        map.put("phone", "13545");
        map.put("photo", "photo");

        //这里将map.entrySet()转换成list
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            //升序排序
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }

        });

        for (Map.Entry<String, String> mapping : list) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }
    }


    public static String genSign(Map<String, String> map) {
        String result = "";

        //这里将map.entrySet()转换成list
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            //升序排序
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }

        });

//        for(Map.Entry<String,String> mapping:list){
//            System.out.println(mapping.getKey()+":"+mapping.getValue());
//        }

        for (Map.Entry<String, String> mapping : list) {
            String newval = mapping.getValue();
//            try {
//                newval = URLEncoder.encode(newval, "UTF-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//
//            }

            result = result + newval;
        }
        result = result + "amdsdfwrer21aaf";
        System.out.println("--------------");
        System.out.println(result);
        result = Util.MD5(result);
        System.out.println(result);
        return result;
    }


    public static void test() {
        Map<String, String> map = new LinkedHashMap<String, String>();
//        LabelIDs
//        appid	mAPP01
//        goPage	0
//        keyword	你的
//        loginkey
//        pageSize	10
//        time	20150910120005
//        userGUID
//        sign	c906f0b8a60c3e63739e840629405e3e

        map.put("LabelIDs", "");
        map.put("goPage", "0");
        map.put("keyword", "你的");
        map.put("loginkey", "");
        map.put("pageSize", "10");
        String timeStr = "20150910120005";
        map.put("appid", "mAPP01");
        map.put("time", timeStr);
        map.put("sign", genSign(map));


        for (String key : map.keySet()) {
            String newval = map.get(key);
//            if ((!key.equals("appid")) && (!key.equals("time")) && (!key.equals("sign"))) {
//                try {
//                    newval = URLEncoder.encode(newval, "UTF-8");
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//            }
            System.out.println(key + " " + newval);
        }
    }


    public static void main(String[] args) throws Exception {
        String s = "123456";
        System.out.println("原始：" + s);
        System.out.println("MD5后：" + string2MD5(s));
//        System.out.println("加密的：" + convertEncrypt(s));
//        System.out.println("解密的：" + convertEncrypt(convertEncrypt(s)));
//
//        System.out.println(encodeSHA1("123456"));
//        System.out.println(encodeSHA1("**123456"));
//        System.out.println(encodeSHA1("123456--"));
//        System.out.println(encodeSHA1("abcdefghigk"));
//
//        System.out.println("------\n");
//        String content = "123456";

//        System.out.println(string2MD5(s));

//        toRmb(40);
//        URLEncoder.encode()
//        System.out.println(URLEncoder.encode("你的", "UTF-8"));
//        System.out.println(URLEncoder.encode("你的", "GB2312"));
//        System.out.println(URLEncoder.encode("你的", "GBK"));


//        System.out.println(Util.string2MD5("mAPP01" +"86"+"f4a95052-1ba1-465b-9ba0-ec582dd39a1c"+"13545218594"+"123321" + "20150908050814" +"lele2015"+"1657"+ "amdsdfwrer21aaf"));
//        sortParam();

        test();

        System.out.println(Util.string2MD5("mAPP010你的1020150910120005amdsdfwrer21aaf"));
        System.out.println(Util.MD5("mAPP010你的1020150910120005amdsdfwrer21aaf"));
    }


//    mAPP0100你的2015091018122221a2d1-6d60-40bf-b3cb-b144d087fc4b1020150910101455amdsdfwrer21aaf
//    mAPP010你的2015091018122221a2d1-6d60-40bf-b3cb-b144d087fc4b1020150910101455amdsdfwrer21aaf






    /**
     * Get device information json string for testing device register on umeng.
     *
     * @param context
     * @return deviceInfo json string
     */
    public static String getDeviceInfo(Context context) {
        try {
            final android.telephony.TelephonyManager tm = (android.telephony.TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            String device_id = tm.getDeviceId();
            final android.net.wifi.WifiManager wifi = (android.net.wifi.WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            final String mac = wifi.getConnectionInfo().getMacAddress();
            if (TextUtils.isEmpty(device_id)) {
                device_id = mac;
            }
            if (TextUtils.isEmpty(device_id)) {
                device_id = android.provider.Settings.Secure.getString(context.getContentResolver(),
                        android.provider.Settings.Secure.ANDROID_ID);
            }
            return device_id;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
