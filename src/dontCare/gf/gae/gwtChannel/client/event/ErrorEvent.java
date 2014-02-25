package dontCare.gf.gae.gwtChannel.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

import dontCare.gf.gae.gwtChannel.client.SocketError;

public class ErrorEvent extends GwtEvent<ErrorEvent.ErrorHandler>{
	public interface ErrorHandler extends EventHandler{ 
		void onError(ErrorEvent e);
	}

	public static final GwtEvent.Type<ErrorHandler> TYPE = new GwtEvent.Type<ErrorHandler>();
	
	private SocketError err;
	
	public ErrorEvent(SocketError err){
		this.err = err;
	}
	
	@Override
	public GwtEvent.Type<ErrorHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ErrorHandler handler) {
		handler.onError(this);
	}

	public int getCode() {
		return err.getCode();
	}
	
	public String getDescription(){
		return err.getDescription();
	}
}
