package api.banner;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import task.Task;
import task.TaskManager;

public class PostBannerCreateRequestTask extends Task<PostBannerTaskManager>{

	String baseURI;
	String jsonBody;
	String basePath = "/api/dashboard/banner";
	RequestSpecBuilder createRequestBuilder;
	RequestSpecification createRequestSpec;
			
	@Override
	public void perform(TaskManager<PostBannerTaskManager> taskManager) {
		startTimer();
		createRequestBuilder.setContentType(ContentType.JSON);
		createRequestBuilder.setBaseUri(baseURI);
		createRequestBuilder.setBasePath(basePath);
		createRequestBuilder.setBody(jsonBody);
		System.out.println("Post Banner Request Endpoint - " + baseURI + basePath);
		System.out.println("JSON Body for Post Banner Request - " + jsonBody);
		createRequestSpec = createRequestBuilder.build();
		((PostBannerTaskManager)taskManager).setRequestSpec(createRequestSpec);
		setTaskSuccessfull();
		endTimer();		
	}
	
	public PostBannerCreateRequestTask(String baseURI,String jsonBody) {
		this.baseURI = baseURI;
		this.jsonBody = jsonBody;		
		createRequestBuilder = new RequestSpecBuilder();
	}
	
	public RequestSpecification getHotNewCreateRequestSpec() {		
		return createRequestSpec;
	}	
}