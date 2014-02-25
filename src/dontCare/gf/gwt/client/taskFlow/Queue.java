package dontCare.gf.gwt.client.taskFlow;

import java.util.ArrayList;

/**
 * 先加進來的 Task 就會先執行，Task 執行完才換下一個 Task。
 */
public class Queue implements HasTask{
	private ArrayList<Task> taskList = new ArrayList<Task>();
	private boolean running = false;
	protected HasFlow owner;
	private int index;
	
	public Queue(HasFlow owner){
		this.owner = owner;
	}
	
	public void add(Task t){
		t.setOwner(this);
		taskList.add(t);
	}
	
	/**
	 * 清空 task。
	 * 如果已經在運作中就不會動作。
	 */
	public void clear() {
		if (running) { return; }	//正在執行中就不給 clear
		taskList.clear();
	}
	
	public void start(){
		if (running) { return; }	//已經開始就不要鬧了
		
		if (taskList.size() == 0) {	//沒有 task 直接結束
			owner.complete();
			return;
		}
		
		running = true;
		updateProgress();
		this.run();
	}
	
	private void run(){
		taskList.get(index).run();
	}

	@Override
	public void complete(){
		index++;
		updateProgress();
		if (index == taskList.size()) {	//都做完了，復原
			index=0;
			running=false;
			owner.complete();
		}else{
			this.run();
		}
	}
	
	@Override
	public void updateProgress(){
		owner.updateProgress();
	}
	
	public double getProgress(){
		return 1.0 * index / taskList.size();
	}

	public boolean isRunning() {
		return running;
	}
}