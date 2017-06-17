package api.authenticate;

import com.monotype.api_utils.core.RequestExecutor.ExecuteRequestInterface;
import com.monotype.api_utils.core.RequestExecutor.RequestFactory;
import com.monotype.api_utils.core.RequestExecutor.RequestType;
import com.monotype.api_utils.core.Task;
import com.monotype.api_utils.core.TaskManager;
import com.monotype.api_utils.logger.extentreportlogger.LogStatus;
import com.monotype.api_utils.logger.extentreportlogger.MTLogger;

public class PostAuthenticateExecuteRequestTask extends Task<PostAuthenticateTaskManager>  {

    MTLogger objMTLogger;

    public PostAuthenticateExecuteRequestTask(MTLogger objMTLogger) {
        this.objMTLogger=objMTLogger;
    }

    @Override
    public void perform(TaskManager<PostAuthenticateTaskManager> taskManager)
    {
        try {
            startTimer();
            objMTLogger.log(LogStatus.INFO, "executing the post request");
            System.out.println("executing the post request");
            ExecuteRequestInterface RequestObj= RequestFactory.CreateRequestObj(RequestType.POST);
            RequestObj.executeRequest(taskManager.getRestDriver());
            objMTLogger.log(LogStatus.INFO, "execution complete");
            System.out.println("execution complete");
            setTaskSuccessfull();
        } catch (Exception e) {
            System.out.println("Exception in execution of POST request of API");
            objMTLogger.log(LogStatus.FATAL, "Exception in execution of POST request of API");
            e.printStackTrace();
        }finally {
            endTimer();
        }
    }

}
