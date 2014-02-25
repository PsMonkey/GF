package dontCare.gf.gae.gwtChannel.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

import dontCare.gf.gae.gwtChannel.client.Message;

public class MessageEvent extends GwtEvent<MessageEvent.MessageHandler>{
	public interface MessageHandler extends EventHandler{ 
		void onMessage(MessageEvent e);
	}

	public static final GwtEvent.Type<MessageHandler> TYPE = new GwtEvent.Type<MessageHandler>();
	
	private Message message;
	
	public MessageEvent(Message msg){
		this.message = msg;
	}
	
	@Override
	public GwtEvent.Type<MessageHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(MessageHandler handler) {
		handler.onMessage(this);
	}



	public Message getMessage() {
		return message;
	}
}
