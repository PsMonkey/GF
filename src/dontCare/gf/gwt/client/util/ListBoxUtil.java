package dontCare.gf.gwt.client.util;

import com.google.gwt.user.client.ui.ListBox;

public class ListBoxUtil {
	public static String selectedItem(ListBox lb) {
		return lb.getItemText(lb.getSelectedIndex());
	}
	
	public static String selectedValue(ListBox lb) {
		return lb.getValue(lb.getSelectedIndex());
	}
}
