package dontCare.gf.gwt.client.component;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.user.client.ui.Image;

public class Switch extends Image {
	interface Resources extends ClientBundle {
		@Source("switchOn.png")	ImageResource onImg();
		@Source("switchOff.png") ImageResource offImg();
	}
	private Resources resource = GWT.create(Resources.class);
		
	private boolean status = true;
	
	public Switch() {
		setStatus(true);
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean state) {
		this.status = state;
		super.setUrl(state ? resource.onImg().getSafeUri() : resource.offImg().getSafeUri());
	}

	// 跟設定 URL 有關的就統統變成空白 method，而且鎖定不給繼承
	@Override public final void setUrl(String url) {}
	@Override public final void setUrl(SafeUri url) {}
	@Override public final void setUrlAndVisibleRect(SafeUri url, int left, int top, int width, int height) {}
	@Override public final void setUrlAndVisibleRect(String url, int left, int top, int width, int height) {}
	////
}