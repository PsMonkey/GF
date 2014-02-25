package dontCare.gf.gwt.client.taskFlow;

/**
 * 
 */
public class TaskAgent implements HasFlow {
	private Queue workflow = new Queue(this);

	public void addTask(Task t){
		workflow.add(t);
	}
	
	public void start() {
		workflow.start();
	}
	
	public double getProgress() {
		return workflow.getProgress();
	}

	@Override
	public void updateProgress() {}

	@Override
	public void complete() {}
}