package dontCare.gf.gwt.client.taskFlow;

import com.google.gwt.user.client.Timer;

/**
 * 負責 idle 一段指定的時間的 task。
 */
public final class IdleTask extends Task {
	private Timer timer = new Timer() {
		@Override
		public void run() {
			finish();
		}
	};
	private int idleTime;
	
	public IdleTask(int ms) {
		this.idleTime = ms;
	}
	
	@Override
	protected void specification() {
		timer.schedule(idleTime);		
	}

	@Override
	void run() {
		specification();
	}
}