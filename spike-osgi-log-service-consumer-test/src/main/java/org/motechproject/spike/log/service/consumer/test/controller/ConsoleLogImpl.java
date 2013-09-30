package org.motechproject.spike.log.service.consumer.test.controller;

import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ConsoleLogImpl implements LogListener {
    @Override
    public void logged(LogEntry log) {
        if (log.getMessage() != null) {
            System.out.println("[MyLog][" + log.getBundle().getSymbolicName() + "] " + log.getMessage());
        }
    }

    @Autowired
    public void setLogReaderService(LogReaderService logReaderService) {
        logReaderService.addLogListener(this);
    }
}
