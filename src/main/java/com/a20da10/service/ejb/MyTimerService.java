package com.a20da10.service.ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import java.util.logging.Logger;

@Stateless
public class MyTimerService {
    @Resource
    TimerService timerService;
    private static final Logger logger = Logger.getLogger("ejb.MyTimerService");
    public MyTimerService(){}
    public void setTimer(long interval){
        timerService.createTimer(interval,"Setting a programmatic timer");
    }

    @Timeout
    public void programmaticTimeout(Timer timer){ //mouse click event
        logger.info("@Timeout in programmatic timer at " + new java.util.Date());
    }
//    @Schedule(second = "*/5", minute = "*", hour = "0-23", dayOfWeek = "Mon-Fri", dayOfMonth = "*", month = "*", year = "*", info = "MyTimer")
//    private void scheduleTimeout(final Timer t){
//        logger.info("@Scheduled timer triggered at " + new java.util.Date());
//    }

}
