package dontCare.gf.codeGenerator.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class GenCellColumn extends Composite {
	private static GenCellColumnUiBinder uiBinder = GWT.create(GenCellColumnUiBinder.class);
	interface GenCellColumnUiBinder extends UiBinder<Widget, GenCellColumn> {}

	@UiField TextBox voName;
	@UiField TextArea voField;
	@UiField TextArea columnResult;
	
	public GenCellColumn() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("generate")
	void clickGenerate(ClickEvent ce) {
		StringBuffer result = new StringBuffer();
		StringBuffer addColumnResult = new StringBuffer();
		String voname = voName.getValue();
		voname = voname.substring(0, 1).toLowerCase() + voname.substring(1);

		String[] fieldList = voField.getValue().split("\n");
		
		for (String f : fieldList) {
			String fname = f.substring(f.lastIndexOf(" ") + 1, f.length() - 1);
			String fName = fname.substring(0, 1).toUpperCase() + fname.substring(1);
			result.append(
				template
				.replaceAll(":voName", voName.getValue())
				.replaceAll(":fname", fname)
				.replaceAll(":fName", fName)
			);
			addColumnResult.append(
				addColumnTemplate
				.replaceAll(":voName", voname)
				.replaceAll(":fname", fname)
			);
		}
		
		columnResult.setValue(result.toString() + addColumnResult);
	}
	
	private static final String template = 
			"		TextColumn<:voName> :fname = new TextColumn<:voName>() {\n" +
			"			@Override\n" +
			"			public String getValue(:voName data) {\n" +
			"				return \"\" + data.get:fName();\n" +
			"			}\n" +
			"		};\n";
	
	private static final String addColumnTemplate = 
			"		:voNameTable.addColumn(:fname, \":fname\");\n";
}