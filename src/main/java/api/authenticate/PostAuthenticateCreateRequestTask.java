package api.authenticate;

import com.monotype.api_utils.core.Task;
import com.monotype.api_utils.core.TaskManager;
import com.monotype.api_utils.core.restman.MTRequestBuilder.RequestContentType;
import com.monotype.api_utils.logger.extentreportlogger.LogStatus;
import com.monotype.api_utils.logger.extentreportlogger.MTLogger;
import pojo.Op;

import java.util.Map;


public class PostAuthenticateCreateRequestTask extends Task<PostAuthenticateTaskManager> {

	String baseUri;
	String basePath = "/apps/authenticate";
	Op objAuthenticateRequest;
	Map requestMap;
	MTLogger objMTLogger;

	public PostAuthenticateCreateRequestTask(String baseUri, Op objAuthenticateRequest, MTLogger objMTLogger)
	{
		this.baseUri = baseUri;
		this.objMTLogger = objMTLogger;
		this.objAuthenticateRequest = objAuthenticateRequest;
	}

	@Override
	public void perform(TaskManager<PostAuthenticateTaskManager> taskManager) {
		try{
			startTimer();
			taskManager.getRestDriver().getobjMTRequestBuilder().setContentType(RequestContentType.JSON);
			taskManager.getRestDriver().getobjMTRequestBuilder().setBaseURI(baseUri);
			taskManager.getRestDriver().getobjMTRequestBuilder().setBasePath(basePath);
			taskManager.getRestDriver().getobjMTRequestBuilder().setReqBody(objAuthenticateRequest);

			objMTLogger.log(LogStatus.INFO, "Post Authentication Request Endpoint - " + baseUri + basePath);

			taskManager.getRestDriver().createRequest(taskManager.getRestDriver().getobjMTRequestBuilder());
			objMTLogger.log(LogStatus.INFO, "Request is created successfully");
			System.out.println("Request is created successfully");
			setTaskSuccessfull();
		}
		catch(Exception e){
			System.out.println("Exception in creation of POST request of API");
			objMTLogger.log(LogStatus.FATAL, "Exception in creation of POST request of API");
			e.printStackTrace();
		}
		finally {
			endTimer();
		}
	}

}
