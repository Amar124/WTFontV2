package task;

public abstract class Task<T extends TaskManager<?>> {
	double startTime;
	double endTime;
	String returnStatus = "Status not set";
	
	/**
	 * The perform method includes the core logic that a task is supposed to do 
	 * @param taskManager - The task manager of the task
	 * @return - same task manager
	 */
	public abstract void perform(TaskManager<T> taskManager);
	
	/**
	 * Starts the Timer for the Task(if we need to track the performance)
	 */	
	public void startTimer()
	{
		startTime = System.currentTimeMillis();
	}
	
	/**
	 * Ends the Timer for the Task 
	 */
	public void endTimer()
	{
		endTime = System.currentTimeMillis();
	}
	
	/**
	 * Used to calculate the time taken by the Task
	 * @return - Time taken in Milliseconds
	 */
	public double getTimeTaken()
	{
		return endTime - startTime;
	}
	
	/**
	 * Marks the Task as Successfully completed
	 */
	public void setTaskSuccessfull()
	{
		setStatus("Success");
	}
	
	/**
	 * Gets the Task Status
	 */
	public String getTaskStatus()
	{
		return returnStatus;
	}
	
	/**
	 * Can be used to set an error message for the task
	 * @param messageToSet - The message that conveys any errors that occurred while executing the task
	 */
	public void setStatus(String message)
	{
		this.returnStatus = message;
	}
}
