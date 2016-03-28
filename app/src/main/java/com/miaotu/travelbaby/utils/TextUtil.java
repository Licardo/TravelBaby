package com.miaotu.travelbaby.utils;

import android.content.Context;
import android.text.ClipboardManager;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtil {

	public static String replaceHtml(String html, String tag) {
		Pattern p = Pattern.compile(tag);
		Matcher m = p.matcher(html);
		String s = m.replaceAll("");
		return s;
	}

	public static String getOnlyNumStr(String str) {
		String regEx = "[^0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return (m.replaceAll("").trim());
	}

	public static String delHTMLTag(String htmlStr) {
		String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
		String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
		String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

		Pattern p_script = Pattern.compile(regEx_script,
				Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(""); // 过滤script标签

		Pattern p_style = Pattern
				.compile(regEx_style, Pattern.CASE_INSENSITIVE);
		Matcher m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll(""); // 过滤style标签

		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(htmlStr);
		htmlStr = m_html.replaceAll(""); // 过滤html标签
		return htmlStr; // 返回文本字符串
	}

	/**
	 * 判断给定字符串是否空白串。<br>
	 * 空白串是指由空格、制表符、回车符、换行符组成的字符串<br>
	 * 若输入字符串为null或空字符串，返回true
	 * 
	 * @param input
	 * @return boolean
	 */
	public static boolean isBlank(String input) {
		if (input == null || "".equals(input))
			return true;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
				return false;
			}
		}
		return true;
	}

	public static void testCharset(String datastr) {
		try {
			String temp = new String(datastr.getBytes(), "GBK");
			LogUtil.v("****** getBytes() -> GBK ******/n" + temp);
			temp = new String(datastr.getBytes("GBK"), "UTF-8");
			LogUtil.v("****** GBK -> UTF-8 *******/n" + temp);
			temp = new String(datastr.getBytes("GBK"), "ISO-8859-1");
			LogUtil.v("****** GBK -> ISO-8859-1 *******/n" + temp);
			temp = new String(datastr.getBytes("ISO-8859-1"), "UTF-8");
			LogUtil.v("****** ISO-8859-1 -> UTF-8 *******/n" + temp);
			temp = new String(datastr.getBytes("ISO-8859-1"), "GBK");
			LogUtil.v("****** ISO-8859-1 -> GBK *******/n" + temp);
			temp = new String(datastr.getBytes("UTF-8"), "GBK");
			LogUtil.v("****** UTF-8 -> GBK *******/n" + temp);
			temp = new String(datastr.getBytes("UTF-8"), "ISO-8859-1");
			LogUtil.v("****** UTF-8 -> ISO-8859-1 *******/n" + temp);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 作者: peijiangping<BR>
	 * 时间:2013-1-7下午2:45:33<BR>
	 * 功能:全角转半角<BR>
	 * 返回值:String<BR>
	 */
	public static final String QBchange(String QJstr) {
		StringBuffer outStrBuf = new StringBuffer("");
		String Tstr = "";
		try {
			byte[] b = null;
			for (int i = 0; i < QJstr.length(); i++) {
				Tstr = QJstr.substring(i, i + 1);
				if (Tstr.equals(" ")) {
					// 半角空格
					outStrBuf.append(Tstr);
					continue;
				}
				b = Tstr.getBytes("unicode");
				if (b[2] == 0) {
					// 半角?
					b[3] = (byte) (b[3] - 32);
					b[2] = -1;
					outStrBuf.append(new String(b, "unicode"));
				} else {
					outStrBuf.append(Tstr);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outStrBuf.toString();

	}

	/**
	 * 作者: peijiangping<BR>
	 * 时间:2013-1-7下午2:46:03<BR>
	 * 功能:半角转全角<BR>
	 * 返回值:String<BR>
	 */
	public static final String BQchange(String QJstr, String code) {
		String outStr = "";
		String Tstr = "";
		byte[] b = null;
		for (int i = 0; i < QJstr.length(); i++) {
			try {
				Tstr = QJstr.substring(i, i + 1);
				b = Tstr.getBytes(code);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if (b[3] != -1) {
				b[2] = (byte) (b[2] - 32);
				b[3] = -1;
				try {
					outStr = outStr + new String(b, code);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			} else
				outStr = outStr + Tstr;
		}
		return outStr;
	}

	public static boolean notNull(String str) {
		if (str != null && str.equals("") == false
				&& str.equals("null") == false) {
			return true;
		}
		return false;
	}

	/**
	 * 实现文本复制功能 add by wangqianzhou
	 * 
	 * @param content
	 */
	public static void copy(String content, Context context) {
		// 得到剪贴板管理器
		ClipboardManager cmb = (ClipboardManager) context
				.getSystemService(Context.CLIPBOARD_SERVICE);
		cmb.setText(content.trim());
	}

	/**
	 * 实现粘贴功能 add by wangqianzhou
	 * 
	 * @param context
	 * @return
	 */
	public static String paste(Context context) {
		// 得到剪贴板管理器
		ClipboardManager cmb = (ClipboardManager) context
				.getSystemService(Context.CLIPBOARD_SERVICE);
		return cmb.getText().toString().trim();
	}
	
}
