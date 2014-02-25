package dontCare.gf.gae.gwtChannel.client;

import com.google.gwt.user.client.rpc.RemoteService;

public interface ChannelService<M extends Message> extends RemoteService{
	void sendMessage(String name, M msg);
	String getToken(String name);
}