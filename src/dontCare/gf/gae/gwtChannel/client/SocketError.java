package dontCare.gf.gae.gwtChannel.client;

import com.google.gwt.core.client.JavaScriptObject;

public final class SocketError extends JavaScriptObject {
  protected SocketError() {}

  public final native String getDescription() /*-{
    return this.description;
  }-*/;

  public final native int getCode() /*-{
    return this.code;
  }-*/;
}