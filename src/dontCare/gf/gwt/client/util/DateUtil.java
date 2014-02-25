package dontCare.gf.gwt.client.util;

import java.util.Date;

@SuppressWarnings("deprecation")
public class DateUtil {
	//TODO 增加預設的 date format
	private static final long HOUR_MS = 60L * 60L * 1000L;
	private static final long DAY_MS = 24L * HOUR_MS;
	
	/**
	 * @param date
	 * @return 當天 00:00:00 的時間。
	 */
	public static Date dayBegin(Date date) {
		Date result = clone(date);
		result.setHours(0);
		result.setMinutes(0);
		result.setSeconds(0);
		return result;
	}
	
	/**
	 * @param date
	 * @return 當天 23:59:59 的時間。
	 */
	public static Date dayEnd(Date date) {
		Date result = clone(date);
		result.setHours(23);
		result.setMinutes(59);
		result.setSeconds(59);
		return result;
	}
	
	public static Date nextDay(Date date) {
		return new Date(date.getTime() + DAY_MS);
	}
	
	public static boolean isTheSameDay(Date d1, Date d2) {
		return d1.getYear() == d2.getYear() 
				&& d1.getMonth() == d2.getMonth() 
				&& d1.getDate() == d2.getDate();
	}
	
	public static Date clone(Date date) {
		return new Date(date.getTime());
	}
}