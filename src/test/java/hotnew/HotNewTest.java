package hotnew;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;

import common.BaseTest;

import api.hotnew.GetHotNewTaskManager;

public class HotNewTest extends BaseTest{
	
  @Test(groups = {"Smoke"})
  public void GetHotNewTest() {
	  GetHotNewTaskManager getHotNewTaskManager = new GetHotNewTaskManager(getBaseURI());
	  try
	  {
		  getHotNewTaskManager.perform();
		  Assert.assertEquals(getHotNewTaskManager.getStatus(), "Success");
	  }
	  catch(Exception e)
	  {
		  Assert.fail(e.getMessage());
	  }
	  finally
	  {
		  System.out.println("GetHotNewTaskManager Task Status :- \n" + getHotNewTaskManager.getStatus());
		  System.out.println("GetHotNewTaskManager Task Timings :- \n" + getHotNewTaskManager.getTaskTimings());
	  }
  }
}
