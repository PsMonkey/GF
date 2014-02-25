package dontCare.gf.gae.gwtChannel.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamFactory;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import dontCare.gf.gae.gwtChannel.client.event.CloseEvent;
import dontCare.gf.gae.gwtChannel.client.event.ErrorEvent;
import dontCare.gf.gae.gwtChannel.client.event.MessageEvent;
import dontCare.gf.gae.gwtChannel.client.event.OpenEvent;

public class Channel {
	private static final SerializationStreamFactory SSF = GWT.create(GetMessageService.class);
	private static final String CHANNEL_SRC = "/_ah/channel/jsapi";

	public static ChannelServiceAsync getService(String path){
		ChannelServiceAsync service = (ChannelServiceAsync) GWT.create(ChannelService.class);
	    ServiceDefTarget endpoint = (ServiceDefTarget) service;
	    endpoint.setServiceEntryPoint(GWT.getModuleBaseURL()+path);
	    return service;
	}
	
	private HandlerManager eventBus = new HandlerManager(null);
	private String token;

	public Channel(String token) {
		this.token = token;
		if(!scriptLoaded()){
			ScriptElement script = Document.get().createScriptElement();
			script.setSrc(CHANNEL_SRC);
			Document.get().getElementsByTagName("head").getItem(0).appendChild(script);	
		}
	}
	
	/**
	 * //需 addOpenHandler() 後才能 open()，不然無法觸發 onOpen()
	 */
	public void open(){
		Scheduler.get().scheduleIncremental(new RepeatingCommand() {
			@Override
			public boolean execute() {
				if(scriptLoaded()){
					jsOpen(token);
					return false;	
				}
				return true;
			}
		});
	}

	public void addMessageHandler(MessageEvent.MessageHandler h){
		eventBus.addHandler(MessageEvent.TYPE, h);
	}
	
	private void onMessage(String response) {
		try {
			Message message = (Message) SSF.createStreamReader(response).readObject();
			eventBus.fireEvent(new MessageEvent(message));
		} catch (SerializationException e) {
			//XXX 基本上不應該發生，所以也就不處理了 XD
			e.printStackTrace();
		}
	}

	public void addOpenHandler(OpenEvent.OpenHandler h){
		eventBus.addHandler(OpenEvent.TYPE, h);
	}

	private void onOpen(){
		eventBus.fireEvent(new OpenEvent());
	}

	public void addErrorHandler(ErrorEvent.ErrorHandler h){
		eventBus.addHandler(ErrorEvent.TYPE, h);
	}
	
	private void onError(SocketError se){
		eventBus.fireEvent(new ErrorEvent(se));
	}
	
	public void addCloseHandler(CloseEvent.CloseHandler h){
		eventBus.addHandler(CloseEvent.TYPE, h);
	}
	
	private void onClose(){
		eventBus.fireEvent(new CloseEvent());
	}

	private static native boolean scriptLoaded() /*-{
		return !!$wnd.goog && 
			!!$wnd.goog.appengine && 
			!!$wnd.goog.appengine.Channel;
	}-*/;

	private native void jsOpen(String id) /*-{
        var channel = new $wnd.goog.appengine.Channel(id);
        var socket = channel.open();
		var self = this;
		socket.onopen = function(event) {
			self.@dontCare.gf.gae.gwtChannel.client.Channel::onOpen()();
		};
        socket.onmessage = function(event) {
            self.@dontCare.gf.gae.gwtChannel.client.Channel::onMessage(Ljava/lang/String;)(event.data);
        };
		socket.onerror = function(error) {
			self.@dontCare.gf.gae.gwtChannel.client.Channel::onError(LdontCare/gf/gae/gwtChannel/client/SocketError;)(error);
		};
		socket.onclose = function(event) {
			self.@dontCare.gf.gae.gwtChannel.client.Channel::onClose()();
		};
    }-*/;
}