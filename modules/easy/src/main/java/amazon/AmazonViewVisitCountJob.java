package amazon;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class AmazonViewVisitCountJob implements Job{
    AmazonService amazonService =new AmazonService();

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println(new Date() + ": doing something...");

        //AmazonViewCountUtils.todayNum;
        try {
            amazonService.updateViewVistCount();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}