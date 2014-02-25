package dontCare.gf.gwt.client.taskFlow;

/**
 * 提供一個快速包起一般 method call 的 task class。
 */
public abstract class NormalTask extends Task {
	@Override
	void run(){
		specification();
		finish();
	}
}