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
	MTLogger mtLogger;

	public PostAuthenticateTaskManager(Map<String,String> map,MTLogger mtLogger)
	{
		try {
			baseUri = PropertiesManager.getProperty("baseURI");
			this.mtLogger=mtLogger;

			this.mtLogger.log(LogStatus.INFO, "Request Json is: " + map.get("json").toString());
			System.out.println("Request Json is: " + map.get("json").toString());
			JSONSerializer objJsonSerializer = new JSONSerializer();
			// converting json to pojo using apiart utils
			Op objBannerRequest = objJsonSerializer.stringToPOJO(map.get("json").toString(), Op.class);

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
		addTask(createRequest);
		execute();
		return getStatus();
	}
}
