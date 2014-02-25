package dontCare.gf.gae.gwtChannel.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class OpenEvent extends GwtEvent<OpenEvent.OpenHandler>{
	public interface OpenHandler extends EventHandler{
		void onOpen(OpenEvent e);
	}

	public static final GwtEvent.Type<OpenHandler> TYPE = new GwtEvent.Type<OpenHandler>();
	
	@Override
	public GwtEvent.Type<OpenHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(OpenHandler handler) {
		handler.onOpen(this);
	}
}
