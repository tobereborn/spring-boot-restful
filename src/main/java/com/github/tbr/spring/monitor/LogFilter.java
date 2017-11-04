package com.github.tbr.spring.monitor;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class LogFilter extends Filter<ILoggingEvent> {

    @Override
    public FilterReply decide(ILoggingEvent loggingEvent) {
        if (loggingEvent.getLoggerName().equals(LogAspect.class.getName())) {
            return FilterReply.ACCEPT;
        }
        return FilterReply.DENY;
    }
}
