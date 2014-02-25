package dontCare.gf.gwt.client.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 跟 array、Collection 有關的 util。
 */
public class ArrayUtil {
	/**
	 * 將 List 轉換成 ArrayList。<br/>
	 * Objectify query 出來的 list 沒辦法直接給 GWT RPC，所以用這個來轉換。
	 */
	public static <T> ArrayList<T> convert(List<T> list){
		ArrayList<T> result = new ArrayList<T>();
		for(T t : list){
			result.add(t);
		}
		return result;
	}
	
	public static int indexOf(String[] source, String target) {
		if(source==null || target==null) {
			return -1;
		}
		int result = 0;
		for(String s : source) {
			if (target.equals(s)) {
				return result;
			}
			result++;
		}
		return -1;
	}
	
	public static String implode(List<?> list, String splitter) {
		if (list.size() == 0) { return "";};

		StringBuffer sb = new StringBuffer(list.get(0).toString());
		for (int i = 1; i < list.size(); i++) {
			sb.append(splitter);
			sb.append(list.get(i).toString());
		}
		return sb.toString();
	}
}