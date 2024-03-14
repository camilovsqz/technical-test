package com.capitole.technicaltest.application.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class DateUtil.
 * Used by Fomat Date response
 */
public final class DateUtil {
	
	/**
	 * Date to string format.
	 *
	 * @param value the value
	 * @return the string
	 */
	public static String dateToStringFormat(Date value) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(value);
	}
}
