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

public class GenRpcTask extends Composite {
	private static GenRpcTaskUiBinder uiBinder = GWT.create(GenRpcTaskUiBinder.class);
	interface GenRpcTaskUiBinder extends UiBinder<Widget, GenRpcTask> {}

	@UiField TextBox taskName;
	@UiField TextBox returnType;
	@UiField TextArea result;
	
	public GenRpcTask() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("generateBtn")
	void clickGenerate(ClickEvent ce) {
		String tName = taskName.getValue().trim();
		String tname = tName.substring(0, 1).toLowerCase() + tName.substring(1);
		result.setText(
			template
			.replaceAll(":TaskName:", tName)
			.replaceAll(":ReturnType:", returnType.getValue().trim())
			.replaceAll(":taskName:", tname)
		);
	}
	
	private static final String template = 
			"import dontCare.gf.gwt.client.taskQueue.RpcTask;\n" +
			"\n" +
			"public class :TaskName:Task extends RpcTask<:ReturnType:> {\n" +
			"	@Override\n" +
			"	public void handleException(Throwable caught) {\n" +
			"		caught.printStackTrace();\n" +
			"	}\n" +
			"\n" +
			"	@Override\n" +
			"	public void onCallback(:ReturnType: value) {\n" +
			"		RpcCenter.fireEvent(new :TaskName:Event(value));\n" +
			"	}\n" +
			"\n" +
			"	@Override\n" +
			"	protected void specification() {\n" +
			"		RpcCenter.rpc.:taskName:(this);\n" +
			"	}\n" +
			"}\n";
}