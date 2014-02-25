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

public class GenEvent extends Composite {
	private static GenEventUiBinder uiBinder = GWT.create(GenEventUiBinder.class);
	interface GenEventUiBinder extends UiBinder<Widget, GenEvent> {}

	@UiField TextBox name;
	@UiField TextArea eventResult;
	@UiField TextArea handlerResult;
	
	public GenEvent() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("generate")
	void clickGenerate(ClickEvent ce) {
		String n = name.getValue().trim();
		eventResult.setValue(template.replaceAll(":Name:", n));
		handlerResult.setValue(handlerTemplate.replaceAll(":Name:", n));
	}
	
	private static final String template = 
			"import com.google.gwt.event.shared.GwtEvent;\n" +
			"public class :Name:Event extends GwtEvent<:Name:Handler> {\n" +
			"	public static final Type<:Name:Handler> TYPE = new Type<:Name:Handler>();\n" +
			"	public :Name:Event() {}\n" +
			"	@Override\n" +
			"	public Type<:Name:Handler> getAssociatedType() {\n" +
			"		return TYPE;\n" +
			"	}\n" +
			"	@Override\n" +
			"	protected void dispatch(:Name:Handler handler) {\n" +
			"		handler.on:Name:(this);\n" +
			"	}\n" +
			"}\n";
	private static final String handlerTemplate = 
			"import com.google.gwt.event.shared.EventHandler;\n" +
			"public interface :Name:Handler extends EventHandler{\n" +
			"	public void on:Name:(:Name:Event event);\n" +
			"}\n";
}