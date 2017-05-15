package task;

import java.util.*;

public class TaskManager<T extends TaskManager<?>> {	
	Queue<Task<T>> tasks = new LinkedList<Task<T>>();
	public Map<Task<T>,String> taskResults = new HashMap<Task<T>,String>();
	public Map<Task<T>,Double> taskTimings = new HashMap<Task<T>,Double>();
			
	
	/**
	 * This method adds the Task to the Task Manager
	 * @param taskToAdd
	 */
	public void addTask(Task<T> taskToAdd)
	{
		tasks.add(taskToAdd);
	}
	
	/**
	 * This method executes all Tasks and notes down the results and timings
	 */
	public void execute()
	{
		while(!tasks.isEmpty())
		{
			Task<T> taskToExecute = tasks.remove();
			taskResults.put(taskToExecute, "Not Complete");
			taskTimings.put(taskToExecute, 0.0);
			taskToExecute.perform(this);			
			taskResults.put(taskToExecute, taskToExecute.getTaskStatus());
			taskTimings.put(taskToExecute, taskToExecute.getTimeTaken());
		}
	}
	
	/**
	 * This method executes a single Task and notes down the result and timing
	 */
	public void execute(Task<T> taskToExecute)
	{
		taskResults.put(taskToExecute, "Not Complete");
		taskTimings.put(taskToExecute, 0.0);
		taskToExecute.perform(this);
		taskResults.put(taskToExecute, taskToExecute.getTaskStatus());
		taskTimings.put(taskToExecute, taskToExecute.getTimeTaken());
	}
	
	/**
	 * Get the status of all tasks
	 * @return "Success" if all tasks passed otherwise the Status of the individual tasks
	 */
	public String getStatus()
	{
		StringBuilder finalResult = new StringBuilder();
		Boolean allPassed = true;
		
		//Check if Task Results are present or not
		if(taskResults.entrySet().size()!=0)
		{
			//If any task is not having "Success" result, then get the error message
			for(Map.Entry<Task<T>, String> entry : taskResults.entrySet())
			{
				finalResult.append(entry.getKey().getClass().getSimpleName() + " - " + entry.getValue() + "\n");
				if(!entry.getValue().equals("Success"))
				{
					allPassed = false;
				}
			}
		}
		else
		{
			allPassed=false;
			finalResult.append("No Tasks Executed");
		}
		
		if(allPassed)
		{
			return "Success";			
		}
		else
		{
			return finalResult.toString();
		}
	}
	
	/**
	 * Get the timings of all tasks
	 * @return String which has timing for each task
	 */
	public String getTaskTimings()
	{
		StringBuilder timings = new StringBuilder();
		
		//Check if Task Timings are present or not
		if(taskTimings.entrySet().size()!=0)
		{		
			for(Map.Entry<Task<T>, Double> entry : taskTimings.entrySet())
			{
				timings.append(entry.getKey().getClass().getSimpleName() + " - " + entry.getValue() + " milliseconds\n");				
			}
		}
		else
		{			
			timings.append("No Timings Found\n");
		}
		
		
		return timings.toString();
		
	}
}
