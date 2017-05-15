package api.hotnew;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import task.Task;
import task.TaskManager;
import static io.restassured.RestAssured.*;

public class GetHotNewExecuteRequestTask extends Task<GetHotNewTaskManager>{

	RequestSpecification reqSpec;
	Response apiResponse;
	
	@Override
	public void perform(
			TaskManager<GetHotNewTaskManager> taskManager) {
	
		startTimer();
		reqSpec = ((GetHotNewTaskManager)taskManager).getRequestSpec();
				
		apiResponse = given().spec(reqSpec).get();
		
		System.out.println("JSON Body for GetHotNew Response - " + apiResponse.asString() + "\n");
	
		((GetHotNewTaskManager)taskManager).setHotNewResponse(apiResponse);
		setTaskSuccessfull();
		endTimer();		
		
	}
}