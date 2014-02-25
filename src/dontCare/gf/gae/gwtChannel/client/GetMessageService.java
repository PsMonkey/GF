package dontCare.gf.gae.gwtChannel.client;

import com.google.gwt.user.client.rpc.RemoteService;

public interface GetMessageService extends RemoteService {
	Message getMessage(Message msg);
}