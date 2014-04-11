package dontCare.gf.gwt.client.util;

import javax.swing.event.ChangeEvent;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.user.client.ui.ListBox;

public class ListBoxUtil {
	/**
	 * @param listBox
	 * @return 回傳 {@link ListBox#getSelectedIndex()} 對應的 item 值
	 */
	public static String selectedItem(ListBox listBox) {
		return listBox.getItemText(listBox.getSelectedIndex());
	}
	
	/**
	 * @param listBox
	 * @return 回傳 {@link ListBox#getSelectedIndex()} 對應的 value 值
	 */
	public static String selectedValue(ListBox listBox) {
		return listBox.getValue(listBox.getSelectedIndex());
	}
	
	/**
	 * 讓 ListBox 自動發出 {@link ChangeEvent}（觸發 {@link ChangeHandler}）。
	 * {@link ListBox#getSelectedIndex()} 會是目前的值、沒有變動過。
	 * @param listBox
	 */
	public static void fireChangeEvent(ListBox listBox) {
		DomEvent.fireNativeEvent(Document.get().createChangeEvent(), listBox);
	}
}