package com.thisisentropy.remarkablesdk;

import android.util.Log;

public final class RLog
{
    private static String tag = "REM";
    private static Boolean isLoggingEnabled = false;
    
    public static void v(String msg)
    {
        if (RLog.isLoggingEnabled())
            Log.v(tag, msg);
    }

    public static void d(String msg)
    {
        if (RLog.isLoggingEnabled())
            Log.d(tag, msg);
    }

    public static void i(String msg)
    {
        if (RLog.isLoggingEnabled())
            Log.i(tag, msg);
    }

    public static void w(String msg)
    {
        if (RLog.isLoggingEnabled())
            Log.w(tag, msg);
    }

    public static void e(String msg)
    {
        if (RLog.isLoggingEnabled())
            Log.e(tag, msg);
    }

    public static Boolean isLoggingEnabled() {
        return isLoggingEnabled;
    }

    public static void setIsLoggingEnabled(Boolean isLogging) {
        isLoggingEnabled = isLogging;
    }

}