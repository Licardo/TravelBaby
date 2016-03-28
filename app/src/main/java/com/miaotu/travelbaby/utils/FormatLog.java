package com.miaotu.travelbaby.utils;

import android.util.Log;

import la.ruru.BuildConfig;


/**
 * Created by fan on 15/10/16.
 */
public final class FormatLog {
    /** 调试总开关 */
    public static final boolean DEBUG = BuildConfig.DEBUG;


    public static final boolean DEBUG_DEBUG = true;
    public static final boolean DEBUG_ERROR = true;
    public static final boolean DEBUG_INFO = true;
    public static final boolean DEBUG_VERBOSE = true;
    public static final boolean DEBUG_WARN = true;
    public static final boolean DEBUG_EXCEPT = true;

    private static final String FILE_TYPE = ".java";

    private enum LogLevel {
        DEBUG, ERROR, INFO, VERBOSE, WARN,
    }

    private FormatLog() {
    }

    /**
     * DEBUG信息输出
     *
     * @param aMessage
     *            输出信息
     */
    public static void d(String tag,String aMessage) {
        if (DEBUG && DEBUG_DEBUG) {
            doLog(tag, LogLevel.DEBUG, aMessage, 2, true, null);
        }
    }

    /**
     * DEBUG信息输出
     *
     * @param aMessage
     *            输出信息
     * @param aThrow
     *            输出异常
     */
    public static void d(String tag,String aMessage, Throwable aThrow) {
        if (DEBUG && DEBUG_DEBUG) {
            doLog(tag, LogLevel.DEBUG, aMessage, 2, true, aThrow);
        }
    }

    /**
     * ERROR信息输出
     *
     * @param aMessage
     *            输出信息
     */
    public static void e(String tag,String aMessage) {
        if (DEBUG && DEBUG_ERROR) {
            doLog(tag, LogLevel.ERROR, aMessage, 2, true, null);
        }
    }

    public static void e(String aMessage){
        if (DEBUG && DEBUG_ERROR) {
            doLog("App-Framework", LogLevel.ERROR, aMessage, 2, true, null);
        }
    }


    /**
     * ERROR信息输出
     *
     * @param aMessage
     *            输出信息
     * @param aThrow
     *            输出异常
     */
    public static void e(String tag,String aMessage, Throwable aThrow) {
        if (DEBUG && DEBUG_ERROR) {
            doLog(tag, LogLevel.ERROR, aMessage, 2, true, aThrow);
        }
    }

    /**
     * INFO信息输出
     *
     * @param aMessage
     *            输出信息
     */
    public static void i(String tag,String aMessage) {
        if (DEBUG && DEBUG_INFO) {
            doLog(tag, LogLevel.INFO, aMessage, 2, true, null);
        }
    }

    /**
     * INFO信息输出
     *
     * @param aMessage
     *            输出信息
     * @param aThrow
     *            输出异常
     */
    public static void i(String tag,String aMessage, Throwable aThrow) {
        if (DEBUG && DEBUG_INFO) {
            doLog(tag, LogLevel.INFO, aMessage, 2, true, aThrow);
        }
    }

    /**
     * VERBOSE信息输出
     *
     * @param aMessage
     *            输出信息
     */
    public static void v(String tag,String aMessage) {
        if (DEBUG && DEBUG_VERBOSE) {
            doLog(tag, LogLevel.VERBOSE, aMessage, 2, true, null);
        }
    }

    /**
     * VERBOSE信息输出
     *
     * @param aMessage
     *            输出信息
     * @param aThrow
     *            输出异常
     */
    public static void v(String tag,String aMessage, Throwable aThrow) {
        if (DEBUG && DEBUG_VERBOSE) {
            doLog(tag, LogLevel.VERBOSE, aMessage, 2, true, aThrow);
        }
    }

    /**
     * WARN信息输出
     *
     * @param aMessage
     *            输出信息
     */
    public static void w(String tag,String aMessage) {
        if (DEBUG && DEBUG_WARN) {
            doLog(tag, LogLevel.WARN, aMessage, 2, true, null);
        }
    }

    /**
     * WARN信息输出
     *
     * @param aMessage
     *            输出信息
     * @param aThrow
     *            输出异常
     */
    public static void w(String tag,String aMessage, Throwable aThrow) {
        if (DEBUG && DEBUG_WARN) {
            doLog(tag, LogLevel.WARN, aMessage, 2, true, aThrow);
        }
    }

    /**
     * Exception信息输出
     *
     * @param e
     *            输出异常
     */
    public static void printStackTrace(Exception e) {
        if (DEBUG && DEBUG_EXCEPT) {
            e.printStackTrace();
        }
    }

    private static void doLog(String tag,LogLevel aLevel, String aMessage,
                              int aStackTraceLevel, boolean aShowMethod, Throwable aThrow) {
        StackTraceElement stackTrace = (new Throwable()).getStackTrace()[aStackTraceLevel];
        String filename = stackTrace.getFileName();
        String methodname = stackTrace.getMethodName();
        int linenumber = stackTrace.getLineNumber();
        // 当心！proguard混淆以后getFileName会是一个null值！
        if ((filename != null) && filename.contains(FILE_TYPE)) {
            filename = filename.replace(FILE_TYPE, "");
        }

        String output = "";
        if (aShowMethod) {
            output = String.format("at (%s.java:%d)%s: %s", filename,
                    linenumber, methodname, aMessage);
        } else {
            output = String.format("at (%s.java:%d)%s", filename, linenumber,
                    aMessage);
        }

        switch (aLevel) {
            case DEBUG:
                if (aThrow == null) {
                    Log.d(tag, output);
                } else {
                    Log.d(tag, output, aThrow);
                }
                break;
            case ERROR:
                if (aThrow == null) {
                    Log.e(tag, output);
                } else {
                    Log.e(tag, output, aThrow);
                }
                break;
            case INFO:
                if (aThrow == null) {
                    Log.i(tag, output);
                } else {
                    Log.i(tag, output, aThrow);
                }
                break;
            case VERBOSE:
                if (aThrow == null) {
                    Log.v(tag, output);
                } else {
                    Log.v(tag, output, aThrow);
                }
                break;
            case WARN:
                if (aThrow == null) {
                    Log.w(tag, output);
                } else {
                    Log.w(tag, output, aThrow);
                }
                break;
            default:
                break;
        }
    }
}
