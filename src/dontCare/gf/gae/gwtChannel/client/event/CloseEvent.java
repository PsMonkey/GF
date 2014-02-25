package dontCare.gf.gae.gwtChannel.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class CloseEvent extends GwtEvent<CloseEvent.CloseHandler>{
	public interface CloseHandler extends EventHandler{
		void onClose(CloseEvent e);
	}

	public static final GwtEvent.Type<CloseHandler> TYPE = new GwtEvent.Type<CloseHandler>();
	
	@Override
	public GwtEvent.Type<CloseHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(CloseHandler handler) {
		handler.onClose(this);
	}
}
