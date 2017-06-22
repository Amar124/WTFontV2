package authenticate;

import api.authenticate.PostAuthenticateTaskManager;
import com.monotype.api_utils.annotations.CSVAnnotation.*;
import com.monotype.api_utils.core.test.BaseTest;
import com.monotype.api_utils.datadriver.GenericDataProvider;
import com.monotype.api_utils.logger.extentreportlogger.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.AuthenticateResposneNew;

import java.io.IOException;
import java.util.Map;


public class AuthenticationTest extends BaseTest {

	@Test(groups = {"Smoke","Regression"},dataProvider="dataproviderForTestCase", dataProviderClass=GenericDataProvider.class)
	@CSVFileParameters(path = "test-data\\api\\authenticate\\csv\\AuthenticateTestCases.csv",delimiter="###")
	public void postAuthenticationApiTest(int rowNo, Map<String, String> inputDataMap) throws IOException
	{
		//Creating the Post Authenticate class object
		PostAuthenticateTaskManager auth = new PostAuthenticateTaskManager(inputDataMap,MTLogger);
		try
		{
			//Calling the perform method which add and executes all the tasks
			auth.perform();

			//Putting API responsse to POJO
			AuthenticateResposneNew objAuthenticateResponse = auth.getRestDriver().getAPIResponseAsPOJO(AuthenticateResposneNew.class);

			//Assertions
			Assert.assertTrue( objAuthenticateResponse.getToken().toString() != null);
			Assert.assertEquals(auth.getStatus(), "Success");
		}
		catch(Exception e)
		{
			MTLogger.log(LogStatus.ERROR, "Exception in Authenticate Test case:" +e);
			Assert.fail(e.getMessage());
		}
		finally
		{
			MTLogger.log(LogStatus.INFO, "PostAuthenticateTaskManager Task Status :- \n" + auth.getStatus());
			MTLogger.log(LogStatus.INFO, "PostAuthenticateTaskManager Task Timings :- \n" + auth.getTaskTimings());
		}
	}
}
