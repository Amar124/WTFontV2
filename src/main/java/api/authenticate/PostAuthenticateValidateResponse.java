package api.authenticate;

import com.monotype.api_utils.core.Task;
import com.monotype.api_utils.core.TaskManager;
import com.monotype.api_utils.logger.extentreportlogger.LogStatus;
import com.monotype.api_utils.logger.extentreportlogger.MTLogger;
import org.apache.http.HttpStatus;

/**
 * Created by asingh on 12-06-2017.
 */
public class PostAuthenticateValidateResponse extends Task<PostAuthenticateTaskManager> {

    MTLogger objMTLogger;

    public PostAuthenticateValidateResponse(MTLogger objMTLogger) {
        this.objMTLogger=objMTLogger;
    }

    @Override
    public void perform(TaskManager<PostAuthenticateTaskManager> taskManager) {
        try{
            startTimer();
            //TODO - remove hardcoded 409 response
            objMTLogger.log(LogStatus.INFO, "API hit successful, will validate the response now");

            taskManager.getRestDriver().getobjMTResponseBuilder().setStatusCode(HttpStatus.SC_CREATED);  // 409
            taskManager.getRestDriver().createExpectedResponse(taskManager.getRestDriver().getobjMTResponseBuilder());
            taskManager.getRestDriver().validateResponse();
            setTaskSuccessfull();
        }
        catch (Exception e) {
            System.out.println("Exception in validation of POST request of API");
            objMTLogger.log(LogStatus.FATAL, "Exception in validation of POST request of API");
            e.printStackTrace();
        }
        finally{
            endTimer();
        }

    }
}
