package authenticate;

import api.authenticate.PostAuthenticateTaskManager;
import com.monotype.api_utils.annotations.CSVAnnotation.*;
import com.monotype.api_utils.core.test.BaseTest;
import com.monotype.api_utils.datadriver.GenericDataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;


public class AuthenticationTest extends BaseTest {

	@Test(groups = {"Smoke","Regression"},dataProvider="dataproviderForTestCase", dataProviderClass=GenericDataProvider.class)
	@CSVFileParameters(path = "test-data\\api\\authenticate\\csv\\AuthenticateTestCases.csv",delimiter="###")
	public void postAuthenticationApiTest(int rowNo, Map<String, String> inputDataMap) throws IOException
	{
		PostAuthenticateTaskManager auth = new PostAuthenticateTaskManager(inputDataMap,MTLogger);
		
		auth.perform();
		
	}
}
