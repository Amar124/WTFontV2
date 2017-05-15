package api.banner;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import task.TaskManager;
import api.hotnew.GetHotNewCreateRequestTask;
import api.hotnew.GetHotNewExecuteRequestTask;
import api.hotnew.GetHotNewTaskManager;
import api.hotnew.GetHotNewValidateResponseTask;

public class PostBannerTaskManager extends TaskManager<PostBannerTaskManager> {
	
	String baseURI;	
	PostBannerCreateRequestTask createRequest;
	PostBannerExecuteRequestTask executeRequest;
	PostBannerValidateResponseTask validateResponse;
	RequestSpecification reqSpec;
	Response postBannerResponse;
		
	public PostBannerTaskManager(String baseURI,String jsonBody) {
		this.baseURI = baseURI;
		createRequest = new PostBannerCreateRequestTask(baseURI,jsonBody);
		executeRequest = new PostBannerExecuteRequestTask();
		validateResponse = new PostBannerValidateResponseTask();
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
	
	public void setPostBannerResponse(Response postBannerResponse)
	{
		this.postBannerResponse = postBannerResponse;
	}
	
	public Response getBannerResponse()
	{
		return postBannerResponse;
	}
}
