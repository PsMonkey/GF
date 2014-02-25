package dontCare.gf.gwt.client.taskFlow;

import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class RpcTask<T> extends CallbackTask<T> implements AsyncCallback<T>{
	@Override
	public void onSuccess(T value){
		try{
			onCallback(value);
			finish();
		}catch(RuntimeException exception){
			onFailure(exception);
		}
	}
	
	@Override
	public final void onFailure(Throwable caught) {
		handleException(caught);
		finish();
	}
	
	public abstract void handleException(Throwable caught);
}