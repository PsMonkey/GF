package dontCare.gf.codeGenerator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import dontCare.gf.codeGenerator.client.ui.RootLayout;

public class CGEP implements EntryPoint {
	@Override
	public void onModuleLoad() {
		RootLayoutPanel.get().add(new RootLayout());
	}
}
