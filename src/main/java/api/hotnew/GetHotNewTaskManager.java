package api.hotnew;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import task.TaskManager;

public class GetHotNewTaskManager extends TaskManager<GetHotNewTaskManager> {
	
	String baseURI;	
	GetHotNewCreateRequestTask createRequest;
	GetHotNewExecuteRequestTask executeRequest;
	GetHotNewValidateResponseTask validateResponse;	
	RequestSpecification reqSpec;
	Response hotNewResponse;
		
	public GetHotNewTaskManager(String baseURI) {
		this.baseURI = baseURI;
		createRequest = new GetHotNewCreateRequestTask(baseURI);
		executeRequest = new GetHotNewExecuteRequestTask();
		validateResponse = new GetHotNewValidateResponseTask();
	}
	
	public String perform()
	{
		addTask(createRequest);	
		addTask(executeRequest);
		addTask(validateResponse);
		execute();
		return getStatus();
	}
	
	public void setRequestSpec(RequestSpecification reqSpec)
	{
		this.reqSpec = reqSpec;
	}
	
	public RequestSpecification getRequestSpec()
	{
		return reqSpec;
	}
	
	public void setHotNewResponse(Response hotNewResponse)
	{
		this.hotNewResponse = hotNewResponse;
	}
	
	public Response getHotNewResponse()
	{
		return hotNewResponse;
	}
}
