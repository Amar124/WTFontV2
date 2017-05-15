package banner;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;

import api.banner.PostBannerTaskManager;

public class BannerTest extends BaseTest {
	
  @Test(groups = {"Smoke","Regression"})
  public void PostBannerTest() {
	  
	  String jsonBody = "{\"type\":\"FontFamily\",\"backgroundColor\":\"#f4c2fe \",\"createdBy\":\"ASEEM\",\"image\":{\"imageUrl\":\"http://db2g6ay4rgwu0.cloudfront.net/102de6db-5973-49ff-b240-0392471f1015MT_MLS-Americana_Artwork.jpg\",\"link\":\"http://somenavlink.com\",\"subtitle\":\"Iamahotnewfont\",\"s3Key\":\"0bd28d4c-163c-456c-92ca-7fcacfdb2603MT_MLS-Agilita_Artwork.jpg\"},\"fontFamilyDetails\":{\"familyId\":\"16756923\",\"familyName\":\"UniqueFamilyNameadshfbahj\",\"familyFontsCount\":5,\"freeFontsCount\":0,\"source\":\"Monotype\"}}";
	  
	  PostBannerTaskManager postBannerTaskManager = new PostBannerTaskManager(getBaseURI(),jsonBody);
	  try
	  {
		  postBannerTaskManager.perform();
		  Assert.assertEquals(postBannerTaskManager.getStatus(), "Success");
	  }
	  catch(Exception e)
	  {
		  Assert.fail(e.getMessage());
	  }
	  finally
	  {
		  System.out.println("PostBannerTaskManager Task Status :- \n" + postBannerTaskManager.getStatus());
		  System.out.println("PostBannerTaskManager Task Timings :- \n" + postBannerTaskManager.getTaskTimings());
	  }
  }
}