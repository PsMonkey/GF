package dontCare.gf.gwt.client.taskFlow;

public abstract class CallbackTask<T> extends Task{
	//Refactory 檢討是否一定要 public
	public abstract void onCallback(T value);
	@Override
	void run(){
		specification();
	}
}
