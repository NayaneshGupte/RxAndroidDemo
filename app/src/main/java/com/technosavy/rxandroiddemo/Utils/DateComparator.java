package com.technosavy.rxandroiddemo.Utils;


import com.technosavy.rxandroiddemo.model.BaseModel;
import com.technosavy.rxandroiddemo.model.issues.Issue;

import java.util.Comparator;

/**
 * Date comparator to compare dates on most updated (Ascending order) basis.
 */
public class DateComparator implements Comparator<BaseModel> {


    @Override
    public int compare(BaseModel lhs, BaseModel rhs) {

        long date1 = DateTimeUtil.convertDatetToTimeStamp(lhs.getUpdatedAt());

        long date2 = DateTimeUtil.convertDatetToTimeStamp(rhs.getUpdatedAt());

        if (date1 > date2) {

            return 1;
        } else if (date1 < date2) {

            return -1;
        }


        return 0;
    }
}
