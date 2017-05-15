package api.banner;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import task.Task;
import task.TaskManager;

public class PostBannerExecuteRequestTask extends Task<PostBannerTaskManager>{

	RequestSpecification reqSpec;
	Response apiResponse;
	
	@Override
	public void perform(
			TaskManager<PostBannerTaskManager> taskManager) {
		
		startTimer();
		reqSpec = ((PostBannerTaskManager)taskManager).getRequestSpec();
				
		apiResponse = given().spec(reqSpec).post();
		
		System.out.println("JSON Body for PostBanner Response - " + apiResponse.asString() + "\n");
		
		((PostBannerTaskManager)taskManager).setPostBannerResponse(apiResponse);
		setTaskSuccessfull();
		endTimer();
	}
}