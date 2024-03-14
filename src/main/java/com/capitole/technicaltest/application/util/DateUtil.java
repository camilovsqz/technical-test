package com.capitole.technicaltest.application.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {
	public static String dateToStringFormat(Date value) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(value);
	}
}
