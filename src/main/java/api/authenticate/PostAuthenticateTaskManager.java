package api.authenticate;

import com.monotype.api_utils.core.TaskManager;
import com.monotype.api_utils.logger.extentreportlogger.LogStatus;
import com.monotype.api_utils.logger.extentreportlogger.MTLogger;
import com.monotype.api_utils.serializer.JSONSerializer;
import com.monotype.api_utils.settings.PropertiesManager;
import pojo.Op;

import java.util.Map;

public class PostAuthenticateTaskManager extends TaskManager<PostAuthenticateTaskManager> {
	
	String baseUri;
	String appId;
	String appSecret;
	PostAuthenticateCreateRequestTask createRequest;
	PostAuthenticateExecuteRequestTask executeRequest;
	PostAuthenticateValidateResponse validateResponse;
	Map<String, String> testData;
	MTLogger mtLogger;

	public PostAuthenticateTaskManager(Map<String,String> testData,MTLogger mtLogger)
	{
		try
		{
			this.baseUri = PropertiesManager.getProperty("baseURI");
			this.mtLogger= mtLogger;
			this.testData = testData;

			JSONSerializer objJsonSerializer = new JSONSerializer();

			// converting json to pojo using apiart utils
			Op objBannerRequest = objJsonSerializer.stringToPOJO(testData.get("json").toString(), Op.class);

			createRequest = new PostAuthenticateCreateRequestTask(baseUri, objBannerRequest,this.mtLogger);
			executeRequest = new PostAuthenticateExecuteRequestTask(this.mtLogger);
			validateResponse = new PostAuthenticateValidateResponse(this.mtLogger);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String perform()
	{
		//Adding tasks in addTask method of TaskManager
		addTask(createRequest);
		addTask(executeRequest);
		addTask(validateResponse);

		//Executing the added tasks
		execute();

		//Returning the status of the tasks
		return getStatus();
	}
}
