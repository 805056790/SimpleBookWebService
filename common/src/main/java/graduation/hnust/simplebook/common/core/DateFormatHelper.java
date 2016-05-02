/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.common.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author  : panxin109@gmail.com
 * Date    : 12:16 PM 4/30/16
 */
public class DateFormatHelper {

    private static SimpleDateFormat DEFAULT_FORMAT = new SimpleDateFormat("");

    private String defaultFormat = "yyyy-MM-dd";

    public static DateFormatHelper defaultDateFormat(){
        return new DateFormatHelper(new SimpleDateFormat());
    }

    public DateFormatHelper(SimpleDateFormat sdf) {

    }

    /**
     * 日期转换为字符串
     *
     * @param date 日期
     * @return 格式化后的字符串
     */
    public static String defaultDate2String(Date date) {
        return DEFAULT_FORMAT.format(date);
    }

}
