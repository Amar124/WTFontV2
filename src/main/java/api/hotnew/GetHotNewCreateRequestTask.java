package api.hotnew;

import task.Task;
import task.TaskManager;
import io.restassured.*;
import io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.*;
import static io.restassured.RestAssured.*;

public class GetHotNewCreateRequestTask extends Task<GetHotNewTaskManager>{

	String baseURI;
	String basePath = "/api/Cards";
	RequestSpecBuilder createRequestBuilder;
	RequestSpecification createRequestSpec;
			
	@SuppressWarnings("deprecation")
	@Override
	public void perform(TaskManager<GetHotNewTaskManager> taskManager) {
		startTimer();
		createRequestBuilder.setContentType(ContentType.JSON);
		createRequestBuilder.setBaseUri(baseURI);
		createRequestBuilder.setBasePath(basePath);
		createRequestBuilder.addParameter("type", "HotNew");		
		createRequestSpec = createRequestBuilder.build();
		System.out.println("Get Hot New Endpoint - " + baseURI + basePath + "?type=HotNew");
		((GetHotNewTaskManager)taskManager).setRequestSpec(createRequestSpec);
		setTaskSuccessfull();
		endTimer();		
	}
	
	public GetHotNewCreateRequestTask(String baseURI) {
		this.baseURI = baseURI;
		createRequestBuilder = new RequestSpecBuilder();
	}
	
	public RequestSpecification getHotNewCreateRequestSpec() {		
		return createRequestSpec;
	}	
}