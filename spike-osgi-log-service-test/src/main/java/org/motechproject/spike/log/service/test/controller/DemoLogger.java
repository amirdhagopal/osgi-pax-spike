package org.motechproject.spike.log.service.test.controller;

import org.osgi.service.log.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
public class DemoLogger {

    private Logger slf4jLog = LoggerFactory.getLogger(DemoLogger.class);

    @Autowired
    private LogService osgiLog;

    DemoLogger(){

        TimerTask task = new RunMeTask();

        Timer timer = new Timer();
        timer.schedule(task, 1000,15000);
    }

    class RunMeTask extends TimerTask
    {
        @Override
        public void run() {
            System.out.println("Run Me ~");

            slf4jLog.error("[DemoLogger] ...........................................");
            slf4jLog.debug("[DemoLogger] Debug log for {0}", "LogServiceTest bundle");
            slf4jLog.info("[DemoLogger] Info log for {0}", "LogServiceTest bundle");
            slf4jLog.warn("[DemoLogger] Warn log for {0}", "LogServiceTest bundle");
            slf4jLog.error("[DemoLogger] Error log for {0}", "LogServiceTest bundle");
            slf4jLog.trace("[DemoLogger] Trace log for {0}", "LogServiceTest bundle");
            slf4jLog.error("[DemoLogger] ...........................................");

            osgiLog.log(LogService.LOG_ERROR, "[OsgiDemoLogger] Osgi Error Log");
            osgiLog.log(LogService.LOG_INFO, "[OsgiDemoLogger] Osgi Info Log");
            osgiLog.log(LogService.LOG_WARNING, "[OsgiDemoLogger] Osgi Warn Log");
            osgiLog.log(LogService.LOG_DEBUG, "[OsgiDemoLogger] Osgi Debug Log");
        }
    }
}
