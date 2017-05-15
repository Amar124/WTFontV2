package common;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class BaseTest {

	static String baseURI;
	static double apiTimeBenchMark;
	
	@BeforeSuite
	public void beforeSuite()
	{
		//This can be taken from Properties file
		baseURI = "http://mlscore-test-666500296.us-east-1.elb.amazonaws.com";
		apiTimeBenchMark = 2000;
	}
	
	public String getBaseURI()
	{
		return baseURI;
	}
	
	
}
