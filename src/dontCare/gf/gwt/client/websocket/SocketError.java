package dontCare.gf.gwt.client.websocket;

import com.google.gwt.core.client.JavaScriptObject;

//Refactory 不確定還有沒有其他 field
public final class SocketError extends JavaScriptObject {
	protected SocketError() {}

	public final native String getData() /*-{
		return this.data;
  	}-*/;
}