package dontCare.gf.codeGenerator.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class CodeToString extends Composite {
	private static CodeToStringUiBinder uiBinder = GWT	.create(CodeToStringUiBinder.class);
	interface CodeToStringUiBinder extends UiBinder<Widget, CodeToString> {}

	public CodeToString() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField TextArea code;

	@UiHandler("generate")
	void clickGenerate(ClickEvent e) {
		StringBuffer sb = new StringBuffer(code.getValue().length());
		String[] tmp = code.getValue().trim().split("\n");
		for (String s : tmp) {
			sb.append("\"");
			sb.append(s);
			sb.append("\\n\" +\n");
		}
		code.setValue(sb.substring(0, sb.length()-3) + ";");
	}
}