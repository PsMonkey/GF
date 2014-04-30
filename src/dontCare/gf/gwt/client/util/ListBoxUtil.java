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
	 * 用 item 值設定 selected index。
	 * 
	 * <p><b>注意：不會觸發 change event</b></p>
	 * @param listBox
	 * @param itemValue
	 */
	public static void setByItem(ListBox listBox, String itemValue) {
		for (int i = 0; i < listBox.getItemCount(); i++) {
			if (listBox.getItemText(i).equals(itemValue)) {
				listBox.setSelectedIndex(i);
				return;
			}
		}
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