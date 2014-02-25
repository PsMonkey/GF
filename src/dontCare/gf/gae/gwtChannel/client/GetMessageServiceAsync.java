package dontCare.gf.gae.gwtChannel.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GetMessageServiceAsync {
	void getMessage(Message msg, AsyncCallback<Message> callback);
}
