package api.banner;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import task.Task;
import task.TaskManager;

public class PostBannerValidateResponseTask extends Task<PostBannerTaskManager>{

	ResponseSpecBuilder validateResponseBuilder;
	ResponseSpecification validateResponseSpec;		
	
	@Override
	public void perform(
			TaskManager<PostBannerTaskManager> taskManager) {
		startTimer();
		validateResponseBuilder = new ResponseSpecBuilder();
		validateResponseBuilder.expectStatusCode(200);
		validateResponseSpec = validateResponseBuilder.build();
	    ((PostBannerTaskManager)taskManager).getBannerResponse().then().spec(validateResponseSpec);
	    setTaskSuccessfull();
	    endTimer();		
	}
}