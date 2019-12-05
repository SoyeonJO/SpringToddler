package kr.or.ddit.quartz.config.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TimeCheckJob extends QuartzJobBean {

	// 스케줄(주기|비주기)에 따랄executeInternal() 콜백되는
	// 비지니스로직을 포함하는 메서드
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		SimpleDateFormat dateFormate = 
				       new SimpleDateFormat("yyyy/MM/dd hh24:mm:ss");
		System.out.println("timeCheckJob : " + dateFormate.format(new Date()));
	}

}
