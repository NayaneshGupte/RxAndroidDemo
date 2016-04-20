package com.technosavy.rxandroiddemo.Utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 */
public class DateTimeUtil {

    private static final String TAG = DateTimeUtil.class.getSimpleName();

    /**
     * Convert formatted date to long timedtamp for comparison
     *
     * @param dateString
     * @return date converted in timestamp
     */
    public static long convertDatetToTimeStamp(String dateString) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SS'Z'", Locale.ENGLISH);
        Date convertedDate;
        try {
            convertedDate = sdf.parse(dateString);

            return convertedDate.getTime();

        } catch (ParseException e) {

            Log.e(TAG, e.getMessage());

        }

        return 0;
    }

    public static String getFormatedDate(String strDate) {

        SimpleDateFormat df;
        df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SS'Z'");
        Date date = null;
        try {
            date = df.parse(strDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        df = new SimpleDateFormat("yy-MM-dd HH:mm");
        return df.format(date);

    }
}
