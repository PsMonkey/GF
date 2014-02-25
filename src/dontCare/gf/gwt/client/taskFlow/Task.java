package dontCare.gf.gwt.client.taskFlow;

public abstract class Task{
	HasTask owner;
	void setOwner(HasTask hasTask) {
		this.owner = hasTask;
	}
	protected abstract void specification();
	abstract void run();
	protected final void finish(){
		owner.complete();
	}
}