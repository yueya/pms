package com.yueya.common.util;

import java.sql.Timestamp;
import java.util.Date;

public class DateUtils {

    public static Timestamp getCurTimeStamp(){
        return new Timestamp(new Date().getTime());
    }
}
