package api.hotnew;

import org.apache.http.HttpStatus;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import task.Task;
import task.TaskManager;

public class GetHotNewValidateResponseTask extends Task<GetHotNewTaskManager>{

	ResponseSpecBuilder validateResponseBuilder;
	ResponseSpecification validateResponseSpec;	
	
	@Override
	public void perform(
			TaskManager<GetHotNewTaskManager> taskManager) {
		
		startTimer();
		validateResponseBuilder = new ResponseSpecBuilder();
		validateResponseBuilder.expectStatusCode(HttpStatus.SC_OK);
		
		/* Time Validation In Progress...
		validateResponseBuilder.expectResponseTime(new Matcher<Long>() {

			public void describeMismatch(Object arg0, Description arg1) {
				// TODO Auto-generated method stub
				
			}

			public void describeTo(Description arg0) {
			*/
		validateResponseSpec = validateResponseBuilder.build();
		
	    ((GetHotNewTaskManager)taskManager).getHotNewResponse().then().spec(validateResponseSpec);
	    setTaskSuccessfull();
	    endTimer();
	}
}