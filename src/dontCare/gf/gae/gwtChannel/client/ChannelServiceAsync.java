package dontCare.gf.gae.gwtChannel.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ChannelServiceAsync {
    void sendMessage(String name, Message msg, AsyncCallback<Void> callback);
	void getToken(String channelName, AsyncCallback<String> callback);
}