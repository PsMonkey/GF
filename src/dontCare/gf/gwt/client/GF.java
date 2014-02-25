package dontCare.gf.gwt.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import dontCare.gf.gwt.client.component.Switch;

public class GF implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Switch s = new Switch();
		s.setPixelSize(50, 20);
		RootPanel.get().add(s);
	}
}